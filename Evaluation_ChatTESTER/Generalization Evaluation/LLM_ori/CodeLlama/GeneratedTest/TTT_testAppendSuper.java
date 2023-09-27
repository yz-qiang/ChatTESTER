package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
public class TTT_testAppendSuper {
@Test
public void testAppendSuper() {
    CompareToBuilder builder1 = new CompareToBuilder();
    builder1.setComparison(5);
    CompareToBuilder builder2 = new CompareToBuilder();
    builder2.setComparison(-3);
    builder1.appendSuper(-1);
    builder2.appendSuper(-1);
    assertEquals("The comparison field was not updated correctly", -6, builder1.getComparison());
    assertEquals("The comparison field was not updated correctly", -4, builder2.getComparison());
}
}