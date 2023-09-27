package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToShort
public class TTT_testHexToShort {
@Test
public void testHexToShort() {
    assertEquals((short) 257, Conversion.hexToShort("0x101", 0, (short) 0, 0, 3));
    try {
        Conversion.hexToShort("0x10g", 0, (short) 0, 0, 3);
        fail();
    } catch (IllegalArgumentException e) {
    }
    assertEquals((short) 0, Conversion.hexToShort("", 0, (short) 0, 0, 0));
    try {
        Conversion.hexToShort(null, 0, (short) 0, 0, 0);
        fail();
    } catch (NullPointerException e) {
    }
    assertEquals((short) 257, Conversion.hexToShort("0x00101", 0, (short) 0, 0, 5));
    assertEquals((short) 257, Conversion.hexToShort("0x10100", 0, (short) 0, 0, 5));
    assertEquals((short) -257, Conversion.hexToShort("-0x101", 0, (short) 0, 0, 4));
    try {
        Conversion.hexToShort("0xFFFFFF", 0, (short) 0, 0, 6);
        fail();
    } catch (ArithmeticException e) {
    }
}
}