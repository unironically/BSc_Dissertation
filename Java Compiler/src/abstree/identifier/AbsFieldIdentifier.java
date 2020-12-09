package abstree.identifier;

import struct.StructField;

/**
 * Represents the use of an identifier for a class field within the input program.
 */
public class AbsFieldIdentifier extends AbsIdentifier {

    /**
     * StructField representing the field specified.
     */
    private StructField field;

    /**
     * Constructor for AbsFieldIdentifier taking a StructField representing the field specified.
     * @param field StructField represented.
     */
    public AbsFieldIdentifier(StructField field) {
        super(field.getType(), field.getIdentifier());
        this.field = field;
    }

    /**
     * Method to get the StructField object represented by this identifier.
     * @return StructField represented.
     */
    public StructField getField() {
        return field;
    }

}
