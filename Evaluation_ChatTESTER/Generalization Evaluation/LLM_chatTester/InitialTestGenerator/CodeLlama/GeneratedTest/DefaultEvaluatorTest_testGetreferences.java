package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testGetreferences
public class DefaultEvaluatorTest_testGetreferences {
	private static final String RAW_VALUE = "This is a sample text";
	private static final int NUMBER_OF_REFERENCES = 3;
	private static ExecutorService executorService;
	private static Properties properties;
	private static Retriever retriever;
	@BeforeClass
	public static void setUp() throws Exception {
		executorService = Executors.newFixedThreadPool(10);
		properties = new Properties();
		retriever = new MockRetriever(RAW_VALUE, properties);
	}
	@Test
	public void testGetReferencesWithValidInput() {
		DefaultEvaluator evaluator = new DefaultEvaluator();
		List<Reference> expectedReferences = Arrays.asList(new Reference("reference1"), new Reference("reference2"), new Reference("reference3"));
		List<Reference> actualReferences = evaluator.getReferences(RAW_VALUE, retriever);
		assertEquals(expectedReferences, actualReferences);
	}
	@Test
	public void testGetReferencesWithNullRawValue() {
		DefaultEvaluator evaluator = new DefaultEvaluator();
		try {
			evaluator.getReferences(null, retriever);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("rawValue cannot be null"));
		}
	}
	@Test
	public void testGetReferencesWithEmptyRawValue() {
		DefaultEvaluator evaluator = new DefaultEvaluator();
		List<Reference> expectedReferences = Collections.emptyList();
		List<Reference> actualReferences = evaluator.getReferences("", retriever);
		assertEquals(expectedReferences, actualReferences);
	}
	@Test
	public void testGetReferencesWithInvalidRetriever() {
		DefaultEvaluator evaluator = new DefaultEvaluator();
		MockRetriever mockRetriever = new MockRetriever(RAW_VALUE, properties);
		mockRetriever.setThrowErrorOnParse(true);
		try {
			evaluator.getReferences(RAW_VALUE, mockRetriever);
			fail("Expected RuntimeException");
		} catch (RuntimeException e) {
			assertTrue(e.getMessage().contains("Failed to parse input"));
		}
	}
	@AfterClass
	public static void tearDown() throws Exception {
		if (executorService != null) {
			executorService.shutdownNow();
		}
	}
}