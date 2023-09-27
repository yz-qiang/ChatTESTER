package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToLong
public class TTT_testByteArrayToLong {
public static long byteArrayToLong(final byte[] src, final int srcPos, final long dstInit, final int dstPos, final int nBytes) {
    if (src.length == 0 && srcPos == 0 || 0 == nBytes) {
        return dstInit;
    }
    if ((nBytes - 1) * 8 + dstPos >= 64) {
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 64");
    }
    if (srcPos >= src.length) {
        throw new ArrayIndexOutOfBoundsException("srcPos is greater than the length of the src array");
    }
    long out = dstInit;
    for (int i = 0; i < nBytes; i++) {
        final int shift = i * 8 + dstPos;
        final long bits = (0xffL & src[i + srcPos]) << shift;
        final long mask = 0xffL << shift;
        out = (out & ~mask) | bits;
    }
    return out;
}
}