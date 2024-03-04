// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/ImageData_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:40:48 GMT 2024
 */
package org.jinstagram.entity.common;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.ImageData;
import org.junit.runner.RunWith;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.ImageData;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class ImageData_ESTest extends ImageData_ESTest_scaffolding {

@Test
public void testGetImageUrl() {
    // Create an instance of ImageData
    ImageData imageData = new ImageData();
    
    // Set the imageUrl using the setter method
    String imageUrl = "https://example.com/image.jpg";
    imageData.setImageUrl(imageUrl);
    
    // Call the getImageUrl method and assert that it returns the expected value
    String actualImageUrl = imageData.getImageUrl();
    assertEquals(imageUrl, actualImageUrl);
}

    @Test
    public void testSetImageUrl() {
        // Create an instance of ImageData
        ImageData imageData = new ImageData();

        // Set the image URL using the focal method
        String imageUrl = "https://example.com/image.jpg";
        imageData.setImageUrl(imageUrl);

        // Verify that the image URL is set correctly
        assertEquals(imageUrl, imageData.getImageUrl());
    }

@Test
public void testSetImageHeight() {
    // Create an instance of ImageData
    ImageData imageData = new ImageData();

    // Set the image height
    int imageHeight = 100;
    imageData.setImageHeight(imageHeight);

    // Verify that the image height is set correctly
    assertEquals(imageHeight, imageData.getImageHeight());
}

@Test
public void testGetImageHeight() {
    // Create an instance of ImageData
    ImageData imageData = new ImageData();
    
    // Set the image height
    int expectedHeight = 100;
    imageData.setImageHeight(expectedHeight);
    
    // Get the image height using the getImageHeight() method
    int actualHeight = imageData.getImageHeight();
    
    // Assert that the actual height matches the expected height
    assertEquals(expectedHeight, actualHeight);
}

@Test
public void testGetImageWidth() {
    // Create an instance of ImageData
    ImageData imageData = new ImageData();
    
    // Set the image width
    int expectedWidth = 800;
    imageData.setImageWidth(expectedWidth);
    
    // Get the image width using the getImageWidth() method
    int actualWidth = imageData.getImageWidth();
    
    // Assert that the actual width matches the expected width
    assertEquals(expectedWidth, actualWidth);
}

@Test
public void testSetImageWidth() {
    // Create an instance of ImageData
    ImageData imageData = new ImageData();

    // Set the image width using the focal method
    int imageWidth = 800;
    imageData.setImageWidth(imageWidth);

    // Verify that the image width is set correctly
    assertEquals(imageWidth, imageData.getImageWidth());
}

@Test
public void testToString() {
    // Create an instance of ImageData
    ImageData imageData = new ImageData();
    
    // Set the values for the instance variables
    imageData.setImageHeight(100);
    imageData.setImageUrl("https://example.com/image.jpg");
    imageData.setImageWidth(200);
    
    // Call the toString() method
    String result = imageData.toString();
    
    // Verify the result
    String expected = "ImageData [imageHeight=100, imageUrl=https://example.com/image.jpg, imageWidth=200]";
    assertEquals(expected, result);
}

}
