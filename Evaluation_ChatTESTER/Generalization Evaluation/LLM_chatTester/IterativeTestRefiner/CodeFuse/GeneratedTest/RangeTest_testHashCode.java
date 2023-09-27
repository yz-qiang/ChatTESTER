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
import org.junit.Assert;
import org.apache.commons.lang3.Range;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest###testHashCode
public class RangeTest_testHashCode {
    private Range<Integer> range;
    @Before
    public void setUp(){
        range = new Range<>(5, 8);
    }
    @Test
    public void testHashCode() {
        assertNotNull(range);
        assertEquals(range.hashCode(), range.hashCode());
    }
}