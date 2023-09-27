package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToInt
public class ConversionTest_testByteArrayToInt {
    private static byte[] inputByteArr;
    private static int expectedOutput;
    @BeforeClass
    public static void setUp(){
         inputByteArr = new byte[]{0xFF, 0x7f};
         expectedOutput = 654923;
    }
    @Test
    public void testByteArrayToIntWithValidInputs() {
        try{
            assertEquals(expectedOutput, Conversion.byteArrayToInt(inputByteArr, 0, 0, 0, 2));
        } catch (IllegalArgumentException e){
           fail();
       }
   }
    @Test
    public void testByteArrayToIntWithInvalidInputs() {
        try{
            Conversion.byteArrayToInt(new byte[]{}, 0, 0, 0, 1);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
    @Test
    public void testByteArrayToIntWithZeroNbytes() {
        try{
            Conversion.byteArrayToInt(inputByteArr, 0, 0, 0, 0);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
    @Test
    public void testByteArrayToIntWithLargeDstPos() {
        try{
            Conversion.byteArrayToInt(inputByteArr, 0, 0, 32, 2);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
}