package automaton.base;

import exception.NoSuchTransitionException;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class implementing the states encapsulated within a finite-state automaton object.
 */
public class State {

    /**
     * The label of the state object within the automaton.
     */
    protected Integer label;

    /**
     * Boolean indicating whether this state is an accepting state of the automaton.
     */
    protected Boolean isAccepting;

    /**
     * HashMap representing the transition from this state to another on a character.
     */
    protected HashMap<Character, State> characterTransitions = new HashMap<>();

    /**
     * ArrayList of states we can reach from this state with epsilon.
     */
    protected ArrayList<State> epsilonTransitions = new ArrayList<>();

    /**
     * Constructor for State objects.
     * @param isAccepting Boolean indicating whether this state is an accepting state of the automaton.
     */
    public State(boolean isAccepting, int label) {
        this.isAccepting = isAccepting;
        this.label = label;
    }

    /**
     * Method to add a new transition from this state to another, with 'null' transition corresponding to epsilon.
     * @param transitionChar The character with which we transition to the destination state.
     * @param destination The State object we transition to with the input character.
     */
    public void addTransition(Character transitionChar, State destination) {
        if (transitionChar == null) {
            epsilonTransitions.add(destination);
            return;
        }
        characterTransitions.put(transitionChar, destination);
    }

    /**
     * Method to get the state transitioned to from the current state on some non-null character.
     * @param transitionChar The character to transition with.
     * @return The state transitioned to with the input character.
     * @throws NoSuchTransitionException Thrown when there is no transition to any state from the current state with the
     * input character.
     */
    public State getCharTransition(Character transitionChar) throws NoSuchTransitionException {
        if (!characterTransitions.containsKey(transitionChar)) throw new NoSuchTransitionException();
        return characterTransitions.get(transitionChar);
    }

    /**
     * Method to label the current state as an accepting,or otherwise non-accepting state of the automaton.
     * @param isAccepting Boolean indicating whether this state is accepting or not.
     */
    public void setAccepting(boolean isAccepting) {
        this.isAccepting = isAccepting;
    }

    /**
     * Method to determine whether the current state is an accepting state.
     * @return Boolean indicating whether this state is accepting or not.
     */
    public Boolean isAccepting() {
        return isAccepting;
    }

    /**
     * Method to get the label of the state within the encapsulating automaton.
     * @return The integer label of the state.
     */
    public Integer getLabel() {
        return label;
    }

    /**
     * Method to set the label of the current state.
     * @param label The integer to label the state with.
     */
    public void setLabel(Integer label) {
        this.label = label;
    }

    /**
     * Method to get the states reachable from this state to another on some input char, taking into account the states
     * reachable from the current state on epsilon - used in subset construction.
     * @param transitionChar The character to transition on.
     * @return ArrayList of states reachable from this one on the input character.
     */
    public ArrayList<State> characterClosure(char transitionChar) {
        ArrayList<State> reachableOnCharacter = new ArrayList<>();
        ArrayList<State> epsilonClosure = epsilonClosure();
        for (State state: epsilonClosure) {
            try {
                reachableOnCharacter.add(state.getCharTransition(transitionChar));
            } catch (NoSuchTransitionException e) {
                // No transition from NFAState on transitionChar, we can ignore.
            }
        }
        return reachableOnCharacter;
    }

    /**
     * Method to get the epsilon closure of the current state - all states reachable from this one on epsilon input.
     * @return ArrayList of states reachable on epsilon.
     */
    public ArrayList<State> epsilonClosure() {
        return epsilonClosure(new ArrayList<>());
    }

    /**
     * Recursive method to get all of the states reachable on epsilon input from the current state - all states
     * reachable from those states on epsilon - and so on.
     * @param alreadyMarked ArrayList of states we have added to the closure to eliminate kleene closure infinite loop.
     * @return ArrayList of states corresponding to the epsilon closure of the current state.
     */
    private ArrayList<State> epsilonClosure(ArrayList<State> alreadyMarked){
        ArrayList<State> currentClosure = new ArrayList<>();
        currentClosure.add(this);
        alreadyMarked.add(this);
        for (State state: epsilonTransitions) {
            if (alreadyMarked.contains(state)) continue;
            currentClosure.addAll(state.epsilonClosure(alreadyMarked));
        }
        return currentClosure;
    }

    /**
     * Method to pretty print the attributes of the current state - label, is accepting and states reachable on
     * transitions.
     * @return String representing the attributes of the current state.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" - State " + label + ": ");
        for (Character transitionChar: characterTransitions.keySet()) {
            try {
                builder.append("(" + transitionChar + ", " + getCharTransition(transitionChar).getLabel() + ") ");
            } catch (NoSuchTransitionException e) {
                // No transition from NFAState on transitionChar, we can ignore.
            }
        }
        for (State s:  epsilonTransitions) builder.append("(ε, " + s.getLabel() + ") ");
        if (isAccepting) builder.append("ACCEPTING");
        return builder.toString();
    }

}
