package abstree;

import abstree.identifier.AbsClassIdentifier;
import abstree.identifier.AbsFieldIdentifier;
import convert.Operation;
import exception.CompileTimeError;
import resource.ConstantPool;
import struct.StructType;

import java.nio.ByteBuffer;

/**
 * Represents field references specified with a receiver class.
 */
public class AbsFieldRef extends AbsExpr {

    /**
     * Field identifier for this field reference.
     */
    private AbsFieldIdentifier fieldId;

    /**
     * Expression representing the receiver of the field reference.
     */
    private AbsExpr receiver;

    /**
     * Constructor taking a field identifier and a receiver expression.
     * @param fieldId AbsFieldIdentifier field identifier.
     * @param receiver AbsExpr receiver expression.
     */
    public AbsFieldRef(AbsFieldIdentifier fieldId, AbsExpr receiver) {
        super (fieldId.getType(), null);
        this.receiver = receiver;
        this.fieldId = fieldId;
    }

    /**
     * Method to get the field identifier object held by this reference.
     * @return AbsFieldIdentifier field identifier.
     */
    public AbsFieldIdentifier getFieldId() {
        return fieldId;
    }

    /**
     * Method to get the receiver expression of this reference.
     * @return AbsExpr receiver.
     */
    public AbsExpr getReceiver() {
        return receiver;
    }

    /**
     * Method to generate the byte code for all field reference expressions.
     * @return Byte array Java byte code for field reference expressions.
     */
    public byte[] getByteCode() {
        if ((receiver == null && fieldId.getField().isStatic()) || receiver.getClass().equals(AbsClassIdentifier.class))
            return getByteCodeStatic();
        return getByteCodeInstance();
    }

    /**
     * Method to generate byte code representing references to instance fields.
     * @return Byte array Java byte code for instance field references.
     */
    private byte[] getByteCodeInstance() {
        byte[] out = receiver.getByteCode();
        Operation op = Operation.GETFIELD;
        ByteBuffer buffer = ByteBuffer.allocate(out.length + op.getNumBytes());
        buffer.put(out);
        buffer.put(op.getIndex());
        buffer.putShort(getPoolPos(receiver.getType()));
        return buffer.array();
    }

    /**
     * Method to generate byte code representing references to static fields.
     * @return Byte array Java byte code for static field references.
     */
    private byte[] getByteCodeStatic() {
        if (!fieldId.getField().isStatic())
            throw new CompileTimeError("cannot access instance field from a static reference");
        ByteBuffer buffer = ByteBuffer.allocate(Operation.GETSTATIC.getNumBytes());
        buffer.put(Operation.GETSTATIC.getIndex());
        buffer.putShort(getPoolPos(receiver.getType()));
        return buffer.array();
    }

    /**
     * Method to get the position of the field record within the constant pool.
     * @param receiverType StructType type of the field's receiver expression.
     * @return Short constant pool index
     */
    private short getPoolPos(StructType receiverType) {
        return ConstantPool.INSTANCE.putField(receiverType.getPath().getBytes(),
                fieldId.getName().getBytes(), fieldId.getType().getPathAsType().getBytes());
    }

    /**
     * Method to get the max stack size needed for field references.
     * @param current Integer current max stack input size.
     * @return Integer new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = receiver.getMaxStackSize(current);
        return (max > current) ? max : current;
    }

}
