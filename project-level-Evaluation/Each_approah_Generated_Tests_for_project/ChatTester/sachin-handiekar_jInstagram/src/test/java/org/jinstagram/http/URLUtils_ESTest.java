// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/http/URLUtils_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:48:19 GMT 2024
 */
package org.jinstagram.http;

import java.util.Map;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.HashMap;
import java.util.Map;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.http.URLUtils;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.HashMap;
import java.util.Map;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.http.URLUtils;
import org.junit.runner.RunWith;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.HashMap;
import java.util.Map;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.http.URLUtils;
import org.junit.runner.RunWith;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
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

    @Test
    public void testPercentEncode() {
        // Test case 1: Empty string
        String input1 = "";
        String expected1 = "";
        String result1 = URLUtils.percentEncode(input1);
        assertEquals(expected1, result1);

        // Test case 2: String with special characters
        String input2 = "Hello World!";
        String expected2 = "Hello%20World%21";
        String result2 = URLUtils.percentEncode(input2);
        assertEquals(expected2, result2);

        // Test case 3: String with non-ASCII characters
        String input3 = "こんにちは";
        String expected3 = "%E3%81%93%E3%82%93%E3%81%AB%E3%81%A1%E3%81%AF";
        String result3 = URLUtils.percentEncode(input3);
        assertEquals(expected3, result3);

        // Test case 4: String with special characters and non-ASCII characters
        String input4 = "Hello こんにちは!";
        String expected4 = "Hello%20%E3%81%93%E3%82%93%E3%81%AB%E3%81%A1%E3%81%AF%21";
        String result4 = URLUtils.percentEncode(input4);
        assertEquals(expected4, result4);
    }

@Test
public void testAppendParametersToQueryString_withEmptyParams() {
    String url = "https://example.com";
    Map<String, String> params = new HashMap<String, String>();

    String result = URLUtils.appendParametersToQueryString(url, params);
    assertEquals("https://example.com", result);
}

    @Test
    public void testQueryStringToMap() {
        // Test case 1: queryString is null
        String queryString1 = null;
        Map<String, String> result1 = URLUtils.queryStringToMap(queryString1);
        assertNotNull(result1);
        assertTrue(result1.isEmpty());

        // Test case 2: queryString is empty
        String queryString2 = "";
        Map<String, String> result2 = URLUtils.queryStringToMap(queryString2);
        assertNotNull(result2);
        assertTrue(result2.isEmpty());

        // Test case 3: queryString with single parameter
        String queryString3 = "key1=value1";
        Map<String, String> result3 = URLUtils.queryStringToMap(queryString3);
        assertNotNull(result3);
        assertEquals(1, result3.size());
        assertEquals("value1", result3.get("key1"));

        // Test case 4: queryString with multiple parameters
        String queryString4 = "key1=value1&key2=value2&key3=value3";
        Map<String, String> result4 = URLUtils.queryStringToMap(queryString4);
        assertNotNull(result4);
        assertEquals(3, result4.size());
        assertEquals("value1", result4.get("key1"));
        assertEquals("value2", result4.get("key2"));
        assertEquals("value3", result4.get("key3"));

        // Test case 5: queryString with encoded values
        String queryString5 = "key1=value%201&key2=value%202";
        Map<String, String> result5 = URLUtils.queryStringToMap(queryString5);
        assertNotNull(result5);
        assertEquals(2, result5.size());
        assertEquals("value 1", result5.get("key1"));
        assertEquals("value 2", result5.get("key2"));
    }

@Test
public void testFormURLEncodeMap_withNonNullMap() {
    Map<String, String> map = new HashMap<String, String>();

    map.put("key1", "value1");
    map.put("key2", "value2");
    String result = URLUtils.formURLEncodeMap(map);
    assertNotNull(result);
    assertFalse(result.isEmpty());
    assertTrue(result.contains("key1=value1"));
    assertTrue(result.contains("key2=value2"));
}

    @Test
    public void testFormURLDecode() {
        String encodedString = "Hello%20World%21";
        String expectedDecodedString = "Hello World!";
        String decodedString = URLUtils.formURLDecode(encodedString);
        assertEquals(expectedDecodedString, decodedString);
    }

@Test(timeout = 4000)
public void test00() throws Throwable {
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

    @Test
    public void testDecodeURIComponent() {
        // Test case 1: Decoding a URL-encoded string
        String encodedString = "Hello%20World%21";
        String expectedDecodedString = "Hello World!";
        String decodedString = URLUtils.decodeURIComponent(encodedString);
        assertEquals(expectedDecodedString, decodedString);

        // Test case 2: Decoding an empty string
        encodedString = "";
        expectedDecodedString = "";
        decodedString = URLUtils.decodeURIComponent(encodedString);
        assertEquals(expectedDecodedString, decodedString);

        // Test case 3: Decoding a string with special characters
        encodedString = "%24%25%26%2B%2C%2F%3A%3B%3D%3F%40";
        expectedDecodedString = "$%&+,/:;=?@";
        decodedString = URLUtils.decodeURIComponent(encodedString);
        assertEquals(expectedDecodedString, decodedString);

        // Test case 4: Decoding a string with non-URL-encoded characters
        encodedString = "Hello World!";
        expectedDecodedString = "Hello World!";
        decodedString = URLUtils.decodeURIComponent(encodedString);
        assertEquals(expectedDecodedString, decodedString);
    }

}
