package abstree;

import convert.Operation;

import java.nio.ByteBuffer;

/**
 * Represents 'if' statements within the abstract syntax tree.
 */
public class AbsIfStatement extends AbsStatement {

    /**
     * Expression representing the if statement condition.
     */
    private AbsExpr expr;

    /**
     * AbsBlock representing the block to execute if condition evaluates to true.
     */
    private AbsBlock trueBlock;

    /**
     * AbsBlock representing the block to execute if condition evaluates to false.
     */
    private AbsBlock falseBlock;

    /**
     * Constructor taking a condition expression and code blocks for the true and false branches.
     * @param expr AbsExpr condition.
     * @param trueBlock AbsBlock true block.
     * @param falseBlock AbsBlock false block.
     */
    public AbsIfStatement(AbsExpr expr, AbsBlock trueBlock, AbsBlock falseBlock) {
        this.expr = expr;
        this.trueBlock = trueBlock;
        this.falseBlock = falseBlock;
    }

    /**
     * Method to generate the byte code representing if statements.
     * @return Byte array of Java byte code for if statements.
     */
    public byte[] getByteCode() {
        byte[] exprArr = expr.getByteCode(), trueArr = trueBlock.getByteCode();
        int ifOffset = Operation.IFEQ.getNumBytes() + trueArr.length + ((falseBlock != null) ? Operation.GOTO.getNumBytes() : 0);
        ByteBuffer buffer = ByteBuffer.allocate(exprArr.length + Operation.IFEQ.getNumBytes() + trueArr.length);
        buffer.put(exprArr).put(Operation.IFEQ.operationAndValue(ifOffset)).put(trueArr);
        if (falseBlock != null) {
            byte[] falseArr = falseBlock.getByteCode();
            int gotoOffset = Operation.GOTO.getNumBytes() + falseArr.length;
            ByteBuffer bufferElse = ByteBuffer.allocate(buffer.limit() + Operation.GOTO.getNumBytes() + falseArr.length);
            bufferElse.put(buffer.array()).put(Operation.GOTO.operationAndValue(gotoOffset)).put(falseArr);
            return bufferElse.array();
        }
        return buffer.array();
    }

    /**
     * Method to get the max stack size needed for if statements.
     * @param current Integer current max stack input size.
     * @return Integer new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = trueBlock.getMaxStackSize(current);
        if (falseBlock != null) max += falseBlock.getMaxStackSize(current);
        return (max > current) ? max : current;
    }

}
