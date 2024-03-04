// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Pagination_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:50:55 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Pagination;
import org.junit.runner.RunWith;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Pagination;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Pagination_ESTest extends Pagination_ESTest_scaffolding {

    @Test
    public void testSetNextCursor() {
        Pagination pagination = new Pagination();
        String nextCursor = "12345";
        pagination.setNextCursor(nextCursor);
        assertEquals(nextCursor, pagination.getNextCursor());
    }

    @Test
    public void testGetNextMinId() {
        Pagination pagination = new Pagination();
        String expected = "nextMinIdValue";
        pagination.setNextMinId(expected);
        
        String actual = pagination.getNextMinId();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNextUrl() {
        Pagination pagination = new Pagination();
        String expected = "https://example.com/next";
        pagination.setNextUrl(expected);
        
        String actual = pagination.getNextUrl();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSetDepreciationWarning() {
        Pagination pagination = new Pagination();
        String depreciationWarning = "This is a depreciation warning.";

        pagination.setDepreciationWarning(depreciationWarning);

        assertEquals(depreciationWarning, pagination.getDepreciationWarning());
    }

    @Test
    public void testGetNextCursor() {
        Pagination pagination = new Pagination();
        String expected = "nextCursorValue";
        pagination.setNextCursor(expected);
        
        String actual = pagination.getNextCursor();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMinTagId() {
        Pagination pagination = new Pagination();
        String expected = "testMinTagId";
        pagination.setMinTagId(expected);
        
        String actual = pagination.getMinTagId();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSetMinTagId() {
        Pagination pagination = new Pagination();
        String minTagId = "12345";
        pagination.setMinTagId(minTagId);
        assertEquals(minTagId, pagination.getMinTagId());
    }

@Test
public void testHasNextPage() {
    Pagination pagination = new Pagination();
    
    // Test case 1: nextUrl is blank
    pagination.setNextUrl("");
    assertFalse(pagination.hasNextPage());
    
    // Test case 2: nextUrl is not blank
    pagination.setNextUrl("https://example.com");
    assertTrue(pagination.hasNextPage());
}

    @Test
    public void testGetNextMaxId() {
        Pagination pagination = new Pagination();
        String expected = "expected value";
        pagination.setNextMaxId(expected);
        
        String actual = pagination.getNextMaxId();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSetNextUrl() {
        Pagination pagination = new Pagination();
        String nextUrl = "https://example.com/next";
        pagination.setNextUrl(nextUrl);
        assertEquals(nextUrl, pagination.getNextUrl());
    }

    @Test
    public void testSetNextMaxTagId() {
        Pagination pagination = new Pagination();
        String nextMaxTagId = "12345";
        pagination.setNextMaxTagId(nextMaxTagId);
        assertEquals(nextMaxTagId, pagination.getNextMaxTagId());
    }

    @Test
    public void testSetNextMinId() {
        Pagination pagination = new Pagination();
        String nextMinId = "12345";
        pagination.setNextMinId(nextMinId);
        assertEquals(nextMinId, pagination.getNextMinId());
    }

    @Test
    public void testGetNextMaxTagId() {
        Pagination pagination = new Pagination();
        String expected = "nextMaxTagId";
        pagination.setNextMaxTagId(expected);
        
        String actual = pagination.getNextMaxTagId();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDepreciationWarning() {
        Pagination pagination = new Pagination();
        String expectedDepreciationWarning = "This method is deprecated";
        pagination.setDepreciationWarning(expectedDepreciationWarning);

        String actualDepreciationWarning = pagination.getDepreciationWarning();

        assertEquals(expectedDepreciationWarning, actualDepreciationWarning);
    }

@Test
public void testToString() {
    // Create a Pagination object
    Pagination pagination = new Pagination();
    
    // Set values for the Pagination object
    pagination.setDepreciationWarning("Depreciation Warning");
    pagination.setMinTagId("Min Tag ID");
    pagination.setNextMaxId("Next Max ID");
    pagination.setNextMaxTagId("Next Max Tag ID");
    pagination.setNextMinId("Next Min ID");
    pagination.setNextUrl("Next URL");
    
    // Expected result
    String expected = "Pagination [depreciationWarning=Depreciation Warning, minTagId=Min Tag ID, nextMaxId=Next Max ID, nextMaxTagId=Next Max Tag ID, nextMinId=Next Min ID, nextUrl=Next URL]";
    
    // Call the toString() method
    String result = pagination.toString();
    
    // Assert the result
    assertEquals(expected, result);
}

    @Test
    public void testSetNextMaxId() {
        Pagination pagination = new Pagination();
        String nextMaxId = "12345";
        pagination.setNextMaxId(nextMaxId);
        assertEquals(nextMaxId, pagination.getNextMaxId());
    }

}