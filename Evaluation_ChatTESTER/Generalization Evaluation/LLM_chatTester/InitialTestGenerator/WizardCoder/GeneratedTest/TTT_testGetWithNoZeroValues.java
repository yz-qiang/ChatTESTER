package edu.jhu.prim.vector;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.map.IntLongEntry;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/vector/IntLongSortedVectorTest###testGetWithNoZeroValues
public class TTT_testGetWithNoZeroValues {
@Test
public void testGetWithNoZeroValues_sparseInput() throws Exception {
    IntLongSparseVector vec1 = new IntLongSparseVector().add(2,  3L).add(-5,   7L).add(8,    9L).add(6,     0L).add(0,-10000000000L);
    IntLongSortedVector result = IntLongSortedVector.getWithNoZeroValues(vec1);
    assertThat("Resulting Index array size",result.getIndex(),hasItemInArray((Object)(Integer)-5));
    assertThat("Resulting Data array size ",result.getData(), hasItems(3l,(Object)(Long)9l)) ;
}
@Test 
public void testGetWithNoZeroValues_denseInput()throws Exception{
   double[][] arr= {{1.,2.},{-3.,4.}};
   DoubleMatrix matrix = new DoubleMatrix(arr);
   IntLongSortedVector vectordense = new IntLongSortedVector(matrix );
   IntLongSortedVector resultraw = IntLongSortedVector.getWithNoZeroValues(vectordense);
  Assert.assertEquals("-3.",resultraw.getValueByIndex((-3))); 
  Assert.assertEquals("(Double) 4."+System.lineSeparator()+"]"+ System.lineSeparator()+"}",String.valueOf(resultraw)+"}");
}
}