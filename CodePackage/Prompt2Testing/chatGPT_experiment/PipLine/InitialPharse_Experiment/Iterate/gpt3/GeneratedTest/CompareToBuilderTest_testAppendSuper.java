package org.apache.commons.lang3.builder;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
public class CompareToBuilderTest_testAppendSuper {
    @Test
    public void testAppendSuper() {
        CompareToBuilder builder = new CompareToBuilder();
        int superCompareTo = 5;
        builder.appendSuper(superCompareTo);
        assertEquals(superCompareTo, builder.toComparison());
    }
}