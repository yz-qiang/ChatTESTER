package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortToByteArray
public class ConversionTest_testShortToByteArray {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp(){
          conversionObj = new Conversion();
    }
    @Test
    public void testShortToByteArrayWithValidInputs() {
        try{
            short inputValue = 327594;
            byte[] expectedOutput = {(byte) 0b0000000000000,(byte) 0b00000000010,(byte) 0b000000000010};
            assertArrayEquals(expectedOutput,conversionObj.shortToByteArray((short)inputValue,0,new byte[3],0,3);
        }catch(IllegalArgumentException e){
           fail("Should not have thrown exception");
       }
   }
    @Test
    public void testShortToByteArrayWithInvalidInputs() {
        try{
            short inputValue = 327594;
            byte[] output = conversionObj.shortToByteArray((short)inputValue,0,new byte[3],0,4);
            fail("Expected an IllegalArgumentException but it did not occur.");
        } catch(IllegalArgumentException ex){
            String errorMessage = "nBytes-1*8+srcPos should be less than 16";
            String actualErrorMessage = ex.getMessage();
            assertTrue(actualErrorMessage != null && actualErrorMessage.contains(errorMessage));
        }
    }
}