package org.apache.commons.lang3.math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/FractionTest###testEquals
public class FractionTest_testEquals {
    @Test
    public void testEqualsMethod(){
        Fraction frac1 = new Fraction(2,3);
        Fraction frac2 = new Fraction(2,3);
        assertTrue("Two fractions with same numerator and denominator should return true",frac1.equals(frac2));
        Fraction frac3 = new Fraction(4,5);
        Fraction frac4 = new Fraction(4,6);
        assertFalse("Two fractions with same numerator but different denominator should return false",frac1.equals(frac3));
        Fraction frac5 = new Fraction(7,8);
        Fraction frac6 = new Fraction(9,8);
        assertFalse("Two fractions with same denominator but different numerator should return false",frac1.equals(frac5));
        String strObj = "Hello";
        assertFalse("Different type of object should return false",frac1.equals(strObj));
        Fraction nullFrac = null;
        assertFalse("Null comparison should return false",frac1.equals(nullFrac));
    }
}