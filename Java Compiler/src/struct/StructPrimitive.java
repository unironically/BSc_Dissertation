package struct;

/**
 * Representing the use of primitive types within the input program.
 */
public class StructPrimitive extends StructType {

    /**
     * Enum of possible primitive types within the program.
     */
    public enum PrimitiveType {
        /**
         * Int primitive value.
         */
        INT("I"),

        /**
         * Boolean primitive value.
         */
        BOOLEAN("Z");

        /**
         * String path of primitive.
         */
        private String path;

        /**
         * Method to get path of primitive.
         * @return String primitive path.
         */
        private String getPath() { return path; }

        /**
         * Constructor taking a String primitive type path.
         * @param path
         */
        PrimitiveType(String path) { this.path = path; }
    }

    /**
     * PrimitiveType type of current primitive structure.
     */
    private PrimitiveType type;

    /**
     * Constructor taking a PrimitiveType type enum value.
     * @param type PrimitiveType enum value.
     */
    public StructPrimitive(PrimitiveType type) {
        this.type = type;
    }

    /**
     * Method to get the path of a primitive type.
     * @return String primitive type path.
     */
    public String getPath() {
        return this.type.getPath();
    }

}
