// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/util/JsonUtils_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 14:07:05 GMT 2024
 */
package com.zappos.json.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import com.zappos.json.JsonConfig.WriterConfig;
import com.zappos.json.ZapposJson;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.util.JsonUtils;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.util.JsonUtils;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class JsonUtils_ESTest extends JsonUtils_ESTest_scaffolding {

@Test
public void testEscape() throws IOException {
    ZapposJson zapposJson = ZapposJson.getInstance();

    CharSequence value = "Hello, \"World\"!";
    StringWriter writer = new StringWriter();
    JsonUtils.escape(zapposJson, value, writer);
    String escapedValue = writer.toString();
    assertEquals("Hello, \\\"World\\\"!", escapedValue);
}

@Test
public void testEscape_2() throws IOException {
    ZapposJson zapposJson = ZapposJson.getInstance();

    StringWriter writer = new StringWriter();
    CharSequence value = "Hello, \"World\"!";
    JsonUtils.escape(zapposJson, value, writer);
    assertEquals("Hello, \\\"World\\\"!", writer.toString());
}

@Test
public void testUnescape() {
    ZapposJson zapposJson = ZapposJson.getInstance("f[lX;J:ziZx\"");

    CharSequence value = "Hello\\nWorld";
    String expected = "Hello\nWorld";
    StringWriter writer = new StringWriter();
    try {
        JsonUtils.unescape(zapposJson, value, writer);
    } catch (IOException e) {
        fail("IOException occurred");
    }
    String actual = writer.toString();
    assertEquals(expected, actual);
}

}
