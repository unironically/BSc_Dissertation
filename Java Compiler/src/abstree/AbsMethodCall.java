package abstree;

import abstree.identifier.AbsClassIdentifier;
import convert.Operation;
import resource.ConstantPool;
import struct.Modifier;
import struct.StructMethod;
import struct.StructType;
import utils.ByteUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Represents method calls used within the input program.
 */
public class AbsMethodCall extends  AbsExpr {

    /**
     * String identifier name of the method called.
     */
    private String identifier;

    /**
     * StructType type of the method receiver.
     */
    private StructType receiver;

    /**
     * AbsExpr expression representing the object reference used by the method call.
     */
    private AbsExpr objRef;

    /**
     * StructMethod representing the structure of the method called.
     */
    private StructMethod method;

    /**
     * Constructor taking a string identifier method name, object reference, receiver expression, method structure and
     * ArrayList of child expressions representing the arguments.
     * @param identifier String identifier name of the method called.
     * @param objRef AbsExpr object reference.
     * @param receiver StructType receiver type.
     * @param method StructMethod method called.
     * @param children ArrayList of AbsExpr representing call arguments.
     */
    public AbsMethodCall(String identifier, AbsExpr objRef, StructType receiver, StructMethod method, ArrayList<AbsExpr> children) {
        super(method.getType(), children);
        this.identifier = identifier;
        this.receiver = receiver;
        this.objRef = objRef;
        this.method = method;
    }

    /**
     * Constructor taking a string identifier method name, object reference, method structure and
     * ArrayList of child expressions representing the arguments.
     * @param identifier String identifier name of the method called.
     * @param objRef AbsExpr object reference.
     * @param method StructMethod method called.
     * @param children ArrayList of AbsExpr representing call arguments.
     */
    public AbsMethodCall(String identifier, AbsExpr objRef, StructMethod method, ArrayList<AbsExpr> children) {
        super(method.getType(), children);
        this.identifier = identifier;
        this.objRef = objRef;
        this.receiver = objRef.type;
        this.method = method;
    }

    /**
     * Method to generate the byte code for all method calls.
     * @return Byte array representing the Java byte code of this method call.
     */
    public byte[] getByteCode() {
        if (method.getModifiers().contains(Modifier.STATIC)) return getByteCodeStatic();
        byte[] out = objRef.getByteCode();
        for (AbsExpr expr: children) out = ByteUtils.concat(out, expr.getByteCode());
        short poolPos = ConstantPool.INSTANCE.putMethod(receiver.getPath().getBytes(), identifier.getBytes(), method.getSignature().getBytes());
        ByteBuffer buffer = ByteBuffer.allocate(out.length + 3).put(out);
        if (identifier.equals("<init>")) buffer.put(Operation.INVOKESPECIAL.getIndex()); // Constructor
        else buffer.put(Operation.INVOKEVIRTUAL.getIndex()); // Instance method
        buffer.putShort(poolPos);
        return buffer.array();
    }

    /**
     * Method to generate the byte code for static method calls.
     * @return Byte array representing the Java byte code of this method call.
     */
    public byte[] getByteCodeStatic() {
        byte[] out = new byte[0];
        for (AbsExpr expr: children) out = ByteUtils.concat(out, expr.getByteCode());
        short methodPos = ConstantPool.INSTANCE.putMethod(
                ((AbsClassIdentifier) objRef).getThisClassClass().getIdentifier().getBytes(),
                method.getIdentifier().getBytes(), method.getSignature().getBytes());
        return ByteUtils.concat(out, Operation.INVOKESTATIC.operationAndValue(methodPos));
    }

    /**
     * Method to get the max stack size needed for method calls.
     * @param current Integer current max stack input size.
     * @return Integer new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = 1;
        for (AbsExpr child: children) max += child.getMaxStackSize(current);
        return (max > current) ? max : current;
    }


}
