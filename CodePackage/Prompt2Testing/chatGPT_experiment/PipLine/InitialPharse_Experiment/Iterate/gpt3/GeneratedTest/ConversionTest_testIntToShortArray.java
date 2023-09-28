package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToShortArray
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
public class ConversionTest_testIntToShortArray {
    @Test
    public void testIntToShortArray() {
        int src = 0b10101010101010101010101010101010; 
        int srcPos = 0;
        short[] dst = new short[4];
        int dstPos = 0;
        int nShorts = 4;
        Conversion.intToShortArray(src, srcPos, dst, dstPos, nShorts);
        short[] expected = {(short)43690, (short)43690, (short)43690, (short)43690}; 
        assertArrayEquals(expected, dst);
        src = 0b10101010101010101010101010101010; 
        srcPos = 16;
        dst = new short[2];
        dstPos = 0;
        nShorts = 2;
        Conversion.intToShortArray(src, srcPos, dst, dstPos, nShorts);
        expected = new short[] {(short)43690, (short)43690}; 
        assertArrayEquals(expected, dst);
        src = 0b10101010101010101010101010101010; 
        srcPos = 16;
        dst = new short[2];
        dstPos = 1;
        nShorts = 2;
        Conversion.intToShortArray(src, srcPos, dst, dstPos, nShorts);
        expected = new short[] {0, (short)43690}; 
        assertArrayEquals(expected, dst);
        src = 0b10101010101010101010101010101010; 
        srcPos = 16;
        dst = new short[2];
        dstPos = 0;
        nShorts = 3;
        try {
            Conversion.intToShortArray(src, srcPos, dst, dstPos, nShorts);
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nShorts-1)*16+srcPos is greater or equal to than 32", e.getMessage());
        }
    }
}