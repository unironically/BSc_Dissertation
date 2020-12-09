package abstree.literal;


import convert.Operation;

/**
 * Represents the use of a null literal value.
 */
public class AbsLiteralNull extends AbsLiteral {

    /**
     * Constructor for null literal use.
     */
    public AbsLiteralNull() {
        super(null);
    }

    /**
     * Method to generate the byte code representing a null literal.
     * @return Byte array representing the byte code for this literal.
     */
    public byte[] getByteCode() {
        return new byte[] {Operation.ACONST_NULL.getIndex()};
    }

}
