package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToByteArray
public class TestConversion_testLongToByteArray {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp(){
          conversionObj = new Conversion();
    }
    @Test
    public void testLongToByteArrayWithZeroNbytesReturnsEmptyArray() {
        try{
            byte[] result = conversionObj.longToByteArray(123L, 5, new byte[7], 0, 0);
             assertNotNull(result);
             assertTrue(result.length==0);
        }catch(IllegalArgumentException e){
           fail("Should not have thrown exception");
       }
   }
    @Test
    public void testLongToByteArrayThrowsExceptionWhenInvalidInput() {
        try{
            byte[] result = conversionObj.longToByteArray(123L, 5, new byte[7], 0, 9);
            fail("Expected Exception was not thrown.");
        } catch(IllegalArgumentException ex){
            assertEquals("nBytes-1*8+srcPos should be less than 64",ex.getMessage());
        }
    }
    @Test
    public void testLongToByteArrayWithValidInput() {
        byte[] expectedResult = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        byte[] actualResult = conversionObj.longToByteArray(1L, 0, new byte[8], 0, 8);
        assertArrayEquals(expectedResult,actualResult);
    }
    @Test
    public void testLongToByteArrayWithMultipleValues() {
        byte[] expectedResult = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        byte[] actualResult = conversionObj.longToByteArray(-1L, 0, new byte[8], 8);
        assertArrayEquals(expectedResult,actualResult);
    }
}