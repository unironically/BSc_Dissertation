package main;

import automaton.dfa.DFA;
import automaton.nfa.NFA;
import exception.InvalidExpressionException;

import java.util.Scanner;

/**
 * Main class from which the program execution starts.
 */
public class Main {

    /**
     * Main method from which the program starts.
     * @param args List of string arguments passed to the program when run, first argument is the input expression.
     */
    public static void main(String[] args) {
        String expression = args[0];
        DFA minDFA = null;
        try {
            Regex rx = new Regex(expression);
            System.out.println("Expanded regular expression: " + rx.getExpansion() + "\n");
            NFA newNFA = new NFAConstructor(rx.getExpansion(), rx.getAlphabet()).construct();
            System.out.println(newNFA.toString());
            DFA newDFA = new DFAConstructor(newNFA, rx.getAlphabet()).construct();
            System.out.println(newDFA.toString());
            minDFA = newDFA.minimise();
            System.out.println(minDFA.toString());
        } catch (InvalidExpressionException e) {
            System.out.println("Exception: " + e.getMessage());
            return;
        }
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("Test input for DFA: ");
            String lexeme = scan.nextLine();
            boolean accepts = minDFA.accepts(lexeme);
            String infix = (accepts) ? " " : " not ";
            System.out.println("\tDFA does" + infix + "accept lexeme '" + lexeme + "'");
        }
    }
}
