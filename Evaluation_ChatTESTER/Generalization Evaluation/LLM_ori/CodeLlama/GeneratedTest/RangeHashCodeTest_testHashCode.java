package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest###testHashCode
public class RangeHashCodeTest_testHashCode {
    @Test
    public void testHashCode_sameMinMax() {
        Integer min = 5;
        Integer max = 5;
        Range<Integer> range = new Range<>(min, max);
        assertEquals(range.hashCode(), range.hashCode());
    }
    @Test
    public void testHashCode_differentMinMax() {
        Integer min = 5;
        Integer max = 6;
        Range<Integer> range = new Range<>(min, max);
        assertNotEquals(range.hashCode(), range.hashCode());
    }
    @Test
    public void testHashCode_nullMinMax() {
        Integer min = null;
        Integer max = null;
        try {
            new Range<>(min, max);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
        }
    }
}