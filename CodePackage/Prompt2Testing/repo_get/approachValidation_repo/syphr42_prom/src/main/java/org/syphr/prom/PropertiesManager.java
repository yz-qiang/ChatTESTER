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
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * This class creates a management API for a {@link Properties} file.
 *
 * @param <T>
 *            the type that represents the keys of the properties file
 *
 * @author Gregory P. Moyer
 */
public class PropertiesManager<T>
{
    /**
     * Listeners that are waiting for property events, such as loading or saving the file.
     */
    private final List<PropertyListener<T>> listeners = new CopyOnWriteArrayList<PropertyListener<T>>();

    /**
     * A cache of {@link PropertyManager individual property managers} that are
     * created on demand.
     */
    private final ConcurrentMap<T, PropertyManager<T>> propertyManagerCache = new ConcurrentHashMap<T, PropertyManager<T>>();

    /**
     * The evaluator used to convert property references into fully evaluated property
     * values.
     */
    private final Evaluator evaluator;

    /**
     * An executor to handle operations that could take a long time, such as interacting
     * with a file system for loading or saving the properties file.
     */
    private final ExecutorService executor;

    /**
     * The properties file represented by this manager.
     */
    private final File file;

    /**
     * The object that determines how to translate between key objects and property names.
     */
    private final Translator<T> translator;

    /**
     * The properties instance with which this manager will interact.
     */
    private final ManagedProperties properties;

    /**
     * An object used to retrieve the raw, internal value of a given property. This is
     * intended for use with the {@link #evaluator}.
     */
    private volatile Retriever retriever;

    /**
     * A flag that determines whether or not property values are automatically trimmed as
     * they are read. The default is <code>true</code>.
     *
     * @see #isAutoTrim()
     * @see #setAutoTrim(boolean)
     */
    private boolean autoTrim = true;

    /**
     * A flag to determine whether or not default values are stored to the file
     * when saved. The default value is <code>false</code>.
     *
     * @see #isSavingDefaults()
     * @see #setSavingDefaults(boolean)
     */
    private volatile boolean savingDefaults;

    /**
     * The comment that will be written to the top of the properties file when and if it
     * is written. This can be <code>null</code>, in which case no extra comment is
     * written. The default value is <code>null</code>.
     *
     * @see #setComment(String)
     */
    private String comment;

    /**
     * Construct a new manager for the given properties file.
     *
     * @param file
     *            the file system location of the properties represented here
     * @param defaults
     *            default values for the properties represented here
     * @param translator
     *            the translator to convert between key objects and property names
     * @param evaluator
     *            the evaluator to convert nested property references into fully
     *            evaluated strings
     * @param executor
     *            a service to handle potentially long running tasks, such as
     *            interacting with the file system
     */
    public PropertiesManager(File file,
                             Properties defaults,
                             Translator<T> translator,
                             Evaluator evaluator,
                             ExecutorService executor)
    {
        this.file = file;
        this.translator = translator;
        this.evaluator = evaluator;
        this.executor = executor;

        properties = new ManagedProperties(defaults);
    }

    /**
     * Copy the current state of this manager to a new instance that is based on
     * a different file. The logical use case for this is to specify a file that
     * does not currently exist and then call {@link #save()}. This would
     * effectively copy the properties file.<br>
     * <br>
     * Note that this method does not copy listeners or {@link PropertyManager}
     * instances. It will also install the current {@link Translator},
     * {@link Evaluator}, {@link ExecutorService}, as well as the default
     * {@link Properties} into the new instance.
     *
     * @param newFile
     *            the file to which the new instance will be based
     * @return a new manager with the same property values and defaults as this
     *         instance
     */
    public PropertiesManager<T> copy(File newFile)
    {
        PropertiesManager<T> copy = new PropertiesManager<T>(newFile,
                                                             properties.getDefaults(),
                                                             getTranslator(),
                                                             getEvaluator(),
                                                             executor);

        /*
         * Retrieve values from the lower level properties to avoid any
         * auto-trim issues.
         */
        for (T property : keySet())
        {
            copy.setProperty(property,
                             properties.getProperty(getTranslator().getPropertyName(property)));
        }

        return copy;
    }

