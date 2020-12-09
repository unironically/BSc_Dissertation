package utils;

import java.util.Arrays;

/**
 * Class for useful methods when dealing with bytes within this compiler.
 */
public class ByteUtils {

    /**
     * Method to concatenate two byte arrays.
     * @param a Byte array left.
     * @param b Byte array right.
     * @return Resulting byte array after concatenation.
     */
    public static byte[] concat(byte[] a, byte[] b) {
        byte[] out = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, out, a.length, b.length);
        return out;
    }

}
