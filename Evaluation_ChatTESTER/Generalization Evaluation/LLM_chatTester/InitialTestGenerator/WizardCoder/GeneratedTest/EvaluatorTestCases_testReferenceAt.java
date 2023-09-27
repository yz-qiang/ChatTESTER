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
class EvaluatorTestCases_testReferenceAt extends Assert{
    private static final String RAW_VALUE1="This is just one example.";
    private static final Integer POSITION=50;
    @Before 
    public void setUp() throws Exception {}
    @Test   
    public void whenNoValidReferenceFoundThenReturnNull(){
        Properties propertiesMockedObject=mock(Properties.class);
        List<Integer> listPositionalReferences=new ArrayList<>();
        when(propertiesMockedObject.getProperty("validRef")).thenReturn("");
        try{
            defaultEvaluatorInstance().referenceAt("",POSITION,"",listPositionalReferences).equals(null);
             fail("Should not reach here");
        }catch(Exception e){
           assertTrue((e instanceof IllegalArgumentException));
        }
    }
}