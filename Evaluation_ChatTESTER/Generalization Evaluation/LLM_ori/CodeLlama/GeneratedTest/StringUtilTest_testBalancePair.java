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
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/StringUtilTest###testBalancePair
@RunWith(JUnit4.class)
public class StringUtilTest_testBalancePair {
    @Test
    public void testBalancePair() {
        assertArrayEquals(new int[]{2, 5}, balancePair("((()))", "(", ")"));
        assertArrayEquals(new int[]{3, 6}, balancePair("(()())", "(", ")"));
        assertArrayEquals(new int[]{4, 7}, balancePair("((()()))", "(", ")"));
        assertArrayEquals(new int[]{2, -1}, balancePair("(((", "(", ")"));
        assertArrayEquals(new int[]{3, -1}, balancePair("(()(", "(", ")"));
        assertArrayEquals(new int[]{4, -1}, balancePair("((()(", "(", ")"));
        assertArrayEquals(null, balancePair("", "(", ")"));
        assertArrayEquals(null, balancePair(" ", "(", ")"));
        assertArrayEquals(null, balancePair("\t\r\n", "(", ")"));
        assertThrows(IllegalArgumentException.class, () -> balancePair(null, "(", ")"));
        assertThrows(IllegalArgumentException.class, () -> balancePair("", null, ")"));
        assertThrows(IllegalArgumentException.class, () -> balancePair("", "", ""));
    }
}