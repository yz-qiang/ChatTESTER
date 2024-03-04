// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/GridPosition_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:38:49 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.GridPosition;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class GridPosition_ESTest extends GridPosition_ESTest_scaffolding {

    @Test
    public void testGetY() {
        // Create an instance of GridPosition
        GridPosition gridPosition = new GridPosition();
        
        // Set the value of y using the setY() method
        double expectedY = 5.0;
        gridPosition.setY(expectedY);
        
        // Call the getY() method and assert that it returns the expected value
        double actualY = gridPosition.getY();
        assertEquals(expectedY, actualY, 0.001);
    }

    @Test
    public void testSetY() {
        // Create a new GridPosition object
        GridPosition gridPosition = new GridPosition();

        // Set the initial value of y
        double initialY = 0.0;
        gridPosition.setY(initialY);

        // Verify that the initial value of y is set correctly
        assertEquals(initialY, gridPosition.getY(), 0.0);

        // Set a new value of y
        double newY = 5.0;
        gridPosition.setY(newY);

        // Verify that the new value of y is set correctly
        assertEquals(newY, gridPosition.getY(), 0.0);
    }

    @Test
    public void testGetX() {
        // Create an instance of GridPosition
        GridPosition gridPosition = new GridPosition();
        
        // Set the value of x using the setX() method
        double expectedX = 5.0;
        gridPosition.setX(expectedX);
        
        // Retrieve the value of x using the getX() method
        double actualX = gridPosition.getX();
        
        // Assert that the retrieved value of x matches the expected value
        assertEquals(expectedX, actualX, 0.0);
    }

    @Test
    public void testSetX() {
        // Create an instance of GridPosition
        GridPosition gridPosition = new GridPosition();

        // Set the value of x using the setX method
        double expectedX = 5.0;
        gridPosition.setX(expectedX);

        // Verify that the value of x has been set correctly
        double actualX = gridPosition.getX();
        assertEquals(expectedX, actualX, 0.001);
    }

}
