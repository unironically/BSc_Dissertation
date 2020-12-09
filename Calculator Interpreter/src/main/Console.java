package main;

import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class to encapsulate the console interface presented to the user upon starting the program.
 */
public class Console {

    /**
     * InputHandler class instance which we pass input strings to for interpreting,
     * and from which we receive calculation results.
     */
    private InputHandler handler;

    /**
     * Constructor for creating an InputHandler object.
     * @param verboseMode Boolean indicating whether verbose mode was activated by user flag.
     */
    public Console(boolean verboseMode) {
        this.handler = new InputHandler(verboseMode);
    }

    /**
     * Method to create the console interface using a loop and handle all manner of user inputs.
     */
    public void start() {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("$ ");
            Double ans = null;
            try {
                String line = scan.nextLine();
                if (line.strip().equals("")) continue;
                ans = handler.handleString(line);
            } catch (ParseCancellationException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                return;
            }
            if (ans != null) System.out.println(ans);
        }
    }

}
