package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToInt
public class TTT_testByteArrayToInt {
@Test
public void testByteArrayToInt() {
    assertEquals(0, Conversion.byteArrayToInt(new byte[]{}, 0, 0, 0, 0));
    assertEquals(42, Conversion.byteArrayToInt(new byte[]{42}, 0, 0, 0, 1));
    assertEquals(65537, Conversion.byteArrayToInt(new byte[]{1, 2, 3, 4, 5, 6, 7, 8}, 0, 0, 0, 8));
    assertEquals(-1, Conversion.byteArrayToInt(new byte[]{-1}, 0, 0, 0, 1));
    assertEquals(Integer.MAX_VALUE, Conversion.byteArrayToInt(new byte[]{127, 127, 127, 127, 127, 127, 127, 127}, 0, 0, 0, 8));
    try {
        Conversion.byteArrayToInt(null, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{}, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 0);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 1);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 2);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 3);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 4);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 5);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 6);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 7);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.byteArrayToInt(new byte[]{1}, 0, 0, 0, 8);
        fail();
    } catch (IllegalArgumentException e) {}
}
}