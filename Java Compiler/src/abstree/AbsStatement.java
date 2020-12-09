package abstree;

/**
 * Represents statements within the compiler abstract syntax tree.
 */
public abstract class AbsStatement {

    /**
     * AbsMethod method this statement is contained within.
     */
    protected AbsMethod currentMethod;

    /**
     * Method to get the max stack size needed for statements.
     * @param current Integer current max stack input size.
     * @return Integer new max stack input size.
     */
    public int getMaxStackSize(int current) {
        return this.getMaxStackSize(current);
    }

    /**
     * Method to set the method to which this statement belongs.
     * @param currentMethod AbsMethod to which this statement belongs.
     */
    public void setCurrentMethod(AbsMethod currentMethod) {
        this.currentMethod = currentMethod;
    }

    /**
     * Method to generate the Java byte code for all statements.
     * @return Byte array representing this statement.
     */
    public byte[] getByteCode() {
        return this.getByteCode();
    }

}