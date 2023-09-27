package edu.jhu.prim.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest###testUniq
public class LongArrayListTest_testUniq {
    private LongArrayList la;
    @Before
    public void setUp(){
       long[] arr = {5L,2L,3L,4L,6L,7L,2L,9L};
       la=new LongArrayList();
       la.addAll(arr);
   }
    @Test
    public void testUniqueValuesInArrayList() {
        la.uniq();
        assertTrue("No duplicates should be present", Arrays.asList(la.toArray()).containsAll(Arrays.asList(5L,2L,3L,4L,6L,7L,9L));
        la.clear();
        la.addAll(Collections.nCopies(10, 10L));
        la.uniq();
        assertTrue("Only one element should remain after removing duplicates", la.getSize() == 1 && la.getElementAt(0)==10L);
        la.clear();
        la.addAll(new long[]{10L,10L,10L,10L});
        la.uniq();
        assertTrue("Two unique elements should remain after removing duplicates", la.getSize() == 2 && la.getElementAt(0)==10L && la.getElementAt(1)==10L);
        la.clear();
        la.uniq();
        assertTrue("Empty ArrayList should not throw any exception or error", true);
        la.clear();
        la.add(null);
        la.uniq();
        assertNull("Should contain null as first element", la.getElementAt(0));
    }
}