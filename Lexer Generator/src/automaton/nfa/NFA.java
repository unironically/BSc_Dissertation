package automaton.nfa;

import automaton.base.FA;
import automaton.base.State;

/**
 * Class to implement non-deterministic finite-state automaton.
 */
public class NFA extends FA {

    /**
     * The single finish state held within an NFA constructed using Thompson's construction.
     */
    protected State finishState;

    /**
     * Constructor for NFA objects.
     * @param alphabet The array of characters supported by the automaton.
     */
    public NFA(char[] alphabet) {
        super(alphabet);
        this.start = newState(false);
        this.finishState = newState(true);
        this.current = start;
    }

    /**
     * Method to get the finish state of the NFA.
     * @return State representing the finish state.
     */
    public State getFinish() {
        return finishState;
    }

    /**
     * Method to pretty print the NFA using the superclass FA's toString method.
     * @return String representation of this NFA and attributes.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("NFA:\n");
        builder.append(super.toString());
        return builder.toString();
    }

}
