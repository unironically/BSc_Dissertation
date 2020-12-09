package main;

import antlr4.BNFLexer;
import antlr4.BNFParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Main class for taking BNF specification file inputs and printing them with a TreeHandler object.
 * @author Luke Bessant
 */
public class Main {

    /**
     * Main method to begin the process of parsing the BNF specification passed by file.
     * @param args Program arguments, arg[0] being the name of the BNF specification file passed used.
     */
    public static void main(String[] args) {
        String fileName = args[0];
        Path pathToFile = Paths.get(fileName);
        if (!pathToFile.toString().endsWith(".bnf")) {
            System.out.println("Invalid file supplied: must supply .bnf file.");
            return;
        }
        BNFParser parser = importSpecificationFile(fileName);
        TreeHandler printer = new TreeHandler(parser.spec());
        System.out.println(printer.getFormattedString());
    }

    /**
     * Method used to take the file name of a BNF specification and return the parser object for the file.
     * @param fileName The String name of the BNF specification file to import.
     * @return The BNFParser object for the file.
     */
    public static BNFParser importSpecificationFile(String fileName) {
        try {
            BNFLexer lexer = new BNFLexer(CharStreams.fromFileName(fileName));
            return new BNFParser(new CommonTokenStream(lexer));
        } catch (IOException e) {
            System.out.println("Error occurred whilst importing file: " + fileName);
            return null;
        }
    }

}