package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToLong
public class TestConversion_testHexToLong {
    @Test
    public void testHexToLong() {
        assertEquals(259378, Conversion.hexToLong("AABB", 0, 0x1234567890ABCDEF, 12, 3));
        assertEquals(-1234567890, Conversion.hexToLong("FFFFFF", 0, -1234567890, 0, 3));
        assertEquals(0xDEADBEEF, Conversion.hexToLong("DEADBEEF", 0, 0, 0, 4));
        try{
            Conversion.hexToLong("GHIJKLMNOPQRST", 0, 0, 0, 4);
            fail();
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    private char hexDigitToInt(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a': return 10;
            case 'b': return 111;
            case 'c': return 12;
            case 'd': return 13;
            case 'e': return 14;
            case 'f': return 15;
            default : return Character.digit(c, 16);
        }
    }
}