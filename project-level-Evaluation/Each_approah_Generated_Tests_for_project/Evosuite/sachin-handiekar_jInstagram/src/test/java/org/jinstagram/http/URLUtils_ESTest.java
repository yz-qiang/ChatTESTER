/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:48:19 GMT 2024
 */
package org.jinstagram.http;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.HashMap;
import java.util.Map;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.http.URLUtils;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class URLUtils_ESTest extends URLUtils_ESTest_scaffolding {


@Test(timeout = 4000)
public void test02() throws Throwable {
    // Undeclared exception!
    try {
        URLUtils.queryStringToMap("=");
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
    } catch (ArrayIndexOutOfBoundsException e) {
        // 
        // 0
        // 
        verifyException("org.jinstagram.http.URLUtils", e);
    }
}

@Test(timeout = 4000)
public void test03() throws Throwable {
    // Undeclared exception!
    try {
        URLUtils.concatSortedPercentEncodedParams((Map<String, String>) null);
        fail("Expecting exception: NullPointerException");
    } catch (NullPointerException e) {
        // 
        // no message in exception (getMessage() returned null)
        // 
        verifyException("org.jinstagram.http.URLUtils", e);
    }
}

@Test(timeout = 4000)
public void test05() throws Throwable {
    String string0 = URLUtils.decodeURIComponent("^[a-zA-Z][a-zA-Z0-9+.-]*://S+");
    assertEquals("^[a-zA-Z][a-zA-Z0-9 .-]*://S ", string0);
}

}