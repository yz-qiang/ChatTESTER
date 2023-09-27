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
    short[] input = new short[]{1, 2, 3};
    int srcPos = 0;
    long dstInit = 0;
    int dstPos = 0;
    int nShorts = 3;
    long expectedOutput = 759823;
    long actualOutput = Conversion.shortArrayToLong(input, srcPos, dstInit, dstPos, nShorts);
    assertEquals(expectedOutput, actualOutput);
}
}