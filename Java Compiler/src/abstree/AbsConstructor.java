package abstree;

import convert.Operation;
import resource.ConstantPool;
import struct.StructClass;
import struct.StructMethod;
import struct.StructType;
import utils.ByteUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Represents Constructors within classes of the input program.
 */
public class AbsConstructor extends AbsExpr {

    /**
     * StructMethod representing the constructor.
     */
    private StructMethod constructor;

    /**
     * Constructor for AbsConstructor instances taking a type, ArrayList of children and constructor StructMethod.
     * @param type StructType representing the constructor's class.
     * @param children ArrayList of child expressions representing the constructor arguments.
     * @param constructor StructMethod of the constructor within this class.
     */
    public AbsConstructor(StructType type, ArrayList<AbsExpr> children, StructMethod constructor) {
        super(type, children);
        this.constructor = constructor;
    }

    /**
     * Method to generate the Java byte code for constructor methods.
     * @return Byte array representing the constructor byte code.
     */
    public byte[] getByteCode() {
        byte[] out = new byte[0];
        for (AbsExpr expr: children) out = ByteUtils.concat(out, expr.getByteCode());
        ByteBuffer buffer = ByteBuffer.allocate(4 + out.length + 3);
        byte[] classPos = ConstantPool.shortToTwoByte(ConstantPool.INSTANCE.putClass(((StructClass) type).getIdentifier().getBytes()));
        byte[] methodPos = ConstantPool.shortToTwoByte(ConstantPool.INSTANCE.putMethod(
                ((StructClass) type).getIdentifier().getBytes(), "<init>".getBytes(), constructor.getSignature().getBytes()));
        buffer.put(Operation.NEW.getIndex()).put(classPos)
                .put(Operation.DUP.getIndex()).put(out)
                .put(Operation.INVOKESPECIAL.getIndex()).put(methodPos);
        return buffer.array();
    }

    /**
     * Method to get the maximum stack size needed by constructors.
     * @param current Integer representing the current max stack input size.
     * @return Integer representing the new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = 2;    // new + dup
        for (AbsExpr e: children) max += e.getMaxStackSize(current);
        return (max > current) ? max : current;
    }

}
