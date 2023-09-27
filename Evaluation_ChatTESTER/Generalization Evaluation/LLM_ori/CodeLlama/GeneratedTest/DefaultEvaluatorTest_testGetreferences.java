package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testGetreferences
public 
class DefaultEvaluatorTest_testGetreferences {
    private ExecutorService executorService;
    private Properties properties;
    private Retriever retriever;
    @BeforeEach
    void setUp() throws Exception {
        this.executorService = Executors.newSingleThreadExecutor();
        this.properties = new Properties();
        this.retriever = Mockito.mock(Retriever.class);
    }
    @Test
    void testGetReferences_nullRawValue() {
        String rawValue = null;
        assertEquals(0, defaultEvaluator.getReferences(rawValue, retriever).size());
    }
    @Test
    void testGetReferences_nonNullRawValue() {
        String rawValue = "some value";
        List<Reference> expectedReferences = Arrays.asList(Mockito.mock(Reference.class));
        when(retriever.retrieve(any())).thenReturn(expectedReferences);
        assertEquals(1, defaultEvaluator.getReferences(rawValue, retriever).size());
    }
    @Test
    void testGetReferences_invalidRawValue() {
        String rawValue = "";
        assertThrows(IllegalArgumentException.class, () -> defaultEvaluator.getReferences(rawValue, retriever));
    }
}