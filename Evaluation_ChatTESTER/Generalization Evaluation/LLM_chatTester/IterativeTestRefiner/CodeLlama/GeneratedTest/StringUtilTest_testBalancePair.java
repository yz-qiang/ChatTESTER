package cn.xdean.jex.lang;
import io.reactivex.Flowable;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import java.util.stream.IntStream;
import static cn.xdean.jex.lang.StringUtil.*;
import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnit4;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/StringUtilTest###testBalancePair
@RunWith(Theories.class)
public class StringUtilTest_testBalancePair {
    @Test
    public void testBalancePair() {
        assertArrayEquals(new int[] {-1, -1}, balancePair("", "", ""));
        assertArrayEquals(new int[] {0, 0}, balancePair("a", "a", "a"));
        assertArrayEquals(new int[] {1, 1}, balancePair("b", "b", "b"));
        assertArrayEquals(new int[] {2, 2}, balancePair("c", "c", "c"));
        assertArrayEquals(new int[] {0, 5}, balancePair("abcdefghi", "abcd", "efgh"));
        assertArrayEquals(new int[] {6, 9}, balancePair("ijklmnopqrstuvwxyz", "ijk", "lmno"));
        assertArrayEquals(new int[] {0, 7}, balancePair("abcdefghi", "abcd", "efg"));
        assertArrayEquals(new int[] {8, 11}, balancePair("ijklmnopqrstuvwxyz", "ijk", "lmo"));
        assertArrayEquals(new int[] {-1, -1}, balancePair("abcdefghi", "abcd", "efg"));
        assertArrayEquals(new int[] {-1, -1}, balancePair("ijklmnopqrstuvwxyz", "ijk", "lmo"));
        assertArrayEquals(new int[] {0, 5}, balancePair("abcdefghi", "abcd", "efgh"));
        assertArrayEquals(new int[] {6, 9}, balancePair("ijklmnopqrstuvwxyz", "ijk", "lmno"));
        assertArrayEquals(new int[] {0, 5}, balancePair("abcdefghi", "abcd", "efgh"));
        assertArrayEquals(new int[] {6, 9}, balancePair("ijklmnopqrstuvwxyz", "ijk", "lmno"));
    }
}