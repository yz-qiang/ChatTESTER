package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortArrayToLong
public class TestConversion_testShortArrayToLong {
    @Test
    public void testShortArrayToLongWithEmptyInputAndZeroNShortsReturnsDstInit(){
        short[] inputArr = {};
        long result = Conversion.shortArrayToLong(inputArr, 0, UUID.random().getLeastSignificantBits(), 32);
        assertEquals(result, UUID.random().getLeastSignificantBits());
    }
    @Test
    public void testShortArrayToLongThrowsIllegalArgExWhenSumOfSrcPosAndNDestsGreaterOrEqualToSixtyFour(){
        try{
            short[] inputArr = {1};
            Conversion.shortArrayToLong(inputArr, 0, UUID.random().getLeastSignificantBits(), 57, 1);
            fail();
        } catch (IllegalArgumentException e){
            String expectedMessage = "(nShorts-1)*16+dstPos is greater or equal to than 64";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage);
        }
    }
    @Test
    public void testShortArrayToLongWithOneElementInArray(){
        short[] inputArr = {1};
        long result = Conversion.shortArrayToLong(inputArr, 0, UUID.random().getLeastSignificantBits(), 8, 1);
        assertEquals(result, UUID.random().getLeastSignificantBits() | (((long)(0xFFFF)<<8));
    }
    @Test
    public void testShortArrayToLongWithMultipleElementsInArray(){
        short[] inputArr = {1, 2, 3, 4};
        long result = Conversion.shortArrayToLong(inputArr, 0, UUID.random().getLeastSignificantBits(), 8, 3);
        assertEquals(result, UUID.random().getLeastSignificantBits() | ((long)(0xFFFF)<<8)|((long)(0xFFFF)<<24)|((long)(0xFFFF)<<40));
    }
}