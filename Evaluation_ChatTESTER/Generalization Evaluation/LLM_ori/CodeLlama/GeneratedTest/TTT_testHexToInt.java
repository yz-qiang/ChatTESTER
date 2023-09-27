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
    assertEquals(57896, Conversion.hexToInt("1A2B", 0, 0, 0, 4));
    try {
        Conversion.hexToInt("ZYXW", 0, 0, 0, 4);
        fail();
    } catch (IllegalArgumentException e) {
    }
    assertEquals(0, Conversion.hexToInt("", 0, 0, 0, 0));
    try {
        Conversion.hexToInt(null, 0, 0, 0, 0);
        fail();
    } catch (NullPointerException e) {
    }
    assertEquals(1234, Conversion.hexToInt("0x000004D2", 0, 0, 0, 4));
    assertEquals(1234, Conversion.hexToInt("0x04D20000", 0, 0, 0, 4));
    assertEquals(1234, Conversion.hexToInt("0x04d20000", 0, 0, 0, 4));
    try {
        Conversion.hexToInt("0x04d2g000", 0, 0, 0, 4);
        fail();
    } catch (NumberFormatException e) {
    }
}
}