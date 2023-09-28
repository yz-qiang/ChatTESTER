package org.apache.commons.lang3.math;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/FractionTest###testReduce
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
public class FractionTest_testReduce {
    @Test
    public void testReduce() {
        Fraction fraction1 = Fraction.getFraction(4, 8);
        Fraction reducedFraction1 = fraction1.reduce();
        assertEquals(1, reducedFraction1.getNumerator());
        assertEquals(2, reducedFraction1.getDenominator());
        Fraction fraction2 = Fraction.getFraction(3, 5);
        Fraction reducedFraction2 = fraction2.reduce();
        assertEquals(3, reducedFraction2.getNumerator());
        assertEquals(5, reducedFraction2.getDenominator());
        Fraction fraction3 = Fraction.getFraction(0, 7);
        Fraction reducedFraction3 = fraction3.reduce();
        assertSame(Fraction.ZERO, reducedFraction3);
    }
}