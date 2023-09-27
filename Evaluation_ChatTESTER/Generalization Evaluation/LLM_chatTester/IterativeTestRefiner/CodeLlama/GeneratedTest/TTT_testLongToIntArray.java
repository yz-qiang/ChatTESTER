package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToIntArray
public class TTT_testLongToIntArray {
public static int[] longToIntArray(final long src, final int srcPos, final int[] dst, final int dstPos, final int nInts) {
    if (0 == nInts) {
        return dst;
    }
    if ((nInts - 1) * 32 + srcPos >= 64) {
        throw new IllegalArgumentException("(nInts-1)*32+srcPos is greater or equal to than 64");
    }
    if (dstPos + nInts > dst.length) {
        throw new IllegalArgumentException("dstPos + nInts is greater than the length of the dst array");
    }
    for (int i = 0; i < nInts; i++) {
        final int shift = i * 32 + srcPos;
        dst[dstPos + i] = (int) (0xffffffff & (src >> shift));
    }
    return dst;
}
}