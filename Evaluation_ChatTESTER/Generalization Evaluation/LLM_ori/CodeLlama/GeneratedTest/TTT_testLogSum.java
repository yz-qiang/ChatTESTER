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
    double[] logProps = new double[]{1.0, 2.0, 3.0};
    double result = DoubleArrays.logSum(logProps);
    assertEquals(6.0, result, 0.00001);
}
}