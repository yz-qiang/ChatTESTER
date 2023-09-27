package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToByteArray
public class ConversionTest_testLongToByteArray {
    @Test
    public void testLongToByteArrayWithValidInputs() {
        long inputValue = UUID.randomUUID().getLeastSignificantBits();
        byte[] expectedOutput = new byte[2];
        expectedOutput[0] = (byte)(inputValue >>> 56);
        expectedOutput[1] = (byte)(inputValue >>> 48);
        assertArrayEquals(expectedOutput, Conversion.longToByteArray(inputValue, 0, new byte[2], 0, 2));
        inputValue = UUID.randomUUID().getMostSignificantBits();
        expectedOutput = new byte[3];
        expectedOutput[0] = (byte)(inputValue >>> 59);
        expectedOutput[1] = (byte)(inputValue >>> 51);
        expectedOutput[2] = (byte)(inputValue >>> 43);
        assertArrayEquals(expectedOutput, Conversion.longToByteArray(inputValue, 7, new byte[3], 0, 3));
        inputValue = Long.MAX_VALUE;
        expectedOutput = new byte[8];
        expectedOutput[0] = (byte)(inputValue >>> 56);
        expectedOutput[1] = (byte)(inputValue >>> 48);
        expectedOutput[2] = (byte)(inputValue >>> 40);
        expectedOutput[3] = (byte)(inputValue >>> 32);
        expectedOutput[4] = (byte)(inputValue >>> 24);
        expectedOutput[5] = (byte)(inputValue >>> 16);
        expectedOutput[6] = (byte)(inputValue >>>  8);
        expectedOutput[7] = (byte)(inputValue >>>  0);
        assertArrayEquals(expectedOutput, Conversion.longToByteArray(inputValue, 0, new byte[8], 0, 8));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLongToByteArrayWithInvalidInputs() {
        try{
            Conversion.longToByteArray(0L, 0, new byte[1], 0, 9);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException e){
        }
    }
}