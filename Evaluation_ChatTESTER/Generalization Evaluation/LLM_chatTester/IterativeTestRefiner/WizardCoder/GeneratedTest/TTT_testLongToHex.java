package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToHex
public class TTT_testLongToHex {
    @Test
    public void testLongToHex() {
        UUID uuid = UUID.randomUUID();
        long mostSigBits = uuid.getMostSignificantBits();
        byte[] bytes = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bytes[i] = (byte) (mostSigBits & 0xff);
            mostSigBits >>= 8;
        }
        assertEquals("Invalid most significant bits conversion.",
                Conversion.longToHex(mostSigBits, (Integer) ((Object[]) tests[0])[1], (String) ((Object[]) tests[0])[2], (Integer) ((Object[]) tests[0])[3], (Integer) ((Object[]) tests[0])[4]));
    }
}