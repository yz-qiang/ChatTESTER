/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:57:54 GMT 2024
 */
package org.jinstagram.entity.common;


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

@Test(timeout = 4000)
public void test00() throws Throwable {
    Videos videos0 = new Videos();
    VideoData videoData0 = new VideoData();
    videos0.setStandardResolution(videoData0);
    videoData0.setWidth(886);
    VideoData videoData1 = videos0.getStandardResolution();
    assertSame(videoData1, videoData0);
}

@Test(timeout = 4000)
public void test01() throws Throwable {
    Videos videos0 = new Videos();
    VideoData videoData0 = new VideoData();
    videoData0.setWidth(1270);
    videos0.setLowResolution(videoData0);
    VideoData videoData1 = videos0.getLowResolution();
    assertSame(videoData1, videoData0);
}

@Test(timeout = 4000)
public void test02() throws Throwable {
    Videos videos0 = new Videos();
    VideoData videoData0 = new VideoData();
    videos0.setStandardResolution(videoData0);
    videoData0.setWidth(886);
    VideoData videoData1 = videos0.getStandardResolution();
    assertSame(videoData1, videoData0);
}

@Test(timeout = 4000)
public void test03() throws Throwable {
    Videos videos0 = new Videos();
    VideoData videoData0 = new VideoData();
    videoData0.setWidth(1270);
    videos0.setLowResolution(videoData0);
    VideoData videoData1 = videos0.getLowResolution();
    assertSame(videoData1, videoData0);
}

}
