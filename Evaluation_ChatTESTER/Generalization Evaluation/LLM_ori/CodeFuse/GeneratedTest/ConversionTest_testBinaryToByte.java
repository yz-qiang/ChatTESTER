package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToByte
public class ConversionTest_testBinaryToByte {
    private static boolean[] inputArr;
    private static byte expectedOutput;
    @BeforeClass
    public static void setUp(){
         inputArr = new boolean[]{true, false, true};
         expectedOutput = (byte) 6;
    }
    @Test
    public void testBinaryToByteWithValidInputs() {
        try{
            assertEquals(expectedOutput, Conversion.binaryToByte(inputArr, 0, (byte) 2, 3, 2));
        } catch (IllegalArgumentException e){
           fail();
       }
   }
    @Test
    public void testBinaryToByteWithInvalidInputs() {
        try{
            Conversion.binaryToByte(new boolean[]{}, 0, (byte) 2, 4, 5);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
    @Test
    public void testBinaryToByteWithEmptyInput() {
        try{
            Conversion.binaryToByte(new boolean[]{}, 0, (byte) 2, 0, 0);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
}