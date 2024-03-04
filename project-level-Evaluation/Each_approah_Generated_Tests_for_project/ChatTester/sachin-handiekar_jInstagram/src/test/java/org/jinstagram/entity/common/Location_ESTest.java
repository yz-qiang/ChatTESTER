// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Location_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:46:49 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Location;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Location_ESTest extends Location_ESTest_scaffolding {

    @Test
    public void testGetLatitude() {
        // Create a new Location object
        Location location = new Location();
        
        // Set the latitude value
        double expectedLatitude = 37.7749;
        location.setLatitude(expectedLatitude);
        
        // Retrieve the latitude value using the getLatitude() method
        double actualLatitude = location.getLatitude();
        
        // Assert that the retrieved latitude value matches the expected latitude value
        assertEquals(expectedLatitude, actualLatitude, 0.0001);
    }

    @Test
    public void testSetLatitude() {
        // Create a new Location object
        Location location = new Location();

        // Set the latitude value using the setLatitude method
        double latitude = 37.7749;
        location.setLatitude(latitude);

        // Verify that the latitude value has been set correctly
        assertEquals(latitude, location.getLatitude(), 0.0001);
    }

    @Test
    public void testGetLongitude() {
        // Create a new Location object
        Location location = new Location();
        
        // Set the longitude value
        double longitude = 123.456;
        location.setLongitude(longitude);
        
        // Retrieve the longitude value using the getLongitude() method
        double result = location.getLongitude();
        
        // Assert that the retrieved longitude value matches the expected value
        assertEquals(longitude, result, 0.001);
    }

    @Test
    public void testSetId() {
        // Create a new Location object
        Location location = new Location();

        // Set the id using the setId method
        String id = "12345";
        location.setId(id);

        // Verify that the id has been set correctly
        assertEquals(id, location.getId());
    }

    @Test
    public void testSetName() {
        // Create a new Location object
        Location location = new Location();

        // Set the name attribute using the setName method
        String name = "New Location";
        location.setName(name);

        // Verify that the name attribute has been set correctly
        assertEquals(name, location.getName());
    }

    @Test
    public void testSetLongitude() {
        // Create a new Location object
        Location location = new Location();

        // Set the longitude value using the setLongitude method
        double longitude = 45.6789;
        location.setLongitude(longitude);

        // Verify that the longitude value is set correctly
        assertEquals(longitude, location.getLongitude(), 0.0001);
    }

    @Test
    public void testGetId() {
        // Create a new Location object
        Location location = new Location();
        
        // Set the id attribute of the Location object
        location.setId("12345");
        
        // Call the getId() method and store the result in a variable
        String id = location.getId();
        
        // Assert that the returned id is equal to the expected id
        assertEquals("12345", id);
    }

    @Test
    public void testGetName() {
        // Create a new Location object
        Location location = new Location();
        
        // Set the name of the location
        String expectedName = "Test Location";
        location.setName(expectedName);
        
        // Retrieve the name using the getName() method
        String actualName = location.getName();
        
        // Assert that the retrieved name matches the expected name
        assertEquals(expectedName, actualName);
    }

}