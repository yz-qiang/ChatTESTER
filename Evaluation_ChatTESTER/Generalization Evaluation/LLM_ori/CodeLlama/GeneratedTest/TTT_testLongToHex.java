package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToHex
public class TTT_testLongToHex {
@Test
public void testLongToHex() {
    assertEquals(0x123456789ABCDEF0L, Conversion.longToHex("123456789abcdef", 0, "", 0, 16));
    assertEquals(0x123456789ABCDEFL, Conversion.longToHex("123456789abcdef", 4, "", 0, 12));
    assertEquals("123456789abcde", Conversion.longToHex("123456789abcdef", 0, "123456789abcde", 4, 12));
    try {
        Conversion.longToHex("123456789abcdef", 0, "", 0, 17);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
    try {
        Conversion.longToHex("123456789abcdef", 64, "", 0, 16);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
}
}