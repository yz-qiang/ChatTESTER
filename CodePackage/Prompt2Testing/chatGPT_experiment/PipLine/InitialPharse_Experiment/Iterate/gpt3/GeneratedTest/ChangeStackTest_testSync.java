package org.syphr.prom;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/ChangeStackTest###testSync
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ChangeStackTest_testSync {
    private ChangeStack<Integer> stack;
    @Before
    public void setUp() {
        stack = new ChangeStack<Integer>(1);
    }
    @Test
    public void testSync() throws NullPointerException {
        boolean result = stack.sync(2);
        assertTrue(result);
        assertEquals(2, (int) stack.peek());
    }
}