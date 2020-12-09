package automaton.dfa;

import automaton.base.State;

import java.util.ArrayList;

/**
 * Class to implement the states of a deterministic finite-state automaton.
 */
public class DFAState extends State {

    /**
     * ArrayList of states of a non-deterministic finite automaton which, through subset construction, this state holds.
     */
    protected ArrayList<State> nfaSubStates;

    /**
     * Boolean indicating whether this state has been handled during subset construction.
     */
    protected boolean isHandled = false;

    /**
     * Constructor for DFAState objects.
     * @param nfaSubStates The states of an NFA this state encapsulates.
     * @param isAccepting Boolean indicating whether this state is accepting.
     * @param label Integer label of the current state.
     */
    public DFAState(ArrayList<State> nfaSubStates, boolean isAccepting, int label) {
        super(isAccepting, label);
        this.nfaSubStates = nfaSubStates;
    }

    /**
     * Method to get the NFA sub-states encapsulated by this state.
     * @return ArrayList of NFA states.
     */
    public ArrayList<State> getNFASubStates() {
        return nfaSubStates;
    }

    /**
     * Method to determine whether this state has been handled during subset construction.
     * @return Boolean indicating whether this state has been handled.
     */
    public boolean isHandled() {
        return isHandled;
    }

    /**
     * Method to mark this state as handled during subset construction.
     */
    public void markHandled() {
        this.isHandled = true;
    }

    /**
     * Method to check whether this state is equal to another DFAState object by comparing the list of contained
     * NFA states.
     * @param state The DFAState object to compare this to.
     * @return Boolean indicating whether the states are equal.
     */
    public boolean equals(DFAState state) {
        ArrayList<State> otherStates = state.getNFASubStates();
        if (otherStates.size() != nfaSubStates.size()) return false;
        for (int i = 0; i < otherStates.size(); i++) {
            if (otherStates.get(i).getLabel() != nfaSubStates.get(i).getLabel()) return false;
        }
        return true;
    }

}
