package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToByte
public class TTT_testHexToByte {
@Test
public void testHexToByte() {
    assertEquals((byte) 0xA5, Conversion.hexToByte("A", 0, (byte) 0, 0, 2));
    assertEquals((byte) 0xABCD, Conversion.hexToByte("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 0, (byte) 0, 0, 36));
    assertEquals((byte) 0xAA, Conversion.hexToByte("A", 0, (byte) 0, 0, 1));
    assertEquals((byte) 0xBBCC, Conversion.hexToByte("BCD", 0, (byte) 0, 0, 2));
    assertEquals((byte) 0, Conversion.hexToByte("", 0, (byte) 0, 0, 0));
    try {
        Conversion.hexToByte("A", 0, (byte) 0, 0, -1);
        fail();
    } catch (IllegalArgumentException e) {}
}
}