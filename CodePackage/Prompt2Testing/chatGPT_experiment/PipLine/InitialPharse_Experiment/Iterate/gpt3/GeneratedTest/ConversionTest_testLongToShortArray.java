package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToShortArray
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
public class ConversionTest_testLongToShortArray {
    @Test
    public void testLongToShortArray() {
        long src = 0x123456789abcdef0L;
        int srcPos = 4;
        short[] dst = new short[4];
        int dstPos = 1;
        int nShorts = 3;
        short[] expected = {(short) 0x5678, (short) 0x9abc, (short) 0xdef0, 0x0000};
        Conversion.longToShortArray(src, srcPos, dst, dstPos, nShorts);
        assertArrayEquals(expected, dst);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLongToShortArrayThrowsException() {
        long src = 0x123456789abcdef0L;
        int srcPos = 4;
        short[] dst = new short[4];
        int dstPos = 1;
        int nShorts = 4;
        Conversion.longToShortArray(src, srcPos, dst, dstPos, nShorts);
    }
}