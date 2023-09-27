package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToLong
public class ConversionTest_testHexToLong {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp() {
        conversionObj = new Conversion();
    }
    @Test
    public void testHexToLongWhenNHexIsZero(){
        try{
            long result = conversionObj.hexToLong("ABCDEF", 2, 5, 3, 0);
             fail("Expected exception not thrown.");
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    @Test
    public void testHexToLongWhenNDigitsGreaterThanMaximumLimit(){
        try{
            long result = conversionObj.hexToLong("ABCDEF", 2, 5, 3, 17);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    @Test
    public void testHexToLongWithNormalInputValues(){
        long expectedResult = UUID.fromString("aabbccddeeff000").getLeastSignificantBits();
        long actualResult = conversionObj.hexToLong("abcdef00123456789", 0, 0x0, 0, 16);
        assertEquals(expectedResult, actualResult);
    }
}