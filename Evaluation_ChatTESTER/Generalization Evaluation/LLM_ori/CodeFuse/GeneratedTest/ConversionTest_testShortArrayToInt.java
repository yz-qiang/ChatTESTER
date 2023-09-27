package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortArrayToInt
public class ConversionTest_testShortArrayToInt {
    private static short[] inputArr;
    private static int expectedOutput;
    @BeforeClass
    public static void setUp(){
        inputArr = new short[]{1, 2, 3};
        expectedOutput = 549187;
    }
    @Test
    public void testShortArrayToIntWithValidInput() {
        try{
            assertEquals(expectedOutput, Conversion.shortArrayToInt(inputArr, 0, 0, 0, 2));
        } catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void testShortArrayToIntWithInvalidInput() {
        try{
            Conversion.shortArrayToInt(new short[]{}, 0, 0, 0, 1);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
    @Test
    public void testShortArrayToIntWithZeroNShorts() {
        try{
            Conversion.shortArrayToInt(inputArr, 0, 0, 0, 0);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
    @Test
    public void testShortArrayToIntWithLargeDstPos() {
        try{
            Conversion.shortArrayToInt(inputArr, 0, 0, 32, 2);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
}