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
    byte[] input = new byte[]{0x01};
    int expectedOutput = 0x01;
    assertEquals(expectedOutput, Conversion.byteArrayToInt(input, 0, 0, 0, 1));
    input = new byte[]{0x01, 0x02, 0x03, 0x04};
    expectedOutput = 0x01020304;
    assertEquals(expectedOutput, Conversion.byteArrayToInt(input, 0, 0, 0, 4));
    input = new byte[]{0x01, 0x02, 0x03, 0x04, 0x05};
    expectedOutput = 0x030405;
    assertEquals(expectedOutput, Conversion.byteArrayToInt(input, 2, 0, 0, 3));
    input = new byte[]{-0x01, -0x02, -0x03, -0x04};
    expectedOutput = -0x01020304;
    assertEquals(expectedOutput, Conversion.byteArrayToInt(input, 0, 0, 0, 4));
    input = new byte[]{0x7f, 0xff, 0xff, 0xff};
    try {
        Conversion.byteArrayToInt(input, 0, 0, 0, 4);
        fail();
    } catch (IllegalArgumentException e) {
    }
    input = new byte[]{-0x80, -0x80, -0x80, -0x80};
    try {
        Conversion.byteArrayToInt(input, 0, 0, 0, 4);
        fail();
    } catch (IllegalArgumentException e) {
    }
}
}