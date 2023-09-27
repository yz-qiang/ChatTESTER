package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
public class CompareToBuilderTest_testAppendSuper {
    private CompareToBuilder compareToBuilder;
    @Before
    public void setUp(){
       compareToBuilder = new CompareToBuilder();
    }
    @Test
    public void testAppendSuperNotZero(){
         assertEquals("Expected value should be -1", -1, compareToBuilder.appendSuper(-1).getComparison());
    }
    @Test
    public void testAppendSuperIsZero(){
          assertEquals("Expected value should be 0", 0, compareToBuilder.appendSuper(0).getComparison());
    }
    @Test
    public void testAppendSuperPositiveNumber(){
           assertEquals("Expected value should be 2", 2, compareToBuilder.appendSuper(2).getComparison());
    }
    @Test
    public void testAppendSuperNegativeNumber(){
            assertEquals("Expected value should be -3", -3, compareToBuilder.appendSuper(-3).getComparison());
    }
}