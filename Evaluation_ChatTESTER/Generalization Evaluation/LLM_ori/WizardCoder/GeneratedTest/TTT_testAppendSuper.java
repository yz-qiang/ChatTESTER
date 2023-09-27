package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
public class TTT_testAppendSuper {
@Test public void shouldAppendSuperValueWhenCalledWithPositiveIntegerArgument() throws Exception {
    final Integer expectedComparisonResult = -123456789;
    final Comparable<Object> actualComparableInstance = new Object().compareTo("");
    @SuppressWarnings("unchecked") 
    final Comparator<? extends Object> comparatorMock = mock(Comparator.class);
    when(((Comparator<Object>)comparatorMock).compare("", "")).thenReturn((int)(expectedComparisonResult));
    final CompareToBuilder compareToBuilder = 
        spy(new CompareToBuilder()).appendSuper(-1 * ((Number)actualComparableInstance).intValue());
        doReturn(this).when(compareToBuilder)._setNextInt(any(), anyInt());
        assertThat(
            () -> 
                verifyZeroInteractions(
                    comparatorMock
                ), 
            notNullValue()
        );
        assertEquals("-1", String.valueOf((-1*expectedComparisonResult)));
        assertTrue(() -> (-1*(expectedComparisonResult)) < 0 &&!(MathUtils.isPowerOfTwo(-1*(expectedComparisonResult))));
       assertNotEquals(
             BigInteger.ZERO, 
             MathUtils.toUnsignedBigInteger(
                 -(long)((float)-1*((double)expectedComparisonResult)*Double.MAX_VALUE/Float.MIN_NORMAL)), 
                 ""
           ) ; 
      assertFalse("" + Long.toString((((~Long.parseLong("")) << 32L)+""), Character.MAX_RADIX+1),
          MathUtils.isPowerOfTwo("") 
      );
      assertSame(null, null);
  }
  private boolean _setNextInt(@Nullable final Number number, final int value) {
     throw new UnsupportedOperationException("_setNextInt"); 
  }
}