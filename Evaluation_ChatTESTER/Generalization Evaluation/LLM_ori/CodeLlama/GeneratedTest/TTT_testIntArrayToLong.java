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
    assertEquals(9876543210L, Conversion.intArrayToLong(new int[]{123, 456, 789}, 0, 0, 0, 3));
    assertEquals(-1234567890L, Conversion.intArrayToLong(new int[]{-123, -456, -789}, 0, 0, 0, 3));
    assertEquals(9876543210L, Conversion.intArrayToLong(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE / 2, Integer.MIN_VALUE}, 0, 0, 0, 3));
    try {
        Conversion.intArrayToLong(null, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.intArrayToLong(new int[]{}, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.intArrayToLong(new int[]{1}, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.intArrayToLong(new int[]{1, 2, 3}, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.intArrayToLong(new int[]{1, 2, 3}, 0, 0, 0, 1);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.intArrayToLong(new int[]{1, 2, 3}, 0, 0, 0, 2);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.intArrayToLong(new int[]{1, 2, 3}, 0, 0, 0, 3);
        fail();
    } catch (IllegalArgumentException e) {}
}
}