package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToInt
public class TTT_testByteArrayToInt {
public static int byteArrayToInt(final byte[] src, final int srcPos, final int dstInit, final int dstPos, final int nBytes) {
    if (src.length == 0 && srcPos == 0 || 0 == nBytes) {
        return dstInit;
    }
    if ((nBytes - 1) * 8 + dstPos >= 32) {
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 32");
    }
    int out = dstInit;
    for (int i = 0; i < nBytes; i++) {
        final int shift = i * 8 + dstPos;
        final int bits = (0xff & src[i + srcPos]) << shift;
        final int mask = 0xff << shift;
        out = (out & ~mask) | bits;
    }
    return out;
}
}