package edu.jhu.prim.sample;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/sample/PairSamplerTest###testSampleUnorderedPairs
import java.util.Collection;
import java.util.HashSet;
import org.junit.Assert;
import org.junit.Test;
import edu.jhu.prim.tuple.UnorderedPair;
public class PairSamplerTest_testSampleUnorderedPairs {
    @Test
    public void testSampleUnorderedPairs() {
        int minI = 1;
        int maxI = 5;
        int minJ = 2;
        int maxJ = 6;
        double prop = 0.5;
        Collection<UnorderedPair> pairs = PairSampler.sampleUnorderedPairs(minI, maxI, minJ, maxJ, prop);
        for (UnorderedPair pair : pairs) {
            int i = pair.get1();
            int j = pair.get2();
            Assert.assertTrue(i >= minI && i < maxI);
            Assert.assertTrue(j >= minJ && j < maxJ);
        }
        int numPairs = pairs.size();
        long expectedNumPairs = PairSampler.countUnorderedPairs(minI, maxI, minJ, maxJ);
        double expectedProp = expectedNumPairs * prop;
        double tolerance = expectedProp * 0.1; 
        Assert.assertTrue(Math.abs(numPairs - expectedProp) < tolerance);
        HashSet<UnorderedPair> uniquePairs = new HashSet<>(pairs);
        Assert.assertEquals(numPairs, uniquePairs.size());
    }
}