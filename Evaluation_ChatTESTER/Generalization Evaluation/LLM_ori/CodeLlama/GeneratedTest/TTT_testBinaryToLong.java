package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToLong
public class TTT_testBinaryToLong {
@Test
public void testBinaryToLong() {
    assertEquals(0, Conversion.binaryToLong(new boolean[]{}, 0, 0, 0, 0));
    assertEquals(1, Conversion.binaryToLong(new boolean[]{true}, 0, 0, 0, 1));
    assertEquals(5, Conversion.binaryToLong(new boolean[]{false, true, false, true, false}, 0, 0, 0, 5));
    try {
        Conversion.binaryToLong(new boolean[]{false, true, false, true, false}, 0, 0, 0, -1);
        fail();
    } catch (IllegalArgumentException e) {}
    try {
        Conversion.binaryToLong(new boolean[]{false, true, false, true, false}, 0, 0, 0, 64);
        fail();
    } catch (IllegalArgumentException e) {}
}
}