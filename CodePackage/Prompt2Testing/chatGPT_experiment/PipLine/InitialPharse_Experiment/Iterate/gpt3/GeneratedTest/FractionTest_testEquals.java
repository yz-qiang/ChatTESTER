package org.apache.commons.lang3.math;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/FractionTest###testEquals
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
public class FractionTest_testEquals {
    @Test
    public void testEquals() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = new Fraction(2, 3);
        Object obj = new Object();
        assertTrue("Reflexive property failed", f1.equals(f1));
        assertTrue("Symmetric property failed", f1.equals(f2) && f2.equals(f1));
        assertTrue("Transitive property failed", f1.equals(f2) && f2.equals(f3) && f1.equals(f3));
        assertFalse("Inequality test failed", f1.equals(f3));
        assertFalse("Inequality test failed", f1.equals(obj));
        assertFalse("Inequality test failed", f1.equals(null));
    }
}