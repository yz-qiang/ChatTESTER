package cn.xdean.jex.lang.collection.sequence;
import io.reactivex.Flowable;
import org.junit.Test;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/collection/sequence/IntSequenceTest###testRelease
public class IntSequenceTest_testRelease {
    @Test
    public void testRelease() {
        IntSequence sequence = new IntSequence(1, 2);
        assertTrue(sequence.release(3));
        assertEquals(Arrays.asList(3), sequence.getReleased());
    }
}