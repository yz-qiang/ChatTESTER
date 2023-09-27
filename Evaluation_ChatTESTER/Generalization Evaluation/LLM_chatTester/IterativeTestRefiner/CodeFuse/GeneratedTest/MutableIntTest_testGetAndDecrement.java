package org.apache.commons.lang3.mutable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableIntTest###testGetAndDecrement
public class MutableIntTest_testGetAndDecrement {
    private MutableInt mutableInt;
    @Before
    public void setUp(){
        mutableInt = new MutableInt(5);
    }
    @Test
    public void testGetAndDecrementWithPositiveIntegerInputs() {
        assertEquals("Initial Value should be 5", 5, mutableInt.getValue());
        assertEquals("After first call to getAndDecrement(), it should return 5 and decrease its value to 4", 5, mutableInt.getAndDecrement());
        assertEquals("Second call to getAndDecrement() should return 4", 4, mutableInt.getAndDecrement());
        assertEquals("Third call to getAndDecrement() should return 3", 3, mutableInt.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementWithNegativeInputs() {
        mutableInt = new MutableInt(-20);
        assertEquals("Initial Value should be -20", -20, mutableInt.getValue());
        assertEquals("First call to getAndDecrement() should return -20 and decrease its value to -21", -20, mutableInt.getAndDecrement());
        assertEquals("Second call to getAndDecrement() should return -21", -21, mutableInt.getAndDecrement());
        assertEquals("Third call to getAndDecrement() should return -22", -22, mutableInt.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementWithZeroInput() {
        mutableInt = new MutableInt(0);
        assertEquals("Initial Value should be 0", 0, mutableInt.getValue());
        assertEquals("Calling getAndDecrement() on zero input should return 0 and decrease its value to -1", 0, mutableInt.getAndDecrement());
        assertEquals("Subsequent calls to getAndDecrement() should return -1", -1, mutableInt.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementOnNullInput() {
        mutableInt = null;
        try{
            mutableInt.getAndDecrement();
            fail("Expected NullPointerException");
        } catch (NullPointerException e){
            assertNotNull("Should throw NullPointerException when called on null object", e);
        }
    }
}