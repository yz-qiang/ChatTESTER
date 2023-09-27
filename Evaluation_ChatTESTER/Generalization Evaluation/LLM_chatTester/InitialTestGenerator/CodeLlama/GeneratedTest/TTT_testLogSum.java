package edu.jhu.prim.arrays;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import edu.jhu.prim.util.Timer;
import edu.jhu.prim.util.math.FastMath;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/arrays/DoubleArraysTest###testLogSum
public class TTT_testLogSum {
@Test
public void testLogSum() {
    double[] logProps = new double[]{1.23456789, -1.23456789};
    double result = DoubleArrays.logSum(logProps);
    assertEquals("Expected result", Math.log(1 + Math.exp(-1)), result, 1e-10);
}
}