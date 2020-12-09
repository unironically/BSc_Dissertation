package abstree.identifier;

import struct.StructClass;

/**
 * Represents the use of an identifier name for a visible class within the input program.
 */
public class AbsClassIdentifier extends AbsIdentifier {

    /**
     * StructClass representing the structure of the class specified.
     */
    private StructClass thisClass;

    /**
     * Constructor for AbsClassIdentifier taking a StructClass object identifying the class specified.
     * @param thisClass StructClass represented.
     */
    public AbsClassIdentifier(StructClass thisClass) {
        super(thisClass, thisClass.getIdentifier());
        this.thisClass = thisClass;
    }

    /**
     * Method to get the class structure object of the class specified.
     * @return StructClass represented.
     */
    public StructClass getThisClassClass() {
        return thisClass;
    }

    /**
     * Method to generate the byte code for class identifiers.
     * @return Byte array containing Java byte code for this tree node.
     */
    public byte[] getByteCode() {
        return new byte[] {};
    }

}
