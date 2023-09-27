package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
import org.junit.Assert;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortArrayToInt
public class TestConversion_testShortArrayToInt {
    @Test
    public void testShortArrayToIntWithEmptyInputAndZeroNShortsReturnsDstInitValue(){
        short[] inputArr = {};
        int result = Conversion.shortArrayToInt(inputArr, 0, 5, 4, 0);
        Assert.assertEquals(5, result);
    }
    @Test
    public void testShortArrayToIntThrowsIllegalArgExWhenNDestinationBitsGreaterOrEqualTo32(){
        short[] inputArr = {1};
        try{
            Conversion.shortArrayToInt(inputArr, 0, 0, 32, 1);
            fail();
        } catch (IllegalArgumentException e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void testShortArrayToIntWithOneElementInSrcArray(){
        short[] inputArr = {1};
        int result = Conversion.shortArrayToInt(inputArr, 0, 0, 8, 1);
        Assert.assertEquals(256, result);
    }
    @Test
    public void testShortArrayToIntWithMultipleElementsInSrcArray(){
        short[] inputArr = {1, 2, 3, 4};
        int result = Conversion.shortArrayToInt(inputArr, 0, 0, 8, 3);
        Assert.assertEquals(7936, result);
    }
    @Test
    public void testShortArrayToIntWithNonZeroDstPos(){
        short[] inputArr = {1, 2, 3, 4};
        int result = Conversion.shortArrayToInt(inputArr, 0, 0, 4, 3);
        Assert.assertEquals(19472, result);
    }
    @Test
    public void testShortArrayToIntWithNonZeroSrcPos(){
        short[] inputArr = {1, 2, 3, 4};
        int result = Conversion.shortArrayToInt(inputArr, 1, 0, 8, 2);
        Assert.assertEquals(7772, result);
    }
    @Test
    public void testShortArrayToIntWithAllZeros(){
        short[] inputArr = {0, 0, 0};
        int result = Conversion.shortArrayToInt(inputArr, 0, 0, 8, 3);
        Assert.assertEquals(0, result);
    }
}