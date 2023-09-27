package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortToHex
public class ConversionTest_testShortToHex {
    private static Conversion conversionObj;
    @BeforeClass
    public static void setUp() {
        conversionObj = new Conversion();
    }
    @Test
    public void testShortToHexWithValidInput(){
        assertEquals("789a", conversionObj.shortToHex((short)325767, 0, "12345", 1));
        assertEquals("fedcba", conversionObj.shortToHex((short)-214135, 0, "", 0));
        assertEquals("abcd", conversionObj.shortToHex((short)432856, 4, "efghijklmnopqrstuvwxyz", 2));
    }
    @Test
    public void testShortToHexWithInvalidInput(){
        try{
           conversionObj.shortToHex((short)325767, 0, "abcdefghi", 1);
           fail("Expected an IllegalArgumentException to be thrown");
       } catch(IllegalArgumentException e){
           assertTrue(true);
       }
   }
}