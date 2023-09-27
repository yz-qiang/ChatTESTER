package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToByteArray
public class TTT_testLongToByteArray {
public static byte[] longToByteArray(final long src, final int srcPos, final byte[] dst, final int dstPos, final int nBytes) {
    if (0 == nBytes) {
        return dst;
    }
    if ((nBytes - 1) * 8 + srcPos >= 64) {
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 64");
    }
    if (nBytes > 8) {
        return new byte[0];
    }
    for (int i = 0; i < nBytes; i++) {
        final int shift = i * 8 + srcPos;
        dst[dstPos + i] = (byte) (0xff & (src >> shift));
    }
    return dst;
}
}