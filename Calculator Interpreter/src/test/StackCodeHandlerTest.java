package test;

import main.StackCodeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to encapsulate JUnit tests for the StackCodeHandler class.
 */
public class StackCodeHandlerTest {

    /**
     * StackCodeHandler object to use within the test cases.
     */
    private StackCodeHandler genCodeHandler;

    /**
     * Double expected result of calculations within the test cases.
     */
    private Double result;

    /**
     * Method to initialise the StackCodeHandler and Double objects to use in test cases.
     */
    @BeforeEach
    public void setUp() {
        genCodeHandler = new StackCodeHandler();
        result = 4.0;
    }

    /**
     * Method to test the ability to calculate a result by passing stack code to the StackCodeHandler object.
     */
    @Test
    public void testGeneration() {
        assertEquals(result, genCodeHandler.execute("PUSH 9;\nPUSH 11;\nADD;\nPUSH 5;\nDIV;"),
                "Result calculated by StackCodeHandler didn't match expected result.");
    }

}
