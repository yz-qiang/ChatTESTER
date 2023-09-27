package edu.jhu.prim.sample;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import edu.jhu.prim.tuple.OrderedPair;
import edu.jhu.prim.tuple.UnorderedPair;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/sample/PairSamplerTest###testSampleUnorderedPairs
public class TTT_testSampleUnorderedPairs {
@Test
public void testSampleUnorderedPairs() {
    int minI = 5;
    int maxI = 20;
    int minJ = 3;
    int maxJ = 8;
    double prop = 0.7;
    Collection<UnorderedPair> result = PairSampler.sampleUnorderedPairs(minI, maxI, minJ, maxJ, prop);
    assertEquals("Wrong number of pairs", 6, result.size());
    assertTrue("Missing pair (5, 3)", result.contains(new UnorderedPair(5, 3)));
    assertTrue("Missing pair (5, 4)", result.contains(new UnorderedPair(5, 4)));
    assertTrue("Missing pair (5, 5)", result.contains(new UnorderedPair(5, 5)));
    assertTrue("Missing pair (6, 3)", result.contains(new UnorderedPair(6, 3)));
    assertTrue("Missing pair (6, 4)", result.contains(new UnorderedPair(6, 4)));
    assertTrue("Missing pair (6, 5)", result.contains(new UnorderedPair(6, 5)));
}
}