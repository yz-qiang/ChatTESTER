package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToShortArray
public class ConversionTest_testLongToShortArray {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp(){
        conversionObj = new Conversion();
    }
    @Test
    public void testLongToShortArrayWithZeroNShortsReturnsDst() {
        short[] expectedResult = {};
        assertArrayEquals(expectedResult, conversionObj.longToShortArray(0L, 0, new short[]{}, 0, 0);
    }
    @Test
    public void testLongToShortArrayThrowsIllegalArgExWhenNShortsGreaterOrEqualSixteen() {
        try{
            conversionObj.longToShortArray(0L, 32, new short[8], 0, 5);
             fail("Should have thrown exception");
        } catch (IllegalArgumentException e){
           assertTrue(true);
       }
   }
    @Test
    public void testLongToShortArrayConvertsCorrectly() {
        UUID uuid = UUID.randomUUID();
        String randomString = "Hello World";
        byte[] bytes = randomString.getBytes();
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long lngVal = bb.getLong();
        short[] result = new short[8];
        short[] actualOutput = conversionObj.longToShortArray(lngVal, 0, result, 0, 8);
        short[] expectedOutput = {(short)(lngVal>>>48),(short)(lngVal>>>32), (short)(lngVal>>>16), (short)lngVal};
        assertArrayEquals(expectedOutput, actualOutput);
    }
}