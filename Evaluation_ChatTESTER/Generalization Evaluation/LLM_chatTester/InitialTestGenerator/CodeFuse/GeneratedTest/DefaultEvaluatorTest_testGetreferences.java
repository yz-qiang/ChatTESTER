package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testGetreferences
@RunWith(PowerMockRunner.class)
@PrepareForTest({DefaultEvaluator.class})
@ContextConfiguration("file:/path/to/applicationContext.xml")
public class DefaultEvaluatorTest_testGetreferences extends AbstractGenericXmlApplicationContextTests{
    @Autowired
    private DefaultEvaluator defaultEvaluator;
    private Retrieve mockedRetriever;
    @BeforeClass
    public void setUp() throws Exception {
        super.setUp();
        this.mockedRetriever = mock(Retriever.class);
    }
    @Test
    public void testGetReferencesNullInput(){
        String rawValue = null;
        Assert.assertEquals(defaultEvaluator.getReferences(rawValue, mockedRetriever), Collections.<Reference> emptyList());
    }
    @Test
    public void testGetReferencesEmptyRawValue(){
        String rawValue = "";
        when(mockedRetriever.retrieve()).thenReturn(new ArrayList<>());
        Assert.assertTrue(defaultEvaluator.getReferences(rawValue, mockedRetriever).isEmpty());
    }
    @Test
    public void testGetReferencesNonEmptyRawValue(){
        String rawValue = "some value";
        List<Reference> expectedResult = Arrays.asList(new Reference(), new Reference());
        when(mockedRetriever.retrieve()).thenReturn(expectedResult);
        Assert.assertEquals(defaultEvaluator.getReferences(rawValue, mockedRetriever), expectedResult);
    }
}