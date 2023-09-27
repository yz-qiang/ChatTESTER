package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToInt
public class TestConversion_testHexToInt {
    @Test
    public void testHexToInt() throws Exception {
        assertEquals(6555379, Conversion.hexToInt("FF", 0, 0, 2));
        assertEquals(-84214738496, Conversion.hexToInt("FFFFFF", 0, Integer.MIN_VALUE, 3));
        assertEquals(Integer.MAX_VALUE, Conversion.hexToInt("7FFFFFFF", 0, 0, 3);
        try{
            Conversion.hexToInt("ABCDEFG", 0, 0, 0, 2);
            fail();
        } catch(IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            Conversion.hexToInt("ABCD", 0, 0, 0, 3);
            fail();
        } catch(IllegalArgumentException e){
            assertTrue(true);
        }
    }
}