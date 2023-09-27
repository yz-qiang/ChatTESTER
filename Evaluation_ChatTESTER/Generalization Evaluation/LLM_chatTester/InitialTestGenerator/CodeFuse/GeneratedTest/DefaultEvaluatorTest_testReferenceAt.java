package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testReferenceAt
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:/path/to/applicationContext.xml")
public class DefaultEvaluatorTest_testReferenceAt extends AbstractGenericXmlApplicationContextTests{
    @Autowired
    private DefaultEvaluator defaultEvaluator;
    private final String rawValue = "Hello World";
    private final int position = 10;
    private final Retriever mockRetriever = mock(Retriever.class);
    @Before
    public void setUp(){
    }
    @After
    public void tearDown(){
       super.tearDown();
    }
    @Test
    public void testReferenceAt() throws Exception {
        when(mockRetriever.retrieve()).thenReturn(new ArrayList<>());
        Assert.assertNull(defaultEvaluator.referenceAt(null, position, mockRetriever));
        Assert.assertNotNull(defaultEvaluator.referenceAt(rawValue, position, mockRetriever));
    }
}