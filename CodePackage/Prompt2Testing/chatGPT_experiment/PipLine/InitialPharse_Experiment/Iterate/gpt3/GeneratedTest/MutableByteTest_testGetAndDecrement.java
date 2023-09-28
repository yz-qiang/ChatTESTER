package org.apache.commons.lang3.mutable;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableByteTest###testGetAndDecrement
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class MutableByteTest_testGetAndDecrement {
    @Test
    public void testGetAndDecrement() {
        MutableByte mutableByte = new MutableByte((byte) 5);
        byte result = mutableByte.getAndDecrement();
        assertEquals(5, result);
        assertEquals(4, mutableByte.byteValue());
    }
}