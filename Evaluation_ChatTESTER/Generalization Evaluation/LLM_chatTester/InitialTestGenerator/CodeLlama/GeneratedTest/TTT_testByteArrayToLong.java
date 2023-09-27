package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToLong
public class TTT_testByteArrayToLong {
@Test
public void testByteArrayToLong() {
    assertEquals(0L, Conversion.byteArrayToLong(new byte[]{}, 0, 0L, 0, 0));
    byte[] input = new byte[]{1, 2, 3};
    assertEquals(0x010203L, Conversion.byteArrayToLong(input, 0, 0L, 0, 3));
    assertEquals(0x0203L, Conversion.byteArrayToLong(input, 1, 0L, 0, 2));
    try {
        Conversion.byteArrayToLong(input, -1, 0L, 0, 2);
        fail();
    } catch (IllegalArgumentException e) {
    }
    try {
        Conversion.byteArrayToLong(input, 0, 0L, 0, -1);
        fail();
    } catch (IllegalArgumentException e) {
    }
    try {
        Conversion.byteArrayToLong(input, 0, 0L, -1, 2);
        fail();
    } catch (IllegalArgumentException e) {
    }
    try {
        Conversion.byteArrayToLong(input, -1, 0L, 0, 2);
        fail();
    } catch (IndexOutOfBoundsException e) {
    }
}
}