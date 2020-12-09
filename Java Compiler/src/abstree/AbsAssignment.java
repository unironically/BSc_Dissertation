package abstree;

import abstree.identifier.AbsFieldIdentifier;
import abstree.identifier.AbsLocalIdentifier;
import convert.Operation;
import resource.ConstantPool;
import struct.StructLocal;
import struct.StructPrimitive;
import utils.ByteUtils;

/**
 * Represents assignment expressions.
 */
public class AbsAssignment extends AbsExpr {

    /**
     * Expression representing the receiver of the assignment.
     */
    private AbsExpr receiver;

    /**
     * Expression representing the value to assign.
     */
    private AbsExpr assignment;

    /**
     * Constructor taking receiver and assignment expressions.
     * @param receiver Expression representing the receiver.
     * @param assignment Expression representing the assignment value.
     */
    public AbsAssignment(AbsExpr receiver, AbsExpr assignment) {
        super (receiver.type, null);
        this.receiver = receiver;
        this.assignment = assignment;
    }

    /**
     * Method to generate the Java byte code representing all assignments.
     * @return Byte array representing Java byte code for assignment.
     */
    public byte[] getByteCode() {
        return (receiver instanceof AbsFieldRef) ? getByteCodeField() : getByteCodeLocal();
    }

    /**
     * Method generate byte code for field assignments.
     * @return Byte array representing field assignment byte code.
     */
    private byte[] getByteCodeField() {
        AbsFieldRef fieldRef = (AbsFieldRef) receiver;
        AbsFieldIdentifier fieldId = fieldRef.getFieldId();
        short poolPos = ConstantPool.INSTANCE.putField(
                fieldRef.getReceiver().type.getPath().getBytes(),
                fieldId.getName().getBytes(),
                fieldId.getType().getPathAsType().getBytes());
        if (fieldId.getField().isStatic())
            return ByteUtils.concat(assignment.getByteCode(), Operation.PUTSTATIC.operationAndValue(poolPos));
        byte[] origin = fieldRef.getReceiver().getByteCode();
        byte[] assign = ByteUtils.concat(assignment.getByteCode(), Operation.PUTFIELD.operationAndValue(poolPos));
        return ByteUtils.concat(origin, assign);
    }

    /**
     * Method generate byte code for local assignments.
     * @return Byte array representing local assignment byte code.
     */
    private byte[] getByteCodeLocal() {
        AbsLocalIdentifier localRef = (AbsLocalIdentifier) receiver;
        StructLocal local = localRef.getLocal();
        byte[] sub = assignment.getByteCode();
        if (local.getIndex() > 3) {
            Operation op = (type instanceof StructPrimitive) ? Operation.ISTORE : Operation.ASTORE;
            byte[] out = op.operationAndValue(local.getIndex());
            return ByteUtils.concat(sub, out);
        }
        Operation op = (type instanceof StructPrimitive) ? Operation.ISTORE_N : Operation.ASTORE_N;
        return ByteUtils.concat(sub, new byte[] {(byte) (op.getIndex() + local.getIndex())});
    }

    /**
     * Method to get the max stack size needed for assignments.
     * @param current Integer current max stack input size.
     * @return Integer new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = receiver.getMaxStackSize(current) + assignment.getMaxStackSize(current);
        return (max > current) ? max : current;
    }

}