    /**
     * Set the flag that determines whether or not default values are saved to the
     * properties file when and if it is written.
     *
     * @param savingDefaults
     *            the flag to set
     */
    public void setSavingDefaults(boolean savingDefaults)
    {
        this.savingDefaults = savingDefaults;
    }

    /**
     * Determine whether or not default values will be written to the properties file when
     * and if it is saved.
     *
     * @return <code>true</code> if default values will be written out; <code>false</code>
     *         otherwise
     */
    public boolean isSavingDefaults()
    {
        return savingDefaults;
    }

    /**
     * Set the flag that determines whether or not values will be automatically trimmed of
     * whitespace as they are read.
     *
     * @param autoTrim
     *            the flag to set
     */
    public void setAutoTrim(boolean autoTrim)
    {
        this.autoTrim = autoTrim;
    }

    /**
     * Determine whether or not values will be automatically trimmed of whitespace as they
     * are read.
     *
     * @return <code>true</code> if values will be trimmed; <code>false</code> otherwise
     */
    public boolean isAutoTrim()
    {
        return autoTrim;
    }

    /**
     * Set a comment that will be written to the file that stores the properties managed
     * by this instance.<br>
     * <br>
     * The default is no comment.
     *
     * @param comment
     *            the comment to set
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * @return the file represented by this properties manager
     */
    public File getFile()
    {
        return file;
    }

    /**
     * Get an object that will encapsulate the functionality of this manager specific to a
     * single property. This makes it easier to watch, modify, and generally interact with
     * a single property.
     *
     * @param property
     *            the property to manage
     * @return the encapsulation of the functionality of this manager as it pertains to a
     *         single property
     */
    public PropertyManager<T> getPropertyManager(T property)
    {
        PropertyManager<T> propertyManager = propertyManagerCache.get(property);

        if (propertyManager == null)
        {
            PropertyManager<T> newPropertyManager = new PropertyManager<T>(property,
                                                                           this);

            propertyManager = propertyManagerCache.putIfAbsent(property,
                                                               newPropertyManager);
            if (propertyManager == null)
            {
                propertyManager = newPropertyManager;
            }
        }

        return propertyManager;
    }

    /**
     * Add a listener for property events (such as change, save, load).
     *
     * @param listener
     *            the listener to add
     */
    public void addPropertyListener(PropertyListener<T> listener)
    {
        listeners.add(listener);
    }

    /**
     * Remove a property listener.
     *
     * @param listener
     *            the listener to remove
     */
    public void removePropertyListener(PropertyListener<T> listener)
    {
        listeners.remove(listener);
    }

    /**
     * Retrieve the object that translates between key objects and property names.
     *
     * @return the property name translator
     */
    public Translator<T> getTranslator()
    {
        return translator;
    }

    /**
     * Retrieve the object that converts nested property references into evaluated
     * strings.
     *
     * @return the nested property evaluator
     */
    protected Evaluator getEvaluator()
    {
        return evaluator;
    }

    /**
     * Retrieve a {@link Properties} object that contains the properties managed
     * by this instance.<br>
     * <br>
     * Please note that the returned {@link Properties} object is not connected
     * in any way to this manager and is only a snapshot of what the properties
     * looked like at the time the request was fulfilled.
     *
     * @return a {@link Properties} instance containing the properties managed
     *         by this instance (including defaults)
     */
    public Properties getProperties()
    {
        Properties propertiesCopy = properties.getProperties(isSavingDefaults());

        if (isAutoTrim())
        {
            for (Entry<Object, Object> entry : propertiesCopy.entrySet())
            {
                entry.setValue(entry.getValue().toString().trim());
            }
        }

        return propertiesCopy;
    }

