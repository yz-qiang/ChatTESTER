package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToByte
public class TestBinaryToByte_testBinaryToByte {
    @Test
    public void testBinaryToByteWithEmptyInputAndZeroNBooleansReturnsDstInit() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean[] inputArr = {};
        byte result = Conversion.binaryToByte(inputArr, 0, Byte.MAX_VALUE, 3, 0);
        Assert.assertEquals(Byte.MAX_VALUE, result);
    }
    @Test
    public void testBinaryToByteThrowsIllegalArgExWhenNBoolsGreaterOrEqualEight() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try{
            Random random = new Random();
            boolean[] inputArr = new boolean[]{true};
            Conversion.binaryToByte(inputArr, 0, Byte.MIN_VALUE, 7, 2);
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e){
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    @Test
    public void testBinaryToByteWithOneBooleanAtStartOfArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean[] inputArr = {false};
        byte result = Conversion.binaryToByte(inputArr, 0, Byte.MAX_VALUE, 0, 1);
        Assert.assertEquals((byte)(~0b1), result);
    }
    @Test
    public void testBinaryToByteWithMultipleBooleansInArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean[] inputArr = {true, false, true, false, true};
        byte result = Conversion.binaryToByte(inputArr, 0, Byte.MAX_VALUE, 4, 3);
        Assert.assertEquals((byte)(~0b1101000000000), result);
    }
    @Test
    public void testBinaryToByteWithMultipleBooleansNotAtStartOfArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean[] inputArr = {false, true, false, true, true};
        byte result = Conversion.binaryToByte(inputArr, 1, Byte.MAX_VALUE, 5, 2);
        Assert.assertEquals((byte)(~0b111000000000), result);
    }
    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Condition not met!");
        }
    }
}