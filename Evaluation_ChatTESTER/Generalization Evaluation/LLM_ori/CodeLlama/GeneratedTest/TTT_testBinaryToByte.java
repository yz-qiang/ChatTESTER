package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToByte
public class TTT_testBinaryToByte {
@Test
public void testBinaryToByte() {
    assertEquals((byte) 0, Conversion.binaryToByte(new boolean[]{}, 0, (byte) 0, 0, 0));
    assertEquals((byte) 1, Conversion.binaryToByte(new boolean[]{true}, 0, (byte) 0, 0, 1));
    assertEquals((byte) 5, Conversion.binaryToByte(new boolean[]{false, true, true, false, true}, 0, (byte) 0, 0, 4));
    try {
        Conversion.binaryToByte(null, 0, (byte) 0, 0, 1);
        fail();
    } catch (IllegalArgumentException e) {
    }
    try {
        Conversion.binaryToByte(new boolean[]{true}, 0, (byte) 0, 9, 1);
        fail();
    } catch (IllegalArgumentException e) {
    }
    try {
        Conversion.binaryToByte(new boolean[]{true}, 0, (byte) 0, 0, -1);
        fail();
    } catch (IllegalArgumentException e) {
    }
}
}