package abstree.literal;

import convert.Operation;
import resource.ConstantPool;
import struct.StructType;

/**
 * Represents the use of integer literals.
 */
public class AbsLiteralInt extends AbsLiteral {

    /**
     * Integer literal used.
     */
    int value;

    /**
     * Constructor for integer literals taking an integer value used in the program.
     * @param value Integer literal represented.
     */
    public AbsLiteralInt(int value) {
        super(StructType.getTypeFromIdentifier("int"));
        this.value = value;
    }

    /**
     * Method to generate the Java byte code representing this literal.
     * @return Byte array representing the Java byte code.
     */
    public byte[] getByteCode() {
        byte[] out = new byte[0];
        if (-1 <= value && value <= 5)                                                                          // -1..5
            out = new byte[] {Operation.iConstN(value)};
        else if (-128 <= value && value <= 127)                                                                 // byte
            out = new byte[] {Operation.BIPUSH.getIndex(), (byte) value};      // byte
        else if (-32768 <= value && value <= 32767)                                                             // short
            out = storeShortOrInt(ConstantPool.shortToByteArr((short) value), Operation.SIPUSH.getIndex());
        else                                                                                            // int
            out = storeShortOrInt(ConstantPool.shortToByteArr(ConstantPool.INSTANCE.putInteger(value)), Operation.LDC.getIndex());
        return out;
    }

    /**
     * Method to generate the byte code for integer store operations with a value.
     * @param bytes Byte array representing the value used with the operation.
     * @param operation Operation representing the byte code used to store the integer.
     * @return Byte array representing the byte code for storing this integer literal.
     */
    public byte[] storeShortOrInt(byte[] bytes, byte operation) {
        byte[] out = new byte[1 + bytes.length];
        out[0] = operation;
        for (int j = 0; j < bytes.length; j++) out[j+1] = bytes[j];
        return out;
    }

    /**
     * Method representing addition of literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public int add(AbsLiteral other) {
        return this.value + ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing subtraction of literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public int sub(AbsLiteral other) {
        return this.value - ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing multiplication of literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public int mul(AbsLiteral other) {
        return this.value * ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing division of literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public int div(AbsLiteral other) {
        return this.value / ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing a greater than operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public boolean gt(AbsLiteral other) {
        return this.value > ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing a less than operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public boolean lt(AbsLiteral other) {
        return this.value < ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing a greater than or equal to operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public boolean gte(AbsLiteral other) {
        return this.value >= ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing a less than or equal to operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public boolean lte(AbsLiteral other) {
        return this.value <= ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing an equals operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public boolean eq(AbsLiteral other) {
        return this.value == ((AbsLiteralInt) other).value;
    }

    /**
     * Method representing a not equals operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public boolean ne(AbsLiteral other) {
        return this.value != ((AbsLiteralInt) other).value;
    }

}
