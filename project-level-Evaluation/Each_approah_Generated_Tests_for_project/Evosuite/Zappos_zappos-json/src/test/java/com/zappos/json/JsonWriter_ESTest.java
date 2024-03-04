/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 14:01:13 GMT 2024
 */
package com.zappos.json;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.JsonConfig;
import com.zappos.json.JsonWriter;
import com.zappos.json.ZapposJson;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.io.MockFile;
import org.evosuite.runtime.mock.java.io.MockFileWriter;
import org.evosuite.runtime.mock.java.io.MockPrintWriter;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class JsonWriter_ESTest extends JsonWriter_ESTest_scaffolding {

@Test(timeout = 4000)
public void test00() throws Throwable {
    StringWriter stringWriter0 = new StringWriter();
    ZapposJson zapposJson0 = new ZapposJson(false);
    // Undeclared exception!
    try {
        JsonWriter.writeBoolean(zapposJson0, (Boolean) null, stringWriter0);
        fail("Expecting exception: NullPointerException");
    } catch (NullPointerException e) {
        // 
        // no message in exception (getMessage() returned null)
        // 
        verifyException("com.zappos.json.JsonWriter", e);
    }
}

@Test(timeout = 4000)
public void test01() throws Throwable {
    byte[] byteArray0 = new byte[8];
    // Undeclared exception!
    try {
        JsonWriter.writeBase64String((ZapposJson) null, byteArray0, (Writer) null);
        fail("Expecting exception: NullPointerException");
    } catch (NullPointerException e) {
        // 
        // no message in exception (getMessage() returned null)
        // 
        verifyException("com.zappos.json.JsonWriter", e);
    }
}

@Test(timeout = 4000)
public void test02() throws Throwable {
    ZapposJson zapposJson0 = ZapposJson.getInstance("TG$gvGV}05y");
}

@Test(timeout = 4000)
public void test03() throws Throwable {
    CharArrayWriter charArrayWriter0 = new CharArrayWriter();
    // Undeclared exception!
    try {
        JsonWriter.writeArray((boolean[]) null, (Writer) charArrayWriter0);
        fail("Expecting exception: NullPointerException");
    } catch (NullPointerException e) {
        // 
        // no message in exception (getMessage() returned null)
        // 
        verifyException("com.zappos.json.JsonWriter", e);
    }
}

}