package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToByte
public class TestConversion_testHexToByte {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp() {
        conversionObj = new Conversion();
    }
    @Test
    public void testHexToByteWithValidInput() {
        try{
            assertEquals((byte) 2555, conversionObj.hexToByte("FF", 0, (byte) 0, 2));
            assertEquals((byte) 3769, conversionObj.hexToByte("AA", 0, (byte) 0, 2));
            assertEquals((byte) 16, conversionObj.hexToByte("10", 0, (byte) 0, 1));
            assertEquals((byte) 170, conversionObj.hexToByte("Aa", 0, (byte) 0, 1));
        } catch (IllegalArgumentException e){
           fail("An exception should not have been thrown.");
       }
   }
    @Test
    public void testHexToByteWithInvalidInput() {
        try{
            conversionObj.hexToByte("FF", 0, (byte) 0, 3);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
}