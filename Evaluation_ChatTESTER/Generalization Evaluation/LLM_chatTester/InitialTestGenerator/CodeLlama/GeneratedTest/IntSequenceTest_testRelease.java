package cn.xdean.jex.lang.collection.sequence;
import io.reactivex.Flowable;
import org.junit.Test;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/collection/sequence/IntSequenceTest###testRelease
public class IntSequenceTest_testRelease {
    @Test
    public void testRelease() {
        IntSequence seq = new IntSequence(1, 2);
        assertTrue(seq.release(3));
        assertEquals(IntList.of(3), seq.getReleased());
        assertFalse(seq.release(4));
        assertEquals(IntList.empty(), seq.getReleased());
        assertFalse(seq.release(-1));
        assertEquals(IntList.empty(), seq.getReleased());
        assertFalse(seq.release(5));
        assertEquals(IntList.empty(), seq.getReleased());
    }
}