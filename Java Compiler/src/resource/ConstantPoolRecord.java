package resource;

/**
 * Represents a record within a class constant pool.
 */
public class ConstantPoolRecord {

    /**
     * Byte array of bytes representing this constant pool record.
     */
    private byte[] bytes;

    /**
     * Short index of this record in the constant pool.
     */
    private short index;

    /**
     * Constructor taking a byte array of constant pool data and a short pool index.
     * @param bytes Byte array of constant pool data.
     * @param index Short constant pool index.
     */
    public ConstantPoolRecord(byte[] bytes, short index) {
        this.bytes = bytes;
        this.index = index;
    }

    /**
     * Method to get the byte array of constant pool data for this record.
     * @return Byte array of constant pool data.
     */
    public byte[] getBytes() {
        return bytes;
    }

    /**
     * Method to get the short index of this record in the constant pool.
     * @return Short constant pool index.
     */
    public short getIndex() {
        return index;
    }

    /**
     * Equals method for comparing two constant pool records.
     * @param other Object to compare this constant pool record to.
     * @return Boolean indicating whether two records are equal.
     */
    @Override
    public boolean equals(Object other) {
        if (!other.getClass().equals(this.getClass())) return false;
        byte[] otherBytes = ((ConstantPoolRecord) other).getBytes();
        for (int i = 0; i < bytes.length; i++) if (!(bytes[i] == otherBytes[i])) return false;
        return true;
    }

    /**
     * Method to generate the hash code for a constant pool record.
     * @return Integer hash code of constant pool record.
     */
    @Override
    public int hashCode() {
        return bytes.length;
    }

}
