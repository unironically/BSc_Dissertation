package test;

import antlr4.BNFParser;
import main.Main;
import main.TreeHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for testing the TreeHandler class.
 * @author Luke Bessant
 */
class TreeHandlerTest {

    /**
     * Test for correct output of printer string based on text input.
     */
    @Test
    public void testTreePrinter() {
        String out = "if_stmt ::= ( ( ( ( ( ( ( ( ( ( ( 'if' cond 'then' stmt [ 'else' stmt ] ) " +
                "| ( '(' cond ')' '?' stmt ':' stmt ) ) ) ) ) ) ) ) ) ) ) . \nboolean ::= 'true' \n\t| 'false' . \n";
        String fileName = "sample/boolean.bnf";
        BNFParser parser = Main.importSpecificationFile(fileName);
        TreeHandler handler = new TreeHandler(parser.spec());
        assertEquals(handler.getFormattedString(), out);
    }

}