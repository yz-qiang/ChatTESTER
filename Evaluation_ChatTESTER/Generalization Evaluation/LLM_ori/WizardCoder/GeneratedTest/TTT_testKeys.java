package edu.jhu.prim.map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.jhu.prim.util.IntJUnitUtils;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/IntObjectHashMapTest###testKeys
public class TTT_testKeys {
@Test public void testGetKeys() throws Exception{
    IntObjectHashMap<String> map = createMapWithValues("a", "b");
    Integer[] actualResultArray = Arrays.stream(map.keys()).boxed().toArray(Integer[]::new);
    List<Integer> actualList = Lists.newArrayList(actualResultArray);
    Collections.sort(actualList);
   assertThat(actualList).containsExactlyInAnyOrderElementsOf(Arrays.asList(-26789456, 1)); 
} 
  private <K extends Comparable<? super K>, V> Map<K,V> createMapWithValues(K keyOne, V valueOne){
        HashMap<K,V> result= Maps.<K,V>builder().put(keyOne,valueOne).build(); 
        return result ;
  }
}