// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/http/APILimitUtils_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:39:18 GMT 2024
 */
package org.jinstagram.http;

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
import org.jinstagram.http.APILimitUtils;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class APILimitUtils_ESTest extends APILimitUtils_ESTest_scaffolding {

@Test
public void testGetAPILimitStatus() {
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("X-Ratelimit-Limit", "10");
    int limitStatus = APILimitUtils.getAPILimitStatus(headers);
    assertEquals(10, limitStatus);
}

}
