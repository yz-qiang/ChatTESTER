package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/EqualsBuilderTest###testReflectionAppend
public class TestReflectionAppend_testReflectionAppend {
    private EqualsBuilder equalsBuilder;
    @Before
    public void setUp(){
       equalsBuilder = new EqualsBuilder();
    }
    @Test
    public void testReflectionAppendEqualObjects(){
         String obj1 = "Hello";
         String obj2 = "Hello";
         assertTrue(equalsBuilder.reflectionAppend(obj1, obj2).isEquals());
    }
    @Test
    public void testReflectionAppendNotEqualObjects(){
         Integer obj1 = 50;
         Double obj2 = 50.0;
         assertFalse(equalsBuilder.reflectionAppend(obj1, obj2).isEquals());
    }
    @Test
    public void testReflectionAppendOneObjectIsNull(){
         String obj1 = null;
         String obj2 = "World";
         assertFalse(equalsBuilder.reflectionAppend(obj1, obj2).isEquals());
    }
    @Test
    public void testReflectionAppendBothAreArrays(){
         int[] arr1 = {1, 2};
         int[] arr2 = {1, 2};
         assertTrue(equalsBuilder.reflectionAppend(arr1, arr2).isEquals());
    }
    @Test
    public void testReflectionAppendOnlyOneIsArray(){
         int[] arr1 = {1, 2};
         double[] arr2 = {};
         assertFalse(equalsBuilder.reflectionAppend(arr1, arr2).isEquals());
    }
    @Test
    public void testReflectionAppendNeitherIsArray(){
         MyClass obj1 = new MyClass();
         MyClass obj2 = new MyClass();
         assertTrue(equalsBuilder.reflectionAppend(obj1, obj2).isEquals());
    }
}