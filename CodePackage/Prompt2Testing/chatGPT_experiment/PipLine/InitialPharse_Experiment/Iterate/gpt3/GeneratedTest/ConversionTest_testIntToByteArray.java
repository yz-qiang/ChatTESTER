package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToByteArray
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
public class ConversionTest_testIntToByteArray {
    @Test
    public void testIntToByteArray() {
        int src = 123456789;
        int srcPos = 0;
        byte[] dst = new byte[4];
        int dstPos = 0;
        int nBytes = 4;
        byte[] expected = {7, 91, 205, 21};
        byte[] result = Conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);
        assertArrayEquals(expected, result);
        nBytes = 0;
        expected = new byte[] {};
        result = Conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);
        assertArrayEquals(expected, result);
        nBytes = 5;
        try {
            Conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nBytes-1)*8+srcPos is greater or equal to than 32", e.getMessage());
        }
    }
}