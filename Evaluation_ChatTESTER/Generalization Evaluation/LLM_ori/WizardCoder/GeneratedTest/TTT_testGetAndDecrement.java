package org.apache.commons.lang3.mutable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableIntTest###testGetAndDecrement
public class TTT_testGetAndDecrement {
@Test public void testGetAndDecrement_shouldReturnPreviousValueAndUpdateTheMutableObject() {
    final MutableInt mutableInteger = new MutableInt(-10);
    final int result = mutableInteger.getAndDecrement();
    assertThat(result).isEqualTo(-10);  
    assertThat(mutableInteger.getValue()).isZero();   
} 
public int getValue(){
  return value;  
}
}