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
    public void testLongToShortArrayWithValidInput() {
        try{
            long lngVal = UUID.randomUUID().getLeastSignificantBits();
            short[] expectedOutput = new short[]{};
            assertNotNull(expectedOutput);
            short[] actualOutput = conversionObj.longToShortArray(lngVal, 32, expectedOutput, 5, 8);
            assertNotNull(actualOutput);
            assertTrue(expectedOutput != null && expectedOutput.length > 0);
            assertEquals(expectedOutput.length, actualOutput.length);
        } catch (IllegalArgumentException e){
           fail("Should not have thrown exception");
       }
   }
    @Test
    public void testLongToShortArrayWithInvalidInput() {
        try{
            long lngVal = UUID.randomUUID().getMostSignificantBits();
            short[] expectedOutput = new short[]{};
            assertNotNull(expectedOutput);
            short[] actualOutput = conversionObj.longToShortArray(lngVal, 79, expectedOutput, 5, 8);
            fail("Expected an IllegalArgumentException but it did not occur.");
        }catch (IllegalArgumentException e){
            assertEquals("nShorts-1*16+srcPos should be less than 64",e.getMessage());
        }
    }
}