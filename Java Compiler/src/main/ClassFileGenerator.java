package main;

import convert.ClassFormatConverter;
import exception.CompileTimeError;
import resource.ConstantPool;
import struct.StructClass;
import struct.StructFile;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Class to convert the input program to byte code stored within class files.
 */
public class ClassFileGenerator {

    /**
     * 4 byte magic number used at the beginning of each Java program.
     */
    public static final byte[] MAGIC_NUM = {(byte)202, (byte)254, (byte)186, (byte)190};

    /**
     * Short representing the minor Java version supported by this compiler.
     */
    public static final short MIN_VERSION = 0;

    /**
     * Short representing the major Java version supported by this compiler.
     */
    public static final short MAJ_VERSION = 50;

    /**
     * ByteBuffer to write bytes to as they are generated.
     */
    private ByteBuffer buffer;

    /**
     * ArrayList of byte arrays representing the byte code for each class.
     */
    private ArrayList<byte[]> bufferList;

    /**
     * String directory of the class files to write.
     */
    private String classDir;

    /**
     * StructFile file to convert to class files.
     */
    private StructFile mainFile;

    /**
     * ClassFormatConverter object to convert each class within the input program to byte code.
     */
    private ClassFormatConverter classFormatConverter;

    /**
     * Constructor taking a file path string and a file structure to convert.
     * @param classDir String file directory.
     * @param mainFile StructFile file to process.
     */
    public ClassFileGenerator(String classDir, StructFile mainFile) {
        this.classDir = classDir.split(mainFile.getMainClassName()+".java")[0];
        this.classFormatConverter = new ClassFormatConverter();
        this.mainFile = mainFile;
    }

    /**
     * Method to generate the byte code for each class within the file.
     */
    public void generate() {
        for (StructClass structClass: mainFile.getClassList()) {
            bufferList = new ArrayList<>();
            buildClass(structClass);
        }
    }

    /**
     * Method to generate the byte code for a particular class within the file.
     * @param structClass StructClass structure of the class to convert.
     */
    public void buildClass(StructClass structClass) {
        addData(MAGIC_NUM);
        addData(MIN_VERSION);
        addData(MAJ_VERSION);
        byte[] classData = classFormatConverter.convertClass(structClass);
        addData(ConstantPool.INSTANCE.getBytes());
        addData(classData);
        createBuffer();
        writeBuffer(structClass.getIdentifier());
    }

    /**
     * Method to add the data used by a class file to the byte buffer.
     * @param o Object to convert.
     */
    private void addData(Object o) {
        if (o == null) return;
        ByteBuffer out;
        if (o.getClass().equals(Integer.class))
            out = ByteBuffer.allocate(4).putInt((int) o);
        else if (o.getClass().equals(Short.class))
            out = ByteBuffer.allocate(2).putShort((short) o);
        else if (o.getClass().equals(byte[].class))
            out = ByteBuffer.allocate(((byte[]) o).length).put((byte[]) o);
        else
            out = ByteBuffer.allocate(1).putInt((byte) o);
        bufferList.add(out.array());
    }

    /**
     * Method to create the ByteBuffer based on the size of the bufferList ArrayList.
     */
    private void createBuffer() {
        int capacity = 0;
        for (byte[] b: bufferList) capacity += b.length;
        buffer = ByteBuffer.allocate(capacity);
        for (byte[] b: bufferList) buffer.put(b);
    }

    /**
     * Method to write a class structure and byte code to a respective class file.
     * @param className
     */
    private void writeBuffer(String className) {
        try {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(classDir + className + ".class"));
            for (byte b: buffer.array()) os.write(b);
            os.close();
        } catch (IOException e) {
            throw new CompileTimeError("couldn't write bytes to " + className + ".class");
        }
    }

}
