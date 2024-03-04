// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/JsonReader_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:53:16 GMT 2024
 */
package com.zappos.json;

import org.junit.Test;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.JsonReader;
import com.zappos.json.ZapposJson;
import java.io.IOException;
import java.io.PipedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class JsonReader_ESTest extends JsonReader_ESTest_scaffolding {

@Test(timeout = 4000)
public void testParse() throws Throwable {
    // Create a new JsonReader object with a null ZapposJson and null Reader
    JsonReader jsonReader = new JsonReader(null, (Reader) null);
    
    // Undeclared exception!
    try {
        // Call the parse() method on the JsonReader object
        jsonReader.parse();
        
        // Fail the test if no exception is thrown
        fail("Expecting exception: NullPointerException");
    } catch (NullPointerException e) {
        // Verify that the exception is of type NullPointerException
        verifyException("com.zappos.json.JsonReader", e);
    }
}

}