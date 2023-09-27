package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToShort
public class TTT_testBinaryToShort {
@Test
public void testBinaryToShort() {
    assertEquals((short) 0, Conversion.binaryToShort(new boolean[]{}, 0, (short) 0, 0, 0));
    assertEquals((short) 1, Conversion.binaryToShort(new boolean[]{true}, 0, (short) 0, 0, 1));
    assertEquals((short) 5, Conversion.binaryToShort(new boolean[]{false, true, false, true, false}, 0, (short) 0, 0, 4));
    try {
        Conversion.binaryToShort(new boolean[]{true}, 0, (short) 0, 0, -1);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.binaryToShort(new boolean[]{true}, 0, (short) 0, 0, 17);
        fail();
    } catch (IllegalArgumentException e) {}
}
}