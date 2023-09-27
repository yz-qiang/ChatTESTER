package org.apache.commons.lang3.mutable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableByteTest###testGetAndDecrement
public class MutableByteTest_testGetAndDecrement {
    private MutableByte mutableByte;
    @Before
    public void setUp(){
        mutableByte = new MutableByte((byte) 5);
    }
    @Test
    public void testGetAndDecrementWithPositiveInputs() {
        assertEquals("The first call should return 5", (byte) 5, mutableByte.getAndDecrement());
        assertEquals("The second call should return 4", (byte) 4, mutableByte.getAndDecrement());
        assertEquals("The third call should return 3", (byte) 3, mutableByte.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementWithNegativeInputs() {
        mutableByte = new MutableByte(-10);
        assertEquals("First call should return -10", (byte)-10, mutableByte.getAndDecrement());
        assertEquals("Second call should return -111", (byte)-111, mutableByte.getAndDecrement());
        assertEquals("Third call should return -12", (byte)-12, mutableByte.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementWithZeroInput() {
        mutableByte = new MutableByte(0);
        assertEquals("Calling decrement on zero should still return zero", (byte) 0, mutableByte.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementOnMaximumValues() {
        mutableByte = new MutableByte(Byte.MAX_VALUE);
        assertEquals("Should return MAX_VALUE when called once", Byte.MAX_VALUE, mutableByte.getAndDecrement());
        assertEquals("Should return MAX_VALUE - 1 after calling twice", (byte)(Byte.MAX_VALUE - 1), mutableByte.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementOnMinimumValues() {
        mutableByte = new MutableByte(Byte.MIN_VALUE);
        assertEquals("Should return MIN_VALUE when called once", Byte.MIN_VALUE, mutableByte.getAndDecrement());
        assertEquals("Should return MIN_VALUE + 1 after calling twice", (byte)(Byte.MIN_VALUE + 1), mutableByte.getAndDecrement());
    }
}