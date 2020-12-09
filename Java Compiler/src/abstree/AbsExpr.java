package abstree;

import struct.StructType;

import java.util.ArrayList;

/**
 * Represents expressions used within the input program.
 */
public abstract class AbsExpr extends AbsStatement {

    /**
     * StructType type of this expression.
     */
    protected StructType type;

    /**
     * ArrayList of child expressions of this expression.
     */
    protected ArrayList<AbsExpr> children;

    /**
     * Constructor for AbsExpr objects taking a type and list of children.
     * @param type StructType expression type.
     * @param children ArrayList of child expressions.
     */
    public AbsExpr(StructType type, ArrayList<AbsExpr> children) {
        this.type = type;
        this.children = children;
    }

    /**
     * Method to get the type of this expression.
     * @return StructType expression type.
     */
    public StructType getType() {
        return type;
    }

}
