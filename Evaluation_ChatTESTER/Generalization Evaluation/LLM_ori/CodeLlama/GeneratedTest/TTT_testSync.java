package org.syphr.prom;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/ChangeStackTest###testSync
public class TTT_testSync {
@Test
public void testSync() {
    ChangeStack<Integer> cs = new ChangeStack<>(10);
    try {
        boolean result = cs.sync(20);
        Assert.assertTrue("Expected the sync method to return true", result);
    } catch (NullPointerException e) {
        fail("Unexpected exception thrown");
    }
    assertEquals(Arrays.asList(10, 20), cs.getStack());
}
}