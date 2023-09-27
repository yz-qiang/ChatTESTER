package org.syphr.prom;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
// original test path: syphr42_prom###syphr42_prom/src/test/java/org/syphr/prom/DefaultEvaluatorTest###testIsReferencing
public 
class DefaultEvaluatorTest_testIsReferencing {
    @Test
    void testIsReferencing() {
        Retriever retrieverMock = Mockito.mock(Retriever.class);
        when(retrieverMock.parse("test")).thenReturn(new ArrayList<>());
        assertFalse(DefaultEvaluator.isReferencing("", "", retrieverMock));
        Reference reference = new Reference("entityName");
        when(retrieverMock.parse("test")).thenReturn(Arrays.asList(reference));
        assertTrue(DefaultEvaluator.isReferencing("test", "entityName", retrieverMock));
        Reference reference1 = new Reference("entityName1");
        Reference reference2 = new Reference("entityName2");
        when(retrieverMock.parse("test")).thenReturn(Arrays.asList(reference1, reference2));
        assertTrue(DefaultEvaluator.isReferencing("test", "entityName1", retrieverMock));
        assertTrue(DefaultEvaluator.isReferencing("test", "entityName2", retrieverMock));
        when(retrieverMock.parse("test")).thenReturn(Arrays.asList(reference1, reference2));
        assertFalse(DefaultEvaluator.isReferencing("test", "nonExistentEntityName", retrieverMock));
    }
}