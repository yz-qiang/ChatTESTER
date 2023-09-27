package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
public class CompareToBuilderTest_testAppendSuper {
    private CompareToBuilder compareToBuilder;
    @Before
    public void setUp(){
       compareToBuilder = new CompareToBuilder();
    }
    @Test
    public void testAppendSuperWhenComparisonNotZero() {
        assertEquals("Expected comparison should be equal to input", 123456789, compareToBuilder.appendSuper(123456789).getComparison());
    }
    @Test
    public void testAppendSuperWhenComparisonNonZero() {
        compareToBuilder.setComparison(1);
        assertEquals("Expected comparison should remain unchanged as it's already non-zero", 1, compareToBuilder.appendSuper(123456789).getComparison());
    }
    private int getComparison() {
      return comparison;
   }
}