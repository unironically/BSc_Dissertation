package automaton.nfa;

/**
 * Class to implement an NFA for a single character used within Thompson's construction.
 */
public class CharacterNFA extends NFA {

    /**
     * Constructor for CharacterNFA objects.
     * @param newChar The character to transition on within this automaton.
     * @param alphabet The array of characters supported by the automaton.
     */
    public CharacterNFA(Character newChar, char[] alphabet) {
        super(alphabet);
        construct(newChar);
    }

    /**
     * Method to construct the single-character automaton.
     * @param newChar The character to transition from the start to finish state on.
     */
    private void construct(Character newChar) {
        if (newChar == 'ε') newChar = null;
        start.addTransition(newChar, finishState);
    }

}
