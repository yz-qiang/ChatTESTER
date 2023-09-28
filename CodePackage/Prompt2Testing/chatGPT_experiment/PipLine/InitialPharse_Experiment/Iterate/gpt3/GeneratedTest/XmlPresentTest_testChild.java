package nl.pvanassen.ns.xml;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/xml/XmlPresentTest###testChild
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;
public class XmlPresentTest_testChild {
    private XmlPresent xml;
    @Before
    public void setUp() {
        String xmlString = "<root><child1>value1</child1><child2>value2</child2></root>";
        InputStream stream = new ByteArrayInputStream(xmlString.getBytes());
        xml = (XmlPresent) Xml.getXml(stream, "root");
    }
    @Test
    public void testChild() {
        Xml child = xml.child("child1");
        assertNotNull(child);
        assertEquals("child1", child.name());
        assertEquals("value1", child.content());
    }
    @Test
    public void testChildNotFound() {
        Xml child = xml.child("nonexistent");
        assertNotNull(child);
        assertEquals("nonexistent", child.name());
        assertTrue(child instanceof XmlAbsent);
    }
    @Test
    public void testMultipleChildren() {
        Xml child = xml.child("child");
        assertNotNull(child);
        assertEquals("child", child.name());
        assertTrue(child instanceof XmlAbsent);
    }
}