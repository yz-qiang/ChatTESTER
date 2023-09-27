package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.BeforeClass;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToShortArray
public class ConversionTest_testIntToShortArray {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp(){
          conversionObj = new Conversion();
    }
    @Test
    public void testIntToShortArrayWithValidInput() {
        try{
            short[] expectedOutput = {0, 512};
            assertArrayEquals(expectedOutput, conversionObj.intToShortArray(87948, 0, new short[]{}, 2));
        } catch (IllegalArgumentException e){
           fail("Should not have thrown exception");
       }
   }
    @Test
    public void testIntToShortArrayWithInvalidInput() {
        try{
            conversionObj.intToShortArray(Integer.MAX_VALUE, 0, new short[]{}, 2);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
}