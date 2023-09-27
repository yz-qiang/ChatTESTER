package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToShort
public class ConversionTest_testHexToShort {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp() {
        conversionObj = new Conversion();
    }
    @Test
    public void testHexToShortWhenNZero(){
        assertEquals((short) 5, conversionObj.hexToShort("ABCDEF", 2, (short) 3, 0, 0));
    }
    @Test
    public void testHexToShortNormalInput(){
        assertEquals((short) 978, conversionObj.hexToShort("ABCD", 0, (short) 0, 0, 2);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testHexToShortWithInvalidArgs(){
        conversionObj.hexToShort("ABCDE", 0, (short) 0, 16, 1);
    }
}