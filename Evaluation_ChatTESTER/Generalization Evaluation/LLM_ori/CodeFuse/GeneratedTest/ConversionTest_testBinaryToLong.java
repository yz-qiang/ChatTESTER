package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToLong
public class ConversionTest_testBinaryToLong {
    private static boolean[] inputArr;
    private static long expectedOutput;
    @BeforeClass
    public static void setUp(){
         inputArr = new boolean[]{true, false, true};
         expectedOutput = 5;
    }
    @Test
    public void testBinaryToLongWithValidInputs() {
        try{
            assertEquals(expectedOutput, Conversion.binaryToLong(inputArr, 0, 0, 2, 3));
        } catch (IllegalArgumentException e){
           fail();
       }
   }
    @Test
    public void testBinaryToLongWithInvalidInputs() {
        try{
            Conversion.binaryToLong(new boolean[]{}, 0, 0, 70, 8);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
    @Test
    public void testBinaryToLongWithEmptyBooleanArrayAndZeroNBooleans() {
        try{
            Conversion.binaryToLong(new boolean[]{}, 0, 0, 0, 0);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
    @Test
    public void testBinaryToLongWithLargeNBoolsValue() {
        try{
            Conversion.binaryToLong(new boolean[]{false, true, true}, 0, 0, 65);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
}