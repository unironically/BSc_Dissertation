package test;

import main.InputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to encapsulate JUnit test cases for the InputHandler class.
 */
public class InputHandlerTest {

    /**
     * InputHandler object to be used in the test cases.
     */
    private InputHandler handler;

    /**
     * Method to set up the test cases by initialising a new InputHandler object.
     */
    @BeforeEach
    public void setUp() {
        handler = new InputHandler(false);
    }

    /**
     * Test case for the ability to calculate the result of an expression and return the result through InputHandler.
     */
    @Test
    public void testProcessInput() {
        Double ans = 100.0;
        assertEquals(ans, handler.handleString("25 * 4"), "");
    }

}
