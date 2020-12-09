package abstree.identifier;

import abstree.AbsExpr;
import struct.StructType;

/**
 * Abstract class representing the use of identifiers within the input program.
 */
public abstract class AbsIdentifier extends AbsExpr {

    /**
     * String name of the identifier used.
     */
    private String name;

    /**
     * Constructor for AbsIdentifiers taking a type and identifier name.
     * @param type StructType representing the type of the identifier used.
     * @param name String representing the name of the identifier.
     */
    public AbsIdentifier(StructType type, String name) {
        super(type, null);
        this.name = name;
    }

    /**
     * Method to get the name of the identifier used.
     * @return String representing the name of the identifier.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the maximum stack size needed by identifiers.
     * @param current Integer representing the current max stack input size.
     * @return Integer representing the new max stack input size.
     */
    public int getMaxStackSize(int current) {
        return 1;
    }

}
