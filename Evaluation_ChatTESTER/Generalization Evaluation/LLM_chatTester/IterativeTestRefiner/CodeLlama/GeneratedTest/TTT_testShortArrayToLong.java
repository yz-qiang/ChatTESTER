package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortArrayToLong
public class TTT_testShortArrayToLong {
@Test
public void testShortArrayToLong() {
    short[] src = new short[]{1, 2, 3};
    int srcPos = 0;
    long dstInit = 0;
    int dstPos = 0;
    int nShorts = 3;
    long expectedResult = 7598231;
    long actualResult = Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);
    assertEquals(expectedResult, actualResult);
}
}