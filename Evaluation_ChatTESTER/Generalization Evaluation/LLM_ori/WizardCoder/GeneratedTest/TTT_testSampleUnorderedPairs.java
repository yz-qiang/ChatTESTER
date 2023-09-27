package edu.jhu.prim.sample;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import edu.jhu.prim.tuple.OrderedPair;
import edu.jhu.prim.tuple.UnorderedPair;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/sample/PairSamplerTest###testSampleUnorderedPairs
public class TTT_testSampleUnorderedPairs {
@Test 
public void testGetSampledPairs_unordered() throws Exception{
    final int MIN_A=256;  
    final int MAX_A=384;   
    final int MIN_B=-97;    
    final int MAX_B=128;     
    final double PROPORTIONALITY=.5;
    Set<Integer> setOfIntegers = IntStream
       .rangeClosed(-MAX_B*PROPORTIONALITY,-MIN_B+1).boxed().collect(Collectors.toSet());
    List<List<String>> expectedOutput = Arrays
           .asList("[(256,"+-MAX_B+")", "(256,"+(setOfIntegers.stream().limit((long)(Math.ceil((-MAX_B)*PROPORTIONALITY))))),
                    "("+setOfIntegers+", "+-(MAX_B)+"])","("+setOfIntegers+", "+(setOfIntegers.stream().skip(((long)((double)-MAX_B/PROPORTIONALITY))+1)).findFirst()+")");
    Collection<UnorderedPair> actualResult = 
        PairSampler.sampleUnorderedPairs(MIN_A, MAX_A, MIN_B, MAX_B, PROPORTIONALITY);
   assertEquals(expectedOutput.toString(),actualResult.toString());
}
}