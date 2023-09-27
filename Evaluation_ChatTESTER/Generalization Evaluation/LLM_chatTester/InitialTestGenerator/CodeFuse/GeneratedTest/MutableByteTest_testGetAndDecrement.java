package org.apache.commons.lang3.mutable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableByteTest###testGetAndDecrement
public class MutableByteTest_testGetAndDecrement {
    private MutableByte mb;
    @Before
    public void setUp(){
        mb = new MutableByte((byte)5);
    }
    @Test
    public void testGetAndDecrementWithPositiveInputs() {
        assertEquals("Initial Value should be 5", 5, mb.getValue());
        assertEquals("After first call it should decrease to 4", 4, mb.getAndDecrement());
        assertEquals("Second call should also decrease to 3", 3, mb.getAndDecrement());
        assertEquals("Third call should decrease to 2", 2, mb.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementWithNegativeInputs() {
        mb = new MutableByte(-5);
        assertEquals("Initial Value should be -5", -5, mb.getValue());
        assertEquals("First call should increase to -6", -6, mb.getAndDecrement());
        assertEquals("Second call should increase to -7", -7, mb.getAndDecrement());
        assertEquals("Third call should increase to -8", -8, mb.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementWithZeroInput() {
        mb = new MutableByte(0);
        assertEquals("Initial Value should be 0", 0, mb.getValue());
        assertEquals("Calling getAndDecrement on zero should result in negative one", -1, mb.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementOnMaximumValues() {
        mb = new MutableByte(Byte.MAX_VALUE);
        assertEquals("Initial Value should be MAX_VALUE", Byte.MAX_VALUE, mb.getValue());
        assertEquals("Should wrap around from MAX_VALUE to MIN_VALUE when called", Byte.MIN_VALUE, mb.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementOnMinimumValues() {
        mb = new MutableByte(Byte.MIN_VALUE);
        assertEquals("Initial Value should be MIN_VALUE", Byte.MIN_VALUE, mb.getValue());
        assertEquals("Should wrap around from MIN_VALUE to MAX_VALUE when called", Byte.MAX_VALUE, mb.getAndDecrement());
    }
}