// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/format/JavaTimeInstantFormatter_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:40:01 GMT 2024
 */
package com.zappos.json.format;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.format.JavaTimeInstantFormatter;
import com.zappos.json.format.ValueFormatter;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockInstant;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class JavaTimeInstantFormatter_ESTest extends JavaTimeInstantFormatter_ESTest_scaffolding {

    @Test
    public void testNewInstance() {
        JavaTimeInstantFormatter formatter = new JavaTimeInstantFormatter();
        ValueFormatter<Instant> newInstance = formatter.newInstance();
        
        assertNotNull(newInstance);
        assertTrue(newInstance instanceof JavaTimeInstantFormatter);
    }

    @Test
    public void testSetPattern() {
        JavaTimeInstantFormatter formatter = new JavaTimeInstantFormatter();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        
        ValueFormatter<Instant> result = formatter.setPattern(pattern);
        
        assertNotNull(result);
        assertEquals(pattern, formatter.getPattern());
    }

    @Test
    public void testCast() {
        JavaTimeInstantFormatter formatter = new JavaTimeInstantFormatter();
        
        // Test case 1: Valid Instant object
        Object obj1 = Instant.now();
        Instant result1 = formatter.cast(obj1);
        assertEquals(obj1, result1);
        
        // Test case 2: Invalid object type
        Object obj2 = "2021-01-01T00:00:00Z";
        try {
            Instant result2 = formatter.cast(obj2);
            fail("Expected ClassCastException to be thrown");
        } catch (ClassCastException e) {
            // Exception expected
        }
        
        // Test case 3: Null object
        Object obj3 = null;
        Instant result3 = formatter.cast(obj3);
        assertNull(result3);
    }

}