    /**
     * Retrieve the set of keys currently in use by this manager. This
     * encompasses any key which currently has a value or a default value
     * associated with it. Normally, this should have the same contents as an
     * enumeration of the valid key objects, but it is not guaranteed.<br>
     * <br>
     * An example of where this set would not have the same contents as the set
     * of key objects would be if at least one property key has no value defined
     * for it and no default value associated with it. In that case, it would
     * not be included in this set.
     *
     * @return the set of keys currently in use by this manager
     */
    public Set<T> keySet()
    {
        Set<T> keys = new TreeSet<T>();

        for (String propertyName : properties.getPropertyNames())
        {
            try
            {
                keys.add(getTranslator().getPropertyKey(propertyName));
            }
            catch (IllegalArgumentException e)
            {
                /*
                 * Skip unknown properties.
                 */
                continue;
            }
        }

        return keys;
    }

    /**
     * Get the current value of the given property.
     *
     * @param property
     *            the property to retrieve
     * @return the value of the given property (or <code>null</code> if an error occurred
     *         while attempting to read the properties)
     */
    public String getProperty(T property)
    {
        return getEvaluator().evaluate(getRawProperty(property), getRetriever());
    }

    /**
     * Retrieve the value of the given property as a boolean.
     *
     * @param property
     *            the property to retrieve
     * @return <code>true</code> if the value of the property is "true" (case
     *         insensitive); <code>false</code> otherwise
     */
    public boolean getBooleanProperty(T property)
    {
        return Boolean.parseBoolean(getProperty(property));
    }

    /**
     * Retrieve the value of the given property as an integer.
     *
     * @param property
     *            the property to retrieve
     * @return the integer value of the given property
     * @throws NumberFormatException
     *             if the current value is not an integer
     */
    public int getIntegerProperty(T property) throws NumberFormatException
    {
        return Integer.parseInt(getProperty(property));
    }

    /**
     * Retrieve the value of the given property as an integer. If the current
     * value of the specified property cannot be converted to an integer, the
     * default value will be retrieved.
     *
     * @param property
     *            the property to retrieve
     * @return the integer value of the given property or the default value if
     *         the current value is not a valid integer
     * @throws NumberFormatException
     *             if both the current and default values are not integers
     */
    public int getIntegerPropertyFallback(T property) throws NumberFormatException
    {
        try
        {
            return getIntegerProperty(property);
        }
        catch (NumberFormatException e)
        {
            return Integer.parseInt(getDefaultProperty(property));
        }
    }

    /**
     * Retrieve the value of the given property as a long.
     *
     * @param property
     *            the property to retrieve
     * @return the long value of the given property
     * @throws NumberFormatException
     *             if the current value is not a long
     */
    public long getLongProperty(T property) throws NumberFormatException
    {
        return Long.parseLong(getProperty(property));
    }

    /**
     * Retrieve the value of the given property as a long. If the current value
     * of the specified property cannot be converted to a long, the default
     * value will be retrieved.
     *
     * @param property
     *            the property to retrieve
     * @return the long value of the given property or the default value if the
     *         current value is not a valid long
     * @throws NumberFormatException
     *             if both the current and default values are not longs
     */
    public long getLongPropertyFallback(T property) throws NumberFormatException
    {
        try
        {
            return getLongProperty(property);
        }
        catch (NumberFormatException e)
        {
            return Long.parseLong(getDefaultProperty(property));
        }
    }

    /**
     * Retrieve the value of the given property as a float.
     *
     * @param property
     *            the property to retrieve
     * @return the float value of the given property
     * @throws NumberFormatException
     *             if the current value is not a float
     */
    public float getFloatProperty(T property) throws NumberFormatException
    {
        return Float.parseFloat(getProperty(property));
    }

    /**
     * Retrieve the value of the given property as a float. If the current value
     * of the specified property cannot be converted to a float, the default
     * value will be retrieved.
     *
     * @param property
     *            the property to retrieve
     * @return the float value of the given property or the default value if the
     *         current value is not a valid float
     * @throws NumberFormatException
     *             if both the current and default values are not floats
     */
    public float getFloatPropertyFallback(T property) throws NumberFormatException
    {
        try
        {
            return getFloatProperty(property);
        }
        catch (NumberFormatException e)
        {
            return Float.parseFloat(getDefaultProperty(property));
        }
    }

