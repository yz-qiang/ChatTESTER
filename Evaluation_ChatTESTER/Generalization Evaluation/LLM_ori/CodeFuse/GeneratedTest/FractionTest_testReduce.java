package org.apache.commons.lang3.math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/FractionTest###testReduce
public class FractionTest_testReduce {
    private static Fraction fraction;
    @BeforeClass
    public static void setUp(){
          fraction=new Fraction(24,8);
    }
    @Test
    public void testReduceWithZeroNumeratorAndPositiveDenominator() {
        Fraction zeroFraction = new Fraction(0,5);
        Fraction result = zeroFraction.reduce();
        assertSame("The reduced fraction should be same as Zero",zeroFraction,result);
    }
    @Test
    public void testReduceWithNonZeroNumeratorAndPositiveDenominator() {
        Fraction nonZeroFraction = new Fraction(6,3);
        Fraction result = nonZeroFraction.reduce();
        assertEquals("The reduced fraction should have correct numerator value",2,result.getNumerator());
        assertEquals("The reduced fraction should have correct denominator value",1,result.getDenominator());
    }
    @Test
    public void testReduceWithNegativeNumeratorAndPositiveDenominator() {
        Fraction negativeFraction = new Fraction(-9,-7);
        Fraction result = negativeFraction.reduce();
        assertEquals("The reduced fraction should have correct numerator value",-1,result.getNumerator());
        assertEquals("The reduced fraction should have correct denominator value",1,result.getDenominator());
    }
    @Test
    public void testReduceWithEqualNumeratorAndDenominator() {
        Fraction equalFraction = new Fraction(10,10);
        Fraction result = equalFraction.reduce();
        assertSame("The reduced fraction should be same as EqualFraction",equalFraction,result);
    }
    @Test
    public void testReduceWithDifferentNumeratorAndDenominator() {
        Fraction differentFraction = new Fraction(12,15);
        Fraction result = differentFraction.reduce();
        assertEquals("The reduced fraction should have correct numerator value",2,result.getNumerator());
        assertEquals("The reduced fraction should have correct denominator value",3,result.getDenominator());
    }
}