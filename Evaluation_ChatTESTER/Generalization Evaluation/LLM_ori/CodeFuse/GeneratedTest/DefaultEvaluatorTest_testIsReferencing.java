package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testIsReferencing
@RunWith(PowerMockRunner.class)
@PrepareForTest({DefaultEvaluator.class})
public class DefaultEvaluatorTest_testIsReferencing {
    private DefaultEvaluator defaultEvaluator;
    private Retriever mockRetriever;
    @Before
    public void setUp() throws Exception{
        mockRetriever = mock(Retriever.class);
        whenNew(Retriever.class).withAnyArguments().thenReturn(mockRetriever);
        defaultEvaluator = new DefaultEvaluator();
    }
    @Test
    public void testIsReferencing() throws ScriptException {
        Assert.assertFalse(defaultEvaluator.isReferencing(null,"test", mockRetriever));
        when(mockRetriever.retrieve()).thenReturn("");
        Assert.assertFalse(defaultEvaluator.isReferencing("some string", "test", mockRetriever));
        Reference reference = new Reference("test","value");
        List<Reference> references = Arrays.asList(reference);
        Whitebox.setInternalState(defaultEvaluator, "references", references);
        Assert.assertTrue(defaultEvaluator.isReferencing("some string", "test", mockRetriever));
    }
}