// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/User_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:53:01 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.User;
import org.junit.runner.RunWith;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.User;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class User_ESTest extends User_ESTest_scaffolding {

    @Test
    public void testGetBio() {
        // Create a User object
        User user = new User();
        
        // Set the bio of the user
        user.setBio("I am a software engineer");
        
        // Retrieve the bio using the getBio() method
        String bio = user.getBio();
        
        // Assert that the retrieved bio is equal to the expected bio
        assertEquals("I am a software engineer", bio);
    }

    @Test
    public void testGetUserName() {
        // Create a new User object
        User user = new User();

        // Set the value of the userName variable
        user.setUserName("JohnDoe");

        // Call the getUserName() method and store the result
        String result = user.getUserName();

        // Assert that the result is equal to the expected value
        assertEquals("JohnDoe", result);
    }

    @Test
    public void testSetUserName() {
        // Create a new User object
        User user = new User();

        // Set the username using the setUserName method
        String expectedUserName = "john_doe";
        user.setUserName(expectedUserName);

        // Verify that the username has been set correctly
        String actualUserName = user.getUserName();
        assertEquals(expectedUserName, actualUserName);
    }

    @Test
    public void testSetId() {
        // Create a new User object
        User user = new User();

        // Set the id using the setId method
        String id = "12345";
        user.setId(id);

        // Verify that the id has been set correctly
        assertEquals(id, user.getId());
    }

    @Test
    public void testSetProfilePictureUrl() {
        // Create a new User object
        User user = new User();

        // Set the profile picture URL using the setProfilePictureUrl method
        String profilePictureUrl = "https://example.com/profile.jpg";
        user.setProfilePictureUrl(profilePictureUrl);

        // Verify that the profile picture URL has been updated correctly
        assertEquals(profilePictureUrl, user.getProfilePictureUrl());
    }

    @Test
    public void testGetId() {
        // Create a new User object
        User user = new User();

        // Set the id attribute of the User object
        user.setId("12345");

        // Call the getId() method and store the result in a variable
        String id = user.getId();

        // Assert that the returned id is equal to the expected id
        assertEquals("12345", id);
    }

    @Test
    public void testGetProfilePictureUrl() {
        // Create a User object
        User user = new User();
        
        // Set the profile picture URL
        String profilePictureUrl = "https://example.com/profile.jpg";
        user.setProfilePictureUrl(profilePictureUrl);
        
        // Call the getProfilePictureUrl() method
        String result = user.getProfilePictureUrl();
        
        // Assert that the returned URL matches the set URL
        assertEquals(profilePictureUrl, result);
    }

    @Test
    public void testGetWebsiteUrl() {
        // Create a User object
        User user = new User();

        // Set the website URL
        String websiteUrl = "https://www.example.com";
        user.setWebsiteUrl(websiteUrl);

        // Retrieve the website URL using the getWebsiteUrl() method
        String retrievedWebsiteUrl = user.getWebsiteUrl();

        // Assert that the retrieved website URL matches the expected website URL
        assertEquals(websiteUrl, retrievedWebsiteUrl);
    }

@Test
public void testToString() {
    // Create a User object with sample data
    User user = new User();
    user.setBio("I am a software engineer");
    user.setFullName("John Doe");
    user.setId("123456789");
    user.setProfilePictureUrl("https://example.com/profile.jpg");
    user.setUserName("johndoe");
    user.setWebsiteUrl("https://example.com");

    // Expected string representation of the User object
    String expected = "User [bio=I am a software engineer, fullName=John Doe, id=123456789, profilePictureUrl=https://example.com/profile.jpg, userName=johndoe, websiteUrl=https://example.com]";

    // Call the toString() method and compare the result with the expected string
    assertEquals(expected, user.toString());
}

    @Test
    public void testSetWebsiteUrl() {
        // Create a new User object
        User user = new User();

        // Set the website URL using the setWebsiteUrl method
        String websiteUrl = "https://example.com";
        user.setWebsiteUrl(websiteUrl);

        // Verify that the website URL was set correctly
        assertEquals(websiteUrl, user.getWebsiteUrl());
    }

    @Test
    public void testGetFullName() {
        // Create a User object
        User user = new User();
        
        // Set the full name of the user
        user.setFullName("John Doe");
        
        // Retrieve the full name using the getFullName() method
        String fullName = user.getFullName();
        
        // Assert that the retrieved full name matches the expected value
        assertEquals("John Doe", fullName);
    }

    @Test
    public void testSetFullName() {
        // Create a new User object
        User user = new User();

        // Set the full name using the setFullName method
        String fullName = "John Doe";
        user.setFullName(fullName);

        // Verify that the full name has been set correctly
        assertEquals(fullName, user.getFullName());
    }

    @Test
    public void testSetBio() {
        // Create a new User object
        User user = new User();

        // Set the bio using the setBio method
        String bio = "This is my bio";
        user.setBio(bio);

        // Verify that the bio has been set correctly
        assertEquals(bio, user.getBio());
    }

}
