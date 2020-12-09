package struct;

/**
 * Representing structure of arrays used within the input program.
 */
public class StructArray extends StructType {

    /**
     * StructType type of the array.
     */
    private StructType arrayType;

    /**
     * Integer length of the array.
     */
    private int length;

    /**
     * Constructor taking an array type and length.
     * @param arrayType StructType type of the array.
     * @param length Integer length of the array.
     */
    public StructArray(StructType arrayType, int length) {
        this.arrayType = arrayType;
        this.length = length;
    }

    /**
     * Method to get the type of an array.
     * @return StructType type of the array.
     */
    public StructType getArrayType() {
        return arrayType;
    }

}
