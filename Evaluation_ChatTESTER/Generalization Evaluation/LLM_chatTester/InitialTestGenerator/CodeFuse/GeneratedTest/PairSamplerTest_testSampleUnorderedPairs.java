package edu.jhu.prim.sample;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import edu.jhu.prim.tuple.OrderedPair;
import edu.jhu.prim.tuple.UnorderedPair;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/sample/PairSamplerTest###testSampleUnorderedPairs
public class PairSamplerTest_testSampleUnorderedPairs {
    private static Random prng;
    @BeforeClass
    public static void setUp(){
        prng = new Random();
    }
    @Test
    public void testSampleUnorderedPairsWithSmallRangeAndProportionLessThanOne() {
        List<UnorderedPair> expectedOutput = new ArrayList<>();
        Set<Integer> seenValues = new HashSet<>();
        for (int i=2; i<=5; i++){
            for (int j=3; j<=7; j++){
                if (i!=j){
                    expectedOutput.add(new UnorderedPair(i,j));
                    seenValues.add(i);
                    seenValues.add(j);
                }
            }
        }
        assertEquals(expectedOutput, PairSampler.sampleUnorderedPairs(2,6,3,8,.9));
    }
    @Test
    public void testSampleUnorderedPairsWithLargeRangeAndProportionGreaterThanOne() {
        Set<UnorderedPair> actualOutput = PairSampler.sampleUnorderedPairs(-10000,-100,1000,10000, .5);
        assertTrue("The size should be greater than zero",actualOutput.size()>0);
        for (UnorderedPair pair : actualOutput){
             assertNotNull("Each element in the output should not be null",pair);
             assertFalse("No duplicate elements are allowed",seenValues.contains((int)pair.getFirst())||seenValues.contains((int)pair.getSecond()));
             seenValues.add((int)pair.getFirst());
             seenValues.add((int)pair.getSecond());
        }
    }
    @Test
    public void testSampleUnorderedPairsWithZeroProp() {
        Set<UnorderedPair> actualOutput = PairSampler.sampleUnorderedPairs(2,6,3,8,0);
        assertTrue("The size should be zero when prop is zero",actualOutput.isEmpty());
    }
    @Test
    public void testSampleUnorderedPairsWithMaximumValueAsMinusInfinity() {
        try{
           PairSampler.sampleUnorderedPairs(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, .5);
          fail("Expected IllegalArgumentException");
       } catch (IllegalArgumentException e){
           assertEquals("Should throw exception as maximum values cannot be negative",e.getMessage(),"Invalid range");
       }
   }
}