    /**
     * Retrieve the value of the given property as a double.
     *
     * @param property
     *            the property to retrieve
     * @return the double value of the given property
     * @throws NumberFormatException
     *             if the current value is not a double
     */
    public double getDoubleProperty(T property) throws NumberFormatException
    {
        return Double.parseDouble(getProperty(property));
    }

    /**
     * Retrieve the value of the given property as a double. If the current
     * value of the specified property cannot be converted to a double, the
     * default value will be retrieved.
     *
     * @param property
     *            the property to retrieve
     * @return the double value of the given property or the default value if
     *         the current value is not a valid double
     * @throws NumberFormatException
     *             if both the current and default values are not doubles
     */
    public double getDoublePropertyFallback(T property) throws NumberFormatException
    {
        try
        {
            return Double.parseDouble(getProperty(property));
        }
        catch (NumberFormatException e)
        {
            return Double.parseDouble(getDefaultProperty(property));
        }
    }

    /**
     * Retrieve the value of the given property as an Enum constant of the given
     * type.<br>
     * <br>
     * Note that this method requires the Enum constants to all have upper case
     * names (following Java naming conventions). This allows for case
     * insensitivity in the properties file.
     *
     * @param <E>
     *            the type of Enum that will be returned
     * @param property
     *            the property to retrieve
     * @param type
     *            the Enum type to which the property will be converted
     * @return the Enum constant corresponding to the value of the given
     *         property
     * @throws IllegalArgumentException
     *             if the current value is not a valid constant of the given
     *             type
     */
    public <E extends Enum<E>> E getEnumProperty(T property, Class<E> type) throws IllegalArgumentException
    {
        return Enum.valueOf(type, getProperty(property).toUpperCase());
    }

    /**
     * Retrieve the value of the given property as an Enum constant of the given
     * type. If the current value of the specified property cannot be converted
     * to the appropriate Enum, the default value will be retrieved.<br>
     * <br>
     * Note that this method requires the Enum constants to all have upper case
     * names (following Java naming conventions). This allows for case
     * insensitivity in the properties file.
     *
     * @param <E>
     *            the type of Enum that will be returned
     * @param property
     *            the property to retrieve
     * @param type
     *            the Enum type to which the property will be converted
     * @return the Enum constant corresponding to the value of the given
     *         property or the default value if the current value is not a valid
     *         instance of the given type
     * @throws IllegalArgumentException
     *             if both the current and default values are not valid
     *             constants of the given type
     */
    public <E extends Enum<E>> E getEnumPropertyFallback(T property, Class<E> type) throws IllegalArgumentException
    {
        try
        {
            return Enum.valueOf(type, getProperty(property).toUpperCase());
        }
        catch (IllegalArgumentException e)
        {
            return Enum.valueOf(type, getDefaultProperty(property).toUpperCase());
        }
    }

    /**
     * Get the current value of the given property, but without translating references. If
     * {@link #isAutoTrim() auto trim} is enabled, the value will also be trimmed of
     * whitespace.
     *
     * @param property
     *            the property to retrieve
     * @return the value of the given property
     */
    public String getRawProperty(T property)
    {
        String propertyName = getTranslator().getPropertyName(property);
        String value = properties.getProperty(propertyName);

        if (value != null && isAutoTrim())
        {
            value = value.trim();
        }

        return value;
    }

    /**
     * Determine whether or not the given property is set to its default value.
     *
     * @param property
     *            the property to check
     * @return <code>true</code> if the given property has its default value;
     *         <code>false</code> otherwise
     */
    public boolean isDefault(T property)
    {
        return getRawProperty(property).equals(getRawDefaultProperty(property));
    }

    /**
     * Retrieve the default raw value of the given property. This functionality
     * is local by design - nothing outside of the properties manager should be
     * directly requesting the default value. Client code should not be
     * concerned with what the default value is specifically, just what the
     * value is and whether or not it is default (see {@link #isDefault(Object)}
     * ).<br>
     * <br>
     * Note that if {@link #isAutoTrim() auto trim} is enabled, this value will
     * be trimmed of whitespace.
     *
     * @param property
     *            the property whose default value is requested
     * @return the default raw value of the given property
     */
    private String getRawDefaultProperty(T property)
    {
        String propertyName = getTranslator().getPropertyName(property);
        String value = properties.getDefaultValue(propertyName);

        if (value != null && isAutoTrim())
        {
            value = value.trim();
        }

        return value;
    }

