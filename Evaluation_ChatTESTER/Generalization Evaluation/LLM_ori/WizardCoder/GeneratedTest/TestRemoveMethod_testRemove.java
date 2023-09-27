package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongSortedMapTest###testRemove
public 
class TestRemoveMethod_testRemove extends AbstractIntLongSortedMapTest{
    @Test
    public void should_remove_element_from_map(){
        IntLongSortedMap mappy = createRandomFilledMapWithDuplicates();
        assertThat(mappy).hasSize(SIZE * DUPLICATES);
        Iterator<Integer> iterator = getKeys().iterator(); 
        while(iterator.hasNext()){
            Integer nextKey = iterator.next(); 
            boolean containsBeforeRemoval = mappy.containsKey(nextKey);
            try{
                mappy.remove((int)(long)nextKey);
                assertFalse(containsBeforeRemoval ||!mappy.containsKey(nextKey)); 
                assertEquals(--expectedSizeAfterRemovals, expectedSizeAfterRemovals);
            }catch(IllegalArgumentException e){
                assertTrue(!containsBeforeRemoval &&!(e instanceof UnsupportedOperationException));  
            }
        }
    }
}