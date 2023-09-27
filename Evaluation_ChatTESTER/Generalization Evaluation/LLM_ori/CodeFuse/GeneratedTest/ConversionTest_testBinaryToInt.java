package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToInt
public class ConversionTest_testBinaryToInt {
    private static boolean[] inputArr;
    @BeforeClass
    public static void setUp(){
          inputArr=new boolean[]{true, false, true, false};
    }
    @Test
    public void testBinaryToIntWithValidInputs() {
        try{
            assertEquals(Conversion.binaryToInt(inputArr, 0, 5, 4, 3);
        } catch (IllegalArgumentException e){
           fail();
       }
   }
    @Test
    public void testBinaryToIntWithInvalidInputs() {
        try{
            Conversion.binaryToInt(inputArr, 0, 6, 8, 3);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
    @Test
    public void testBinaryToIntWithEmptyArrayAndZeroNBooleans() {
        try{
            Conversion.binaryToInt(new boolean[]{}, 0, 0, 0, 0);
        } catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void testBinaryToIntWithNonEmptyArrayAndZeroNBooleans() {
        try{
            Conversion.binaryToInt(inputArr, 0, 0, 0, 0);
        } catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void testBinaryToIntWithLargeDstPos() {
        try{
            Conversion.binaryToInt(inputArr, 0, 0, 32, 3);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
}