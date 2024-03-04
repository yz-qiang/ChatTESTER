// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/utils/Preconditions_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 05:17:41 GMT 2024
 */
package org.jinstagram.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.utils.Preconditions;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Preconditions_ESTest extends Preconditions_ESTest_scaffolding {

    @Test
    public void testCheckNotNull() {
        // Test case 1: object is not null
        Object object1 = new Object();
        try {
            Preconditions.checkNotNull(object1, "Object should not be null");
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        
        // Test case 2: object is null
        Object object2 = null;
        try {
            Preconditions.checkNotNull(object2, "Object should not be null");
            fail("Exception should be thrown");
        } catch (Exception e) {
            assertEquals("Object should not be null", e.getMessage());
        }
    }

    @Test
    public void testCheckValidLatLong() {
        // Test case 1: Valid latitude
        String lat = "37.7749";
        String errorMsg = "Invalid latitude";
        Preconditions.checkValidLatLong(lat, errorMsg);
        // No exception should be thrown

        // Test case 2: Valid longitude
        String lon = "-122.4194";
        Preconditions.checkValidLatLong(lon, errorMsg);
        // No exception should be thrown

        // Test case 3: Invalid latitude
        String invalidLat = "abc";
        try {
            Preconditions.checkValidLatLong(invalidLat, errorMsg);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(errorMsg, e.getMessage());
        }

        // Test case 4: Invalid longitude
        String invalidLon = "xyz";
        try {
            Preconditions.checkValidLatLong(invalidLon, errorMsg);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(errorMsg, e.getMessage());
        }
    }

    @Test
    public void testCheckValidRadius() {
        // Test case 1: Valid radius string
        String radiusString1 = "10";
        String errorMsg1 = "Invalid radius";
        try {
            Preconditions.checkValidRadius(radiusString1, errorMsg1);
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }

        // Test case 2: Empty radius string
        String radiusString2 = "";
        String errorMsg2 = "Invalid radius";
        try {
            Preconditions.checkValidRadius(radiusString2, errorMsg2);
            fail("Expected exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(errorMsg2, e.getMessage());
        }

        // Test case 3: Non-numeric radius string
        String radiusString3 = "abc";
        String errorMsg3 = "Invalid radius";
        try {
            Preconditions.checkValidRadius(radiusString3, errorMsg3);
            fail("Expected exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(errorMsg3, e.getMessage());
        }
    }

    @Test
    public void testCheckValidOAuthCallback() {
        String validUrl = "http://example.com";
        String invalidUrl = "invalidUrl";
        String errorMsg = "Invalid OAuth callback URL";

        // Test with valid URL
        Preconditions.checkValidOAuthCallback(validUrl, errorMsg);

        // Test with out-of-band URL
        Preconditions.checkValidOAuthCallback("oob", errorMsg);

        // Test with invalid URL
        try {
            Preconditions.checkValidOAuthCallback(invalidUrl, errorMsg);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(errorMsg, e.getMessage());
        }
    }

    @Test
    public void testCheckValidUrl() {
        // Test case 1: Valid URL
        String validUrl = "https://www.example.com";
        try {
            Preconditions.checkValidUrl(validUrl, "Invalid URL");
        } catch (Exception e) {
            fail("Valid URL should not throw an exception");
        }

        // Test case 2: Empty URL
        String emptyUrl = "";
        try {
            Preconditions.checkValidUrl(emptyUrl, "Invalid URL");
            fail("Empty URL should throw an exception");
        } catch (Exception e) {
            assertEquals("Invalid URL", e.getMessage());
        }

        // Test case 3: Invalid URL format
        String invalidUrl = "example.com";
        try {
            Preconditions.checkValidUrl(invalidUrl, "Invalid URL");
            fail("Invalid URL format should throw an exception");
        } catch (Exception e) {
            assertEquals("Invalid URL", e.getMessage());
        }
    }

@Test
public void testCheckBothNotNull() {
    Object object1 = new Object();
    Object object2 = new Object();
    String errorMsg = "Both objects are null";
    try {
        Preconditions.checkBothNotNull(object1, object2, errorMsg);
    } catch (Exception e) {
        fail("Exception should not be thrown");
    }
    object1 = null;
    object2 = new Object();
    try {
        Preconditions.checkBothNotNull(object1, object2, errorMsg);
        fail("AssertionError should be thrown");
    } catch (AssertionError e) {
        // Assertion passed
    }
}

    @Test
    public void testCheckEmptyString() {
        // Test case 1: string is not empty or null
        String string1 = "Hello";
        String errorMsg1 = "Error message 1";
        try {
            Preconditions.checkEmptyString(string1, errorMsg1);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        
        // Test case 2: string is empty
        String string2 = "";
        String errorMsg2 = "Error message 2";
        try {
            Preconditions.checkEmptyString(string2, errorMsg2);
            fail("Exception should be thrown");
        } catch (Exception e) {
            assertEquals(errorMsg2, e.getMessage());
        }
        
        // Test case 3: string is null
        String string3 = null;
        String errorMsg3 = "Error message 3";
        try {
            Preconditions.checkEmptyString(string3, errorMsg3);
            fail("Exception should be thrown");
        } catch (Exception e) {
            assertEquals(errorMsg3, e.getMessage());
        }
    }

}