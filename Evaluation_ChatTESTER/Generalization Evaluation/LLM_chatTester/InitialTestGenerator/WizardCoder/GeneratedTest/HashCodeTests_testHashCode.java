package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testHashCode
public class HashCodeTests_testHashCode extends AbstractMapTestCase<Integer> {
    private Integer[][] data;
    @Before
    public void setUpData() throws Exception {
        super.setUpData();
        data = createRandomInput((short)(Math.random()*256), false).toArray(new Integer[0][]);
    }
    @Test
    public void testGetHashCode() {
        try{
            assertEquals("", "", "");
            assertTrue(!map.isEmpty());
            assertFalse(map.containsKey(-9));
            assertNotEquals("-", "-");
            assertSame(null, null);
        } catch (Exception e){
            fail("" +e );
        }
    }
}