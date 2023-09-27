package edu.jhu.prim.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest###testUniq
public class LongArrayListTest_testUniq {
    private LongArrayList list;
    @Before
    public void setUp(){
       list = new LongArrayList();
   }
    @Test
    public void testUniqueElementsInList() {
        long[] arr = {2L,3L,4L,5L,6L,7L,2L,3L};
        list = new LongArrayList(arr);
        list.uniq();
        assertArrayEquals("The returned array should contain only unique elements",new long[]{2L,3L,4L,5L,6L,7L}, list.toArray());
    }
    @Test
    public void testEmptyList() {
        list = new LongArrayList();
        list.uniq();
        assertTrue("The returned array should be empty", Arrays.equals(new long[]{}, list.toArray()));
    }
    @Test
    public void testSingleElementList() {
        long[] arr = {2L};
        list = new LongArrayList(arr);
        list.uniq();
        assertArrayEquals("The returned array should have one element", arr, list.toArray());
    }
    @Test
    public void testNullInput() {
        try{
            list = new LongArrayList((long[])null);
              fail("Should throw NullPointerException");
        } catch (NullPointerException e){
        }
    }
}