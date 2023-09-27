package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToShort
public class HexToShortConversionTests_testHexToShort extends BaseTestCase {
    @Test
    public void shouldConvertSingleDigit() throws Exception {
        assertEquals((short) 5,
                Conversion.hexToShort("f", 0, Short.MIN_VALUE, 2, 1));
        try {
            Conversion.hexToShort("", 0, Short.MAX_VALUE, 3, 1);
            fail();
        } catch (IllegalArgumentException e) {}
        try {
            Conversion.hexToShort("-", 0, Byte.MIN_VALUE, 7, 1);
            fail();
        } catch (NumberFormatException e) {}
    }
    private static int hexDigitToInt(char c) {
        switch (c) {
            case '0': 
                return 0x0; 
            case '1': 
                return 0x1; 
            case '2': 
                return 0x2; 
            case '3': 
                return 0x3; 
            case '4': 
                return 0x4; 
            case '5': 
                return 0x5; 
            case '6': 
                return 0x6; 
            case '7': 
                return 0x7; 
            case '8': 
                return 0x8; 
            case '9': 
                return 0x9; 
            case 'A': 
            case 'a': 
                return 0xA; 
            case 'B': 
            case 'b': 
                return 0xB;
            case 'C': 
            case 'c': 
                return 0xC;
            case 'D': 
            case 'd': 
                return 0xD;
            case 'E': 
            case 'e': 
                return 0xE;
            case 'F': 
            case 'f': 
                return 0xF;
            default: 
                return -1; 
        } 
    }
}
class BaseTestCase {
    protected UUID uuidGenerator() {
        return UUID.randomUUID();
    }
}