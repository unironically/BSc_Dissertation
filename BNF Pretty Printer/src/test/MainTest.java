package test;

import antlr4.BNFLexer;
import main.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit test class for testing the Main class.
 * @author Luke Bessant
 */
class MainTest {

    /**
     * Testing the Main.importSpecificationFile() method for creating a parser object for a file 'sample/boolean.bnf'
     */
    @Test
    public void testArgsFile() {
        BNFLexer lexer = null;
        String fileName = "sample/sample.bnf";
        assertNotNull(Main.importSpecificationFile(fileName),
                    "importSpecificationFile returned a null parser for the file supplied.");
    }

}