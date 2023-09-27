package org.syphr.prom;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/ChangeStackTest###testSync
public class ChangeStackTest_testSync {
    private ChangeStack<Integer> changeStack;
    @Before
    public void setUp() {
        changeStack = new ChangeStack<Integer>(10);
    }
    @Test
    public void testSyncWithValue() {
        try {
            boolean result = changeStack.sync(20);
            Assert.assertTrue("The value should have been added successfully", result);
        } catch (NullPointerException e) {
            Assert.fail("An exception occurred while adding value");
        }
    }
}