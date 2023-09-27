package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToHex
public class ConversionTest_testLongToHex {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp() {
        conversionObj = new Conversion();
    }
    @Test
    public void testLongToHexWithValidInput() {
        assertEquals("789a", conversionObj.longToHex(235L, 2, "123456789abcdefg", 3, 2));
        assertEquals("fedcba9876543210", conversionObj.longToHex(-1234567890L, 0, "", 0, 8));
        assertEquals("000000000000000000000000000", conversionObj.longToHex(0L, 0, "", 0, 16));
        assertEquals("ffffffffffffffffffff", conversionObj.longToHex(-1L, 0, "", 0, 16));
    }
    @Test
    public void testLongToHexWithInvalidInput() {
        try{
           conversionObj.longToHex(1234567890L, 0, "abcd", 10);
          fail("Expected an IllegalArgumentException to be thrown");
       } catch(IllegalArgumentException e){
             assertTrue(true);
       }
   }
}