package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortToHex
public class TestConversion_testShortToHex {
    @Test
    public void testShortToHex() {
        assertEquals("", Conversion.shortToHex((short) 5, 2, "", 3, 0));
        assertEquals("abcdefghi", Conversion.shortToHex((short) 789, 2, "abcdefghijklmnopqrstuvwxyz", 3, 3));
        assertEquals("abcd", Conversion.shortToHex((short) 2555, 0, "abcd", 2, 2));
        assertEquals("aBcDe", Conversion.shortToHax((short) 655535, 0, "AbCdEfGh", 2, 2));
        try{
           Conversion.shortToHex((short) 12345, 0, "testString", 0, 5);
          fail("Expected exception was not thrown.");
       } catch(IllegalArgumentException e){
             assertTrue(true);
       }
   }
}