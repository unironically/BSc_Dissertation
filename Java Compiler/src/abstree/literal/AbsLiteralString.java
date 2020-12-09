package abstree.literal;

import convert.Operation;
import resource.ConstantPool;
import struct.StructType;

/**
 * Represents the use of a String literal within the input program.
 */
public class AbsLiteralString extends AbsLiteral {

    /**
     * String literal value used.
     */
    String value;

    /**
     * Constructor taking a String value representing the literal used.
     * @param value String literal represented.
     */
    public AbsLiteralString(String value) {
        super(StructType.getTypeFromIdentifier("String"));
        this.value = value.replace("\"", "");
    }

    /**
     * Method to generate the byte code needed for String literal usage.
     * @return Byte array representing the byte code this String literals.
     */
    public byte[] getByteCode() {
        byte[] out;
        byte[] poolPos = ConstantPool.shortToByteArr(ConstantPool.INSTANCE.putString(value.getBytes()));
        if (poolPos.length < 2) out = new byte[] {Operation.LDC.getIndex(), poolPos[0]};
        else out = new byte[] {Operation.LDC_W.getIndex(), poolPos[0], poolPos[1]};
        return out;
    }

}
