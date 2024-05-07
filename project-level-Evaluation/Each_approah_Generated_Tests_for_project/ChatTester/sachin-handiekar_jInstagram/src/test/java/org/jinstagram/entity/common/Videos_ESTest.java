// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Videos_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:57:54 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.VideoData;
import org.jinstagram.entity.common.Videos;
import org.junit.runner.RunWith;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.VideoData;
import org.jinstagram.entity.common.Videos;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Videos_ESTest extends Videos_ESTest_scaffolding {

    @Test
    public void testSetStandardResolution() {
        // Given
        VideoData videoData = new VideoData();
        Videos videos = new Videos();

        // When
        videos.setStandardResolution(videoData);

        // Then
        assertEquals(videoData, videos.getStandardResolution());
    }

    @Test
    public void testSetLowResolution() {
        // Given
        Videos videos = new Videos();
        VideoData expectedLowResolution = new VideoData();
        
        // When
        videos.setLowResolution(expectedLowResolution);
        VideoData actualLowResolution = videos.getLowResolution();
        
        // Then
        assertEquals(expectedLowResolution, actualLowResolution);
    }

    @Test
    public void testGetLowResolution() {
        Videos videos = new Videos();
        VideoData expectedLowResolution = new VideoData();
        
        videos.setLowResolution(expectedLowResolution);
        VideoData actualLowResolution = videos.getLowResolution();
        
        assertNotNull(actualLowResolution);
        assertEquals(expectedLowResolution, actualLowResolution);
    }

    @Test
    public void testGetStandardResolution() {
        Videos videos = new Videos();
        VideoData expectedStandardResolution = new VideoData();
        videos.setStandardResolution(expectedStandardResolution);

        VideoData actualStandardResolution = videos.getStandardResolution();

        assertEquals(expectedStandardResolution, actualStandardResolution);
    }

}
