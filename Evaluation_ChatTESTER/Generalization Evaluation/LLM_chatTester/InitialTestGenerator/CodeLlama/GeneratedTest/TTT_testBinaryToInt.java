package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToInt
public class TTT_testBinaryToInt {
@Test
public void testBinaryToInt() {
    assertEquals(0, Conversion.binaryToInt(new boolean[0], 0, 0, 0, 0));
    assertEquals(1, Conversion.binaryToInt(new boolean[]{true}, 0, 0, 0, 1));
    assertEquals(5, Conversion.binaryToInt(new boolean[]{false, true, false, true, false}, 0, 0, 0, 4));
    assertEquals(-1, Conversion.binaryToInt(new boolean[]{true, false, true, false, true}, 0, 0, 0, 4));
    assertEquals(Integer.MAX_VALUE, Conversion.binaryToInt(new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, 0, 0, 0, 16));
    try {
        Conversion.binaryToInt(new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, 0, 0, 0, 33);
        fail();
    } catch (IllegalArgumentException e) {}
}
}