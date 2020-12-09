package automaton.nfa;

import automaton.base.State;
import automaton.dfa.DFA;
import main.DFAConstructor;

import java.util.ArrayList;

/**
 * Class to implement the construction of alternation ('or') within Thompson's construction for regular expressions.
 */
public class AlternationNFA extends NFA {

    /**
     * Constructor for AlternationNFA objects.
     * @param left The left sub-NFA to alternate.
     * @param right The right sub-NFA to alternate.
     * @param alphabet Array of characters within the alphabet of the NFA.
     */
    public AlternationNFA(NFA left, NFA right, char[] alphabet) {
        super(alphabet);
        construct(left, right);
    }

    /**
     * Method to construct the alternation NFA using minimised DFA objects constructed from the left and right sub-NFAs.
     * @param left The left sub-NFA to alternate.
     * @param right The right sub-NFA to alternate.
     */
    private void construct(NFA left, NFA right) {
        DFA minLeft = new DFAConstructor(left, alphabet).construct().minimise();
        DFA minRight = new DFAConstructor(right, alphabet).construct().minimise();
        start.addTransition(null, minLeft.getStart());
        start.addTransition(null, minRight.getStart());
        ArrayList<State> allAccepting = minLeft.getAcceptingStates();
        allAccepting.addAll(minRight.getAcceptingStates());
        for (State s: allAccepting) {
            s.addTransition(null, finishState);
            s.setAccepting(false);
        }
        states.addAll(minLeft.getStates());
        states.addAll(minRight.getStates());
    }

}
