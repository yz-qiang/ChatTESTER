package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToByteArray
public class ConversionTest_testIntToByteArray {
    private static Conversion conversion;
    @BeforeClass
    public static void setUp(){
          conversion = new Conversion();
    }
    @Test
    public void testIntToByteArrayWithZeroNbytesReturnsDst() throws Exception{
        int inputSrc = 56789;
        int inputSrcPos = 4;
        byte[] expectedOutput = new byte[]{};
        byte[] actualOutput = new byte[inputSrc];
        int inputDstPos = 0;
        int inputNBytes = 0;
        try {
            byte[] result = conversion.intToByteArray(inputSrc, inputSrcPos, actualOutput, inputDstPos, inputNBytes);
            assertNotNull(result);
            assertArrayEquals(expectedOutput, result);
        } catch (IllegalArgumentException e){
           fail("Should not have thrown exception");
       }
    }
    @Test
    public void testIntToByteArrayThrowsExceptionWhenNbytesGreaterOrEqualThan32() throws Exception{
        int inputSrc = 56789;
        int inputSrcPos = 4;
        byte[] expectedOutput = null;
        byte[] actualOutput = new byte[inputSrc];
        int inputDstPos = 0;
        int inputNBytes = 5;
        try {
            byte[] result = conversion.intToByteArray(inputSrc, inputSrcPos, actualOutput, inputDstPos, inputNBytes);
            fail("Expected an IllegalArgumentException but it did not occur.");
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    @Test
    public void testIntToByteArrayConvertsCorrectly() throws Exception{
        int inputSrc = 56789;
        int inputSrcPos = 4;
        byte[] expectedOutput = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] actualOutput = new byte[inputSrc];
        int inputDstPos = 0;
        int inputNBytes = 8;
        try {
            byte[] result = conversion.intToByteArray(inputSrc, inputSrcPos, actualOutput, inputDstPos, inputNBytes);
            assertNotNull(result);
            assertArrayEquals(expectedOutput, result);
        } catch (IllegalArgumentException e){
            fail("Should not have thrown exception");
        }
    }
}