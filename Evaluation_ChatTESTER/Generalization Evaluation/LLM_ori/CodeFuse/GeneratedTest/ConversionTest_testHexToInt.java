package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToInt
public class ConversionTest_testHexToInt {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp() {
        conversionObj = new Conversion();
    }
    @Test
    public void testHexToIntWhenNHexIsZero(){
        assertEquals(56789, conversionObj.hexToInt("ABCDEF", 0, 56789, 0);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testHexToIntWithInvalidInput(){
        conversionObj.hexToInt("ABCDEFGHIJKLMNO", 0, 0, 0, 10);
    }
    @Test
    public void testValidInputValues(){
        assertEquals(16777772160, conversionObj.hexToInt("ABCD", 0, 0, 2));
    }
    @Test(expected=NumberFormatException.class)
    public void testInvalidStringValue(){
        conversionObj.hexToInt("XYZ", 0, 0, 2);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testNegativeSrcAndDstPos(){
        conversionObj.hexToInt("ABCDE", -1, 0, -1, 2);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testLargeSrcAndDstPos(){
        conversionObj.hexToInt("ABCDE", Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 2);
    }
}