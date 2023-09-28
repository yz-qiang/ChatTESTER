package cn.xdean.jex.lang.collection.sequence;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/collection/sequence/IntSequenceTest###testRelease
import io.reactivex.Flowable;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class IntSequenceTest_testRelease {
    @Test
    public void testRelease() {
        IntSequence sequence = new IntSequence(0, 2);
        assertTrue(sequence.release(0));
        assertFalse(sequence.release(1));
        assertTrue(sequence.release(2));
        assertFalse(sequence.release(3));
        assertTrue(sequence.release(4));
        assertFalse(sequence.release(5));
        assertTrue(sequence.release(6));
        assertFalse(sequence.release(7));
        assertTrue(sequence.release(8));
        assertFalse(sequence.release(9));
    }
}