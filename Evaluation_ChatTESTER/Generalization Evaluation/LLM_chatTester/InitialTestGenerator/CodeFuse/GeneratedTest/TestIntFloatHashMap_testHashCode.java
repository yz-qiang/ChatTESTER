package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testHashCode
public class TestIntFloatHashMap_testHashCode {
    private IntFloatHashMap map;
    @Before
    public void setUp(){
        map = new IntFloatHashMap();
    }
    @Test
    public void testHashCode() {
        assertEquals(0, map.hashCode());
        map.put(1, 2f);
        map.put(2, 4f);
        map.put(3, 6f);
        int expectedHashCode = 0;
        int[] indices = map.getIndices();
        float[] values = map.getValues();
        Primitives.sortIndexAsc(indices, values);
        for (int i=0; i<indices.length; i++){
            int result = 17;
            result = 37*result + Primitives.hashOfInt(indices[i]);
            result = 37*result + Primitives.hashOfFloat(values[i]);
            expectedHashCode+=result;
        }
        assertEquals(expectedHashCode, map.hashCode());
    }
}