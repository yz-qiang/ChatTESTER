package org.syphr.prom;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/ChangeStackTest###testSync
public class TTT_testSync {
@Test
public void testSync() {
    List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5).toList());
    ChangeStack<Integer> stack = new ChangeStack<Integer>(list);
    Integer newValue = 6;
    Assert.assertTrue("New value was added successfully", stack.sync(newValue));
    Assert.assertEquals("New value is now the most recent addition", newValue, stack.peek());
    Assert.assertArrayEquals("Other elements were shifted down by one position",
            Arrays.asList(1, 2, 3, 4), stack.toList().subList(0, 4));
}
}