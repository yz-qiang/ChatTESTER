package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToShort
public class TTT_testBinaryToShort {
    @Test
    public void testBinaryToShort() {
        boolean[] inputBooleanArr = {true, false, true, false, true, false, true, false};
        short initDestinationVal = 0;
        char desiredDestLowOrderChar = 'a';
        int numBits = 2;
        int expectedOutputIntValue = 3;
        String actualResultStr = "[" + (Conversion.binaryToShort(inputBooleanArr, 2, initDestinationVal, 7, 2)) + ", "
                + (~(((short) (~(Conversion.binaryToShort(inputBooleanArr, 2, initDestinationVal, 7, 2)) >>> 8)))) + "]";
        String expectedResultStr = "[" + expectedOutputIntValue + ", " + desiredDestLowOrderChar + "]";
        try {
            assertEquals(expectedResultStr, actualResultStr);
        } catch (AssertionError e) {
            assertEquals(expectedResultStr, actualResultStr, "Actual results did not match expected outputs.");
        }
    }
}