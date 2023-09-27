package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
@Test 
public void shouldAppendSuperValueAndReturnSelf_whenCalledWithNonZeroArgument() throws Exception{
    final BigInteger bigInteger1 = new BigInteger("2"); 
    final BigInteger bigInteger2 = new BigInteger("-3456789012345678901234567890L");
    assertEquals(-1, 
        new CompareToBuilder_testAppendSuper().
            appendSuper(bigInteger1.compareTo(bigInteger2)).build());
    assertTrue(new CompareToBuilder_testAppendSuper().
        appendSuper(bigInteger1).equals(new CompareToBuilder_testAppendSuper()));
} 
class CompareToBuilder_testAppendSuper extends Object implements Comparable<Object> {}