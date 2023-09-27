package nl.pvanassen.ns.model.stations;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest###testGetModel
public class StationsHandleTest_testGetModel {
    @Test
    public void testGetModel() throws Exception {
        InputStream stream = this.getClass().getResourceAsStream("/stations_data.xml");
        Stations result = new StationsHandle().getModel(stream);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.containsKey("AMS"));
        assertTrue(result.containsValue("Amsterdam"));
        assertFalse(result.isEmpty());
    }
}