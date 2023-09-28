package org.apache.commons.lang3.mutable;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableIntTest###testGetAndDecrement
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class MutableIntTest_testGetAndDecrement {
    @Test
    public void testGetAndDecrement() {
        MutableInt mutableInt = new MutableInt(5);
        int result = mutableInt.getAndDecrement();
        assertEquals(5, result);
        assertEquals(4, mutableInt.intValue());
    }
}