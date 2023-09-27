package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SerializationUtilsTest###testClone
public class TestSerializationUtils_testClone {
    private SerializationUtils utils;
    @Before
    public void setUp() {
        utils = new SerializationUtils();
    }
    @Test
    public void testCloneWithValidInput() throws Exception {
        DummyObj obj1 = new DummyObj();
        obj1.setName("John");
        obj1.setAge(25);
        DummyObj obj2 = utils.clone(obj1);
        assertNotNull(obj2);
        assertEquals(obj1.getName(), obj2.getName());
        assertEquals(obj1.getAge(), obj2.getAge());
    }
    @Test
    public void testCloneWithInvalidInput() throws Exception {
        Object invalidObj = new Object();
        Object result = utils.clone(invalidObj);
        assertNull(result);
    }
    @Test
    public void testCloneWithNullInput() throws Exception {
        Object nullObj = null;
        Object result = utils.clone(nullObj);
        assertNull(result);
    }
    @Test
    public void testCloneWithNonSerializableObject() throws Exception {
        NonSerializableObj nonSerializeableObj = new NonSerializableObj();
        Object result = utils.clone(nonSerializeableObj);
        assertNull(result);
    }
    @Test
    public void testCloneWithTransientField() throws Exception {
        TransientFieldObj transientObj = new TransientFieldObj();
        transientObj.setId(101);
        transientObj.setValue("test value");
        TransientFieldObj clonedObj = utils.clone(transientObj);
        assertNotNull(clonedObj);
        assertEquals(transientObj.getValue(), clonedObj.getValue());
        assertEquals(transientObj.getId(), clonedObj.getId());
    }
    private static class DummyObj implements Serializable {
        private String name;
        private int age;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }
    private static class NonSerializableObj {
        private String value;
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }
    private static class TransientFieldObj implements Serializable {
        private static final long serialVersionUID = 1L;
        private int id;
        private transient String value;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }
}