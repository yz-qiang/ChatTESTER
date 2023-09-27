package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToByteArray
public class TTT_testIntToByteArray {
@Test
public void testIntToByteArray() {
    int src = 456789;
    int srcPos = 1;
    byte[] dst = new byte[4];
    int dstPos = 0;
    int nBytes = 3;
    byte[] expectedResult = new byte[]{0x00, 0x00, 0x00, 0x00};
    byte[] actualResult = Conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);
    assertArrayEquals(expectedResult, actualResult);
}
}