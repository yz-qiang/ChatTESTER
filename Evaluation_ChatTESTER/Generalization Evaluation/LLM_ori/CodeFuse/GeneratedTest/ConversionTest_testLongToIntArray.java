package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToIntArray
public class ConversionTest_testLongToIntArray {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp(){
          conversionObj = new Conversion();
    }
    @Test
    public void testLongToIntArrayWithValidInput() {
        try{
            long inputValue = UUID.randomUUID().getLeastSignificantBits();
            int[] expectedOutput = new int[]{0};
            int[] actualOutput = conversionObj.longToIntArray(inputValue, 5, new int[1], 0, 1);
            assertNotNull(actualOutput);
            assertTrue(expectedOutput.length > 0 && actualOutput.length > 0);
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (IllegalArgumentException e){
           fail("Should not have thrown exception " + e.getMessage());
       }
   }
    @Test
    public void testLongToIntArrayWithInvalidInput() {
        try{
            long inputValue = UUID.randomUUID().getMostSignificantBits();
            int[] expectedOutput = null;
            int[] actualOutput = conversionObj.longToIntArray(inputValue, 7, new int[1], 0, 1);
            fail("Expected an IllegalArgumentException but it did not occur.");
        }catch (IllegalArgumentException e){
            assertEquals("nInts-1*32+srcPos should be less than 64", e.getMessage());
        }
    }
}