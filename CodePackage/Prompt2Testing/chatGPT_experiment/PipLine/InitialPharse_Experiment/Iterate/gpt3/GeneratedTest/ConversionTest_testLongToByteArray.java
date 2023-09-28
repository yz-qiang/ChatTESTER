package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToByteArray
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
public class ConversionTest_testLongToByteArray {
    @Test
    public void testLongToByteArray() {
        long src = 1234567890L;
        int srcPos = 0;
        byte[] dst = new byte[4];
        int dstPos = 0;
        int nBytes = 4;
        byte[] expected = {0x49, 0x96, 0x02, 0xd2};
        byte[] result = Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);
        assertArrayEquals(expected, result);
        nBytes = 0;
        result = Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);
        assertArrayEquals(dst, result);
        nBytes = 8;
        try {
            result = Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nBytes-1)*8+srcPos is greater or equal to than 64", e.getMessage());
        }
    }
}