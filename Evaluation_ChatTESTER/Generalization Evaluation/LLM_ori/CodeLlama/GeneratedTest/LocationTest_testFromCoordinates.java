package no.api.meteo.entity.core;
import org.junit.Assert;
import org.junit.Test;
// original test path: lazee_meteo###lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest###testFromCoordinates
public class LocationTest_testFromCoordinates {
    @Test
    public void testFromCoordinates() {
        assertEquals(new Location(-75.698, 45.421), Location.fromCoordinates("-75.698,45.421"));
        assertEquals(new Location(-75.698, 45.421, 100), Location.fromCoordinates("-75.698,45.421,100"));
        assertThrows(IllegalArgumentException.class, () -> Location.fromCoordinates(null));
        assertThrows(IllegalArgumentException.class, () -> Location.fromCoordinates("invalid_input"));
        assertThrows(IllegalArgumentException.class, () -> Location.fromCoordinates("-75.698,45.421,abc"));
    }
}