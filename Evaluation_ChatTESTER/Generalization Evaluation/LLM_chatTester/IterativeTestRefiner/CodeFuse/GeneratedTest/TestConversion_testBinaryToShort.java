package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
import org.junit.Assert;
import java.nio.ByteBuffer;
import java.util.Arrays;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToShort
public class TestConversion_testBinaryToShort {
    @Test
    public void testBinaryToShortWithEmptyInputAndZeroNBooleansReturnsDstInit(){
        boolean[] emptyArr = {};
        try{
            short result = Conversion.binaryToShort(emptyArr, 0, (short) 5, 2, 3);
            fail();
        } catch (IllegalArgumentException e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void testBinaryToShortWithInvalidPositionThrowsError(){
        boolean[] arr = {false, true};
        try{
            short result = Conversion.binaryToShort(arr, 0, (short) 5, 17, 2);
            fail();
        } catch (IllegalArgumentException e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void testBinaryToShortWithValidInputReturnsCorrectValue(){
        boolean[] arr = {true, false, true, true, false, true};
        short expectedResult = (short) 9;
        short actualResult = Conversion.binaryToShort(arr, 0, (short) 0, 4, 4);
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testBinaryToShortWithMultipleValuesInSrc(){
        UUID uuid = UUID.randomUUID();
        byte[] bytes = ByteBuffer.allocate(Long.BYTES * 2).putLong(uuid.getMostSignificantBits()).putLong(uuid.leastSignificantBits())
                .array();
        boolean[] boolArr = new boolean[bytes.length*8];
        for (byte b : bytes) {
            for (int j = 0; j < 8; ++j) {
                boolArr[(b >> j) & 0xff] = true;
            }
        }
        short expectedResult = (short) 0xFFFF;
        short actualResult = Conversion.binaryToShort(boolArr, 0, (short) 0, 0, 16);
        Assert.assertEquals(expectedResult, actualResult);
    }
}