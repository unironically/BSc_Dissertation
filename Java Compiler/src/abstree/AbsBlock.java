package abstree;

import utils.ByteUtils;

import java.util.ArrayList;

/**
 * Represents the use of a block of statements within the input program.
 */
public class AbsBlock {

    /**
     * ArrayList of statements used within the block.
     */
    private ArrayList<AbsStatement> statements;

    /**
     * Constructor taking an ArrayList of statements contained within the block.
     * @param statements
     */
    public AbsBlock(ArrayList<AbsStatement> statements) {
        this.statements = statements;
    }

    /**
     * Method to generate the byte code for this block of statements.
     * @return Byte array representing the byte code for this block.
     */
    public byte[] getByteCode() {
        byte[] out = new byte[0];
        for (AbsStatement statement: statements) out = ByteUtils.concat(out, statement.getByteCode());
        return out;
    }

    /**
     * Method to get the maximum stack size needed by blocks of statements.
     * @param current Integer representing the current max stack input size.
     * @return Integer representing the new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = 0;
        for (AbsStatement statement: statements) max += statement.getMaxStackSize(current);
        return (max > current) ? max : current;
    }

}
