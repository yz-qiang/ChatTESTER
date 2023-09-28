package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortArrayToInt
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;
public class ConversionTest_testShortArrayToInt {
    @Test
    public void testShortArrayToInt() {
        short[] src = {0x1234, 0x5678, 0x9abc};
        int srcPos = 1;
        int dstInit = 0x0000ffff;
        int dstPos = 8;
        int nShorts = 2;
        int expected = 0x00bc5678;
        int result = Conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);
        assertEquals(expected, result);
        short[] emptySrc = {};
        int emptyExpected = dstInit;
        int emptyResult = Conversion.shortArrayToInt(emptySrc, 0, dstInit, dstPos, 0);
        assertEquals(emptyExpected, emptyResult);
        try {
            Conversion.shortArrayToInt(src, srcPos, dstInit, 24, nShorts);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nShorts-1)*16+dstPos is greater or equal to than 32", e.getMessage());
        }
    }
}