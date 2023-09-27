package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortArrayToInt
public class TTT_testShortArrayToInt {
@Test
public void testShortArrayToInt() {
    assertEquals(0, Conversion.shortArrayToInt(new short[]{}, 0, 0, 0, 0));
    assertEquals(42, Conversion.shortArrayToInt(new short[]{42}, 0, 0, 0, 1));
    assertEquals(5789, Conversion.shortArrayToInt(new short[]{1234, 5678}, 0, 0, 0, 2));
    assertEquals(-1234, Conversion.shortArrayToInt(new short[]{-1234}, 0, 0, 0, 1));
    assertEquals(123456789, Conversion.shortArrayToInt(new short[]{1234, 5678, 9012}, 0, 0, 0, 3));
    try {
        Conversion.shortArrayToInt(null, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.shortArrayToInt(new short[]{}, 0, 0, 0, -1);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.shortArrayToInt(new short[]{}, 0, 0, 0, 1);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.shortArrayToInt(new short[]{}, 0, 0, 0, 2);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.shortArrayToInt(new short[]{}, 0, 0, 0, 3);
        fail();
    } catch (IllegalArgumentException e) {}
}
}