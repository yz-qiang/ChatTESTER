package org.syphr.prom;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/ChangeStackTest###testSync
public class TestableChangeStack_testSync {
    private ChangeStack<Object> cstack;
    @Before
    public void setUp() {
        cstack = new ChangeStack<Object>(Comparator.naturalOrder());
    }
    @Test
    public void testPush() {
        cstack.push("one");
        cstack.push("two");
        cstack.push("three");
        Assert.assertEquals(3, cstack.size());
    }
    @Test
    public void testPop() {
        cstack.push("one");
        cstack.push("two");
        cstack.push("three");
        Assert.assertEquals("three", cstack.pop());
        Assert.assertEquals("two", cstack.pop());
        Assert.assertEquals("one", cstack.pop());
        Assert.assertEquals(0, cstack.size());
    }
    @Test
    public void testPeek() {
        cstack.push("one");
        cstack.push("two");
        cstack.push("three");
        Assert.assertEquals("three", cstack.peek());
        Assert.assertEquals(3, cstack.size());
    }
    @Test
    public void testIsEmpty() {
        Assert.assertTrue(cstack.isEmpty());
        cstack.push("one");
        Assert.assertFalse(cstack.isEmpty());
    }
    @Test
    public void testClear() {
        cstack.push("one");
        cstack.push("two");
        cstack.push("three");
        cstack.clear();
        Assert.assertEquals(0, cstack.size());
    }
}