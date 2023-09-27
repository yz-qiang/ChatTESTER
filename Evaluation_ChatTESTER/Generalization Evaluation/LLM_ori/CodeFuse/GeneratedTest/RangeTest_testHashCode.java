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
public class RangeTest_testHashCode {
    private Range<Integer> range;
    @Before
    public void setUp(){
       Integer minValue = 5;
       Integer maxValue = 10;
       range = new Range<>(minValue,maxValue);
    }
    @Test
    public void testHashCode() {
        assertNotNull(range);
        assertEquals(range.getMin(), minValue);
        assertEquals(range.getMax(), maxValue);
        int expectedHashCode = 34986; 
        int actualHashCode = range.hashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }
}