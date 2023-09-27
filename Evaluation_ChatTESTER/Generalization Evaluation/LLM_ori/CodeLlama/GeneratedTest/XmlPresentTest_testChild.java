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
    @Test
    public void testChildMethod() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/test.xml");
        Element rootElement = XmlPresent.rootElement(inputStream, "root");
        XmlPresent xmlPresent = new XmlPresent(rootElement);
        assertEquals("child", xmlPresent.child("child").getName());
        assertEquals("grandchild", xmlPresent.child("child").child("grandchild").getName());
        assertNull(xmlPresent.child("nonExistent"));
    }
}