    /**
     * Retrieve the evaluated default value of the given property.<br>
     * <br>
     * For an explanation of why this functionality is hidden, see
     * {@link #getRawDefaultProperty(Object)}.
     *
     * @param property
     *            the property whose default value is requested
     * @return the default raw value of the given property
     */
    private String getDefaultProperty(T property)
    {
        return getEvaluator().evaluate(getRawDefaultProperty(property), getRetriever());
    }

    /**
     * Determine whether or not one property holds references to another property.
     *
     * @param property1
     *            the property to check for references
     * @param property2
     *            the target referenced property
     * @return <code>true</code> if the first property references the second;
     *         <code>false</code> otherwise
     */
    public boolean isReferencing(T property1, T property2)
    {
        return getEvaluator().isReferencing(getRawProperty(property1),
                                            getTranslator().getPropertyName(property2),
                                            getRetriever());
    }

    /**
     * Retrieve the reference to another property from within the value of the
     * given property at the given position. If such a reference does not exist,
     * the result of this method will be <code>null</code>.
     *
     * @param property
     *            the property to search for the requested reference
     * @param position
     *            the position to check for a reference
     * @return the appropriate reference if one exists; <code>null</code>
     *         otherwise
     */
    public Reference referenceAt(T property, int position)
    {
        return getEvaluator().referenceAt(getRawProperty(property), position, getRetriever());
    }

    /**
     * Load the current value of the given property from the file without
     * modifying the values of any other properties. In other words,
     * {@link #isModified(Object)} will return <code>false</code> for the given
     * property after this call completes, but it will return <code>true</code>
     * for any other properties that have been modified since the last load or
     * save.<br>
     * <br>
     * This method will block and wait for the property to be loaded. See
     * {@link #loadPropertyNB(Object)} for a non-blocking version.
     *
     * @param property
     *            the property to load
     * @throws IOException
     *             if there is an error while attempting to read the property
     *             from the file
     */
    public void loadProperty(T property) throws IOException
    {
        try
        {
            Future<Void> task = loadPropertyNB(property);
            task.get();
        }
        catch (ExecutionException e)
        {
            Throwable t = e.getCause();

            if (t instanceof IOException)
            {
                throw (IOException) t;
            }

            throw new IOException(t);
        }
        catch (InterruptedException e)
        {
            throw new IOException("Loading of the property "
                                  + property
                                  + " from file \""
                                  + getFile().getAbsolutePath()
                                  + "\" was interrupted.");
        }
    }

    /**
     * Load the current value of the given property from the file without
     * modifying the values of any other properties. In other words,
     * {@link #isModified(Object)} will return <code>false</code> for the given
     * property after this call completes, but it will return <code>true</code>
     * for any other properties that have been modified since the last load or
     * save.<br>
     * <br>
     * This method will not block to wait for the property to be loaded. See
     * {@link #loadProperty(Object)} for a blocking version.
     *
     * @param property
     *            the property to save
     * @return a task representing this save request
     * @throws IOException
     *             if there is an error while attempting to write the property
     *             to the file
     */
    public Future<Void> loadPropertyNB(final T property)
    {
        Callable<Void> task = new Callable<Void>()
        {
            @Override
            public Void call() throws Exception
            {
                properties.load(getFile(),
                                getTranslator().getPropertyName(property));
                firePropertyLoaded(property);
                return null;
            }
        };

        return executor.submit(task);
    }

    /**
     * Load the current values of all properties.<br>
     * <br>
     * This method will block and wait for the properties to be loaded. See
     * {@link #loadNB()} for a non-blocking version.
     *
     * @throws IOException
     *             if there is an error while attempting to load the properties
     */
    public void load() throws IOException
    {
        try
        {
            Future<Void> task = loadNB();
            task.get();
        }
        catch (ExecutionException e)
        {
            Throwable t = e.getCause();

            if (t instanceof IOException)
            {
                throw (IOException)t;
            }

            throw new IOException(t);
        }
        catch (InterruptedException e)
        {
            throw new IOException("Loading of the properties file \""
                                        + getFile().getAbsolutePath() + "\" was interrupted.");
        }
    }

