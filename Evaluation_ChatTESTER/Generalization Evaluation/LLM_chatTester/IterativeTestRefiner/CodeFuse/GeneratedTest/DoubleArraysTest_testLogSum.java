package edu.jhu.prim.arrays;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import edu.jhu.prim.util.Timer;
import edu.jhu.prim.util.math.FastMath;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/arrays/DoubleArraysTest###testLogSum
public class DoubleArraysTest_testLogSum {
    @Test
    public void testLogSum() {
        assertEquals("The result should be negative infinity when passed empty array", Double.NEGATIVE_INFINITY, DoubleArrays.logSum(new double[]{}, 0);
        assertEquals("The result should equal the input value if there's only one number in the array", Math.log(5), DoubleArrays.logSum(new double[]{Math.log(5)}, 0);
        assertEquals("The result should be correct when multiple numbers are provided", Math.log(4 + 6 + 8 + 9), DoubleArrays.logSum(new double[]{Math.log(4), Math.log(6), Math.log(9)}, 0);
        try{
            DoubleArrays.logSum(new double[]{Math.log(-1)});
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e){
        }
    }
}