package abstree.literal;

import abstree.AbsExpr;
import exception.CompileTimeError;
import struct.StructType;

/**
 * Abstract class representing the use of literals within the input program.
 */
public abstract class AbsLiteral extends AbsExpr {

    /**
     * Constructor for literal values used within the program taking a type.
     * @param type StructType representing the type of the literal used.
     */
    public AbsLiteral(StructType type) {
        super(type, null);
    }

    /**
     * Method to get the maximum stack size needed by a literal within the Java byte code.
     * @param current Integer current maximum stack input size.
     * @return Integer new maximum stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = 1;
        return (max > current) ? max : current;
    }

    /**
     * Method representing addition of literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public int add(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for addition");
    }

    /**
     * Method representing subtraction of literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public int sub(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for subtraction");
    }

    /**
     * Method representing multiplication of literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public int mul(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for multiplication");
    }

    /**
     * Method representing division of literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public int div(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for division");
    }

    /**
     * Method representing an AND operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public boolean and(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for and");
    }

    /**
     * Method representing an OR operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public boolean or(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for or");
    }

    /**
     * Method representing a greater than operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public boolean gt(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for greater than");
    }

    /**
     * Method representing a less than operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public boolean lt(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for less than");
    }

    /**
     * Method representing a greater than or equal to operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public boolean gte(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for greater than/equal");
    }

    /**
     * Method representing a less than or equal to operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public boolean lte(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for less than/equal");
    }

    /**
     * Method representing an equals operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public boolean eq(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for equal");
    }

    /**
     * Method representing a not equals operation over literals.
     * @param other Right literal in binary operation.
     * @return Integer result of this operation.
     */
    public boolean ne(AbsLiteral other) {
        throw new CompileTimeError("incompatible types for less not equal");
    }

}
