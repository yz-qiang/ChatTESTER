package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
public class TTT_testAppendSuper {
@Test
public void testAppendSuper() {
    Object obj1 = new Object() {
        @Override
        public int compareTo(Object o) {
            return -1;
        }
    };
    Object obj2 = new Object() {
        @Override
        public int compareTo(Object o) {
            return 1;
        }
    };
    ComparableToBuilder builder = new ComparableToBuilder();
    builder.appendSuper(obj1.compareTo(obj2));
    assertEquals(-1, builder.getComparison());
}
}