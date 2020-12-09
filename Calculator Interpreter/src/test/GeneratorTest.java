package test;

import antlr4.InfixLexer;
import antlr4.InfixParser;
import main.Generator;
import main.ReducedInputTree;
import main.SymbolTable;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to encapsulate JUnit test cases for the public methods ot the Generator class.
 */
public class GeneratorTest {

    /**
     * Generator object used in the tests.
     */
    private Generator gen;

    /**
     * ReducedInputTree object created by the Generator.
     */
    private ReducedInputTree tree;

    /**
     * Setting up the ReducedInputTree and Generator objects to use in the tests.
     */
    @BeforeEach
    public void setUp() {
        InfixLexer lexer = new InfixLexer(CharStreams.fromString("9 + 11"));
        InfixParser parser = new InfixParser(new CommonTokenStream(lexer));
        tree = new ReducedInputTree(parser.input().getChild(0));
        gen = new Generator(new SymbolTable());
    }

    /**
     * Test case for the method which generates stack code for a ReducedInputTree.
     */
    @Test
    public void testGeneration() {
        String code = gen.generateFromTree(tree.getRoot());
        String exp = "PUSH 9.0;\nPUSH 11.0;\nADD;\n";
        assertEquals(exp, code, "Generator object constructed incorrect code for given syntax tree.");
    }

}
