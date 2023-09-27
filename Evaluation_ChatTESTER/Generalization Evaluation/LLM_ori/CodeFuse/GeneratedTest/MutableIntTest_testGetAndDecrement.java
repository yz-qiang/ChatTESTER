package org.apache.commons.lang3.mutable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableIntTest###testGetAndDecrement
public class MutableIntTest_testGetAndDecrement {
    private MutableInt mutableInt;
    @Before
    public void setUp(){
        mutableInt = new MutableInt(5);
    }
    @Test
    public void testGetAndDecrementWithPositiveNumber() {
        assertEquals("The first call should return 5", 5, mutableInt.getAndDecrement());
        assertEquals("The second call should return 4", 4, mutableInt.getAndDecrement());
        assertEquals("The third call should return 3", 3, mutableInt.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementWithNegativeNumber() {
        mutableInt = new MutableInt(-10);
        assertEquals("First call should return -10", -10, mutableInt.getAndDecrement());
        assertEquals("Second call should return -111", -111, mutableInt.getAndDecrement());
        assertEquals("Third call should return -12", -12, mutableInt.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementWithZero() {
        mutableInt = new MutableInt(0);
        assertEquals("Calling decrement on zero should still return 0", 0, mutableInt.getAndDecrement());
    }
    @Test
    public void testGetAndDecrementOnNullInput() {
        try{
            mutableInt = null;
            mutableInt.getAndDecrement();
            fail("Expected exception not thrown");
        } catch (NullPointerException e){
            assertNotNull("An expected exception was caught", e);
        }
    }
}