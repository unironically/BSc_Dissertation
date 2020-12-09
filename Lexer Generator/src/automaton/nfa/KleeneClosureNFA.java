package automaton.nfa;

import automaton.base.State;
import automaton.dfa.DFA;
import main.DFAConstructor;

/**
 * Class to implement kleene closure regular expressions during Thompson's construction.
 */
public class KleeneClosureNFA extends NFA {

    /**
     * Constructor for KleeneClosureNFA objects.
     * @param sub The sub-NFA we construct a kleene closure for.
     * @param alphabet The array of characters supported by this automaton.
     */
    public KleeneClosureNFA(NFA sub, char[] alphabet) {
        super(alphabet);
        construct(sub);
    }

    /**
     * Method to construct the kleene closure automaton.
     * @param sub The sub-NFA we construct the kleene closure for.
     */
    private void construct(NFA sub) {
        DFA minSub = new DFAConstructor(sub, alphabet).construct().minimise();
        start.addTransition(null, finishState);
        start.addTransition(null, minSub.getStart());
        for (State s: minSub.getAcceptingStates()) {
            s.addTransition(null, finishState);
            s.addTransition(null, minSub.getStart());
            s.setAccepting(false);
        }
        states.addAll(minSub.getStates());
    }

}
