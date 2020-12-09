package abstree.identifier;

import convert.Operation;
import struct.StructLocal;
import struct.StructPrimitive;

/**
 * Represents use of identifiers pointing to local variables within the input program.
 */
public class AbsLocalIdentifier extends AbsIdentifier {

    /**
     * StructLocal object pointed to by this identifier.
     */
    private StructLocal local;

    /**
     * Constructor taking a StructLocal representing the local variable identifier used.
     * @param local StructLocal represented.
     */
    public AbsLocalIdentifier(StructLocal local) {
        super(local.getType(), local.getIdentifier());
        this.local = local;
    }

    /**
     * Method to get the StructLocal object represented by this identifier.
     * @return StructLocal object represented.
     */
    public StructLocal getLocal() {
        return local;
    }

    /**
     * Method to generate the Java byte code for this identifier.
     * @return Byte array generated for this identifier reference.
     */
    public byte[] getByteCode() {
        int index = local.getIndex();
        byte[] out;
        if (index > 3) {
            Operation op = (local.getType().getClass().equals(StructPrimitive.class)) ? Operation.ILOAD : Operation.ALOAD;
            out = new byte[]{op.getIndex(), (byte) index};
        }
        else {
            Operation op = (local.getType().getClass().equals(StructPrimitive.class)) ? Operation.ILOAD_N : Operation.ALOAD_N;
            out = new byte[]{(byte) (op.getIndex() + index)};
        }
        return out;
    }

}
