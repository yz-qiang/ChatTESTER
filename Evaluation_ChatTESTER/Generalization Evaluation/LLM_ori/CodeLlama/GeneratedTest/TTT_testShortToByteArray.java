package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortToByteArray
public class TTT_testShortToByteArray {
@Test
public void testShortToByteArray() {
    short inputValue = 42;
    int srcPos = 3;
    byte[] outputBuffer = new byte[5];
    int dstPos = 2;
    int nBytes = 3;
    byte[] expectedOutput = new byte[]{0x00, 0x00, 0x2A, 0x00};
    byte[] actualOutput = Conversion.shortToByteArray(inputValue, srcPos, outputBuffer, dstPos, nBytes);
    assertArrayEquals(expectedOutput, actualOutput);
}
}