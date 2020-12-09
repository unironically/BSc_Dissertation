package struct;

/**
 * Represents the structure of local variables used within the program.
 */
public class StructLocal {

    /**
     * String identifier of the local variable used.
     */
    private String identifier;

    /**
     * StructType type of the local.
     */
    private StructType type;

    /**
     * Integer index of the local within the parent method.
     */
    private int index;

    /**
     * Integer current count of all locals within a method.
     */
    public static int localCount = 0;

    /**
     * Constructor taking a variable identifier and type.
     * @param identifier String identifier of local.
     * @param type StructType type of local.
     */
    public StructLocal(String identifier, StructType type) {
        this.identifier = identifier;
        this.type = type;
        this.index = localCount++;
    }

    /**
     * Method to get the identifier of a local variable.
     * @return String local identifier.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Method to get the type of a local variable.
     * @return StructType local type.
     */
    public StructType getType() {
        return type;
    }

    /**
     * Method to get the index of a local variable.
     * @return Integer local index.
     */
    public int getIndex() {
        return index;
    }

}
