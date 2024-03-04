// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/UsersInPhoto_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:53:50 GMT 2024
 */
package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.GridPosition;
import org.jinstagram.entity.common.User;
import org.jinstagram.entity.common.UsersInPhoto;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class UsersInPhoto_ESTest extends UsersInPhoto_ESTest_scaffolding {

    @Test
    public void testSetUser() {
        // Create a new UsersInPhoto object
        UsersInPhoto usersInPhoto = new UsersInPhoto();

        // Create a new User object
        User user = new User();

        // Set the user object using the setUser method
        usersInPhoto.setUser(user);

        // Verify that the user object is set correctly
        assertEquals(user, usersInPhoto.getUser());
    }

@Test
public void testGetUser() {
    User user = new User();
    user.setFullName("John Doe");

    UsersInPhoto usersInPhoto = new UsersInPhoto();
    usersInPhoto.setUser(user);
    User result = usersInPhoto.getUser();
    assertEquals(user, result);
}

@Test
public void testSetPosition() {
    UsersInPhoto usersInPhoto = new UsersInPhoto();

    GridPosition position = new GridPosition();
    position.setX(2);
    position.setY(3);

    usersInPhoto.setPosition(position);
    assertEquals(position, usersInPhoto.getPosition());
}

@Test
public void testGetPosition() {
    UsersInPhoto usersInPhoto = new UsersInPhoto();
    GridPosition expectedPosition = new GridPosition();
    expectedPosition.setY(2.0);
    usersInPhoto.setPosition(expectedPosition);
    GridPosition actualPosition = usersInPhoto.getPosition();
    assertSame(expectedPosition, actualPosition);
}

}