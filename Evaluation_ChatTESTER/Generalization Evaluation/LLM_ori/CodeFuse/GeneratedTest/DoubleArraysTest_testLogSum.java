package edu.jhu.prim.arrays;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import edu.jhu.prim.util.Timer;
import edu.jhu.prim.util.math.FastMath;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/arrays/DoubleArraysTest###testLogSum
public class DoubleArraysTest_testLogSum {
    private static final double DELTA = 1e-6; 
    private static DoubleArrays da;
    @BeforeClass
    public static void setUp(){
         da = new DoubleArrays();
    }
    @Test
    public void testLogSumWithEmptyInput() {
        double[] input = {};
        assertEquals(-Double.MAX_VALUE, da.logSum(input), DELTA);
    }
    @Test
    public void testLogSumWithSingleElement() {
        double[] input = {5};
        assertEquals(5, da.logSum(input), DELTA);
    }
    @Test
    public void testLogSumWithMultipleElements() {
        double[] input = {-2, -3, -4, -1, 7};
        assertEquals(-1, da.logSum(input), DELTA);
    }
    @Test
    public void testLogSumWithNegativeValues() {
        double[] input = {-2, -3, -4, -1, 7, -8};
        assertEquals(-9, da.logSum(input), DELTA);
    }
    @Test
    public void testLogSumWithZeroValue() {
        double[] input = {0, 0, 0, 0, 0};
        assertTrue(da.logSum(input) > -Double.MAX_VALUE && da.logSum(input) <= 0);
    }
}