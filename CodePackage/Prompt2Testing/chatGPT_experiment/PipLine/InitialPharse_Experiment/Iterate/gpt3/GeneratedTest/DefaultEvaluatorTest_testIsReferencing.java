package org.syphr.prom;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testIsReferencing
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class DefaultEvaluatorTest_testIsReferencing {
    private DefaultEvaluator evaluator;
    @Before
    public void setUp() {
        evaluator = new DefaultEvaluator();
    }
    @Test
    public void testIsReferencing() {
        String rawValue = "Hello ${name}";
        String name = "name";
        Retriever retriever = new Retriever() {
            @Override
            public String retrieve(String key) {
                return "World";
            }
        };
        boolean result = evaluator.isReferencing(rawValue, name, retriever);
        Assert.assertTrue(result);
    }
    @Test
    public void testIsNotReferencing() {
        String rawValue = "Hello World";
        String name = "name";
        Retriever retriever = new Retriever() {
            @Override
            public String retrieve(String key) {
                return "World";
            }
        };
        boolean result = evaluator.isReferencing(rawValue, name, retriever);
        Assert.assertFalse(result);
    }
}