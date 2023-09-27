package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortArrayToInt
public class TTT_testShortArrayToInt {
public static int shortArrayToInt(final short[] src, final int srcPos, final int dstInit, final int dstPos, final int nShorts) {
    if (nShorts > src.length) {
        return dstInit;
    }
    if ((nShorts - 1) * 16 + dstPos >= 32) {
        throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 32");
    }
    int out = dstInit;
    for (int i = 0; i < nShorts; i++) {
        final int shift = i * 16 + dstPos;
        final int bits = (0xffff & src[i + srcPos]) << shift;
        final int mask = 0xffff << shift;
        out = (out & ~mask) | bits;
    }
    return out;
}
}