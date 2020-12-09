package abstree.literal;

import convert.Operation;
import struct.StructType;

/**
 * Represents the use of boolean literals.
 */
public class AbsLiteralBoolean extends AbsLiteral {

    /**
     * Boolean value used.
     */
    boolean value;

    /**
     * Constructor taking a boolean value representing the literal value used.
     * @param value Boolean literal value.
     */
    public AbsLiteralBoolean(boolean value) {
        super(StructType.getTypeFromIdentifier("boolean"));
        this.value = value;
    }

    /**
     * Method to generate the Java byte code representing this literal.
     * @return Byte array representing the Java byte code.
     */
    public byte[] getByteCode() {
        byte thisOp = (value) ? Operation.iConstN(1) : Operation.iConstN(0);
        byte[] out =  new byte[] {thisOp};
        return out;
    }

    /**
     * Method representing an AND operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public boolean and(AbsLiteral other) {
        return this.value && ((AbsLiteralBoolean)other).value;
    }

    /**
     * Method representing an OR operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    @Override
    public boolean or(AbsLiteral other) {
        return this.value || ((AbsLiteralBoolean)other).value;
    }

}
