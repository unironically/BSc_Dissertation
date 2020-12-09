package main;

import exception.CompileTimeError;
import struct.StructFile;

import java.io.IOException;

/**
 * Main class from which the compiler program begins execution.
 */
public class Main {

    /**
     * Main method taking as input the file name of the Java input program to compile.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String fileName = verifyFile(args[0]);
        InputFileHandler inputHandler = new InputFileHandler(fileName);
        StructFile mainFile = inputHandler.getFileRepr();
        new ClassFileGenerator(fileName, mainFile).generate();

    }

    /**
     * Method to check that the input file is a .java file.
     * @param file String file name to check.
     * @return String valid file name.
     */
    public static String verifyFile(String file) {
        if (!file.endsWith(".java"))
            throw new CompileTimeError("input file must have .java extension");
        return file;
    }

}
