// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/users/basicinfo/UserInfo_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:22:05 GMT 2024
 */
package org.jinstagram.entity.users.basicinfo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.entity.users.basicinfo.UserInfoData;
import org.junit.runner.RunWith;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.entity.users.basicinfo.UserInfoData;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class UserInfo_ESTest extends UserInfo_ESTest_scaffolding {

    @Test
    public void testSetData() {
        // Create a new instance of UserInfo
        UserInfo userInfo = new UserInfo();

        // Create a new instance of UserInfoData
        UserInfoData data = new UserInfoData();

        // Set the data using the setData method
        userInfo.setData(data);

        // Verify that the data is set correctly
        assertEquals(data, userInfo.getData());
    }

@Test
public void testGetMeta() {
    // Create a new instance of UserInfo
    UserInfo userInfo = new UserInfo();

    // Create a new instance of Meta
    Meta expectedMeta = new Meta();

    // Set the expected Meta object in UserInfo
    userInfo.setMeta(expectedMeta);

    // Call the getMeta() method
    Meta actualMeta = userInfo.getMeta();

    // Assert that the returned Meta object is equal to the expected Meta object
    assertEquals(expectedMeta, actualMeta);
}

    @Test
    public void testGetData() {
        // Create a new instance of UserInfo
        UserInfo userInfo = new UserInfo();

        // Create a new instance of UserInfoData
        UserInfoData expectedData = new UserInfoData();

        // Set the expected data in the UserInfo instance
        userInfo.setData(expectedData);

        // Call the getData() method and store the result
        UserInfoData actualData = userInfo.getData();

        // Assert that the actual data is equal to the expected data
        assertEquals(expectedData, actualData);
    }

@Test
public void testSetMeta() {
    // Create a new instance of UserInfo
    UserInfo userInfo = new UserInfo();

    // Create a new instance of Meta
    Meta meta = new Meta();

    // Set the Meta instance to the UserInfo instance
    userInfo.setMeta(meta);

    // Verify that the Meta instance is set correctly
    assertEquals(meta, userInfo.getMeta());
}

}
