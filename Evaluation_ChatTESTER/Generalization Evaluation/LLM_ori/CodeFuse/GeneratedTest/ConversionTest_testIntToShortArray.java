package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToShortArray
public class ConversionTest_testIntToShortArray {
    private static short[] expectedDst;
    @BeforeClass
    public static void setUp(){
    }
    @Test
    public void testIntToShortArrayWithValidInput() {
        try{
            short[] actualResult = Conversion.intToShortArray(543789, 2, new short[5], 0, 3);
            assertArrayEquals(expectedDst, actualResult);
        } catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void testIntToShortArrayWithInvalidInput() {
        try{
            Conversion.intToShortArray(543789, 2, new short[5], 0, 5);
            fail();
        } catch (IllegalArgumentException e){
           assertTrue(true);
        }
    }
}