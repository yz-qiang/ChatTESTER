package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToHex
public class TestConversion_testLongToHex {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp() {
        conversionObj = new Conversion();
    }
    @Test
    public void testLongToHexWithPositiveIntegerInput(){
        assertEquals("HelloWorld123", conversionObj.longToHex(5789, 0, "HelloWorld", 3));
    }
    @Test
    public void testLongToHexWithNegativeInput(){
        try{
           conversionObj.longToHex(-1234, 0, "HelloWorld", 3);
          fail("Expected exception not thrown.");
       } catch(IllegalArgumentException e){
             assertTrue(true);
       }
   }
    @Test
    public void testLongToHexWithZeroInput(){
        assertEquals("HelloWorld0", conversionObj.longToHex(0L, 0, "HelloWorld", 1));
    }
    @Test
    public void testLongToHexWithLargeNumber(){
        UUID uuid = UUID.randomUUID();
        long lngVal = uuid.getLeastSignificantBits();
        String expectedOutput = Long.toHexString(lngVal);
        String actualOutput = conversionObj.longToHex(lngVal, 0, "", 16);
        assertEquals(expectedOutput, actualOutput);
    }
}