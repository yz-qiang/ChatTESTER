package org.syphr.prom;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testGetreferences
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
public class DefaultEvaluatorTest_testGetreferences {
    @Test
    public void testGetReferences() {
        Retriever mockRetriever = new Retriever() {
            @Override
            public String retrieve(String reference) {
                return "Mock value for " + reference;
            }
        };
        DefaultEvaluator evaluator = new DefaultEvaluator();
        List<Reference> nullReferences = evaluator.getReferences(null, mockRetriever);
        Assert.assertEquals(0, nullReferences.size());
        List<Reference> emptyReferences = evaluator.getReferences("", mockRetriever);
        Assert.assertEquals(0, emptyReferences.size());
        String rawValue = "This is a test string with references [ref1], [ref2], and [ref3]";
        List<Reference> references = evaluator.getReferences(rawValue, mockRetriever);
        Assert.assertEquals(3, references.size());
        Assert.assertEquals("Mock value for ref1", references.get(0).getValue());
        Assert.assertEquals("Mock value for ref2", references.get(1).getValue());
        Assert.assertEquals("Mock value for ref3", references.get(2).getValue());
    }
}