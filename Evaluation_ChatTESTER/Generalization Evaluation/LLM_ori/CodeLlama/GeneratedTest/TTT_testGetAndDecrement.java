package org.apache.commons.lang3.mutable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableIntTest###testGetAndDecrement
public class TTT_testGetAndDecrement {
@Test
public void testGetAndDecrement() {
    MutableInt mutableInt1 = new MutableInt(5);
    MutableInt mutableInt2 = new MutableInt(-3);
    assertEquals(4, mutableInt1.getAndDecrement());
    assertEquals(-4, mutableInt2.getAndDecrement());
    assertEquals(2, mutableInt1.getAndDecrement(2));
    assertEquals(-6, mutableInt2.getAndDecrement(3));
    try {
        mutableInt1.getAndDecrement(0);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
    try {
        mutableInt2.getAndDecrement(-1);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
}
}