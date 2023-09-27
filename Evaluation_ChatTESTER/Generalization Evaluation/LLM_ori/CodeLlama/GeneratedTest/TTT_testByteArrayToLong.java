package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToLong
public class TTT_testByteArrayToLong {
@Test
public void testByteArrayToLong() {
    byte[] src = new byte[]{0x01, 0x23, 0x45, 0x67};
    int srcPos = 0;
    long dstInit = 0;
    int dstPos = 0;
    int nBytes = 4;
    long expectedResult = 0x01234567;
    long actualResult = Conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);
    assertEquals(expectedResult, actualResult);
}
}