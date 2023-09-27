package org.apache.commons.lang3.math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/FractionTest###testEquals
public 
class TestFractionEqualsMethod_testEquals extends TestCase{
    @Test
    public void shouldReturnTrueIfTwoFractionsAreEqualBasedOnValuesAndDenomenator(){
        assertEquals("Expected True", new Fraction(10,2),new Fraction(5,-3)); 
    }
}