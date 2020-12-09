package resource;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the constant pool used by each class within a class file.
 */
public class ConstantPool {

    /**
     * Constant pool instance used by a class.
     */
    public static ConstantPool INSTANCE = new ConstantPool();

    /**
     * HashMap matching constant pool records to their index in the pool.
     */
    private HashMap<ConstantPoolRecord, Short> addedMap = new HashMap<>();

    /**
     * ArrayList of current constant pool entries.
     */
    private ArrayList<ConstantPoolRecord> entries = new ArrayList<>();

    /**
     * Method to add a class reference to the constant pool.
     * @param in Byte array representing the class to add.
     * @return Short position of the class reference after adding to the pool.
     */
    public short putClass(byte[] in) {
        short pointer = putUtf8(in);
        byte[] entry = ByteBuffer.allocate(3)
                .put((byte) 7)
                .putShort(pointer)
                .array();
        return put(entry);
    }

    /**
     * Method to add a method reference to the constant pool.
     * @param inClass Byte array representing the class the method belongs to.
     * @param inName Byte array representing the method name.
     * @param inType Byte array representing the type descriptor of the method.
     * @return Short position of the method reference after adding to the pool.
     */
    public short putMethod(byte[] inClass, byte[] inName, byte[] inType) {
        return putMethodOrField((byte) 10, inClass, inName, inType);
    }

    /**
     * Method to add a field reference to the constant pool.
     * @param inClass Byte array representing the class the field belongs to.
     * @param inName Byte array representing the field name.
     * @param inType Byte array representing the type descriptor of the field.
     * @return Short position of the field reference after adding to the pool.
     */
    public short putField(byte[] inClass, byte[] inName, byte[] inType) {
        return putMethodOrField((byte) 9, inClass, inName, inType);
    }

    /**
     * Method to add a method or field reference to the constant pool.
     * @param tag Byte tag identifying a field or method reference.
     * @param inClass Byte array representing the class the method/field belongs to.
     * @param inName Byte array representing the method/field name.
     * @param inType Byte array representing the type descriptor of the method/field.
     * @return Short position of the method/field reference after adding to the pool.
     */
    private short putMethodOrField(byte tag, byte[] inClass, byte[] inName, byte[] inType) {
        inClass = alterPath(inClass);
        inType = alterPath(inType);
        short pointerA = putClass(inClass);
        short pointerB = putNameType(inName, inType);
        byte[] entry = ByteBuffer.allocate(5)
                .put(tag)
                .putShort(pointerA)
                .putShort(pointerB)
                .array();
        return put(entry);
    }

    /**
     * Method to add a name and type record to the constant pool.
     * @param inName Byte array representing the method/field name for the name and type record.
     * @param inType Byte array representing the type descriptor of the method/field for the name and type record.
     * @return Short position of the name and type reference after adding to the pool.
     */
    private short putNameType(byte[] inName, byte[] inType) {
        short pointerA = putUtf8(inName);
        short pointerB = putUtf8(inType);
        byte[] entry = ByteBuffer.allocate(5)
                .put((byte)12)
                .putShort(pointerA)
                .putShort(pointerB)
                .array();
        return put(entry);
    }

    /**
     * Method to add a String constant to the constant pool.
     * @param in Byte array of the string of characters to add.
     * @return Short position of the String reference after adding to the pool.
     */
    public short putString(byte[] in) {
        short pointer = putUtf8(in);
        byte[] entry = ByteBuffer.allocate(3)
                .put((byte)8)
                .putShort(pointer)
                .array();
        return put(entry);
    }

    /**
     * Method to add an integer constant to the constant pool.
     * @param in Byte array of the integer to add.
     * @return Short position of the name and type reference after adding to the pool.
     */
    public short putInteger(int in) {
        byte[] entry = ByteBuffer.allocate(5)
                .put((byte)3)
                .putInt(in)
                .array();
        return put(entry);
    }

    /**
     * Method to add a utf-8 string constant to the constant pool.
     * @param in Byte array of the utf-8 string to add.
     * @return Short position of the utf-8 string  after adding to the pool.
     */
    public short putUtf8(byte[] in) {
        byte[] entry = ByteBuffer.allocate(3 + in.length)
                .put((byte)1)
                .putShort(Integer.valueOf(in.length).shortValue())
                .put(in)
                .array();
        return put(entry);
    }

    /**
     * Method to put a constant pool record into the constant pool.
     * @param in Byte array of the record to add to the pool.
     * @return Short position of the constant pool record after adding to the pool.
     */
    public short put(byte[] in) {
        ConstantPoolRecord record = new ConstantPoolRecord(in, Integer.valueOf(entries.size() + 1).shortValue());
        if (addedMap.containsKey(record)) {
            return addedMap.get(record);
        }
        entries.add(record);
        addedMap.put(record, record.getIndex());
        return record.getIndex();
    }

    /**
     * Method to convert a short to either a two or one byte array.
     * @param in Short to convert to byte array.
     * @return Byte array representing the short.
     */
    public static byte[] shortToByteArr(short in) {
        if (in < 256) return new byte[] {(byte) in};
        return shortToTwoByte(in);
    }

    /**
     * Method to convert a short to a two byte array.
     * @param in Short to convert to byte array.
     * @return Byte array representing the short.
     */
    public static byte[] shortToTwoByte(short in) {
        return new byte[] {(byte)(in >>> 8), (byte)in};
    }

    /**
     * Method to convert dots in Java class path to forward slashes used in constant pool records.
     * @param in Byte array of the path to convert.
     * @return Byte array of the modified class path.
     */
    private byte[] alterPath(byte[] in) {
        byte[] out = in;
        for (int i = 0; i < out.length; i++)
            if (out[i] == '.') out[i] = '/';
        return out;
    }

    /**
     * Method to get the full byte code of the constant pool in its current state.
     * @return Byte array representing the current constant pool.
     */
    public byte[] getBytes() {
        int capacity = 0;
        for (ConstantPoolRecord entry: entries) capacity += entry.getBytes().length;
        ByteBuffer buffer = ByteBuffer.allocate(2 + capacity);
        buffer.putShort((short) (entries.size() + 1));
        for (ConstantPoolRecord entry: entries) buffer.put(entry.getBytes());
        return buffer.array();
    }

}
