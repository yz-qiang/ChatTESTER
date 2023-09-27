package nl.pvanassen.ns.xml;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/xml/XmlPresentTest###testChild
public class XmlPresentTest_testChild {
    private Document doc;
    private Element root;
    private XmlPresent xmlPresent;
    @Before
    public void setUp(){
        try{
            byte[] bytes = "<test><child1></child1><child2></child2></test>".getBytes(StandardCharsets.UTF_8);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(inputStream);
            root = doc.getDocumentElement();
            xmlPresent = new XmlPresent(root);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }
    @Test
    public void testChildMethodReturnsCorrectResultWhenGivenValidInput() throws Exception {
        assertNotNull(xmlPresent.child("child1"));
        assertNull(xmlPresent.child("nonExistentChild"));
    }
    @Test
    public void testChildMethodThrowsErrorOnMultipleMatchingChildren() throws Exception {
        Element child2 = doc.createElement("child1");
        root.appendChild(child2);
        xmlPresent = new XmlPresent(root);
        try {
            xmlPresent.child("child1");
            fail("Should have thrown exception on finding more than one match.");
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }
    @Test
    public void testChildMethodHandlesEmptyTagNames() throws Exception {
        try {
            xmlPresent.child("");
            fail("Should throw IllegalArgumentException on passing empty string.");
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }
    @Test
    public void testChildMethodHandlesNullInput() throws Exception {
        try {
            xmlPresent.child(null);
            fail("Should throw NullPointerException on passing null.");
        } catch (NullPointerException ex) {
            assertTrue(true);
        }
    }
}