    /**
     * Load the properties file. This will override all current values with
     * whatever has last been saved.<br>
     * <br>
     * This method will not block to wait for the properties to be loaded. See
     * {@link #load()} for a blocking version.
     *
     * @return a {@link Future} representing this load request
     */
    public Future<Void> loadNB()
    {
        Callable<Void> task = new Callable<Void>()
        {
            @Override
            public Void call() throws Exception
            {
                properties.load(getFile());
                firePropertiesLoaded();
                return null;
            }
        };

        return executor.submit(task);
    }

    /**
     * Set the given property using an Enum constant. This will not write the
     * new value to the file system.<br>
     * <br>
     * Please note that the Enum value set here is case insensitive. See
     * {@link #getEnumProperty(Object, Class)} for additional details.
     *
     * @see #saveProperty(Object, Enum)
     *
     * @param <E>
     *            the type of Enum value to set
     * @param property
     *            the property whose value is being set
     * @param value
     *            the value to set
     * @throws IllegalArgumentException
     *             if a <code>null</code> value is given (see
     *             {@link #resetProperty(Object)})
     */
    public <E extends Enum<E>> void setProperty(T property, E value) throws IllegalArgumentException
    {
        if (value == null)
        {
            throw new IllegalArgumentException("Cannot set a null value, use reset instead");
        }

        setProperty(property, value.name().toLowerCase());
    }

    /**
     * Set the given property using an object's string representation. This will not write
     * the new value to the file system.
     *
     * @see #saveProperty(Object, Object)
     *
     * @param property
     *            the property whose value is being set
     * @param value
     *            the value to set
     * @throws IllegalArgumentException
     *             if a <code>null</code> value is given (see
     *             {@link #resetProperty(Object)})
     */
    public void setProperty(T property, Object value) throws IllegalArgumentException
    {
        if (value == null)
        {
            throw new IllegalArgumentException("Cannot set a null value, use reset instead");
        }

        setProperty(property, value.toString());
    }

    /**
     * Set the given property using a string. This will not write the new value
     * to the file system.
     *
     * @see #saveProperty(Object, String)
     *
     * @param property
     *            the property whose value is being set
     * @param value
     *            the value to set
     * @throws IllegalArgumentException
     *             if a <code>null</code> value is given (see
     *             {@link #resetProperty(Object)})
     */
    public void setProperty(T property, String value) throws IllegalArgumentException
    {
        if (value == null)
        {
            throw new IllegalArgumentException("Cannot set a null value, use reset instead");
        }

        String propertyName = getTranslator().getPropertyName(property);
        if (properties.setProperty(propertyName, value))
        {
            firePropertyChanged(property);
        }
    }

    /**
     * Save the given property using an Enum constant. See
     * {@link #saveProperty(Object, String)} for additional details.<br>
     * <br>
     * Please note that the Enum value saved here is case insensitive. See
     * {@link #getEnumProperty(Object, Class)} for additional details.
     *
     * @param <E>
     *            the type of Enum value to save
     * @param property
     *            the property whose value is being saved
     * @param value
     *            the value to save
     * @throws IOException
     *             if there is an error while attempting to write the property
     *             to the file
     */
    public <E extends Enum<E>> void saveProperty(T property, E value) throws IOException
    {
        saveProperty(property, value.name());
    }

    /**
     * Save the given property using an object's string representation. See
     * {@link #saveProperty(Object, String)} for additional details.
     *
     * @param property
     *            the property whose value is being saved
     * @param value
     *            the value to save
     * @throws IOException
     *             if there is an error while attempting to write the property
     *             to the file
     */
    public void saveProperty(T property, Object value) throws IOException
    {
        saveProperty(property, value.toString());
    }

