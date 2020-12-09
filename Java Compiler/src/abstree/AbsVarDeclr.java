package abstree;

import abstree.identifier.AbsLocalIdentifier;
import struct.StructLocal;

/**
 * Represents a variable declaration within the input program.
 */
public class AbsVarDeclr extends AbsStatement {

    /**
     * String name of the variable declared.
     */
    private String identifier;

    /**
     * AbsExpr expression used to initialise the variable, if exists.
     */
    private AbsExpr expression;

    /**
     * StructLocal object representing the new local declared.
     */
    private StructLocal local;

    /**
     * Constructor taking a String variable name and local object.
     * @param identifier String variable name.
     * @param local StructLocal representing the new local declared.
     */
    public AbsVarDeclr(String identifier, StructLocal local) {
        this(identifier, null, local);
    }

    /**
     * Constructor taking a String variable name, initialise expression and local object.
     * @param identifier String variable name.
     * @param expression AbsExpr variable initialise value.
     * @param local StructLocal representing the new local declared.
     */
    public AbsVarDeclr(String identifier, AbsExpr expression, StructLocal local) {
        this.identifier = identifier;
        this.expression = expression;
        this.local = local;
    }

    /**
     * Method to generate the byte code for variable declarations.
     * @return Byte array representing the byte code for variable declarations.
     */
    public byte[] getByteCode() {
        if (expression == null) return null;
        return new AbsAssignment(new AbsLocalIdentifier(local), expression).getByteCode();
    }

    /**
     * Method to get the max stack size needed for variable declarations.
     * @param current Integer current max stack input size.
     * @return Integer new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = (expression != null) ? expression.getMaxStackSize(current) : 1;
        return (max > current) ? max : current;
    }

}
