package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToLong
public class TestConversion_testByteArrayToLong {
    private static byte[] inputByteArr;
    private static long expectedOutput;
    @BeforeClass
    public static void setUp(){
        inputByteArr = new byte[]{0xFF, 0x7f};
        expectedOutput = 325535;
    }
    @Test
    public void testByteArrayToLongWithValidInputs() {
        try{
            assertEquals(expectedOutput, Conversion.byteArrayToLong(inputByteArr, 0, 0, 0, 2));
        } catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void testByteArrayToLongWithInvalidInputs() {
        try{
            Conversion.byteArrayToLong(new byte[]{}, 0, 0, 0, 9);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
    @Test
    public void testByteArrayToLongWithEmptyInputAndZeroNbytes() {
        try{
            Conversion.byteArrayToLong(new byte[]{}, 0, 0, 0, 0);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex){
            assertTrue(true);
        }
    }
    @Test
    public void testByteArrayToLongWithNullInput() {
        try{
            Conversion.byteArrayToLong(null, 0, 0, 0, 2);
            fail("Expected NullPointerException not thrown.");
        } catch (NullPointerException ex){
            assertTrue(true);
        }
    }
    @Test
    public void testByteArrayToLongWithOutOfBoundsDstPos() {
        try{
            Conversion.byteArrayToLong(inputByteArr, 0, 0, 8, 2);
            fail("Expected IndexOutOfBoundsException not thrown.");
        } catch (IndexOutOfBoundsException ex){
            assertTrue(true);
        }
    }
    @Test
    public void testByteArrayToLongWithOverflowingValue() {
        try{
            Conversion.byteArrayToLong(new byte[]{0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF}, 0, 0, 8);
            fail("Expected ArithmeticException not thrown.");
        } catch (ArithmeticException ex){
            assertTrue(true);
        }
    }
}