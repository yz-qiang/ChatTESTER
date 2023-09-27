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
public class EqualsBuilderTest_testReflectionAppend {
    @Test
    public void testReflectionAppend_equalObjects() throws Exception {
        Foo foo1 = new Foo("foo", "bar");
        Foo foo2 = new Foo("foo", "bar");
        EqualsBuilder builder = new EqualsBuilder();
        builder.reflectionAppend(foo1, foo2);
        assertTrue(builder.isEquals());
    }
    @Test
    public void testReflectionAppend_unequalObjects() throws Exception {
        Foo foo1 = new Foo("foo", "bar");
        Bar bar1 = new Bar("baz", "qux");
        EqualsBuilder builder = new EqualsBuilder();
        builder.reflectionAppend(foo1, bar1);
        assertFalse(builder.isEquals());
    }
    private static class Foo {
        String field1;
        String field2;
        public Foo(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }
    }
    private static class Bar extends Foo {
        String field3;
        public Bar(String field1, String field2, String field3) {
            super(field1, field2);
            this.field3 = field3;
        }
    }
}