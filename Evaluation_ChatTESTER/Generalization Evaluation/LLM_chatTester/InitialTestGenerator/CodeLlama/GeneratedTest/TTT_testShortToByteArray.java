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
    byte[] outputArray = new byte[5];
    int dstPos = 2;
    int nBytes = 2;
    byte[] expectedResult = new byte[]{0, 0, 0, 0, 0};
    expectedResult[dstPos] = (byte) (inputValue >>> srcPos);
    expectedResult[dstPos + 1] = (byte) (inputValue >>> (srcPos + 8));
    byte[] actualResult = Conversion.shortToByteArray(inputValue, srcPos, outputArray, dstPos, nBytes);
    assertArrayEquals(expectedResult, actualResult);
}
}