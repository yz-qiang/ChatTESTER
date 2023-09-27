package org.apache.commons.lang3.math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/FractionTest###testReduce
public class TTT_testReduce {
@Test
public void testReduce() {
    assertEquals("Zero numerator", ZERO, new Fraction(0, 2).reduce());
    try {
        new Fraction(3, 0).reduce();
        fail("Expected ArithmeticException");
    } catch (ArithmeticException e) {}
    assertEquals("Non-zero numerator, non-zero denominator", new Fraction(6, 8), new Fraction(4, 8).reduce());
    assertEquals("Negative numerator, negative denominator", new Fraction(-6, -8), new Fraction(-4, -8).reduce());
    assertEquals("Positive numerator, negative denominator", new Fraction(6, -8), new Fraction(4, -8).reduce());
    assertEquals("Negative numerator, positive denominator", new Fraction(-6, 8), new Fraction(-4, 8).reduce());
    assertEquals("Large numbers", new Fraction(Integer.MAX_VALUE, Integer.MAX_VALUE), new Fraction(Integer.MAX_VALUE * 2, Integer.MAX_VALUE * 2).reduce());
}
}