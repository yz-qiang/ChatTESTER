package org.apache.commons.lang3.mutable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableIntTest###testGetAndDecrement
public class TTT_testGetAndDecrement {
@Test
public void testGetAndDecrement() {
    MutableInt mutableInt = new MutableInt(5);
    assertEquals(5, mutableInt.getValue());
    int result = mutableInt.getAndDecrement();
    assertEquals(4, result);
    assertEquals(4, mutableInt.getValue());
    result = mutableInt.getAndDecrement();
    assertEquals(3, result);
    assertEquals(3, mutableInt.getValue());
    mutableInt.setValue(-2);
    result = mutableInt.getAndDecrement();
    assertEquals(-3, result);
    assertEquals(-3, mutableInt.getValue());
}
}