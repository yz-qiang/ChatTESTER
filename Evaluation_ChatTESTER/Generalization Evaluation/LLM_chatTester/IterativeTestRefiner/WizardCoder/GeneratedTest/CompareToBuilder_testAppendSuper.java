package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
public class CompareToBuilder_testAppendSuper {
    @Test
    public void shouldAppendSuperValueAndReturnSelf_whenCalledWithNonZeroArgument() throws Exception {
        final BigInteger bigInteger1 = new BigInteger("1");
        final BigInteger bigInteger2 = new BigInteger("-3456789012345678901234567890L");
        assertEquals(-1, new CompareToBuilder().appendSuper(bigInteger1.compareTo(bigInteger2) < 0).build());
        assertTrue(new CompareToBuilder().appendSuper(bigInteger1).equals(new CompareToBuilder()));
    }
}