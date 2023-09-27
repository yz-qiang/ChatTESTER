package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToShortArray
public class TTT_testLongToShortArray {
@Test
public void testLongToShortArray() {
    long src = 0x123456789ABCDEF0L;
    int srcPos = 0;
    short[] dst = new short[8];
    int dstPos = 0;
    int nShorts = 4;
    short[] expectedResult = new short[]{0x1234, 0x5678, 0x9ABC, 0xDEF0};
    short[] actualResult = Conversion.longToShortArray(src, srcPos, dst, dstPos, nShorts);
    assertArrayEquals(expectedResult, actualResult);
}
}