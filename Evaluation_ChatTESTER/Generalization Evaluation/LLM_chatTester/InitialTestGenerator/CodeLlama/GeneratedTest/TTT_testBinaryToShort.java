package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToShort
public class TTT_testBinaryToShort {
@Test
public void testBinaryToShort() {
    boolean[] src = new boolean[]{true, true, false, false};
    int srcPos = 2;
    short dstInit = 0;
    int dstPos = 4;
    int nBools = 3;
    short expectedResult = 5;
    short actualResult = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
    assertEquals(expectedResult, actualResult);
}
}