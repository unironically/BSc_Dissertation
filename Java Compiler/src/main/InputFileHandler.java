package main;

import antlr4.*;
import exception.MismatchInputListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import struct.StructFile;
import visitor.ClassBuilderVisitor;
import visitor.TypeCheckerVisitor;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class to handle the input file given by a user.
 */
public class InputFileHandler {

    /**
     * String file name.
     */
    private String fileName;

    /**
     * ANTLR generated JavaLexer class to perform lexical analysis the input file.
     */
    private JavaLexer lexer;

    /**
     * ANTLR generated JavaParser class to parse the input file.
     */
    private JavaParser parser;

    /**
     * StructFile representing the input file.
     */
    private StructFile fileRepr;

    /**
     * Constructor taking a String file name.
     * @param fileName String file name.
     * @throws IOException Thrown if input file not found.
     */
    public InputFileHandler(String fileName) throws IOException {
        this.fileName = fileName;
        this.lexer = new JavaLexer(CharStreams.fromFileName(fileName));
        this.parser = new JavaParser(new CommonTokenStream(lexer));
        this.parser.removeErrorListeners();
        this.parser.addErrorListener(MismatchInputListener.INSTANCE);
        this.fileRepr = buildFile();
    }

    /**
     * Method to build the file structure representing the input program.
     * @return StructFile input file structure.
     */
    private StructFile buildFile() {
        String legalPublicClassName = Paths.get(fileName).getFileName().toString().split(".java")[0];
        StructFile builtFile = new ClassBuilderVisitor(legalPublicClassName).visitInput(parser.input());
        TypeCheckerVisitor vis = new TypeCheckerVisitor(builtFile);
        parser.reset();
        vis.visitInput(parser.input());
        return builtFile;
    }

    /**
     * Method to get the file structure generated by this class.
     * @return StructFile input file structure.
     */
    public StructFile getFileRepr() {
        return fileRepr;
    }

}