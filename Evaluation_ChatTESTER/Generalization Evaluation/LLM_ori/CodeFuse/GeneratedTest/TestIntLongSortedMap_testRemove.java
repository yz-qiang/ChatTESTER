package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongSortedMapTest###testRemove
public class TestIntLongSortedMap_testRemove {
    @BeforeClass
    public static void setUp(){
    }
    @AfterClass
    public static void tearDown(){
    }
    @Before
    public void setUp(){
    }
    @After
    public void tearDown(){
    }
    @Test
    public void testRemoveMethodWithValidInput(){
        IntLongSortedMap map = new IntLongSortedMap();
        map.remove(5);
        assertTrue(map.isEmpty());
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveMethodWithInvalidInput(){
        IntLongSortedMap map = new IntLongSortedMap();
        map.remove(-1);
    }
}