    /**
     * Modify the value of the given property and save <b>only that change</b>
     * to permanent storage. This method will not save other properties whose
     * values may have been modified since the file was last loaded or saved.
     * Any modifications that have been made to other properties will still be
     * set, but the file will not reflect those changes until {@link #save()} or
     * {@link #saveNB()} is called.<br>
     * <br>
     * Note that there is no guarantee that the modification and saving will be
     * atomic. In other words, it is possible that this call will modify the
     * value, another call will further change the value, and then the property
     * will be saved.
     *
     * @param property
     *            the property whose value is being saved
     * @param value
     *            the value to save
     * @throws IOException
     *             if there is an error while attempting to write the property
     *             to the file
     */
    public void saveProperty(T property, String value) throws IOException
    {
        setProperty(property, value);
        saveProperty(property);
    }

    /**
     * Save the current value of the given property to the file without
     * modifying the values of any other properties in the file. In other words,
     * {@link #isModified(Object)} will return <code>false</code> for the given
     * property after this call completes, but it will return <code>true</code>
     * for any other properties that have been modified since the last load or
     * save.<br>
     * <br>
     * This method will block and wait for the property to be saved. See
     * {@link #savePropertyNB(Object)} for a non-blocking version.
     *
     * @param property
     *            the property to save
     * @throws IOException
     *             if there is an error while attempting to write the property
     *             to the file
     */
    public void saveProperty(T property) throws IOException
    {
        try
        {
            Future<Void> task = savePropertyNB(property);
            task.get();
        }
        catch (ExecutionException e)
        {
            Throwable t = e.getCause();

            if (t instanceof IOException)
            {
                throw (IOException) t;
            }

            throw new IOException(t);
        }
        catch (InterruptedException e)
        {
            throw new IOException("Saving of the property "
                                  + property
                                  + " to file \""
                                  + getFile().getAbsolutePath()
                                  + "\" was interrupted.");
        }
    }

    /**
     * Save the current value of the given property to the file without
     * modifying the values of any other properties in the file. In other words,
     * {@link #isModified(Object)} will return <code>false</code> for the given
     * property after this call completes, but it will return <code>true</code>
     * for any other properties that have been modified since the last load or
     * save.<br>
     * <br>
     * This method will not block to wait for the property to be saved. See
     * {@link #saveProperty(Object)} for a blocking version.
     *
     * @param property
     *            the property to save
     * @return a task representing this save request
     * @throws IOException
     *             if there is an error while attempting to write the property
     *             to the file
     */
    public Future<Void> savePropertyNB(final T property)
    {
        Callable<Void> task = new Callable<Void>()
        {
            @Override
            public Void call() throws Exception
            {
                properties.save(getFile(),
                                comment,
                                isSavingDefaults(),
                                getTranslator().getPropertyName(property));
                firePropertySaved(property);
                return null;
            }
        };

        return executor.submit(task);
    }

    /**
     * Save the current values of all properties.<br>
     * <br>
     * This method will block and wait for the properties to be saved. See
     * {@link #saveNB()} for a non-blocking version.
     *
     * @throws IOException
     *             if there is an error while attempting to save the properties
     */
    public void save() throws IOException
    {
        try
        {
            Future<Void> task = saveNB();
            task.get();
        }
        catch (ExecutionException e)
        {
            Throwable t = e.getCause();

            if (t instanceof IOException)
            {
                throw (IOException)t;
            }

            throw new IOException(t);
        }
        catch (InterruptedException e)
        {
            throw new IOException("Saving of the properties file \"" + getFile().getAbsolutePath()
                                  + "\" was interrupted.");
        }
    }

    /**
     * Save the current values of all properties.<br>
     * <br>
     * This method will not block to wait for the properties to be saved. See
     * {@link #save()} for a blocking version.
     *
     * @return a task representing this save request
     */
    public Future<Void> saveNB()
    {
        Callable<Void> task = new Callable<Void>()
        {
            @Override
            public Void call() throws Exception
            {
                properties.save(getFile(), comment, isSavingDefaults());
                firePropertiesSaved();
                return null;
            }
        };

        return executor.submit(task);
    }

