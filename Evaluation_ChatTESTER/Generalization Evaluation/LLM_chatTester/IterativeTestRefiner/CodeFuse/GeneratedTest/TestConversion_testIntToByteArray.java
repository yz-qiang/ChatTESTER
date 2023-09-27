package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToByteArray
public class TestConversion_testIntToByteArray {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp() {
        conversionObj = new Conversion();
    }
    @Test
    public void testIntToByteArrayWithValidInputs() {
        try {
            int src = 567894;
            int srcPos = 0;
            byte[] expectedOutput = {0xC1, 0xEA};
            byte[] actualOutput = conversionObj.intToByteArray(src, srcPos);
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown exception");
        }
    }
    @Test
    public void testIntToByteArrayWithInvalidInputs() {
        try {
            int src = 567894;
            int srcPos = 0;
            byte[] dst = new byte[2];
            int nBytes = 3;
            byte[] result = conversionObj.intToByteArray(src, srcPos, dst, 0, nBytes);
            fail("Expected an illegal argument exception but it did not occur.");
        } catch (IllegalArgumentException e) {
            String errorMessage = "nBytes-1*8+srcPos should be less than 32";
            String actualErrorMessage = e.getMessage();
            assertTrue(actualErrorMessage.contains(errorMessage);
        }
    }
}