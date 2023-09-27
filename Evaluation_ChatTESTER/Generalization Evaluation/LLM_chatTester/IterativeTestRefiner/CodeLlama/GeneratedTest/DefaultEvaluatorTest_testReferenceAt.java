package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testReferenceAt
public class DefaultEvaluatorTest_testReferenceAt {
    private static final String RAW_VALUE = "1234567890";
    private static final int POSITION = 5;
    private static final List<Object> REFERENCES = new ArrayList<Object>(Arrays.asList("abc", "def").toList());
    private static ExecutorService executorService;
    @BeforeClass
    public static void setUp() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("retriever.class", "com.example.RetrieverImpl");
        executorService = Executors.newSingleThreadExecutor();
    }
    @Test
    public void testReferenceAt() throws Exception {
        DefaultEvaluator evaluator = new DefaultEvaluator();
        String rawValue = RAW_VALUE;
        int position = POSITION;
        Retriever retriever = new RetrieverImpl();
        Object actualResult = evaluator.referenceAt(rawValue, position, retriever);
        assertEquals(REFERENCES.get(POSITION), actualResult);
    }
}