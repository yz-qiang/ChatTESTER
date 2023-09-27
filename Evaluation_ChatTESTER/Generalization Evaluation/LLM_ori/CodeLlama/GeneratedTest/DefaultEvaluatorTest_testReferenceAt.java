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
class DefaultEvaluatorTest_testReferenceAt {
    private ExecutorService executorService;
    @BeforeEach
    void setUp() throws Exception {
        this.executorService = Executors.newSingleThreadExecutor();
    }
    @AfterEach
    void tearDown() throws Exception {
        this.executorService.shutdownNow();
    }
    @Nested
    @DisplayName("Reference at")
    class ReferenceAtTests {
        @ParameterizedTest
        @CsvSource({"1, 'a', 'b', 'c'", "2, 'd', 'e', 'f'"})
        void returnsCorrectReferenceForGivenPositionAndRetriever(int position, String expectedReference, Retriever retriever) {
            List<String> values = Arrays.asList("a", "b", "c");
            Properties properties = new Properties();
            properties.setProperty("retriever", retriever.getClass().getName());
            DefaultEvaluator evaluator = new DefaultEvaluator(properties);
            Reference actualReference = evaluator.referenceAt(values, position, retriever);
            assertEquals(expectedReference, actualReference.getValue());
        }
    }
}