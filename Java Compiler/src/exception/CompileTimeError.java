package exception;

/**
 * Represents the error when the input program cannot be compiled.
 */
public class CompileTimeError extends Error {

    /**
     * Constructor for CompileTimeError taking a String error message.
     * @param message String error message.
     */
    public CompileTimeError(String message) {
        super(message);
        System.out.println("ERROR: " + message);
        System.exit(1);
    }

}
