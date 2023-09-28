package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToShort
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
public class ConversionTest_testHexToShort {
    @Test
    public void testHexToShort() {
        String src = "1A2B3C";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 0;
        int nHex = 3;
        short expected = 0x1A2;
        short actual = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);
        assertEquals(expected, actual);
        src = "1A2B3C";
        srcPos = 1;
        dstInit = 0x1A2;
        dstPos = 4;
        nHex = 2;
        expected = (short) 0x1A2B3;
        actual = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);
        assertEquals(expected, actual);
        src = "1A2B3C";
        srcPos = 2;
        dstInit = (short) 0x1A2B3;
        dstPos = 8;
        nHex = 1;
        expected = (short) 0x3C;
        actual = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);
        assertEquals(expected, actual);
        try {
            src = "1A2B3C";
            srcPos = 0;
            dstInit = 0;
            dstPos = 13;
            nHex = 1;
            Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nHexs-1)*4+dstPos is greater or equal to than 16", e.getMessage());
        }
    }
}