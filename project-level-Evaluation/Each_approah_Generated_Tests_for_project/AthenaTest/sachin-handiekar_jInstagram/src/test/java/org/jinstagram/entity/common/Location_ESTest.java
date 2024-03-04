/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:46:49 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Location;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Location_ESTest extends Location_ESTest_scaffolding {
    @Test 
    public void testSetName() throws Exception { 
    Location location = new Location();
    location.setName("name");
    assertEquals("name", location.getName());
    }
    
    
    @Test 
    public void testSetLongitude() throws Exception { 
    Location location = new Location();
    location.setLongitude(0.0);
    assertEquals(0.0, location.getLongitude(), 0.0);
    }
    
    
    @Test 
    public void testSetLatitude() { 
    Location location = new Location();
    location.setLatitude(1.0);
    assertEquals(1.0, location.getLatitude(), 0.0);
    }
    
    
    @Test 
    public void testGetLatitude() { 
    System.out.println("getLatitude");
    Location instance = new Location();
    double expResult = 0.0;
    double result = instance.getLatitude();
    assertEquals(expResult, result, 0.0);
    }
    
    
    @Test 
    public void testSetId() { 
    Location location = new Location();
    location.setId("id");
    assertEquals("id", location.getId());
    }
    
    
    @Test 
    public void testGetId() { 
    System.out.println("getId");
    Location instance = new Location();
    String id = instance.getId();
    assertEquals(id, id);
    }
    
}