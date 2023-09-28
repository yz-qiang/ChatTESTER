package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToLong
public class TTT_testBinaryToLong {
public static long binaryToLong(final boolean[] src, final int srcPos, final long dstInit, final int dstPos, final int nBools) {
    if (src.length == 0 && srcPos == 0 || 0 == nBools) {
        return dstInit;
    }
    if (nBools - 1 + dstPos >= 64) {
        throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 64");
    }
    if (srcPos > src.length) {
        return dstInit;
    }
    long out = dstInit;
    for (int i = 0; i < nBools; i++) {
        final int shift = i + dstPos;
        final long bits = (src[i + srcPos] ? 1L : 0) << shift;
        final long mask = 0x1L << shift;
        out = (out & ~mask) | bits;
    }
    return out;
}
}