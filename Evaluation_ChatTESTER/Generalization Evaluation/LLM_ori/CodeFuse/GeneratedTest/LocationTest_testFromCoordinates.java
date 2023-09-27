package no.api.meteo.entity.core;
import org.junit.Assert;
import org.junit.Test;
// original test path: lazee_meteo###lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest###testFromCoordinates
public class LocationTest_testFromCoordinates {
    private static Pattern P = Pattern.compile("(\\d{1,3}\.\d{1,3}),(\d{1,3}\.\d{1,3})(,\d{1,4})?");
    @Test
    public void testFromCoordinatesValid() {
        String coordinates = "56.789,-123.456";
        Location location = Location.fromCoordinates(coordinates);
        Assert.assertEquals(-123.456, location.getLongitude(), 0.0001);
        Assert.assertEquals(56.789, location.getLatitude(), 0.0001);
        Assert.assertEquals(null, location.getName());
    }
    @Test(expected=IllegalArgumentException.class)
    public void testFromCoordinatesInvalidFormat() {
        String coordinates = "-123.456,56.789";
        Location.fromCoordinates(coordinates);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testFromCoordinatesNonNumericValues() {
        String coordinates = "abc,def";
        Location.fromCoordinates(coordinates);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testFromCoordinatesIncorrectArguments() {
        String coordinates = "56.789,-123.456,xyz";
        Location.fromCoordinates(coordinates);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testFromCoordinatesNullInput() {
        String coordinates = null;
        Location.fromCoordinates(coordinates);
    }
}