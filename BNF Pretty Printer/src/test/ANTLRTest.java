package test;

import antlr4.BNFLexer;
import antlr4.BNFParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class used to test the functionality of the classes created by the ANTLR4 parser generator.
 * @author Luke Bessant
 */
class ANTLRTest {

    /**
     * BNFLexer object used to tokenise the input stream.
     */
    public static BNFLexer lexer;

    /**
     * BNFParser object used to parse the tokens identified by the lexer.
     */
    public static BNFParser parser;

    /**
     * Testing for the ability to create simple productions.
     */
    @Test
    public void testFirstTreeString() {
        lexer = new BNFLexer(CharStreams.fromString("if_stmt ::= 'if' expr 'then' stmt ['else' stmt]."));
        parser = new BNFParser(new CommonTokenStream(lexer));
        assertEquals(parser.spec().getText(), "if_stmt::='if'expr'then'stmt['else'stmt].",
                "Test string for if_stmt non-terminal did not match the string generated by the parser.");
    }

    /**
     * Testing for the correct parsing of the pipe character.
     */
    @Test
    public void testPipeTreeString() {
        lexer = new BNFLexer(CharStreams.fromString("boolean ::= 'true' | 'false'."));
        parser = new BNFParser(new CommonTokenStream(lexer));
        assertEquals(parser.spec().getText(), "boolean::='true'|'false'.",
                "Test string for boolean non-terminal did not match the string generated by the parser.");
    }

    /**
     * Testing the regex '.*?' for the ability to include special characters in terminal strings.
     */
    @Test
    public void testNonSpecifiedChars() {
        lexer = new BNFLexer(CharStreams.fromString("char ::= '`' | '~' | ':' | '#'."));
        parser = new BNFParser(new CommonTokenStream(lexer));
        assertEquals(parser.spec().getText(), "char::='`'|'~'|':'|'#'.",
                "Test string for char non-terminal not match the string generated by the parser.");
    }

    /**
     * Testing the ability to load a bnf specification from a file input stream.
     */
    @Test
    public void testFileInputStream() {
        String fileName = "sample/boolean.bnf";
        try {
            lexer = new BNFLexer(CharStreams.fromFileName(fileName));
            parser = new BNFParser(new CommonTokenStream(lexer));
            assertEquals(parser.spec().getText(), "if_stmt::=((((((((((('if'cond'then'stmt['else'stmt])" +
                            "|('('cond')''?'stmt':'stmt)))))))))));boolean::='true'|'false'.",
                    "Test string imported from file did not match the string generated by the parser.");
        } catch (IOException e) {
            System.out.println("Error occurred whilst handling file: " + fileName);
        }
    }

}