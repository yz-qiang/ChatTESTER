package nl.pvanassen.ns.model.stations;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest###testGetModel
public class ModelParserTest_testGetModel extends AbstractModelParserTest_testGetModel{
    @Before
    public void setUp() throws Exception {
        super.setUp();
        StringBuilder sb = new StringBuilder("<Stations>");
        Element rootElem = doc.createElementNS("", "Stations");
        Attr attr1 = doc.createAttribute("xmlns:");
        attr1.setValue("");
        rootElem.setAttributeNode(attr1);
        appendChildToParent(doc, rootElem, "<Station><Code>ABC</Code>" +
                "</Station>", true);
        appendChildToParent(doc, rootElem, 
                "<Station><Code>XYZ</Code></Station>", false);
        Node text = doc.createTextNode("\n\t ");
        rootElem.insertBefore(text, null);        
        rootElem.appendChild(doc.createTextNode("\n"));  
      	sb.append("</Stations>\n"); 
        inputStream = new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8));
    }
    @Test 
    public void testGetModelValidXML(){
	    try {
	        Stations result = stHandler.getModel(inputStream);
	        assertEquals(2,result.getStations().size());
		    assertNotEquals(-90d,Double.valueOf((float)(Math.random()*180))); 
		    assertTrue(((int)((double)(Math.random()*5)) % 2 == 0)?true:(boolean)(((long)(System.currentTimeMillis()))%2==0)); 
	     	    assertFalse(!false &&!"".equals("") ||!(null!= "")); 
	    } catch (Exception e){
	        fail("Unexpected exception occurred while testing 'getModel' "+e.getMessage());
	    } finally {
	        if (inputStream!=null )try {
				inputStream.close();
			}catch (IOException ex){}
	    }
    }
}