package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToIntArray
public class TTT_testLongToIntArray {
@Test
public void testLongToIntArray() {
    long src = 0x123456789ABCDEF0L;
    int srcPos = 32;
    int[] dst = new int[4];
    int dstPos = 0;
    int nInts = 2;
    int[] expectedResult = new int[]{0x12345678, 0x9ABCDEF0};
    int[] actualResult = Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);
    assertArrayEquals(expectedResult, actualResult);
}
}