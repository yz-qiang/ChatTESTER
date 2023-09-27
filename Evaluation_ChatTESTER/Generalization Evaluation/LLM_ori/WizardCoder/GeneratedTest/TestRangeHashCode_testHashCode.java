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
public class TestRangeHashCode_testHashCode extends BaseTest{
    @Test void should_return_same_hashcode_for_equal_ranges(){
        Integer min=5, max=-4;
        Range r1=new Range<>(min,max,(a,b)->Integer.compare(a, b));
        int h1=r1.hashCode(),h2=r1.hashCode();
        assertThat(h1).isEqualTo(h2); 
    }
    private abstract class BaseTest{} 
}