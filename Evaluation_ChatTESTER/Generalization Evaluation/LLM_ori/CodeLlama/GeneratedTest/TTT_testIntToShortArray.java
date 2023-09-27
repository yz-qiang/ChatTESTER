package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToShortArray
public class TTT_testIntToShortArray {
@Test
public void testIntToShortArray() {
    int src = 45789;
    int srcPos = 10;
    short[] dst = new short[5];
    int dstPos = 0;
    int nShorts = 3;
    short[] expectedResult = new short[]{1, 2, 3};
    short[] actualResult = Conversion.intToShortArray(src, srcPos, dst, dstPos, nShorts);
    assertArrayEquals(expectedResult, actualResult);
}
}