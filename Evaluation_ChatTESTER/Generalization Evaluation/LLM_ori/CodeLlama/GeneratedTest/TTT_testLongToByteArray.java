package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToByteArray
public class TTT_testLongToByteArray {
@Test
public void testLongToByteArray() {
    long src = UUID.randomUUID().getMostSignificantBits();
    int srcPos = 32;
    byte[] dst = new byte[8];
    int dstPos = 0;
    int nBytes = 4;
    byte[] expectedResult = new byte[]{
            (byte) (src >>> 56),
            (byte) (src >>> 48),
            (byte) (src >>> 40),
            (byte) (src >>> 32)};
    byte[] actualResult = Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);
    assertArrayEquals(expectedResult, actualResult);
}
}