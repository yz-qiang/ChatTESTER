package cn.xdean.jex.lang.collection.sequence;
import io.reactivex.Flowable;
import org.junit.Test;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/collection/sequence/IntSequenceTest###testRelease
public class IntSequenceTest_testRelease {
    private IntSequence sequence;
    private IntList listSpy;
    @Before
    public void setUp() throws Exception {
        listSpy = spy(new IntList());
        sequence = new IntSequence(10, 2);
        sequence.setReleased(listSpy);
    }
    @Test
    public void testReleaseWithValidInputReturnsTrueAndAddsElementToList() {
        Integer input = 14;
        assertTrue(sequence.release(input));
        verify(listSpy).add(input);
    }
    @Test
    public void testReleaseWithInvalidInputDoesNotAddElementToList() {
        Integer input = 7;
        assertFalse(sequence.release(input));
        verify(listSpy, never()).add(anyInt());
    }
    @Test
    public void testReleaseWithNegativeNumberThrowsException() {
        try{
            sequence.release(-5);
             fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException ex){
           assertEquals("Start value cannot be negative", ex.getMessage());
       }
   }
}