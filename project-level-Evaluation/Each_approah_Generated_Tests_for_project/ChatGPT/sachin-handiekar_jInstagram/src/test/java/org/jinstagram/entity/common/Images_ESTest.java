// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Images_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:42:55 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.ImageData;
import org.jinstagram.entity.common.Images;
import org.junit.runner.RunWith;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.ImageData;
import org.jinstagram.entity.common.Images;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Images_ESTest extends Images_ESTest_scaffolding {

    @Test
    public void testGetStandardResolution() {
        // Create an instance of the Images class
        Images images = new Images();

        // Create an instance of ImageData for standard resolution
        ImageData standardResolution = new ImageData();

        // Set the standard resolution image data
        images.setStandardResolution(standardResolution);

        // Call the getStandardResolution() method
        ImageData result = images.getStandardResolution();

        // Assert that the returned value is equal to the set value
        assertEquals(standardResolution, result);
    }

@Test
public void testToString() {
    // Create test data
    ImageData lowResolution = new ImageData();
    ImageData thumbnail = new ImageData();
    ImageData standardResolution = new ImageData();
    
    // Set test data
    Images images = new Images();
    images.setLowResolution(lowResolution);
    images.setThumbnail(thumbnail);
    images.setStandardResolution(standardResolution);
    
    // Call the method under test
    String result = images.toString();
    
    // Verify the result
    String expected = String.format("Images [lowResolution=%s, standardResolution=%s, thumbnail=%s]", lowResolution, standardResolution, thumbnail);
    assertEquals(expected, result);
}

    @Test
    public void testGetThumbnail() {
        // Create an instance of Images
        Images images = new Images();

        // Create an instance of ImageData for thumbnail
        ImageData thumbnail = new ImageData();

        // Set the thumbnail in Images
        images.setThumbnail(thumbnail);

        // Call the getThumbnail() method
        ImageData result = images.getThumbnail();

        // Assert that the returned thumbnail is the same as the one set
        assertEquals(thumbnail, result);
    }

    @Test
    public void testGetLowResolution() {
        // Create an instance of Images
        Images images = new Images();

        // Create an instance of ImageData for low resolution
        ImageData lowResolution = new ImageData();
        // Set the low resolution image data
        images.setLowResolution(lowResolution);

        // Call the getLowResolution() method
        ImageData result = images.getLowResolution();

        // Assert that the returned value is equal to the set low resolution image data
        assertEquals(lowResolution, result);
    }

    @Test
    public void testSetLowResolution() {
        // Create an instance of the Images class
        Images images = new Images();

        // Create an instance of the ImageData class
        ImageData lowResolution = new ImageData();

        // Set the low resolution image data using the setLowResolution method
        images.setLowResolution(lowResolution);

        // Verify that the low resolution image data is set correctly
        assertEquals(lowResolution, images.getLowResolution());
    }

    @Test
    public void testSetThumbnail() {
        // Create an instance of the Images class
        Images images = new Images();

        // Create a sample ImageData object
        ImageData thumbnail = new ImageData();

        // Set the thumbnail using the setThumbnail method
        images.setThumbnail(thumbnail);

        // Verify that the thumbnail is set correctly
        assertEquals(thumbnail, images.getThumbnail());
    }

    @Test
    public void testSetStandardResolution() {
        // Create a new instance of the Images class
        Images images = new Images();

        // Create a new instance of the ImageData class
        ImageData standardResolution = new ImageData();

        // Set the standard resolution using the setStandardResolution method
        images.setStandardResolution(standardResolution);

        // Verify that the standard resolution has been set correctly
        assertEquals(standardResolution, images.getStandardResolution());
    }

}