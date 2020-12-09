package automaton.base;

import java.util.ArrayList;

/**
 * Class implementing finite-state automata with a list of states, extended by both deterministic and non-deterministic
 * finite-state automata.
 */
public class FA {

    /**
     * ArrayList of states within the automaton which are accepting states.
     */
    protected ArrayList<State> acceptingStates = new ArrayList<>();

    /**
     * ArrayList of all of the state within the automaton.
     */
    protected ArrayList<State> states = new ArrayList<>();

    /**
     * Start state of the automaton, where processing begins.
     */
    protected State start;

    /**
     * Current state pointed to, which we use when traversing the automaton with an input string.
     */
    protected State current;

    /**
     * Array of all characters supported by the automaton, the alphabet.
     */
    protected char[] alphabet;

    /**
     * Static count of all states within an automaton object.
     */
    public static int stateCount = 0;

    /**
     * Constructor for finite-state automata taking an alphabet.
     * @param alphabet Character array corresponding to the alphabet supported by the finite-state automaton.
     */
    public FA(char[] alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Method to add a new state to an automaton and add it to the list of states held.
     * @param isAccepting Boolean indicating whether the new state is an accepting state.
     * @return The State object created and added to the automaton.
     */
    public State newState(boolean isAccepting) {
        State toAdd = new State(isAccepting, stateCount++);
        if (isAccepting) acceptingStates.add(toAdd);
        states.add(toAdd);
        return toAdd;
    }

    /**
     * Method to concatenate two finite-state automaton by creating a transition from all of the left automaton's
     * accepting states to the right's start state and making them non-accepting.
     * @param other The finite-state automaton to concatenate to this.
     * @return The final finite-state automaton after concatenation.
     */
    public FA concatenate(FA other) {
        for (State acceptingState: getAcceptingStates()) {
            acceptingState.addTransition(null, other.getStart());
            acceptingState.setAccepting(false);
        }
        acceptingStates = other.getAcceptingStates();
        for (State s: other.getStates()) {
            if (!states.contains(s)) states.add(s);
        }
        return this;
    }

    /**
     * Method to get the starting state of the automaton.
     * @return State which acts as the start state.
     */
    public State getStart() {
        return start;
    }

    /**
     * Method to get the list of accepting states of the automaton.
     * @return ArrayList containing the accepting states.
     */
    public ArrayList<State> getAcceptingStates() {
        return acceptingStates;
    }

    /**
     * Method to get the list of all states of the automaton.
     * @return ArrayList containing all states.
     */
    public ArrayList<State> getStates() {
        return states;
    }

    /**
     * Method to remove a state from the automaton.
     * @param toRemove The state to remove.
     */
    public void removeState(State toRemove) {
        states.remove(toRemove);
    }

    /**
     * Method to relabel all of the states of the automaton with numbers from 0.
     */
    public void relabel() {
        int firstLabel = 0;
        for (State s: states) {
            s.setLabel(firstLabel++);
        }
    }

    /**
     * Method to pretty print the automaton with the list of states contained.
     * @return String representing the attributes of the automaton.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Start state: " + start.getLabel() + "\n");
        for (State s: states) builder.append(s.toString() + "\n");
        return builder.toString();
    }

}
