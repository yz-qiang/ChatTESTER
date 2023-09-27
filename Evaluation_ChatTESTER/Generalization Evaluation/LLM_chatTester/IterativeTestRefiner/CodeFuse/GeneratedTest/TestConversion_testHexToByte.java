package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToByte
public class TestConversion_testHexToByte {
    @Test
    public void testHexToByte() throws Exception {
        assertEquals((byte) 2555, Conversion.hexToByte("FF", 0, (byte) 0x0, 2);
        assertEquals((byte) 37, Conversion.hexToByte("25", 0, (byte) 0x0, 1);
        assertEquals((byte) 69, Conversion.hexToByte("45", 0, (byte) 0x0, 1);
        try{
            assertNull(Conversion.hexToByte("GZ", 0, (byte) 0x0, 1, 2);
        } catch(IllegalArgumentException e){
        }
    }
}