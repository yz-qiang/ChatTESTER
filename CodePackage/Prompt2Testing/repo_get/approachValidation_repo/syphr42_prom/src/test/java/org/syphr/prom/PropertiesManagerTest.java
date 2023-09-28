/*
 * Copyright 2010-2012 Gregory P. Moyer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.syphr.prom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.EnumSet;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertiesManagerTest
{
    private static final double FLOATING_POINT_DELTA = 0.00001;

    private static File TEST_DATA_DIR = new File("target/test-data");

    private static File TEST_PROPS_1 = new File(TEST_DATA_DIR, "test1.properties");
    private static File TEST_PROPS_2 = new File(TEST_DATA_DIR, "test2.properties");
    private static File TEST_PROPS_2_DEFAULT = new File(TEST_DATA_DIR, "default.test2.properties");

    private static String BASE_PROPS_1_RESOURCE_PATH = "/test.base.1.properties";
    private static String BASE_PROPS_2_RESOURCE_PATH = "/test.base.2.properties";
    private static String BASE_PROPS_2_DEFAULT_RESOURCE_PATH = "/default.test.base.2.properties";

    private static Translator<Key1> TRANSLATOR1;
    private static ExecutorService EXECUTOR;

    private static Properties test2DefaultProperties;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        Assert.assertTrue("Unable to create \"" + TEST_DATA_DIR.getAbsolutePath() + "\"",
                          TEST_DATA_DIR.isDirectory() || TEST_DATA_DIR.mkdirs());

        InputStream baseIn1 = PropertiesManagerTest.class.getResourceAsStream(BASE_PROPS_1_RESOURCE_PATH);
        Assert.assertNotNull("Base properties 1 is missing", baseIn1);

        OutputStream baseOut1 = new FileOutputStream(TEST_PROPS_1);
        IOUtils.copy(baseIn1, baseOut1);

        baseIn1.close();
        baseOut1.close();

        InputStream baseIn2 = PropertiesManagerTest.class.getResourceAsStream(BASE_PROPS_2_RESOURCE_PATH);
        Assert.assertNotNull("Base properties 2 is missing", baseIn2);

        OutputStream baseOut2 = new FileOutputStream(TEST_PROPS_2);
        IOUtils.copy(baseIn2, baseOut2);

        baseIn2.close();
        baseOut2.close();

        InputStream baseIn2Default = PropertiesManagerTest.class.getResourceAsStream(BASE_PROPS_2_DEFAULT_RESOURCE_PATH);
        Assert.assertNotNull("Base properties 2 default is missing", baseIn2Default);

        baseIn2Default.mark(Integer.MAX_VALUE);

        OutputStream baseOut2Default = new FileOutputStream(TEST_PROPS_2_DEFAULT);
        IOUtils.copy(baseIn2Default, baseOut2Default);

        baseIn2Default.reset();
        test2DefaultProperties = new Properties();
        test2DefaultProperties.load(baseIn2Default);

        baseIn2Default.close();
        baseOut2Default.close();

        TRANSLATOR1 = new Translator<Key1>()
        {
            @Override
            public String getPropertyName(Key1 propertyKey)
            {
                return propertyKey.name().toLowerCase().replace('_', '-');
            }

            @Override
            public Key1 getPropertyKey(String propertyName)
            {
                String enumName = propertyName.toUpperCase().replace('-', '_');
                return Key1.valueOf(enumName);
            }
        };

        EXECUTOR = Executors.newCachedThreadPool();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        EXECUTOR.shutdownNow();
        FileUtils.deleteDirectory(TEST_DATA_DIR);
    }

    private PropertiesManager<Key1> test1Manager;
    private PropertiesManager<Key2> test2Manager;

    private PropertyListener<Key1> monitor1;
    private PropertyListener<Key2> monitor2;

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() throws IOException
    {
        test1Manager = PropertiesManagers.newManager(TEST_PROPS_1, Key1.class, TRANSLATOR1, EXECUTOR);
        test1Manager.addPropertyListener(monitor1 = EasyMock.createMock(PropertyListener.class));

        test2Manager = PropertiesManagers.newManager(TEST_PROPS_2, TEST_PROPS_2_DEFAULT, Key2.class, EXECUTOR);
        test2Manager.addPropertyListener(monitor2 = EasyMock.createMock(PropertyListener.class));
    }

    @Test
    public void testGetBooleanProperty()
    {
        Assert.assertEquals("Failed to retrieve boolean value",
                            test2Manager.getBooleanProperty(Key2.VALUE_BOOLEAN),
                            Boolean.parseBoolean(getTest2DefaultProperty(Key2.VALUE_BOOLEAN)));
    }

    @Test
    public void testGetIntegerProperty()
    {
        Assert.assertEquals("Failed to retrieve integer value",
                            test2Manager.getIntegerProperty(Key2.VALUE_INT),
                            Integer.parseInt(getTest2DefaultProperty(Key2.VALUE_INT)));
    }

    @Test(expected=NumberFormatException.class)
    public void testGetIntegerPropertyFails()
    {
        test2Manager.getIntegerProperty(Key2.VALUE_NESTED);
    }

    @Test
    public void testGetIntegerPropertyFallback()
    {
        test2Manager.setProperty(Key2.VALUE_INT, "not a number");
        Assert.assertEquals("Failed to retrieve default integer value",
                            test2Manager.getIntegerPropertyFallback(Key2.VALUE_INT),
                            Integer.parseInt(getTest2DefaultProperty(Key2.VALUE_INT)));
    }

    @Test
    public void testGetLongProperty()
    {
        Assert.assertEquals("Failed to retrieve long value",
                            test2Manager.getLongProperty(Key2.VALUE_LONG),
                            Long.parseLong(getTest2DefaultProperty(Key2.VALUE_LONG)));
    }

    @Test(expected=NumberFormatException.class)
    public void testGetLongPropertyFails()
    {
        test2Manager.getLongProperty(Key2.VALUE_NESTED);
    }

    @Test
    public void testGetLongPropertyFallback()
    {
        test2Manager.setProperty(Key2.VALUE_LONG, "not a number");
        Assert.assertEquals("Failed to retrieve default long value",
                            test2Manager.getLongPropertyFallback(Key2.VALUE_LONG),
                            Long.parseLong(getTest2DefaultProperty(Key2.VALUE_LONG)));
    }

    @Test
    public void testGetFloatProperty()
    {
        Assert.assertEquals("Failed to retrieve float value",
                            test2Manager.getFloatProperty(Key2.VALUE_FLOAT),
                            Float.parseFloat(getTest2DefaultProperty(Key2.VALUE_FLOAT)),
                            FLOATING_POINT_DELTA);
    }

    @Test(expected=NumberFormatException.class)
    public void testGetFloatPropertyFails()
    {
        test2Manager.getFloatProperty(Key2.VALUE_NESTED);
    }

    @Test
    public void testGetFloatPropertyFallback()
    {
        test2Manager.setProperty(Key2.VALUE_FLOAT, "not a number");
        Assert.assertEquals("Failed to retrieve default float value",
                            test2Manager.getFloatPropertyFallback(Key2.VALUE_FLOAT),
                            Float.parseFloat(getTest2DefaultProperty(Key2.VALUE_FLOAT)),
                            FLOATING_POINT_DELTA);
    }

    @Test
    public void testGetDoubleProperty()
    {
        Assert.assertEquals("Failed to retrieve double value",
                            test2Manager.getDoubleProperty(Key2.VALUE_DOUBLE),
                            Double.parseDouble(getTest2DefaultProperty(Key2.VALUE_DOUBLE)),
                            FLOATING_POINT_DELTA);
    }

    @Test(expected=NumberFormatException.class)
    public void testGetDoublePropertyFails()
    {
        test2Manager.getDoubleProperty(Key2.VALUE_NESTED);
    }

    @Test
    public void testGetDoublePropertyFallback()
    {
        test2Manager.setProperty(Key2.VALUE_DOUBLE, "not a number");
        Assert.assertEquals("Failed to retrieve default double value",
                            test2Manager.getDoublePropertyFallback(Key2.VALUE_DOUBLE),
                            Double.parseDouble(getTest2DefaultProperty(Key2.VALUE_DOUBLE)),
                            FLOATING_POINT_DELTA);
    }

    @Test
    public void testGetEnumProperty()
    {
        Assert.assertEquals("Failed to retrieve enum value",
                            test2Manager.getEnumProperty(Key2.VALUE_ENUM, Color.class),
                            Color.valueOf(getTest2DefaultProperty(Key2.VALUE_ENUM).toUpperCase()));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetEnumPropertyFails()
    {
        test2Manager.getEnumProperty(Key2.VALUE_NESTED, Color.class);
    }

    @Test
    public void testGetEnumPropertyFallback()
    {
        test2Manager.setProperty(Key2.VALUE_ENUM, "not a color");
        Assert.assertEquals("Failed to retrieve default enum value",
                            test2Manager.getEnumPropertyFallback(Key2.VALUE_ENUM,
                                                                 Color.class),
                            Color.valueOf(getTest2DefaultProperty(Key2.VALUE_ENUM).toUpperCase()));
    }

    private String getTest2DefaultProperty(Key2 key)
    {
        return test2DefaultProperties.getProperty(test2Manager.getTranslator().getPropertyName(key));
    }

    @Test
    public void testAutoTrim()
    {
        test2Manager.setAutoTrim(false);
        String notTrimmed = test2Manager.getProperty(Key2.VALUE_STRING_TRIM);

        test2Manager.setAutoTrim(true);
        String trimmed = test2Manager.getProperty(Key2.VALUE_STRING_TRIM);

        Assert.assertFalse("The trimmed and not trimmed values should not be equal",
                           trimmed.equals(notTrimmed));
        Assert.assertTrue("The trimmed and not trimmed values should be equal after manually trimming",
                          trimmed.equals(notTrimmed.trim()));
    }

    @Test
    public void testKeySet()
    {
        Assert.assertTrue("Default keys were not discovered properly",
                          test1Manager.keySet()
                                      .containsAll(EnumSet.allOf(Key1.class)));
    }

    @Test
    public void testManagedPropertiesCached()
    {
        Assert.assertSame("Single property managers are not cached correctly",
                          test1Manager.getPropertyManager(Key1.SOME_KEY),
                          test1Manager.getPropertyManager(Key1.SOME_KEY));
    }

    @Test
    public void testSetPropertyString()
    {
        final String value = "a non-default value";
        test1Manager.setProperty(Key1.SOME_KEY, value);
        Assert.assertEquals("Failed to set string property",
                            value,
                            test1Manager.getProperty(Key1.SOME_KEY));
    }

    @Test
    public void testSetPropertyEnum()
    {
        final Color value = Color.BLUE;
        test1Manager.setProperty(Key1.SOME_KEY, value);
        Assert.assertEquals("Failed to set Enum property",
                            value,
                            test1Manager.getEnumProperty(Key1.SOME_KEY,
                                                         Color.class));
    }

    @Test
    public void testResetProperty()
    {
        test1Manager.setProperty(Key1.SOME_KEY, "a non-default value");
        test1Manager.resetProperty(Key1.SOME_KEY);
        Assert.assertEquals("Failed to reset an individual property",
                            Key1.SOME_KEY.getDefaultValue(),
                            test1Manager.getProperty(Key1.SOME_KEY));
    }

    @Test
    public void testResetPropertyWithoutDefault()
    {
        test2Manager.setProperty(Key2.VALUE_NO_DEFAULT, "a non-default value");
        test2Manager.resetProperty(Key2.VALUE_NO_DEFAULT);
        Assert.assertNull("Failed to remove an individual property without a default",
                          test2Manager.getProperty(Key2.VALUE_NO_DEFAULT));
    }

    @Test
    public void testSetPropertyWithoutDefaultMarksModified()
    {
        test2Manager.setProperty(Key2.VALUE_NO_DEFAULT, "a non-default value");
        Assert.assertTrue("Setting a property without a default value was not recognized as a change",
                          test2Manager.isModified(Key2.VALUE_NO_DEFAULT));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testEventSentWhenSetChangesValue()
    {
        monitor1.changed(EasyMock.isA(PropertyEvent.class));
        EasyMock.replay(monitor1);

        test1Manager.setProperty(Key1.SOME_KEY, "some non-default value");

        EasyMock.verify(monitor1);
    }

    @Test
    public void testEventNotSentWhenSetDoesNotChangeValue()
    {
        EasyMock.replay(monitor1);
        test1Manager.setProperty(Key1.SOME_KEY, Key1.SOME_KEY.getDefaultValue());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testEventSentWhenResetChangesValue()
    {
        monitor1.changed(EasyMock.isA(PropertyEvent.class));
        monitor1.reset(EasyMock.isA(PropertyEvent.class));
        EasyMock.replay(monitor1);

        test1Manager.setProperty(Key1.SOME_KEY, "some non-default value");
        test1Manager.resetProperty(Key1.SOME_KEY);

        EasyMock.verify(monitor1);
    }

    @Test
    public void testEventNotSentWhenResetDoesNotChangeValue()
    {
        EasyMock.replay(monitor1);
        test1Manager.resetProperty(Key1.SOME_KEY);
    }

    @Test
    public void testSavingDefaultsWithNoChanges() throws IOException
    {
        File file = new File(TEST_DATA_DIR, "SavingDefaultsWithNoChanges.properties");
        PropertiesManager<Key1> prom = PropertiesManagers.newManager(file, Key1.class);
        prom.setSavingDefaults(true);
        prom.save();

        Assert.assertEquals("After saving with defaults on and no modifications, written file should match default properties",
                            PropertiesManagers.getDefaultProperties(Key1.class,
                                                                    PropertiesManagers.getEnumTranslator(Key1.class)),
                            PropertiesManagers.getProperties(file));
    }

    @Test
    public void testIsModified()
    {
        Assert.assertFalse("Manager has not been modified",
                           test1Manager.isModified());

        test1Manager.setProperty(Key1.SOME_KEY,
                                 test1Manager.getProperty(Key1.SOME_KEY));
        Assert.assertFalse("Setting the current value should not mark the manager as modified",
                           test1Manager.isModified());

        test1Manager.setProperty(Key1.SOME_KEY, "some new value");
        Assert.assertTrue("Manager has been modified",
                          test1Manager.isModified());
    }

    @Test
    public void testIsModifiedProperty()
    {
        Assert.assertFalse("Manager has not been modified",
                           test1Manager.isModified(Key1.SOME_KEY));

        test1Manager.setProperty(Key1.SOME_KEY,
                                 test1Manager.getProperty(Key1.SOME_KEY));
        Assert.assertFalse("Setting the current value should not mark the manager as modified",
                           test1Manager.isModified(Key1.SOME_KEY));

        test1Manager.setProperty(Key1.SOME_KEY, "some new value");
        Assert.assertTrue("Manager has been modified",
                          test1Manager.isModified(Key1.SOME_KEY));
    }

    @Test
    public void testSavingClearsModified() throws IOException
    {
        File file = new File(TEST_DATA_DIR, "SavingClearsModified.properties");
        PropertiesManager<Key1> prom = PropertiesManagers.newManager(file,
                                                                     Key1.class);
        prom.setProperty(Key1.SOME_KEY, "some new value");
        prom.save();

        Assert.assertFalse("After save, no properties should be in a modified state",
                           prom.isModified());
    }

    @Test
    public void testCopy()
    {
        PropertiesManager<Key2> copy = test2Manager.copy(new File(TEST_DATA_DIR,
                                                                  "test2.copy.ro.properties"));
        Assert.assertEquals("Copy does not equal the source",
                            test2Manager.getProperties(),
                            copy.getProperties());
        Assert.assertFalse("Copying an unmodified manager should result in an unmodified copy",
                           copy.isModified());
    }

    @Test
    public void testCopyModified()
    {
        test2Manager.setProperty(Key2.VALUE_STRING, "some non-default value");
        PropertiesManager<Key2> copy = test2Manager.copy(new File(TEST_DATA_DIR,
                                                                  "test2.copy.ro.properties"));

        Assert.assertTrue("Copying a modified manager should result in a modified copy",
                          copy.isModified());
    }

    @Test
    public void testLoadClearsAllModifications() throws IOException
    {
        test2Manager.load();

        PropertiesManager<Key2> copy = test2Manager.copy(test2Manager.getFile());
        copy.setProperty(Key2.VALUE_STRING, "some non-default value");
        copy.setProperty(Key2.VALUE_NO_DEFAULT, "some value");
        copy.load();

        Assert.assertEquals("After load, manager should look identical to the a freshly created and loaded manager",
                            test2Manager.getProperties(),
                            copy.getProperties());
    }

    @Test
    public void testSavingPropertyDoesNotSaveAllProperties() throws Exception
    {
        PropertiesManager<Key2> copy = test2Manager.copy(new File(TEST_DATA_DIR,
                                                                  "SavingPropertyDoesNotSaveAllProperties.properties"));
        copy.setProperty(Key2.VALUE_NO_DEFAULT, "a value");
        copy.setProperty(Key2.VALUE_STRING, "a non-default value");

        int value = 999999;
        copy.saveProperty(Key2.VALUE_INT, value);

        Assert.assertTrue(Key2.VALUE_NO_DEFAULT.name()
                                  + " has been changed, but not saved",
                          copy.isModified(Key2.VALUE_NO_DEFAULT));
        Assert.assertTrue(Key2.VALUE_STRING.name()
                                  + " has been changed, but not saved",
                          copy.isModified(Key2.VALUE_STRING));
        Assert.assertFalse(Key2.VALUE_INT.name()
                                   + " has been changed and saved",
                           copy.isModified(Key2.VALUE_INT));

        copy.load();

        Assert.assertArrayEquals("3 values were changed, but only 1 should have been saved",
                                 new Object[] { null,
                                               getTest2DefaultProperty(Key2.VALUE_STRING),
                                               value },
                                 new Object[] { copy.getProperty(Key2.VALUE_NO_DEFAULT),
                                               copy.getProperty(Key2.VALUE_STRING),
                                               copy.getIntegerProperty(Key2.VALUE_INT) });
    }

    @Test
    public void testLoadingPropertyDoesNotLoadAllProperties() throws IOException
    {
        test2Manager.setProperty(Key2.VALUE_NO_DEFAULT, "a value");
        test2Manager.setProperty(Key2.VALUE_STRING, "a non-default value");
        test2Manager.setProperty(Key2.VALUE_INT, 999999);

        test2Manager.loadProperty(Key2.VALUE_INT);

        Assert.assertTrue(Key2.VALUE_NO_DEFAULT.name()
                                  + " has been changed, but not saved",
                          test2Manager.isModified(Key2.VALUE_NO_DEFAULT));
        Assert.assertTrue(Key2.VALUE_STRING.name()
                                  + " has been changed, but not saved",
                          test2Manager.isModified(Key2.VALUE_STRING));
        Assert.assertFalse(Key2.VALUE_INT.name()
                                   + " has been changed and saved",
                           test2Manager.isModified(Key2.VALUE_INT));
    }

    @Test
    public void testLoadingPropertySendsCorrectEvent() throws IOException
    {
        Capture<PropertyEvent<Key2>> event = new Capture<PropertyEvent<Key2>>();
        monitor2.loaded(EasyMock.capture(event));
        EasyMock.replay(monitor2);

        test2Manager.loadProperty(Key2.VALUE_BOOLEAN);

        EasyMock.verify(monitor2);

        Assert.assertEquals("The event should have specified the key that was loaded",
                            Key2.VALUE_BOOLEAN,
                            event.getValue().getProperty());
    }

    @Test
    public void testWritingToADirThatDoesNotExist() throws IOException
    {
        PropertiesManager<Key2> copy = test2Manager.copy(new File(TEST_DATA_DIR, "some/dir/does/not/exist/p.properties"));
        copy.setSavingDefaults(true);
        copy.save();
    }

    public static enum Key1 implements Defaultable
    {
        SOME_KEY("some key's value!");

        private final String defaultValue;

        private Key1(String defaultValue)
        {
            this.defaultValue = defaultValue;
        }

        @Override
        public String getDefaultValue()
        {
            return defaultValue;
        }
    }

    public static enum Key2
    {
        VALUE_BOOLEAN,
        VALUE_INT,
        VALUE_LONG,
        VALUE_FLOAT,
        VALUE_DOUBLE,
        VALUE_ENUM,
        VALUE_STRING,
        VALUE_STRING_TRIM,
        VALUE_NESTED,
        VALUE_NO_DEFAULT;
    }

    public static enum Color
    {
        RED, GREEN, BLUE;
    }
}
