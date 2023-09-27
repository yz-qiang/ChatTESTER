package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToShort
public class ConversionTest_testBinaryToShort {
    private static boolean[] inputArr;
    private static short expectedOutput;
    @BeforeClass
    public static void setUp(){
        inputArr = new boolean[]{true, false, true};
        expectedOutput = (short) 5;
    }
    @Test
    public void testBinaryToShortWithValidInputs() {
        try{
            assertEquals(expectedOutput, Conversion.binaryToShort(inputArr, 0, (short) 2, 3, 2));
        } catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void testBinaryToShortWithInvalidInputs() {
        try{
            Conversion.binaryToShort(new boolean[]{}, 0, (short) 0, 4, 8);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
    @Test
    public void testBinaryToShortWithEmptyInputAndZeroNBooleans() {
        try{
            Conversion.binaryToShort(new boolean[]{}, 0, (short) 0, 0, 0);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
    @Test
    public void testBinaryToShortWithLargeDstPosValue() {
        try{
            Conversion.binaryToShort(new boolean[]{false, true, true}, 0, (short) 0, 17, 2);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }
}