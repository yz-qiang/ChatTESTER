// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/format/NoOpValueFormatter_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:46:01 GMT 2024
 */
package com.zappos.json.format;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.format.NoOpValueFormatter;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class NoOpValueFormatter_ESTest extends NoOpValueFormatter_ESTest_scaffolding {

    @Test
    public void testCast() {
        // Create an instance of NoOpValueFormatter
        NoOpValueFormatter formatter = new NoOpValueFormatter();

        // Test case 1: Verify that the method returns the input object as is
        Object input1 = "Test";
        Object result1 = formatter.cast(input1);
        assertEquals(input1, result1);

        // Test case 2: Verify that the method returns the input object as is
        Object input2 = 123;
        Object result2 = formatter.cast(input2);
        assertEquals(input2, result2);

        // Test case 3: Verify that the method returns the input object as is
        Object input3 = new Object();
        Object result3 = formatter.cast(input3);
        assertEquals(input3, result3);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNewInstance() {
        NoOpValueFormatter formatter = new NoOpValueFormatter();
        formatter.newInstance();
    }

}
