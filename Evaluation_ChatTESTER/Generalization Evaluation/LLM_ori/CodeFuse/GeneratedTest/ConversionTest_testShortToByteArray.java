package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortToByteArray
public class ConversionTest_testShortToByteArray {
    private static short inputShort;
    private static byte[] expectedOutput;
    private static byte[] actualOutput;
    @BeforeClass
    public static void setUp(){
         inputShort = Short.parseShort("32767", 10);
         expectedOutput = new byte[]{0b111111111111, 0b1111111111};
    }
    @Test
    public void testShortToByteArrayWithValidInputsAndNonZeroNbytes() {
        try{
            actualOutput = Conversion.shortToByteArray(inputShort, 4, new byte[5], 0, 2);
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void testShortToByteArrayWithInvalidNbytes() {
        try{
            Conversion.shortToByteArray(inputShort, 4, new byte[5], 0, 3);
            fail();
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    @Test
    public void testShortToByteArrayWithZeroNbytes() {
        try{
            actualOutput = Conversion.shortToByteArray(inputShort, 4, new byte[5], 0, 0);
            assertNull(actualOutput);
        } catch (IllegalArgumentException e){
            fail();
        }
    }
}