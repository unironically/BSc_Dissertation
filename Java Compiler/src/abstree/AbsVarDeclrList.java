package abstree;

import struct.StructType;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents lists of variable expressions all of the same type as a single statement.
 */
public class AbsVarDeclrList extends AbsStatement {

    /**
     * StructType type of the variables declared.
     */
    private StructType type;

    /**
     * ArrayList of variable declarations contained.
     */
    private ArrayList<AbsVarDeclr> declarations;

    /**
     * Constructor taking a declaration type.
     * @param type StructType type of the variables declared.
     */
    public AbsVarDeclrList(StructType type) {
        this.type = type;
        this.declarations = new ArrayList<>();
    }

    /**
     * Method to add a variable declaration to this declaration list.
     * @param declaration AbsVarDeclr declaration to add.
     */
    public void addDeclaration(AbsVarDeclr declaration) {
        declarations.add(declaration);
    }

    /**
     * Method to get the type of this variable declaration list.
     * @return StructType type of the variable declaration list.
     */
    public StructType getType() {
        return type;
    }

    /**
     * Method to generate the byte code for variable declaration lists.
     * @return Byte array of Java byte code for variable declaration lists.
     */
    public byte[] getByteCode() {
        byte[] out = new byte[0];
        for (AbsVarDeclr dec: declarations) {
            byte[] outDec = dec.getByteCode();
            if (outDec == null) continue;
            byte[] outDecs = Arrays.copyOf(out, out.length + outDec.length);
            System.arraycopy(outDec, 0, outDecs, out.length, outDec.length);
            out = outDecs;
        }
        return out;
    }

    /**
     * Method to get the max stack size needed for variable declaration lists.
     * @param current Integer current max stack input size.
     * @return Integer new max stack input size.
     */
    public int getMaxStackSize(int current) {
        int max = 0;
        for (AbsVarDeclr dec: declarations) {
            max += dec.getMaxStackSize(current);
        }
        return (max > current) ? max : current;
    }

}
