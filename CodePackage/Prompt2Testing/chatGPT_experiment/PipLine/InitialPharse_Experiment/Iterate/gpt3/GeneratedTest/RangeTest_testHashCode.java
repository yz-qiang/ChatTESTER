package org.apache.commons.lang3;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest###testHashCode
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;
public class RangeTest_testHashCode {
    private Range<Integer> range1;
    private Range<Integer> range2;
    @Before
    public void setUp() {
        range1 = Range.between(1, 5, null);
        range2 = Range.between(1, 5, null);
    }
    @Test
    public void testHashCode() {
        int expectedHashCode = 17;
        expectedHashCode = 37 * expectedHashCode + range1.getClass().hashCode();
        expectedHashCode = 37 * expectedHashCode + range1.getMinimum().hashCode();
        expectedHashCode = 37 * expectedHashCode + range1.getMaximum().hashCode();
        assertEquals(expectedHashCode, range1.hashCode());
        assertEquals(expectedHashCode, range2.hashCode());
    }
}