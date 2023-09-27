package cn.xdean.jex.lang.collection.sequence;
import io.reactivex.Flowable;
import org.junit.Test;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/collection/sequence/IntSequenceTest###testRelease
public class IntSequenceTest_testRelease {
    private IntSequence intSeq;
    @Before
    public void setUp(){
         intSeq = new IntSequence(10,5);
    }
    @Test
    public void testReleaseWithValidInput() {
        assertTrue("Expected true when input is valid", intSeq.release(20));
        List<Integer> expectedOutput = Arrays.asList(new Integer[]{20});
        Iterator<Integer> itr = expectedOutput.iterator();
        while(itr.hasNext()) {
            assertEquals("Incorrect output after releasing valid inputs", itr.next(), intSeq.getReleased().toInt());
        }
    }
    @Test
    public void testReleaseWithInvalidInput() {
        assertFalse("Expected false when input is invalid", intSeq.release(-3));
        assertNull("Expected null as no elements are added in list", intSeq.getReleased());
    }
    @Test
    public void testReleaseMultipleValues() {
        assertTrue("Expected true when input is valid", intSeq.release(15));
        assertTrue("Expected true when input is valid", intSeq.release(20));
        assertTrue("Expected true when input is valid", intSeq.release(40));
        List<Integer> expectedOutput = Arrays.asList(new Integer[]{15,20,40});
        Collections.sort(expectedOutput);
        Iterator<Integer> itr = expectedOutput.iterator();
        while(itr.hasNext()) {
            assertEquals("Incorrect output after releasing multiple values", itr.next(), intSeq.getReleased().toInt());
        }
    }
}