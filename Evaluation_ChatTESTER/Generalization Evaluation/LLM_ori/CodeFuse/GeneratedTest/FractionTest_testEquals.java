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
        Fraction f1 = new Fraction(2,3);
        Fraction f2 = new Fraction(4,6);
        assertTrue("Two fractions should be equal",f1.equals(f2));
        Fraction f3 = new Fraction(5,3);
        Fraction f4 = new Fraction(7,3);
        assertFalse("Two fractions should not be equal as they have different numerators",f1.equals(f3));
        Fraction f5 = new Fraction(0,3);
        Fraction f6 = new Fraction(8,0);
        assertFalse("Two fractions should not be equal since one has zero denominator",f1.equals(f5));
        Fraction f7 = new Fraction(0,0);
        Fraction f8 = new Fraction(9,0);
        assertTrue("Two fractions should be equal even though their numerators are different because both have zero denominator",f7.equals(f8));
        Fraction f9 = null;
        assertFalse("A fraction cannot be equal to null",f1.equals(f9));
        String str = "not a fraction";
        assertFalse("An object which is not instance of Fraction should not be equal to any fraction",f1.equals(str));
    }
}