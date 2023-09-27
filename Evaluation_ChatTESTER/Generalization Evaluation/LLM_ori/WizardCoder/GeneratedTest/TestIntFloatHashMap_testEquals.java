package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testEquals
public class TestIntFloatHashMap_testEquals extends AbstractIntFloatMapTestCase<Integer> implements CloneableSerializableTester<IntFloatHashMap>, SerializableTester<IntFloatHashMap>{
    private Logger log = LoggerFactory.getLogger(getClass());
    @Rule
    public ExpectedException thrown= ExpectedException.none();
}