package test;

import main.TreeToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to encapsulate the JUnit test cases for the TreeToken class.
 */
public class TreeTokenTest {

    /**
     * Method to test the ability to get the value of a TreeToken holding a Double object.
     */
    @Test
    public void testNumberTokenValue() {
        TreeToken token = new TreeToken("99.0");
        assertEquals(99.0, Double.valueOf(token.toString()),
                "TreeToken with number input returned incorrect value.");
    }

    /**
     * Method to test the ability to get the type of a TreeToken number object.
     */
    @Test
    public void testNumberTokenType() {
        TreeToken token = new TreeToken("99");
        assertEquals(TreeToken.TokenType.NUMBER, token.getType(),
                "TreeToken with number input returned incorrect type.");
    }

    /**
     * Method to test the ability to get the value of a TreeToken holding an operation.
     */
    @Test
    public void testOperatorTokenValue() {
        TreeToken token = new TreeToken("+");
        assertEquals("+", Double.valueOf(token.toString()),
                "TreeToken with operator input returned incorrect value.");
    }

    /**
     * Method to test the ability to get the type of a TreeToken holding an operation.
     */
    @Test
    public void testOperatorTokenType() {
        TreeToken token = new TreeToken("+");
        assertEquals(TreeToken.TokenType.ADD, token.getType(),
                "TreeToken with operator input returned incorrect type.");
    }

}