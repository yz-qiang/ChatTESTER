/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:14:28 GMT 2024
 */
package org.jinstagram.entity.tags;


import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.tags.TagInfoData;
import org.jinstagram.entity.tags.TagInfoFeed;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class TagInfoFeed_ESTest extends TagInfoFeed_ESTest_scaffolding {


@Test(timeout = 4000)
public void test0() throws Throwable {
    TagInfoFeed tagInfoFeed0 = new TagInfoFeed();
    TagInfoData tagInfoData0 = new TagInfoData();
    tagInfoFeed0.setTagInfo(tagInfoData0);
    TagInfoData tagInfoData1 = tagInfoFeed0.getTagInfo();
    assertSame(tagInfoData1, tagInfoData0);
}


@Test(timeout = 4000)
public void test1() throws Throwable {
    TagInfoFeed tagInfoFeed0 = new TagInfoFeed();
    Meta meta0 = new Meta();
    meta0.setCode(2119);
    tagInfoFeed0.setMeta(meta0);
    Meta meta1 = tagInfoFeed0.getMeta();
    assertNull(meta1.getErrorType());
}


@Test(timeout = 4000)
public void test2() throws Throwable {
    TagInfoFeed tagInfoFeed0 = new TagInfoFeed();
    String string0 = tagInfoFeed0.toString();
    assertEquals("TagInfoFeed [meta=null, tagInfo=null]", string0);
}

}