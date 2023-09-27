package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testIsReferencing
@RunWith(MockitoJUnitRunner.class)
public class DefaultEvaluatorTest_testIsReferencing {
    @Mock
    private Retriever mockRetriever;
    @InjectMocks
    private DefaultEvaluator defaultEvaluator;
    @Before
    public void setUp(){
    }
    @After
    public void tearDown(){
    }
    @Test
    public void testIsReferencingWhenRawValueNullReturnFalse() {
        Assert.assertEquals("Expected False when Raw Value is Null",false,defaultEvaluator.isReferencing(null,"testName",mockRetriever));
    }
    @Test
    public void testIsReferencingWhenNoMatchingReferenceFoundReturnFalse() {
        String rawValue="This is a sample text";
        String name="testName";
        when(mockRetriever.retrieve()).thenReturn(new Properties());
        Assert.assertEquals("Expected False when No Matching Reference Found",false,defaultEvaluator.isReferencing(rawValue,name,mockRetriever));
    }
    @Test
    public void testIsReferencingWhenMatchingReferenceFoundReturnTrue() {
        String rawValue="This is a $sample$text";
        String name="$sample$";
        Properties properties=new Properties();
        properties.setProperty("sample","value");
        when(mockRetriever.retrieve()).thenReturn(properties);
        Assert.assertEquals("Expected True when Matching Reference Found",true,defaultEvaluator.isReferencing(rawValue,name,mockRetriever);
    }
}