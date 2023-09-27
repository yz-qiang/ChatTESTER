package no.api.meteo.entity.core;
import org.junit.Assert;
import org.junit.Test;
// original test path: lazee_meteo###lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest###testFromCoordinates
public class LocationTest_testFromCoordinates {
    @Test
    public void testFromCoordinatesValidInput(){
        String coordinates = "56.789,-123.456";
        Location expectedLocation = new Location(-123.456, 56.789, 0, "");
        Assert.assertEquals(expectedLocation, Location.fromCoordinates(coordinates));
    }
    @Test
    public void testFromCoordinatesNoAltitudeProvided(){
        String coordinates = "-123.456,56.789";
        Location expectedLocation = new Location(-123.456, 56.789, 0, "");
        Assert.assertEquals(expectedLocation, Location.fromCoordinates(coordinates));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testFromCoordinatesInvalidFormat(){
        String coordinates = "invalid_format";
        Location.fromCoordinates(coordinates);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testFromCoordinatesNullInput(){
        String coordinates = null;
        Location.fromCoordinates(coordinates);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testFromCoordinatesInvalidValues(){
        String coordinates = "abc,def,ghi";
        Location.fromCoordinates(coordinates);
    }
}