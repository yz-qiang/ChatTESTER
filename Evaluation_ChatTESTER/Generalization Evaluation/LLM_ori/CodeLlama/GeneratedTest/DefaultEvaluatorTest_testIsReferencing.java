package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testIsReferencing
public class DefaultEvaluatorTest_testIsReferencing {
    private ExecutorService executorService;
    @BeforeClass
    public void setUp() throws Exception {
        this.executorService = Executors.newSingleThreadExecutor();
    }
    @AfterClass
    public void tearDown() throws Exception {
        this.executorService.shutdownNow();
    }
    @Test
    public void testIsReferencing_nullRawValue() {
        assertFalse("Should be false when raw value is null",
                new DefaultEvaluator().isReferencing(null, "testName", mockRetriever()));
    }
    @Test
    public void testIsReferencing_emptyRawValue() {
        assertFalse("Should be false when raw value is empty",
                new DefaultEvaluator().isReferencing("", "testName", mockRetriever()));
    }
    @Test
    public void testIsReferencing_nonEmptyRawValueNoMatchingRef() {
        assertFalse("Should be false when there is no matching reference",
                new DefaultEvaluator().isReferencing("some text without a match", "testName", mockRetriever()));
    }
    @Test
    public void testIsReferencing_matchingRefInDifferentCase() {
        assertTrue("Should be true when there is a matching reference regardless of case",
                new DefaultEvaluator().isReferencing("Some Text With A Match", "TESTNAME", mockRetriever()));
    }
    @Test
    public void testIsReferencing_multipleMatchesWithOneExactMatch() {
        assertTrue("Should be true when there is at least one exact match among multiple matches",
                new DefaultEvaluator().isReferencing("Some Text With Multiple Matches But Only One Exact Match", "testName", mockRetriever()));
    }
    @Test
    public void testIsReferencing_noMatchButSimilarTextExists() {
        assertFalse("Should be false when there is no direct match but similar text exists",
                new DefaultEvaluator().isReferencing("Some Similar Text Without An Exact Match", "testName", mockRetriever()));
    }
    private Retriever mockRetriever() {
        Properties properties = new Properties();
        properties.setProperty("retriever.class", "com.example.evaluator.DefaultRetriever");
        return new DefaultRetriever(properties);
    }
}