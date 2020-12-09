package convert;

import abstree.AbsMethod;
import resource.ConstantPool;

/**
 * Represents an operation used within Java byte code to execute some action.
 */
public enum Operation {

    /**
     * Load a constant pool entry by single byte index.
     */
    LDC((byte) 18, 2),

    /**
     * Load a constant pool entry by two byte index.
     */
    LDC_W((byte) 19, 3),

    /**
     * Store an object as a local of index greater than 3.
     */
    ASTORE((byte) 58, 2),

    /**
     * Store an object as a local of index less than or equal to 3,
     */
    ASTORE_N((byte) 75, 1),

    /**
     * Store an int primitive as a local of index greater than 3.
     */
    ISTORE((byte) 54, 2),

    /**
     * Store an int primitive as a local of index less than or equal to 3,
     */
    ISTORE_N((byte) 59, 1),

    /**
     * Get a static field by two byte constant pool index.
     */
    GETSTATIC((byte) 178, 3),

    /**
     * Get a static field by two byte constant pool index.
     */
    GETFIELD((byte) 180, 3),

    /**
     * Put a value in a static field.
     */
    PUTSTATIC((byte) 179, 3),

    /**
     * Put a value in an instance field.
     */
    PUTFIELD((byte) 181, 3),

    /**
     * Invoke a virtual non-static instance method.
     */
    INVOKEVIRTUAL((byte) 182,3),

    /**
     * Invoke a static method.
     */
    INVOKESTATIC((byte) 184, 3),

    /**
     * Invoke a constructor method.
     */
    INVOKESPECIAL((byte)183, 3),

    /**
     * Load the constant int value 0 onto the stack.
     */
    ICONST_0((byte) 3, 1),

    /**
     * Push a byte number onto the stack.
     */
    BIPUSH((byte) 16, 2),

    /**
     * Push a short number onto the stack.
     */
    SIPUSH((byte) 17, 3),

    /**
     * Push a null reference onto the stack.
     */
    ACONST_NULL((byte) 1, 1),

    /**
     * Load an int local of index greater than 3 onto the stack.
     */
    ILOAD((byte) 21, 2),

    /**
     * Load an int local of index less than or equal to 3 onto the stack.
     */
    ILOAD_N((byte) 26, 1),

    /**
     * Load an object reference of index greater than 3 onto the stack.
     */
    ALOAD((byte) 25, 2),

    /**
     * Load an object reference of index less than or equal to 3 onto the stack.
     */
    ALOAD_N((byte)42, 2),

    /**
     * Add two integer values and push the result to the stack.
     */
    IADD((byte) 96, 1),

    /**
     * Subtract two integer values and push the result to the stack.
     */
    ISUB ((byte) 100, 1),

    /**
     * Multiply two integer values and push the result to the stack.
     */
    IMUL((byte) 104, 1),

    /**
     * Divide two integer values and push the result to the stack.
     */
    IDIV((byte) 108, 1),

    /**
     * Perform an AND operation over two boolean values and push the result to the stack.
     */
    IAND((byte) 126, 1),

    /**
     * Perform an OR operation over two boolean values and push the result to the stack.
     */
    IOR((byte) 128, 1),

    /**
     * Perform a branching operation if the value at the top of the stack is 0.
     */
    IFEQ((byte) 153, 3),

    /**
     * Perform a branching operation if first two int entries in the stack are not equal.
     */
    IF_ICMPNE((byte) 160, 3),

    /**
     * Perform a branching operation if first two int entries in the stack are equal.
     */
    IF_ICMPEQ((byte) 159, 3),

    /**
     * Perform a branching operation if first two object entries in the stack are not equal.
     */
    IF_ACMPNE((byte) 166, 3),

    /**
     * Perform a branching operation if first two object entries in the stack are equal.
     */
    IF_ACMPEQ((byte) 165, 3),

    /**
     * Go to another location in the byte code.
     */
    GOTO((byte) 167, 3),

    /**
     * Instantiate a new object by class reference.
     */
    NEW((byte) 187, 3),

    /**
     * Duplicate the entry at the top of the stack.
     */
    DUP((byte)89, 3),

    /**
     * Void return operation.
     */
    RETURN((byte) 177, 1),

    /**
     * Return operation of int type.
     */
    IRETURN((byte) 172, 1),

    /**
     * Return operation of object types.
     */
    ARETURN((byte) 176, 1);

    /**
     * Byte op code of the operation.
     */
    private byte index;

    /**
     * Integer number of bytes used by the operation.
     */
    private int numBytes;

    /**
     * Constructor taking a byte op code and a the number of bytes the operation uses.
     * @param index Byte op code of the Operation.
     * @param numBytes Integer number of bytes used by the operation.
     */
    Operation(byte index, int numBytes) {
        this.index = index;
        this.numBytes = numBytes;
    }

    /**
     * Method to get the op code of an Operation.
     * @return Byte operation op code.
     */
    public byte getIndex() {
        AbsMethod.byteCount += numBytes;
        return index;
    }

    /**
     * Method to get the number of bytes used by an operation.
     * @return Integer number of bytes used.
     */
    public int getNumBytes() {
        return numBytes;
    }

    /**
     * Method to get a constant loading operation by integer value of the constant to load.
     * @param constant Integer constant value to load.
     * @return Byte op code of the constant loading operation used.
     */
    public static byte iConstN(int constant) {
        return (byte) (ICONST_0.getIndex() + constant);
    }

    /**
     * Method to generate the byte code for an operation with an attached integer value.
     * @param val Integer value to use in the operation.
     * @return Byte array representing the byte code of the operation.
     */
    public byte[] operationAndValue(int val) {
        byte[] out = new byte[getNumBytes()];
        out[0] = getIndex();
        if (getNumBytes() > 2) {
            byte[] shortArr = ConstantPool.shortToTwoByte((short) val);
            for (int i = 0; i < shortArr.length; i++) out[i+1] = shortArr[i];
        } else {
            out[1] = (byte) val;
        }
        return out;
    }

}
