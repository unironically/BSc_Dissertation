package main;

import automaton.nfa.AlternationNFA;
import automaton.nfa.CharacterNFA;
import automaton.nfa.KleeneClosureNFA;
import automaton.nfa.NFA;
import exception.InvalidExpressionException;

import java.util.Stack;

/**
 * Class allowing us to create new NFA objects using Thompson's construction.
 */
public class NFAConstructor {

    /**
     * The character array of the input expression.
     */
    private char[] patternArray;

    /**
     * The array of characters within the alphabet of the expression.
     */
    private char[] alphabet;

    /**
     * Constructor for NFAConstructor objects.
     * @param pattern The String input pattern of the expression.
     * @param alphabet The array of characters within the expression's alphabet.
     */
    public NFAConstructor(String pattern, char[] alphabet) {
        this.alphabet = alphabet;
        patternArray = pattern.toCharArray();
    }

    /**
     * Method to begin Thompson's construction with the input regular expression.
     * @return The new NFA object constructed.
     * @throws InvalidExpressionException Thrown when an input regular expression is invalid.
     */
    public NFA construct() throws InvalidExpressionException {
        NFA newNFA = construct(patternArray);
        newNFA.relabel();
        return newNFA;
    }

    /**
     * Method implementing Thompson's construction for input regular expressions.
     * @param sub The subexpression of the original expression currently being handled.
     * @return The new NFA constructed using this algorithm.
     * @throws InvalidExpressionException Thrown when an input regular expression is invalid.
     */
    private NFA construct(char[] sub) throws InvalidExpressionException {
        Stack<NFA> nfaStack = new Stack<>();
        char[][] splitArr = seekAlternation(sub);
        int backslashStack = 0;
        if (splitArr != null) return new AlternationNFA(construct(splitArr[0]), construct(splitArr[1]), alphabet);
        for (int i = 0; i < sub.length; i++) {
            if (backslashStack % 2 != 0) {
                nfaStack.push(new CharacterNFA(sub[i], alphabet));
            } else if (sub[i] == '(') {
                i = handleInsideParentheses(sub, i, nfaStack);
            } else if (sub[i] == '*') {
                nfaStack.push(new KleeneClosureNFA(nfaStack.pop(), alphabet));
            } else if (sub[i] == '\\') {
                backslashStack++;
                continue;
            } else {
                nfaStack.push(new CharacterNFA(sub[i], alphabet));
            }
            backslashStack = 0;
        }
        NFA last = nfaStack.pop();
        while (!nfaStack.empty()) {
            NFA newLast = (NFA) nfaStack.pop().concatenate(last);
            last = newLast;
        }
        return last;
    }

    /**
     * Method to handle the expression held within a set of parentheses appearing inside an input expression.
     * @param sub The subexpression which contains the set of parentheses.
     * @param index The index of the opening parenthesis.
     * @param nfaStack The stack which we add the NFA constructed from the clause inside the parentheses to.
     * @return The integer index of the closing parenthesis of the expression.
     * @throws InvalidExpressionException Thrown when an input regular expression is invalid.
     */
    private int handleInsideParentheses(char[] sub, int index, Stack<NFA> nfaStack) throws InvalidExpressionException {
        index++;
        int bracketsLevel = 1;
        boolean isEscaped = false;
        int beginInsideParentheses = index;
        for (; index < sub.length && bracketsLevel != 0; index++) {
            if (isEscaped);
            else if (sub[index] == '(') bracketsLevel++;
            else if (sub[index] == ')') bracketsLevel--;
            else if (sub[index] == '\\') {
                isEscaped = true;
                continue;
            }
            isEscaped = false;
        }
        index--;
        if (bracketsLevel != 0) throw new InvalidExpressionException("Unbalanced parentheses.");
        char[] insideParentheses = new char[index - beginInsideParentheses];
        for (int i = beginInsideParentheses; i < index; i++) insideParentheses[i - beginInsideParentheses] = sub[i];
        nfaStack.push(construct(insideParentheses));
        return index;
    }

    /**
     * Method to seek a non-escaped '|' character within the expression and current parentheses level, corresponding to
     * alternation between the expressions to the left and right of this character.
     * @param sub The subexpression we search for the bar character within.
     * @return Two-dimensional character array, containing the expressions to the left and right of the bar if found.
     * @throws InvalidExpressionException Thrown when an input regular expression is invalid.
     */
    private char[][] seekAlternation(char[] sub) throws InvalidExpressionException {
        int bracketsLevel = 0;
        int barIndex = 0;
        boolean isEscaped = false;
        boolean outerBarExists = false;
        for (; barIndex < sub.length; barIndex++) {
            if (isEscaped);
            else if (sub[barIndex] == '(') bracketsLevel++;
            else if (sub[barIndex] == ')') bracketsLevel--;
            else if (sub[barIndex] == '|' && bracketsLevel == 0) {
                outerBarExists = true;
                break;
            } else if (sub[barIndex] == '\\') {
                isEscaped = true;
                continue;
            }
            isEscaped = false;
        }
        if (!outerBarExists) return null;
        else if (barIndex >= sub.length - 1 || barIndex <= 0) throw new InvalidExpressionException("Invalid bar location.");
        char[] newLeft = new char[barIndex];
        char[] newRight = new char[sub.length - 1 - barIndex];
        for (int i = 0; i < sub.length; i++) {
            if (i < barIndex) newLeft[i] = sub[i];
            else if (i > barIndex) newRight[i - (barIndex + 1)] = sub[i];
        }
        return new char[][] {newLeft, newRight};
    }

}
