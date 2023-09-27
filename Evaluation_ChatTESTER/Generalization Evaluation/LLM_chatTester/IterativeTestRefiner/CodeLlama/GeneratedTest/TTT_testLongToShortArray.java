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
    long[] longValues = new long[]{12345L, 67890L};
    short[] expectedShortValues = new short[]{12345, 67890};
    int srcPos = (int) 0L;
    int dstPos = (int) 0L;
    int nShorts = 2;
    short[] actualShortValues = Conversion.longToShortArray(longValues, srcPos, expectedShortValues, dstPos, nShorts);
    assertArrayEquals(expectedShortValues, actualShortValues);
}
}