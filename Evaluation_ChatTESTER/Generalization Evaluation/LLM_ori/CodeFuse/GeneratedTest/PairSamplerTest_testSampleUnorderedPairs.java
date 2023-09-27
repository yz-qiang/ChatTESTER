package edu.jhu.prim.sample;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import edu.jhu.prim.tuple.OrderedPair;
import edu.jhu.prim.tuple.UnorderedPair;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/sample/PairSamplerTest###testSampleUnorderedPairs
public class PairSamplerTest_testSampleUnorderedPairs {
    private static final Random prng = new Random(); 
    private static List<Integer[]> inputList;
    private static List<UnorderedPair> expectedOutputList;
    @BeforeClass
    public static void setUp(){
        inputList = Arrays.asList(new Integer[]{
            {-5,-3},{-2,-1},{0,2},{1,6},{7,9},{8,10},{10,10}
        };
        expectedOutputList = Arrays.asList(
            new UnorderedPair(-5,-3),
            new UnorderedPair(-2,-1),
            new UnorderedPair(0,2),
            new UnorderedPair(1,6),
            new UnorderedPair(7,9),
            new UnorderedPair(8,10),
            new UnorderedPair(10,10)
        );
    }
    @Test
    public void testSampleUnorderedPairsWithSmallRangeAndPropLessThanOne() {
        Collection<UnorderedPair> actualResult = PairSampler.sampleUnorderedPairs(-5, -3, 10, 0.5);
        Assert.assertEquals("The size should be equal", expectedOutputList.size(), actualResult.size());
        for(UnorderedPair pair : actualResult){
            boolean found = false;
            for(UnorderedPair expectedPair : expectedOutputList){
                if((pair.getFirst().equals(expectedPair.getFirst()) && pair.getSecond().equals(expectedPair.getSecond()))){
                    found = true;
                    break;
                }
            }
            Assert.assertTrue("Expected output not present in result",found);
        }
    }
    @Test
    public void testSampleUnorderedPairsWithLargeRangeAndPropGreaterThanZeroPointNine() {
        Collection<UnorderedPair> actualResult = PairSampler.sampleUnorderedPairs(0, 10000, 0, 0.9);
        Assert.assertNotNull("Result cannot be null",actualResult);
        Assert.assertFalse("Should contain duplicates", hasDuplicates(actualResult));
    }
    private boolean hasDuplicates(Collection<?> list) {
        Set<Object> set = new HashSet<>();
        for (Object e : list) {
            if (!set.add(e)) {
              return true;
            }
          }
        return false;
      }
}