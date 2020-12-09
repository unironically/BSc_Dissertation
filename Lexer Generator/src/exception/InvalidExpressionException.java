package exception;

/**
 * Class implementing an exception thrown when an input regular expression is invalid.
 */
public class InvalidExpressionException extends Exception {

    /**
     * Constructor for InvalidExpressionException objects.
     * @param message The exception message passed when throwing this exception.
     */
    public InvalidExpressionException(String message) {
        super(message);
    }

}
