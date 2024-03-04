// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Meta_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:48:49 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.junit.runner.RunWith;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Meta_ESTest extends Meta_ESTest_scaffolding {

    @Test
    public void testGetErrorType() {
        // Create an instance of Meta
        Meta meta = new Meta();

        // Set the error type
        String errorType = "Runtime Error";
        meta.setErrorType(errorType);

        // Retrieve the error type using the getErrorType() method
        String retrievedErrorType = meta.getErrorType();

        // Assert that the retrieved error type matches the expected error type
        assertEquals(errorType, retrievedErrorType);
    }

@Test
public void testToString() {
    // Create a Meta object with sample values
    Meta meta = new Meta();
    meta.setCode(200);
    meta.setErrorMessage("Success");
    meta.setErrorType("Info");

    // Call the toString() method
    String result = meta.toString();

    // Verify the generated string representation
    String expected = "Meta [code=200, errorMessage=Success, errorType=Info]";
    assertEquals(expected, result);
}

    @Test
    public void testGetErrorMessage() {
        // Create an instance of Meta
        Meta meta = new Meta();

        // Set the error message
        String errorMessage = "This is an error message";
        meta.setErrorMessage(errorMessage);

        // Retrieve the error message using the getErrorMessage() method
        String retrievedErrorMessage = meta.getErrorMessage();

        // Assert that the retrieved error message is equal to the set error message
        assertEquals(errorMessage, retrievedErrorMessage);
    }

    @Test
    public void testSetErrorType() {
        // Create an instance of Meta
        Meta meta = new Meta();

        // Set the error type using the setErrorType method
        String errorType = "Runtime Error";
        meta.setErrorType(errorType);

        // Verify that the error type is set correctly
        assertEquals(errorType, meta.getErrorType());
    }

    @Test
    public void testSetErrorMessage() {
        // Create an instance of Meta
        Meta meta = new Meta();

        // Set the error message
        String errorMessage = "This is an error message";
        meta.setErrorMessage(errorMessage);

        // Verify that the error message is set correctly
        assertEquals(errorMessage, meta.getErrorMessage());
    }

    @Test
    public void testSetCode() {
        // Create an instance of Meta
        Meta meta = new Meta();

        // Set the code using the setCode method
        meta.setCode(123);

        // Verify that the code has been set correctly
        assertEquals(123, meta.getCode());
    }

    @Test
    public void testGetCode() {
        // Create an instance of Meta
        Meta meta = new Meta();
        
        // Set the code value
        meta.setCode(123);
        
        // Retrieve the code value using getCode() method
        int code = meta.getCode();
        
        // Assert that the retrieved code value is equal to the expected value
        assertEquals(123, code);
    }

}