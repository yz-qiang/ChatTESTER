package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortToHex
public class TTT_testShortToHex {
@Test
public void testShortToHex() {
    assertEquals("0x0", Conversion.shortToHex((short) 0, 0, "0x", 2, 1));
    assertEquals("0x1", Conversion.shortToHex((short) 1, 0, "0x", 2, 1));
    assertEquals("0xA", Conversion.shortToHex((short) 10, 0, "0x", 2, 1));
    assertEquals("0xFF", Conversion.shortToHex((short) 255, 0, "0x", 2, 1));
    assertEquals("0xFFFF", Conversion.shortToHex((short) -1, 0, "0x", 2, 1));
    assertEquals("0xFFFE", Conversion.shortToHex((short) -2, 0, "0x", 2, 1));
    assertEquals("0xFFFD", Conversion.shortToHex((short) -3, 0, "0x", 2, 1));
    assertEquals("0x7FFF", Conversion.shortToHex((short) Short.MAX_VALUE, 0, "0x", 2, 1));
    assertEquals("0x8000", Conversion.shortToHex((short) Short.MIN_VALUE, 0, "0x", 2, 1));
    try {
        Conversion.shortToHex((short) 0, 0, null, 2, 1);
        fail("Expected NullPointerException");
    } catch (NullPointerException e) {}
    try {
        Conversion.shortToHex((short) 0, 0, "", 2, 1);
        fail("Expected IndexOutOfBoundsException");
    } catch (IndexOutOfBoundsException e) {}
    try {
        Conversion.shortToHex((short) 0, 0, "0x", 2, 0);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {}
}
}