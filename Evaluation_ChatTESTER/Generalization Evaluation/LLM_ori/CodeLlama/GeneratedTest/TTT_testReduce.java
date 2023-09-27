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
    assertEquals("Zero fraction", ZERO, ZERO.reduce());
    assertEquals("Non-zero fraction with no common divisors", new Fraction(3, 5).reduce(), new Fraction(3, 5));
    assertEquals("Non-zero fraction with common divisors", new Fraction(6, 8).reduce(), new Fraction(3, 4));
    assertEquals("Negative fraction", new Fraction(-3, -5).reduce(), new Fraction(3, 5));
    try {
        new Fraction(null, null).reduce();
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
}
}