    /**
     * Reset the given property to its default value. This will not write the new value to
     * the file system.
     *
     * @param property
     *            the property whose value is being reset
     */
    public void resetProperty(T property)
    {
        String propertyName = getTranslator().getPropertyName(property);

        if (properties.resetToDefault(propertyName))
        {
            firePropertyReset(property);
        }
    }

    /**
     * Reset the properties to the original defaults.
     */
    public void reset()
    {
        properties.resetToDefaults();
        firePropertiesReset();
    }

    /**
     * Determine whether or not the given property has been modified since it
     * was last load or saved.
     *
     * @param property
     *            the property to check
     * @return <code>true</code> if this property has been modified since the
     *         last time it was loaded or saved; <code>false</code> otherwise
     */
    public boolean isModified(T property)
    {
        return properties.isModified(getTranslator().getPropertyName(property));
    }

    /**
     * Determine whether or not any property has been modified since the last
     * load or save.
     *
     * @return <code>true</code> if any property known to this instance has been
     *         modified since the last load or save; <code>false</code>
     *         otherwise
     */
    public boolean isModified()
    {
        return properties.isModified();
    }

    /**
     * Build a new {@link Retriever} instance that will be used by the
     * {@link #getEvaluator() evaluator} to request the values of nested property
     * references.
     *
     * @return a new {@link Retriever}
     */
    protected Retriever createRetriever()
    {
        return new Retriever()
        {
            @Override
            public String retrieve(String name)
            {
                return properties.getProperty(name);
            }
        };
    }

    /**
     * Get the {@link Retriever} instance used internally to fetch values using an
     * {@link Evaluator}.
     *
     * @see #createRetriever()
     * @see Evaluator
     *
     * @return the retriever instance
     */
    protected Retriever getRetriever()
    {
        if (retriever == null)
        {
            synchronized (Lock.CREATE_RETRIEVER)
            {
                if (retriever == null)
                {
                    retriever = createRetriever();
                }
            }
        }

        return retriever;
    }

    /**
     * Notify all listeners that a property has been loaded.
     *
     * @param property
     *            the property whose value has been loaded
     */
    private void firePropertyLoaded(T property)
    {
        PropertyEvent<T> event = null;

        for (PropertyListener<T> l : listeners)
        {
            if (event == null)
            {
                event = new PropertyEvent<T>(this, property);
            }

            l.loaded(event);
        }
    }

    /**
     * Notify all listeners that the properties have been loaded.
     */
    private void firePropertiesLoaded()
    {
        firePropertyLoaded(null);
    }

    /**
     * Notify all listeners that a property has been saved.
     *
     * @param property
     *            the property whose value has been saved
     */
    private void firePropertySaved(T property)
    {
        PropertyEvent<T> event = null;

        for (PropertyListener<T> l : listeners)
        {
            if (event == null)
            {
                event = new PropertyEvent<T>(this, property);
            }

            l.saved(event);
        }
    }

    /**
     * Notify all listeners that the properties have been saved.
     */
    private void firePropertiesSaved()
    {
        firePropertySaved(null);
    }

    /**
     * Notify all listeners that a property has changed.
     *
     * @param property
     *            the property whose value has changed
     */
    private void firePropertyChanged(T property)
    {
        PropertyEvent<T> event = null;

        for (PropertyListener<T> l : listeners)
        {
            if (event == null)
            {
                event = new PropertyEvent<T>(this, property);
            }

            l.changed(event);
        }
    }

    /**
     * Notify all listeners that a property has been reset.
     *
     * @param property
     *            the property whose value has changed
     */
    private void firePropertyReset(T property)
    {
        PropertyEvent<T> event = null;

        for (PropertyListener<T> l : listeners)
        {
            if (event == null)
            {
                event = new PropertyEvent<T>(this, property);
            }

            l.reset(event);
        }
    }

    /**
     * Notify all listeners that all of the properties have been reset.
     */
    private void firePropertiesReset()
    {
        firePropertyReset(null);
    }

    /**
     * An internal enum representing locking objects.
     */
    private enum Lock
    {
        /**
         * A lock used to protect the creation of a new {@link Retriever}.
         */
        CREATE_RETRIEVER
    }
}
