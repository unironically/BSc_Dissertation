package automaton.dfa;

import automaton.base.FA;
import automaton.base.State;
import exception.NoSuchTransitionException;

import java.util.ArrayList;

/**
 * Class to implement deterministic finite-state automata constructed by subset construction.
 */
public class DFA extends FA {

    /**
     * The current DFAState used during traversal of the automaton.
     */
    private DFAState currentState;

    /**
     * Constructor for DFA objects simply using the parent FA constructor.
     * @param alphabet Character alphabet supported by the automaton.
     */
    public DFA(char[] alphabet) {
        super(alphabet);
    }

    /**
     * Method to add a new state to the DFA, which holds a list of NFA states contained.
     * @param nfaSubStates The states of the NFA this DFA state is constructed from using subset construction.
     * @param isAccepting Boolean indicating whether this state is an accepting state.
     * @return The DFAState object created by this method.
     */
    public DFAState newState(ArrayList<State> nfaSubStates, boolean isAccepting) {
        DFAState toAdd = new DFAState(nfaSubStates, isAccepting, stateCount++);
        if (isAccepting) acceptingStates.add(toAdd);
        states.add(toAdd);
        return toAdd;
    }

    /**
     * Method to set the start state of the DFA.
     * @param startState The state to set as the start state.
     */
    public void setStart(State startState) {
        this.start = startState;
        this.current = startState;
    }

    /**
     * Method to transition from one state in the DFA to another on an input character.
     * @param transitionChar The character to transition with.
     * @throws NoSuchTransitionException Thrown when there is no transition to any state on the input character.
     */
    private void traverse(char transitionChar) throws NoSuchTransitionException {
        currentState = (DFAState) currentState.getCharTransition(transitionChar);
    }

    /**
     * Method to test whether this DFA accepts an input string.
     * @param expression The string input to determine acceptance for.
     * @return Boolean indicating whether or not the DFA accepts the input string.
     */
    public boolean accepts(String expression) {
        boolean accepts;
        currentState = (DFAState) start;
        try {
            for (char c : expression.toCharArray()) traverse(c);
            accepts = currentState.isAccepting();
        } catch (NullPointerException | NoSuchTransitionException e) {
            return false;
        }
        return accepts;
    }

    /**
     * Method to minimise the current DFA using Hopcroft's algorithm for DFA minimisation.
     * @return The minimum possible DFA equivalent to the current original DFA.
     */
    public DFA minimise() {
        ArrayList<ArrayList<State>> partition = new ArrayList<>();
        ArrayList<State> nonAcceptingStates = getNonAcceptingStates();
        if (nonAcceptingStates.size() > 0) partition.add(nonAcceptingStates);
        partition.add(acceptingStates);
        ArrayList<ArrayList<State>> partitionCopy  = (ArrayList<ArrayList<State>>) partition.clone();
        while (!partitionCopy.isEmpty()) {
            ArrayList<State> currentStateGroup = partitionCopy.get(0);
            partitionCopy.remove(currentStateGroup);
            for (char transitionChar: alphabet) {
                ArrayList<State> statesReachableInGroupOnChar = getTransitionToStateIn(currentStateGroup, transitionChar);
                if (statesReachableInGroupOnChar.size() <= 0) continue;
                for (int i = 0; i < partition.size(); i++) {
                    if (getIntersection(statesReachableInGroupOnChar, partition.get(i)).isEmpty()
                            || getComplement(partition.get(i), statesReachableInGroupOnChar).isEmpty()) continue;
                    ArrayList<State> partitionGroup = partition.get(i);
                    ArrayList<State> xIntersectY = getIntersection(statesReachableInGroupOnChar, partitionGroup);
                    ArrayList<State> xComplementY = getComplement(partitionGroup, statesReachableInGroupOnChar);
                    partition.remove(partitionGroup);
                    partition.add(xIntersectY);
                    partition.add(xComplementY);
                    if (partitionCopy.contains(partitionGroup)) {
                        partitionCopy.remove(partitionGroup);
                        partitionCopy.add(xIntersectY);
                        partitionCopy.add(xComplementY);
                    } else {
                        if (xIntersectY.size() <= xComplementY.size()) partitionCopy.add(xIntersectY);
                        else partitionCopy.add(xComplementY);
                    }
                }
            }
        }
        return getFinalMinimalDFA(partition);
    }

