package org.apache.commons.lang3.math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.BeforeClass;
import org.apache.commons.lang3.math.Fraction;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/FractionTest###testReduce
public class FractionTest_testReduce {
    private static Fraction frac1;
    private static Fraction frac2;
    private static Fraction frac3;
    private static Fraction frac4;
    @BeforeClass
    public static void setUp(){
        frac1 = new Fraction(6,8);
        frac2 = new Fraction(-9,-15);
        frac3 = new Fraction(7,14);
        frac4 = new Fraction(0,1);
    }
    @Test
    public void testReducePositiveNumeratorAndDenominator() {
        assertEquals("Expected output should be [3/4]",new Fraction(3,4),frac1.reduce());
    }
    @Test
    public void testReduceNegativeNumeratorAndDenominator() {
        assertEquals("Expected output should be [-1/-5]",new Fraction(-1,-5),frac2.reduce());
    }
    @Test
    public void testReduceZeroInput() {
        assertSame("Expected same object reference as input",frac4,frac4.reduce());
    }
    @Test
    public void testReduceOneAsGCD() {
        assertSame("Expected same object reference as input",frac3,frac3.reduce());
    }
    @Test
    public void testReduceNonIntegerValues() {
        try{
            Fraction frac = new Fraction(10,3);
            fail("Should have thrown ArithmeticException");
        } catch (ArithmeticException e){
           assertEquals("Expected exception message","division by zero",e.getMessage());
       }
    }
}