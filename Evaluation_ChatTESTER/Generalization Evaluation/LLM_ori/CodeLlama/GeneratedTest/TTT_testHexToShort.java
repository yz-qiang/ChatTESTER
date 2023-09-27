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
    assertEquals((short) 0x1234, Conversion.hexToShort("1234", 0, (short) 0, 0, 4));
    try {
        Conversion.hexToShort("invalid_string", 0, (short) 0, 0, 4);
        fail();
    } catch (IllegalArgumentException e) {
    }
    assertEquals((short) 0, Conversion.hexToShort("", 0, (short) 0, 0, 0));
    try {
        Conversion.hexToShort(null, 0, (short) 0, 0, 4);
        fail();
    } catch (NullPointerException e) {
    }
    assertEquals((short) 0x0001, Conversion.hexToShort("0001", 0, (short) 0, 0, 4));
    assertEquals((short) 0x1234, Conversion.hexToShort("123400", 0, (short) 0, 0, 4));
    assertEquals((short) 0xABCD, Conversion.hexToShort("ABCD", 0, (short) 0xFFFF, 0, 4));
    try {
        Conversion.hexToShort("1234", 0, (short) -1, 0, 4);
        fail();
    } catch (IllegalArgumentException e) {
    }
    try {
        Conversion.hexToShort("1234", 0, (short) 0xFFFF, 0, 4);
        fail();
    } catch (ArithmeticException e) {
    }
}
}