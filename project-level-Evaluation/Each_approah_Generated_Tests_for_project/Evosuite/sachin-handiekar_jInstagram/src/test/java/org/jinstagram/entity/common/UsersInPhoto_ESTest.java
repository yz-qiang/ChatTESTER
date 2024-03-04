/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:53:50 GMT 2024
 */
package org.jinstagram.entity.common;


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

@Test(timeout = 4000)
public void test0() throws Throwable {
    UsersInPhoto usersInPhoto0 = new UsersInPhoto();
    User user0 = new User();
    usersInPhoto0.setUser(user0);
    User user1 = usersInPhoto0.getUser();
    assertNull(user1.getFullName());
}

@Test(timeout = 4000)
public void test1() throws Throwable {
    UsersInPhoto usersInPhoto0 = new UsersInPhoto();
    User user0 = new User();
    usersInPhoto0.setUser(user0);
    User user1 = usersInPhoto0.getUser();
    assertNull(user1.getFullName());
}

@Test(timeout = 4000)
public void test2() throws Throwable {
    UsersInPhoto usersInPhoto0 = new UsersInPhoto();
    GridPosition gridPosition0 = new GridPosition();
    usersInPhoto0.setPosition(gridPosition0);
    gridPosition0.setY(1.0);
    GridPosition gridPosition1 = usersInPhoto0.getPosition();
    assertSame(gridPosition1, gridPosition0);
}

@Test(timeout = 4000)
public void test3() throws Throwable {
    UsersInPhoto usersInPhoto0 = new UsersInPhoto();
    GridPosition gridPosition0 = new GridPosition();
    usersInPhoto0.setPosition(gridPosition0);
    gridPosition0.setY(1.0);
    GridPosition gridPosition1 = usersInPhoto0.getPosition();
    assertSame(gridPosition1, gridPosition0);
}

}
