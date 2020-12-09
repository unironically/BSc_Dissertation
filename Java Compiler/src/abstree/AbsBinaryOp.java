package abstree;

import abstree.literal.AbsLiteral;
import abstree.literal.AbsLiteralBoolean;
import abstree.literal.AbsLiteralInt;
import convert.Operation;
import exception.CompileTimeError;
import struct.StructClass;
import struct.StructPrimitive;
import struct.StructType;
import utils.ByteUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents binary operation expressions.
 */
public class AbsBinaryOp extends AbsExpr {

    /**
     * String binary operator used in operation.
     */
    private String lexeme;

    /**
     * Left side expression.
     */
    private AbsExpr left;

    /**
     * Right side expression.
     */
    private AbsExpr right;

    /**
     * ArrayList of operators with which we require branching if one or more expressions are not literals.
     */
    public static final ArrayList<String> BRANCH_OPERATORS = new ArrayList<>(Arrays.asList("==", "!=", "<", ">", "<=" , ">="));

    /**
     * Constructor taking an ArrayList of child expressions and a String operator.
     * @param children ArrayList of child expressions.
     * @param lexeme String operator used.
     */
    public AbsBinaryOp(ArrayList<AbsExpr> children, String lexeme) {
        super(getOperationType(lexeme, children.get(0).type), children);
        this.lexeme = lexeme;
        this.left = children.get(0);
        this.right = children.get(1);
    }

    /**
     * Method to generate Java byte code for all binary operations.
     * @return Byte array of Java byte code for binary operation.
     */
    public byte[] getByteCode() {
        if (left instanceof AbsLiteral && right instanceof AbsLiteral)
            return getByteCodeLiterals((AbsLiteral) left, (AbsLiteral) right);
        else
            return getByteCodeIdentifier();
    }

    /**
     * Method to generate Java byte code for binary expressions where one or more of the expressions is not a literal.
     * @return Byte array of Java byte code for this binary expression.
     */
    public byte[] getByteCodeIdentifier() {
        if (BRANCH_OPERATORS.contains(lexeme)) return getBranchOperation();
        if (!left.getType().equals(right.getType()))
            throw new CompileTimeError("incompatible types for operation operation " + lexeme);
        byte[] out = ByteUtils.concat(left.getByteCode(), right.getByteCode());
        byte command;
        if (left.getType().equals(StructType.getTypeFromIdentifier("boolean"))) command = getByteCodeIdentifierBoolean();
        else if (left.getType().equals(StructType.getTypeFromIdentifier("int"))) command = getByteCodeIdentifierInt();
        else return getByteCodeIdentifierString();
        return ByteUtils.concat(out, new byte[] {command});
    }

    /**
     * Method to get the byte code operation needed for an operation over two int identifiers.
     * @return Byte representing the operation used.
     */
    private byte getByteCodeIdentifierInt() {
        switch (lexeme) {
            case "+": return Operation.IADD.getIndex();
            case "-": return Operation.ISUB.getIndex();
            case "*": return Operation.IMUL.getIndex();
            case "/": return Operation.IDIV.getIndex();
            default: throw new CompileTimeError("incompatible types for " + lexeme);
        }
    }

    /**
     * Method to get the byte code operation needed for an operation over two boolean identifiers.
     * @return Byte representing the operation used.
     */
    public byte getByteCodeIdentifierBoolean() {
        switch (lexeme) {
            case "&&": return Operation.IAND.getIndex();
            case "||": return Operation.IOR.getIndex();
            default: throw new CompileTimeError("incompatible types for " + lexeme);
        }
    }

    /**
     * Method to get the byte code operation needed for an operation over two String identifiers.
     * @return Byte representing the operation used.
     */
    public byte[] getByteCodeIdentifierString() {
        if (lexeme.equals("+")) {
            return new AbsMethodCall("concat", left,
                    ((StructClass) StructType.getTypeFromIdentifier("String"))
                            .getMethod("concat", new ArrayList<>(Arrays.asList(children.get(0).type))),
                    children).getByteCode();
        }
        throw new CompileTimeError("incompatible types for " + lexeme);
    }

