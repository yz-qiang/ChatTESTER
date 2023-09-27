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
    assertEquals((byte) 0, Conversion.binaryToByte(new boolean[0], 0, (byte) 0, 0, 0));
    assertEquals((byte) 3, Conversion.binaryToByte(new boolean[]{true, true, true}, 0, (byte) 0, 0, 3));
    assertEquals((byte) 5, Conversion.binaryToByte(new boolean[]{false, true, false, true, false}, 0, (byte) 0, 0, 5));
    assertEquals((byte) -16, Conversion.binaryToByte(new boolean[]{true, false, true, false, true}, 0, (byte) 0, 0, 5));
    assertEquals((byte) 127, Conversion.binaryToByte(new boolean[]{true, true, true, true, true, true, true, true}, 0, (byte) 0, 0, 8));
    assertEquals((byte) -128, Conversion.binaryToByte(new boolean[]{false, false, false, false, false, false, false, false}, 0, (byte) 0, 0, 8));
    assertEquals((byte) 9, Conversion.binaryToByte(new boolean[]{true, false, true, false, true, false, true, false}, 0, (byte) 0, 0, 8));
    assertEquals((byte) 12, Conversion.binaryToByte(new boolean[]{true, true, true, true, true, true, true, true}, 0, (byte) 0, 0, 8));
    try {
        Conversion.binaryToByte(new Object[]{null, null, null}, 0, (byte) 0, 0, 3);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.binaryToByte(new boolean[]{true, true, true}, 0, (byte) 0, 0, 4);
        fail();
    } catch (IndexOutOfBoundsException e) {}
}
}