    /**
     * Method to return the minimum possible DFA equivalent after adding the transitions between groups of states
     * within the partition generated by the minimise method.
     * @param statePartition The partition of state groups we transition between.
     * @return The new minimal DFA constructed.
     */
    private DFA getFinalMinimalDFA(ArrayList<ArrayList<State>> statePartition) {
        DFA newDFA = new DFA(alphabet);
        ArrayList<DFAState> minimalDFAStates = new ArrayList<>();
        for (int i = 0; i < statePartition.size(); i++) {
            DFAState groupRepresentative = newDFA.newState(statePartition.get(i), hasAccepting(statePartition.get(i)));
            if (hasStart(statePartition.get(i))) newDFA.setStart(groupRepresentative);
            minimalDFAStates.add(groupRepresentative);
        }
        for (int j = 0; j < statePartition.size(); j++) {
            for (char c: alphabet) {
                int groupTransitionTo = getGroupNumberForTransition(statePartition, statePartition.get(j), c);
                if (groupTransitionTo >= 0) minimalDFAStates.get(j).addTransition(c, minimalDFAStates.get(groupTransitionTo));
            }
        }
        newDFA.relabel();
        return newDFA;
    }

    /**
     * Method to get a list of states of the current DFA which, on an input character, can reach any state within the
     * stateList passed to the function
     * @param stateList The list of states to test transition to.
     * @param transitionChar The character to transition with.
     * @return ArrayList of states of the current DFA with which we can reach any state in stateList on transitionChar.
     */
    private ArrayList<State> getTransitionToStateIn(ArrayList<State> stateList, char transitionChar) {
        ArrayList<State> newStates = new ArrayList<>();
        for (State s: states) {
            State transitionedTo = null;
            try {
                transitionedTo = s.getCharTransition(transitionChar);
            } catch (NoSuchTransitionException e) {
                // No transition to transitionChar, we can ignore
            }
            if (stateList.contains(transitionedTo)) newStates.add(s);
        }
        return newStates;
    }

    /**
     * Method to get the intersection between two groups of states.
     * @param left The first list of states.
     * @param right The second list of states.
     * @return ArrayList containing the intersection between the first and second lists.
     */
    private ArrayList<State> getIntersection(ArrayList<State> left, ArrayList<State> right) {
        ArrayList<State> intersection = new ArrayList<>();
        for (State s: left) {
            if (right.contains(s)) intersection.add(s);
        }
        return intersection;
    }

    /**
     * Method to get the complement left - right of two lists of states left and right.
     * @param left The left list of states.
     * @param right The right list of states.
     * @return ArrayList containing the list of states in left but not in right.
     */
    private ArrayList<State> getComplement(ArrayList<State> left, ArrayList<State> right) {
        ArrayList<State> compliment = new ArrayList<>();
        for (State s: left) {
            if (!right.contains(s)) compliment.add(s);
        }
        return compliment;
    }

    /**
     * Method to get all of the states within the DFA which are non-accepting.
     * @return ArrayList of non-accepting DFA states.
     */
    private ArrayList<State> getNonAcceptingStates() {
        ArrayList<State> nonAccepting = states;
        nonAccepting.removeAll(acceptingStates);
        return nonAccepting;
    }

    /**
     * Method to test whether a group of states contains the start state of a DFA.
     * @param group The ArrayList containing a grouping of states.
     * @return Boolean indicating whether or not a start state is within the passed grouping.
     */
    private boolean hasStart(ArrayList<State> group) {
        DFAState start = (DFAState) getStart();
        for (State s: group) {
            if (s.equals(start)) return true;
        }
        return false;
    }

    /**
     * Method to test whether a group of states contains an accepting state of the DFA.
     * @param group The ArrayList containing a grouping of states.
     * @return Boolean indicating whether or not an accepting state is within this group.
     */
    private boolean hasAccepting(ArrayList<State> group) {
        for (State s: group) {
            if (s.isAccepting()) return true;
        }
        return false;
    }

    /**
     * Method to get the state grouping within the state partition which contains a state we can transition to from
     * any state within the current passed grouping on an input character.
     * @param statePartition The partition of states contained within the DFA.
     * @param group The current grouping of states we transition from.
     * @param transitionChar The character we transition to another grouping with.
     * @return The index of the group within the state partition we transition to.
     */
    private int getGroupNumberForTransition(ArrayList<ArrayList<State>> statePartition, ArrayList<State> group, char transitionChar) {
        DFAState transitionedTo = null;
        int groupNumForState = -1;
        for (int i = 0; i < group.size(); i++) {
            try {
                transitionedTo = (DFAState) group.get(i).getCharTransition(transitionChar);
            } catch (NoSuchTransitionException e) {
                // We can ignore
            }
            if (transitionedTo != null) break;
        }
        for (int i = 0; i < statePartition.size(); i++) {
            if (statePartition.get(i).contains(transitionedTo)) {
                groupNumForState = i;
                break;
            }
        }
        return groupNumForState;
    }

    /**
     * Method to pretty print the DFA, using the superclass FA's toString method.
     * @return The string representation of the DFA and attributes.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DFA:\n");
        builder.append(super.toString());
        return builder.toString();
    }

}