    /**
     * Method to generate byte code for branch operations.
     * @return Byte array representing the byte code for branch operation used.
     */
    public byte[] getBranchOperation() {
        Operation op = getBranchOperationType(left.type);
        byte[] leftBytes = left.getByteCode(), rightBytes = right.getByteCode();
        int ifOffset = Operation.IF_ACMPEQ.getNumBytes() + Operation.ICONST_0.getNumBytes() + Operation.GOTO.getNumBytes();
        int gotoOffset = Operation.GOTO.getNumBytes() + Operation.ICONST_0.getNumBytes();
        int branchOpLength = Operation.IF_ACMPEQ.getNumBytes() + Operation.ICONST_0.getNumBytes() + Operation.GOTO.getNumBytes() + Operation.ICONST_0.getNumBytes();
        ByteBuffer buffer = ByteBuffer.allocate(leftBytes.length + rightBytes.length + branchOpLength);
        buffer.put(leftBytes).put(rightBytes);
        buffer.put(op.operationAndValue(ifOffset)).put(Operation.iConstN(1));
        buffer.put(Operation.GOTO.operationAndValue(gotoOffset)).put(Operation.iConstN(0));
        return buffer.array();
    }

    /**
     * Method to get the byte code operation needed for a branch operation.
     * @return Byte representing the operation used.
     */
    public Operation getBranchOperationType(StructType type) {
        if (lexeme.equals("==")) {
            return (type instanceof StructPrimitive) ? Operation.IF_ICMPNE : Operation.IF_ACMPNE;
        } else if (lexeme.equals("!=")) {
            return (type instanceof StructPrimitive) ? Operation.IF_ICMPEQ : Operation.IF_ACMPEQ;
        }
        return null;
    }

    /**
     * Method to get the type of a binary operation from its lexeme and left expression type.
     * @param lexeme String operator used in expression.
     * @param leftOperandType Left side expression used in binary operation.
     * @return StructType type of this binary operation.
     */
    public static StructType getOperationType(String lexeme, StructType leftOperandType) {
        StructType intType = StructType.getTypeFromIdentifier("int"),
                boolType = StructType.getTypeFromIdentifier("boolean");
        switch (lexeme) {
            case "+": return leftOperandType;
            case "-":
            case "*":
            case "/":
                return intType;
            case "&&":
            case "||":
            case "==":
            case "!=":
            case "<":
            case ">":
            case "<=":
            case ">=":
                return boolType;
            default:
                throw new CompileTimeError("binary operation " + lexeme + " doesn't exist");
        }
    }

    /**
     * Method to generate java byte code for operations over two literal values.
     * @param left Left side literal expression.
     * @param right Right side literal expression.
     * @return Byte array representing the byte code for this binary operation.
     */
    private byte[] getByteCodeLiterals(AbsLiteral left, AbsLiteral right) {
        Object res = 0;
        switch (lexeme) {
            case "+": res = left.add(right); break;
            case "-": res = left.sub(right); break;
            case "*": res = left.mul(right); break;
            case "/": res = left.div(right); break;
            case ">": res = left.gt(right); break;
            case "<": res = left.lt(right); break;
            case ">=": res = left.gte(right); break;
            case "<=": res = left.lte(right); break;
            case "==": res = left.eq(right); break;
            case "!=": res = left.ne(right); break;
            case "&&": res = left.and(right); break;
            case "||": res = left.or(right); break;
        }
        if (res instanceof Boolean) {
            return new AbsLiteralBoolean((boolean) res).getByteCode();
        } else if (res instanceof Integer) {
            return new AbsLiteralInt((int) res).getByteCode();
        }
        return null;
    }

    /**
     * Method to get the maximum stack size needed by binary expressions.
     * @param current Integer representing the current max stack input size.
     * @return Integer representing the new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = left.getMaxStackSize(current) + right.getMaxStackSize(current) + 1;
        return (max > current) ? max : current;
    }

}
