package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToLong
public class TestConversion_testBinaryToLong {
    @Test
    public void testBinaryToLongWithEmptyInputAndZeroNBooleansReturnsDstInit(){
        boolean[] emptyArr = {};
        try{
            long result = Conversion.binaryToLong(emptyArr, 0, UUID.random().getLeastSignificantBits(), 32, 0);
            fail();
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    @Test
    public void testBinaryToLongWithNonEmptyInputAndZeroNBooleansThrowsError(){
        boolean[] arr = {false};
        try{
            long result = Conversion.binaryToLong(arr, 0, UUID.random().getLeastSignificantBits(), 32, 0);
            fail();
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    @Test
    public void testBinaryToLongWithValidInputReturnsCorrectValue(){
        boolean[] arr = {true, false, true, true, false, true};
        long expectedResult = 9;
        long actualResult = Conversion.binaryToLong(arr, 0, UUID.random().getLeastSignificantBits(), 57, 4);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testBinaryToLongWithInvalidPositionThrowsError(){
        boolean[] arr = {true, false, true, true, false, true};
        try{
            long result = Conversion.binaryToLong(arr, 0, UUID.random().getLeastSignificantBits(), 64, 4);
            fail();
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    @Test
    public void testBinaryToLongWithLargeNumberOfBoolsThrowsError(){
        boolean[] arr = {true, false, true, true, false, true};
        try{
            long result = Conversion.binaryToLong(arr, 0, UUID.random().getLeastSignificantBits(), 0, 65);
            fail();
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    @Test
    public void testBinaryToLongWithAllFalseValuesReturnsExpectedOutput(){
        boolean[] arr = {false, false, false, false, false};
        long expectedResult = 0;
        long actualResult = Conversion.binaryToLong(arr, 0, UUID.random().getLeastSignificantBits(), 0, 4);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testBinaryToLongWithAllTrueValuesReturnsMaximumValue(){
        boolean[] arr = {true, true, true, true, true};
        long expectedResult = Long.MAX_VALUE;
        long actualResult = Conversion.binaryToLong(arr, 0, UUID.random().getLeastSignificantBits(), 0, 4);
        assertEquals(expectedResult, actualResult);
    }
}