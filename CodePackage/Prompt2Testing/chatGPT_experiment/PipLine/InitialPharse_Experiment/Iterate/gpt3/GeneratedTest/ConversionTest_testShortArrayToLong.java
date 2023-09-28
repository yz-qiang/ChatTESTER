package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortArrayToLong
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
public class ConversionTest_testShortArrayToLong {
    @Test
    public void testShortArrayToLong() {
        short[] src = {(short) 0x1234, (short) 0x5678, (short) 0x9abc};
        int srcPos = 1;
        long dstInit = 0x00000000fedcba98L;
        int dstPos = 8;
        int nShorts = 2;
        long expected = 0x00000000f56789abcL;
        long result = Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);
        assertEquals(expected, result);
        src = new short[0];
        srcPos = 0;
        dstInit = 0x0000000000000000L;
        dstPos = 0;
        nShorts = 0;
        expected = 0x0000000000000000L;
        result = Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);
        assertEquals(expected, result);
        src = new short[1];
        srcPos = 0;
        dstInit = 0x0000000000000000L;
        dstPos = 63;
        nShorts = 1;
        try {
            Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
        }
    }
}