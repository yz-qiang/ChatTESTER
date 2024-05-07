/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:37:02 GMT 2024
 */
package org.jinstagram.exceptions;


import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.exceptions.InstagramException;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class InstagramException_ESTest extends InstagramException_ESTest_scaffolding {


@Test(timeout = 4000)
public void test0() throws Throwable {
    InstagramException instagramException0 = new InstagramException((String) null);
    int int0 = instagramException0.getAPILimitStatus();
    assertEquals((-1), int0);
}


@Test(timeout = 4000)
public void test1() throws Throwable {
    InstagramException instagramException0 = new InstagramException((String) null);
    String string0 = instagramException0.getErrorType();
    assertNull(string0);
}


@Test(timeout = 4000)
public void test2() throws Throwable {
    HashMap<String, String> hashMap0 = new HashMap<String, String>();
    InstagramException instagramException0 = new InstagramException("?^a }#%%", "", hashMap0);
    InstagramException instagramException1 = new InstagramException("?^a }#%%", instagramException0, (Map<String, String>) null);
    int int0 = instagramException1.getRemainingLimitStatus();
    assertEquals((-1), int0);
}

}
