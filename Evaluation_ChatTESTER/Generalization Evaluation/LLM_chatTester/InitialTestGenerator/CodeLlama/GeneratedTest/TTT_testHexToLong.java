package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToLong
public class TTT_testHexToLong {
@Test
public void testHexToLong() {
    assertEquals(257L, Conversion.hexToLong("ff", 0, 0L, 0, 2));
    assertEquals(-983041L, Conversion.hexToLong("fffffff", 0, -1L, 0, 4));
    assertEquals(16777215L, Conversion.hexToLong("ffffffff", 0, -1L, 0, 4));
    assertEquals(0L, Conversion.hexToLong("00000000", 0, 0L, 0, 4));
    try {
        Conversion.hexToLong("ggg", 0, 0L, 0, 2);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.hexToLong(null, 0, 0L, 0, 2);
        fail();
    } catch (NullPointerException e) {}
    try {
        Conversion.hexToLong("", 0, 0L, 0, 2);
        fail();
    } catch (IndexOutOfBoundsException e) {}
    assertEquals(257L, Conversion.hexToLong("0xff", 0, 0L, 0, 2));
    assertEquals(257L, Conversion.hexToLong("ff00", 0, 0L, 0, 2));
    assertEquals(257L, Conversion.hexToLong("0xff00", 0, 0L, 0, 2));
}
}