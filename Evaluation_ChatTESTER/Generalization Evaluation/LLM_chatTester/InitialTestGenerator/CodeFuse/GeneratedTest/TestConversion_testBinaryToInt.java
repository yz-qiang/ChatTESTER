package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToInt
public class TestConversion_testBinaryToInt {
    @Test
    public void testBinaryToIntWithEmptyInputAndZeroNBooleansReturnsDstInitValue(){
        boolean[] emptyArr = {};
        int result = Conversion.binaryToInt(emptyArr, 0, 5, 4, 0);
        assertEquals(5, result);
    }
    @Test
    public void testBinaryToIntThrowsIllegalArgExWhenNBoolsGreaterOrEqualThan32(){
        try{
            boolean[] arr = {true};
            fail();
        } catch(IllegalArgumentException e){
        }
    }
    @Test
    public void testBinaryToIntWithSingleBooleanTrueAtPositionOneReturnsCorrectResult(){
        boolean[] arr = {false, true};
        int result = Conversion.binaryToInt(arr, 0, 0, 0, 1);
        assertEquals(1, result);
    }
    @Test
    public void testBinaryToIntWithMultipleBooleansReturnsCorrectResult(){
        boolean[] arr = {true, false, true, false, true};
        int result = Conversion.binaryToInt(arr, 0, 0, 0, 3);
        assertEquals(6, result);
    }
    @Test
    public void testBinaryToIntWithMultipleBooleansReturnsCorrectResultForNonDefaultValuesOfSrcPosAndDstPos(){
        boolean[] arr = {true, false, true, false, true};
        int result = Conversion.binaryToInt(arr, 1, 8, 2, 2);
        assertEquals(9, result);
    }
}