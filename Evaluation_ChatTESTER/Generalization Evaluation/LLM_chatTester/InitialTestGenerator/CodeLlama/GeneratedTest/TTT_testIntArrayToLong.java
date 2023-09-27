package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntArrayToLong
public class TTT_testIntArrayToLong {
@Test
public void testIntArrayToLong() {
    assertEquals(0, Conversion.intArrayToLong(new int[]{}, 0, 0, 0, 0));
    assertEquals(5, Conversion.intArrayToLong(new int[]{5}, 0, 0, 0, 1));
    assertEquals(0xFFFFFFFE_00000000L, Conversion.intArrayToLong(new int[]{0xFFFFFFFE, 0x00000000}, 0, 0, 0, 2));
    assertEquals(-1, Conversion.intArrayToLong(new int[]{-1}, 0, 0, 0, 1));
    assertEquals(0xFFFFFFFF_FFFFFFFFL, Conversion.intArrayToLong(new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF}, 0, 0, 0, 4));
    try {
        Conversion.intArrayToLong(null, 0, 0, 0, 1);
        fail();
    } catch (NullPointerException e) {}
    try {
        Conversion.intArrayToLong(new int[]{}, 0, 0, 0, -1);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.intArrayToLong(new int[]{}, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
}
}