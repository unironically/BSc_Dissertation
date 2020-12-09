package main;

/**
 * Main class from which we invoke a new console object's start method to begin the user input console.
 */
public class Main {

    /**
     * The method from which we start the calculator program.
     * @param args The arguments passed when running the program executable.
     */
    public static void main(String[] args) {
        new Console(checkVerboseOn(args)).start();
    }

    /**
     * The method to parse any arguments passed when executing the program, checking for the 'verbose' mode flag.
     * @param args The arguments passed when running the program executable.
     * @return Boolean indicating whether the verbose mode flag was set.
     */
    public static boolean checkVerboseOn(String[] args) {
        for (String arg: args) {
            if (arg.equals("--verbose") | arg.equals("-v")) {
                return true;
            }
            System.out.println("Error: argument '" + arg + "' not recognised");
        }
        return false;
    }

}