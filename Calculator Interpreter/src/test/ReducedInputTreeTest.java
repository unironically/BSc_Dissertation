package test;

import antlr4.InfixLexer;
import antlr4.InfixParser;
import main.ReducedInputTree;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to encapsulate JUnit tests for the ReducedInputTree class.
 */
public class ReducedInputTreeTest {

    /**
     * ReducedInputTree object to be used in the test cases.
     */
    private ReducedInputTree tree;

    /**
     * Method to set up the test cases by initialising a new ReducedInputTree object.
     */
    @BeforeEach
    public void setUp() {
        InfixLexer lexer = new InfixLexer(CharStreams.fromString("(9 + 11) / 5"));
        InfixParser parser = new InfixParser(new CommonTokenStream(lexer));
        tree = new ReducedInputTree(parser.input().getChild(0));
    }

    /**
     * Test case for the ability to get the String representation of a TreeNode's TreeToken object.
     */
    @Test
    public void testCorrectRoot() {
        assertEquals("/", tree.getRoot().getToken().toString(),
                "ReducedInputTree.getRoot() returned an incorrect node.");
    }

}
