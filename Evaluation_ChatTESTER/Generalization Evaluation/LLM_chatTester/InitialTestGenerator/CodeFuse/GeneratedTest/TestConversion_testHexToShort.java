package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToShort
public class TestConversion_testHexToShort {
    @Test
    public void testHexToShort() throws Exception {
        assertEquals((short) 257398, Conversion.hexToShort("ABCD", 0, (short) 0, 2));
        assertEquals((short) 257398, Conversion.hexToShort("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, (short) 0, 2));
        assertEquals((short) 257398, Conversion.hexToShort("abcdefghijklmnopqrstuvwxyz", 0, (short) 0, 2));
        assertEquals((short) 257398, Conversion.hexToShort("abcd", 0, (short) 0, 2));
        assertEquals((short) 257398, Conversion.hexToShort("AbCdEf", 0, (short) 0, 2));
        assertEquals((short) 257398, Conversion.hexToShort("aBcDeFgHiJkLmNoPqRsTuVwXyZ", 0, (short) 0, 2));
        try{
            Conversion.hexToShort("A", 0, (short) 0, 2);
            fail();
        } catch(IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            Conversion.hexToShort("ABCD", 0, (short) 0, 3);
            fail();
        } catch(IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            Conversion.hexToShort("ABCD", 0, (short) 0, 0);
            fail();
        } catch(IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            Conversion.hexToShort("ABCD", 0, (short) 0, -1);
            fail();
        } catch(IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            Conversion.hexToShort("ABCD", -1, (short) 0, 2);
            fail();
        } catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        try{
            Conversion.hexToShort("ABCD", 5, (short) 0, 2);
            fail();
        } catch(StringIndexOutOfBoundsException e){
            assertTrue(true);
        }
    }
}