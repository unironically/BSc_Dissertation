package abstree;

import convert.Operation;
import struct.StructPrimitive;
import struct.StructType;
import utils.ByteUtils;

/**
 * Represents return statements used within input programs.
 */
public class AbsReturn extends AbsStatement {

    /**
     * AbsExpr accompanying return expression where not within a void method.
     */
    private AbsExpr expression;

    /**
     * StructType type of the return statement.
     */
    private StructType type;

    /**
     * Constructor for return statements of void type.
     */
    public AbsReturn() {
        this.expression = null;
        this.type = null;
    }

    /**
     * Constructor for return statements not of void type.
     * @param expression AbsExpr return expression.
     * @param type StructType return type.
     */
    public AbsReturn(AbsExpr expression, StructType type) {
        this.expression = expression;
        this.type = type;
    }

    /**
     * Method to generate Java byte code for return statements.
     * @return Byte array representing the return statement.
     */
    public byte[] getByteCode() {
        if (type == null) {
            byte[] out = new byte[] {Operation.RETURN.getIndex()};
            return out;
        } else {
            byte[] out = expression.getByteCode();
            Operation op;
            if (type.getClass().equals(StructPrimitive.class)) op = Operation.IRETURN;
            else op = Operation.ARETURN;
            return ByteUtils.concat(out, new byte[] {op.getIndex()});
        }
    }

    /**
     * Method to get the max stack size needed for return statements.
     * @param current Integer current max stack input size.
     * @return Integer new max stack input size.
     */
    public int getMaxStackSize(int current) {
        if (expression == null) return 0;
        int max = expression.getMaxStackSize(current);
        return (max > current) ? max : current;
    }

}
