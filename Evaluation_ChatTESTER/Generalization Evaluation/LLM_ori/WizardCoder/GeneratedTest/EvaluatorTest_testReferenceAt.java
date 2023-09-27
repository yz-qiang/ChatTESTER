package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testReferenceAt
public 
class EvaluatorTest_testReferenceAt {
    private final String TEST_VALUE1 = "This is some text.";
    private final List<Reference> EXPECTED_REFERENCES1 = Arrays.asList(
            new Reference("text", 5), 
            new Reference("is", 8));
    @BeforeMethod 
    public void setUp(){
        Properties props = System.getProperties(); 
        ExecutorService executor = Executors.newFixedThreadPool((int)(props.getOrDefault("threads","4")));  
        try{
            evaluator = new DefaultEvaluator(executor);   
        } catch (Exception e){
            fail("Failed creating instance of default evaluator.",e);            
        }
    }
    @Test 
    public void testGetReferencesFromInputTextCorrectly() throws Exception {
        List<Reference> actualRefs=null ; 
        try{
            actualRefs = evaluator.evaluateAndGetReferencesFromString(TEST_VALUE1).collect(Collectors.toList()); 
        }catch(Exception ex){
           throw new RuntimeException ("Error while evaluating or getting References from Input Text ",ex );           
        }        
        assertThat(actualRefs).isNotNull().isNotEmpty().hasSizeGreaterThanOrEqualTo(EXPECTED_REFERENCES1.size()).containsAll(EXPECTED_REFERENCES1);         
      }
}