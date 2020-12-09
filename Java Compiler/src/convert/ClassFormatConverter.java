package convert;

import abstree.AbsStatement;
import resource.ConstantPool;
import struct.Modifier;
import struct.StructClass;
import struct.StructField;
import struct.StructMethod;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for converting user defined classes of the input program to byte code.
 */
public class ClassFormatConverter {

    /**
     * Method to convert the contents of a class structure to byte code.
     * @param currentClass StructClass representing the class to convert.
     * @return Byte array representing the bytes of this class structure.
     */
    public byte[] convertClass(StructClass currentClass) {
        short mods = 0;
        ConstantPool.INSTANCE = new ConstantPool();
        for (Modifier m: currentClass.getModifiers()) mods += m.getDecimalValue();
        short poolPosThis = ConstantPool.INSTANCE.putClass(currentClass.getIdentifier().getBytes());
        short poolPosSuper = ConstantPool.INSTANCE.putClass(currentClass.getSuperClass().getPath().getBytes());
        byte[] fieldInfo = convertFields(currentClass);
        byte[] methodInfo = convertMethods(currentClass);
        ByteBuffer buffer = ByteBuffer.allocate((Short.SIZE/8) * 5 + fieldInfo.length + methodInfo.length);
        buffer.putShort(mods)                                           // 2B: access flags
                .putShort(poolPosThis)                                  // 2B: class cp index
                .putShort(poolPosSuper)                                 // 2B: super cp index
                .putShort((short) 0)                                    // 2B: interface count
                .put(fieldInfo)                                         // 2B nB: field count and info
                .put(methodInfo)                                        // 2B nB: method count and info
                .putShort((short) 0)                                    // 2B: attribute count
        ;
        return buffer.array();
    }

    /**
     * Method to convert the contents of class fields to byte code.
     * @param currentClass StructClass representing the class containing the fields to convert.
     * @return Byte array representing the bytes of the field structures.
     */
    private byte[] convertFields(StructClass currentClass) {
        HashMap<String, StructField> fields = currentClass.getFields();
        short num = (short) fields.size();
        if (num < 1) return ByteBuffer.allocate((Short.SIZE/8)).putShort(num).array();
        ByteBuffer buffer = ByteBuffer.allocate(((Short.SIZE/8) * 4) * num + (Short.SIZE/8)).putShort(num);
        for (String s: fields.keySet()) buffer.put(convertField(fields.get(s)));
        return buffer.array();
    }

    /**
     * Method to convert the contents of a field structure to byte code.
     * @param field StructField field to convert.
     * @return Byte array representing the bytes of this field structure.
     */
    private byte[] convertField(StructField field) {
        short mods = 0;
        for (Modifier m: field.getModifiers()) mods += m.getDecimalValue();
        short poolPosName = ConstantPool.INSTANCE.putUtf8(field.getIdentifier().getBytes());
        short poolPosSig = ConstantPool.INSTANCE.putUtf8(field.getType().getPathAsType().getBytes());
        short attrCount = (short) 0;
        ByteBuffer buffer = ByteBuffer.allocate((Short.SIZE/8) * 4);
        buffer.putShort(mods)                                           // 2B: access flags
                .putShort(poolPosName)                                  // 2B: field name index
                .putShort(poolPosSig)                                   // 2B: field descriptor index
                .putShort(attrCount)                                    // 2B: attribute count
        ;
        return buffer.array();
    }

    /**
     * Method to convert the contents of class methods to byte code.
     * @param currentClass StructClass representing the class containing the methods to convert.
     * @return Byte array representing the bytes of the method structures.
     */
    private byte[] convertMethods(StructClass currentClass) {
        HashMap<String, ArrayList<StructMethod>> methods = currentClass.getMethods();
        ArrayList<byte[]> methodByteList = new ArrayList<>();
        short methodCount = 0;
        short capacity = 0;
        for (String s: methods.keySet()) {
            for (StructMethod m: methods.get(s)) {
                byte[] methodBytes = convertMethod(m);
                capacity += methodBytes.length;
                methodByteList.add(methodBytes);
                methodCount++;
            }
        }
        ByteBuffer buffer = ByteBuffer.allocate(2 + capacity).putShort(methodCount);
        for (byte[] b: methodByteList) buffer.put(b);
        return buffer.array();
    }

    /**
     * Method to convert the contents of a method structure to byte code.
     * @param method StructField method to convert.
     * @return Byte array representing the bytes of this method structure.
     */
    private byte[] convertMethod(StructMethod method) {
        short mods = 0;
        for (Modifier m: method.getModifiers()) mods += m.getDecimalValue();
        short poolPosName = ConstantPool.INSTANCE.putUtf8(method.getIdentifier().getBytes());
        short poolPosSig = ConstantPool.INSTANCE.putUtf8(method.getSignature().getBytes());
        byte[] codeArr = createCodeAttribute(method);
        ByteBuffer buffer = ByteBuffer.allocate((Short.SIZE/8) * 4 + codeArr.length);
        buffer.putShort(mods)                                           // 2B: access flags
                .putShort(poolPosName)                                  // 2B: name index
                .putShort(poolPosSig)                                   // 2B: method signature index
                .putShort((short) 1)                                    // 2B: attribute count (we only use 'Code')
                .put(codeArr)                                           // nB: attribute info
        ;
        return buffer.array();
    }

    /**
     * Method to convert the code attribute containing Java operation byte code.
     * @param method StructMethod to convert the statements of.
     * @return Byte array representing the code of a method.
     */
    private byte[] createCodeAttribute(StructMethod method) {
        short poolPosName = ConstantPool.INSTANCE.putUtf8("Code".getBytes());
        byte[] codeArr = getCode(method);
        ByteBuffer buffer = ByteBuffer.allocate((Integer.SIZE/8) * 2 + (Short.SIZE/8) * 5 + codeArr.length);
        buffer.putShort(poolPosName)                                    // 2B: attribute name index
                .putInt(12 + codeArr.length)                            // 4B: attribute length
                .putShort((short) method.getMaxStackSize())             // 2B: max stack size
                .putShort((short) method.getLocalCount())               // 2B: max local count
                .putInt(codeArr.length)                                 // 4B: code length
                .put(codeArr)                                           // nB: code
                .putShort((short) 0)                                    // 2B: exception table size
                .putShort((short) 0)                                    // 2B: attribute count
        ;
        return buffer.array();
    }

    /**
     * Method to convert the statements of a method structure to byte code.
     * @param method StructMethod method whose statements are converted.
     * @return Byte array representing the converted method code.
     */
    private byte[] getCode(StructMethod method) {
        ArrayList<AbsStatement> statements = method.getMethodTree().getStatements();
        ArrayList<byte[]> byteCode = new ArrayList<>();
        int capacity = 0;
        for (AbsStatement stmt: statements) {
            byte[] code = stmt.getByteCode();
            byteCode.add(code);
            capacity += code.length;
        }
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        for (byte[] code: byteCode) buffer.put(code);
        return buffer.array();
    }

}
