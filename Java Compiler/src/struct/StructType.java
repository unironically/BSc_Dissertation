package struct;

import resource.Environment;

/**
 * Abstract class representing the types available within the input program.
 */
public abstract class StructType {

    /**
     * Method to get the path of a type formatted in the type format required by the constant pool.
     * @return String formatted type path.
     */
    public String getPathAsType() {
        if (this.getClass().equals(StructPrimitive.class)) return this.getPath();
        else if (this.getClass().equals(StructArray.class)) return "[" + ((StructArray) this).getArrayType().getPathAsType();
        return "L" + this.getPath() + ";";
    }

    /**
     * Method to get the path of a type.
     * @return String type path.
     */
    public String getPath() {
        if (this.getClass().equals(StructPrimitive.class)) {
            return this.getPath();
        } else if (this.getClass().equals(StructArray.class)) {
            return ((StructArray) this).getArrayType().getPath();
        }
        return this.getPath();
    }

    /**
     * Method to derive a type by an identifier.
     * @param identifier String identifier to derive type from.
     * @return StructType resulting type found.
     */
    public static StructType getTypeFromIdentifier(String identifier) {
        // Primitive types
        switch (identifier) {
            case "int": return new StructPrimitive(StructPrimitive.PrimitiveType.INT);
            case "boolean":return new StructPrimitive(StructPrimitive.PrimitiveType.BOOLEAN);
            case "void":
            case "null":
                return null;
        }
        // Array types
        if (identifier.endsWith("[]"))
            return new StructArray(getTypeFromIdentifier(identifier.substring(0, identifier.length()-2)), -1);
        // Class types
        return Environment.INSTANCE.getVisibleClass(identifier);
    }

    /**
     * Method to determine whether two StructType objects are equal.
     * @param other Object other to compare this StructType object to.
     * @return Boolean indicating whether Object is a matching StructType object.
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof StructType
                && this.getPathAsType().equals(((StructType) other).getPathAsType());
    }

}
