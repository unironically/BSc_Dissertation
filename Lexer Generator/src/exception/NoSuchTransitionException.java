package exception;

/**
 * Class implementing an exception thrown when no transition exists from one state to another on some character.
 */
public class NoSuchTransitionException extends Exception {

    /**
     * Constructor for NoSuchTransitionException objects.
     */
    public NoSuchTransitionException() {
        super();
    }

}
