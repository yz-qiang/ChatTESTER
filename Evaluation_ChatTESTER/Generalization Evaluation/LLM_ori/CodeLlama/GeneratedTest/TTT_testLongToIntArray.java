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
    long src = UUID.randomUUID().getLeastSignificantBits();
    int srcPos = 5;
    int[] dst = new int[8];
    int dstPos = 2;
    int nInts = 3;
    int[] expectedResult = new int[]{0xFFFFFFFE, 0xFFFFFFFF, 0x7FFFFFFF};
    int[] actualResult = Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);
    assertArrayEquals(expectedResult, actualResult);
}
}