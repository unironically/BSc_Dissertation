package struct;

import java.util.ArrayList;

/**
 * Represents a member of a class, being a method or a field.
 */
public class StructClassMember {

    /**
     * String identifier name of the member.
     */
    protected String identifier;

    /**
     * ArrayList of modifiers held by the member.
     */
    protected ArrayList<Modifier> modifiers;

    /**
     * StructType type of the member.
     */
    protected StructType type;

    /**
     * Constructor taking an identifier, a list of modifiers and a type.
     * @param identifier String member identifier.
     * @param modifiers ArrayList of Modifiers.
     * @param type StructType member type.
     */
    public StructClassMember(String identifier, ArrayList<Modifier> modifiers, StructType type) {
        this.identifier = identifier;
        this.modifiers = modifiers;
        this.type = type;
    }

    /**
     * Method to get the identifier of a member.
     * @return String identifier of member.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Method to get the type of a member.
     * @return StructType type of member.
     */
    public StructType getType() {
        return type;
    }

    /**
     * Method to set the type of a member.
     * @param type StructType type to set.
     */
    public void setType(StructType type) {
        this.type = type;
    }

    /**
     * Method to get the modifiers held by a class member.
     * @return ArrayList of Modifiers.
     */
    public ArrayList<Modifier> getModifiers() {
        return modifiers;
    }

}
