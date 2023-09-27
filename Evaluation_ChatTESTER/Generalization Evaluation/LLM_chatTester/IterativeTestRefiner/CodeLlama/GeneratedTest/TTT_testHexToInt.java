package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToInt
public class TTT_testHexToInt {
@Test
public void testHexToInt() {
    assertEquals(Integer.parseInt("ff", 16), Conversion.hexToInt("ff", 0, 0, 0, 2));
    try {
        Conversion.hexToInt("gg", 0, 0, 0, 2);
        fail();
    } catch (IllegalArgumentException e) {
    }
    assertEquals(0, Conversion.hexToInt("", 0, 0, 0, 0));
    try {
        Conversion.hexToInt(null, 0, 0, 0, 0);
        fail();
    } catch (NullPointerException e) {
    }
    assertEquals(Integer.parseInt("0x000f", 16), Conversion.hexToInt("000f", 0, 0, 0, 4));
    assertEquals(Integer.parseInt("0xf000", 16), Conversion.hexToInt("f000", 0, 0, 0, 4));
    assertEquals(Integer.parseInt("0XaBcDeFgHiJkLmNoPqRsTuVwXyZ", 16), Conversion.hexToInt("abcdefghijklmnopqrstuvwxyz", 0, 0, 0, 8));
    try {
        Conversion.hexToInt("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, 0, 0, 8);
        fail();
    } catch (NumberFormatException e) {
    }
}
}