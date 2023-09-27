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
        int minJ = 30;
        int maxJ = 60;
        double prop = 0.7;
        Collection<UnorderedPair> result = PairSampler.sampleUnorderedPairs(minI, maxI, minJ, maxJ, prop);
        Assert.assertEquals("Result size", 80, result.size());
        Assert.assertTrue("All pairs have same number of elements", result.stream().allMatch(p -> p.getFirst().equals(p.getSecond()) == false));
        Assert.assertTrue("All pairs have different first and second elements", result.stream().distinct().count() == result.size());
        Assert.assertTrue("Probability is close to expected value", Math.abs(result.stream().filter(p -> p.getFirst() < p.getSecond()).count() / (double)result.size() - prop) < 0.01);
    }
}