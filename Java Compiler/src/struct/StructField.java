package struct;

import java.util.ArrayList;

/**
 * Represents fields within each class of the user input program.
 */
public class StructField extends StructClassMember {

    /**
     * Boolean indicating whether the field is a static field.
     */
    private boolean isStatic;

    /**
     * Constructor taking an identifier, list of modifiers and a type.
     * @param identifier String field identifier.
     * @param modifiers ArrayList of field modifiers.
     * @param type StructType field type.
     */
    public StructField(String identifier, ArrayList<Modifier> modifiers, StructType type) {
        super(identifier, modifiers, type);
        isStatic = modifiers.contains(Modifier.STATIC);
    }

    /**
     * Method to check if the field is static.
     * @return Boolean indicating if the field is static.
     */
    public boolean isStatic() {
        return isStatic;
    }

}
