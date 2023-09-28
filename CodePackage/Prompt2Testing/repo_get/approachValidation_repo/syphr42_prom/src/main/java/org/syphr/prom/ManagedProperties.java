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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class provides supporting API around {@link Properties} to allow easier
 * management of the properties within as they pertain to an actual file on the
 * file system and the lifecycle of load/modify/save.
 *
 * @author Gregory P. Moyer
 */
/* default */class ManagedProperties
{
    /**
     * The gatekeeper acts as a barrier that protects any action that has an
     * effect on the {@link ChangeStack#isModified()} value of a property.
     * Normally the gatekeeper will allow full access as the synchronization
     * policy of {@link ChangeStack} and {@link ConcurrentMap} will keep things
     * correct. However, when it's time to save the current state of the
     * properties to the file system, the gatekeeper will lock all threads out
     * except the one doing the saving. This ensures that whether the save
     * succeeds or fails, the properties are all marked appropriately.
     */
    private final Gatekeeper gatekeeper;

    /**
     * A collection of properties and their associated stacks. This map will
     * have, at a minimum, every property for which a default value was
     * specified.
     */
    private final ConcurrentMap<String, ChangeStack<String>> properties;

    /**
     * A copy of the default property values supplied by the client.
     */
    private final Properties defaults;

    /**
     * Construct a new managed instance.
     *
     * @param defaults
     *            the default values (note that these will be copied to a new
     *            object so that the caller cannot change the underlying
     *            defaults used in this instance)
     */
    public ManagedProperties(Properties defaults)
    {
        this.gatekeeper = new Gatekeeper();

        this.defaults = copyProperties(defaults);

        this.properties = new ConcurrentHashMap<String, ChangeStack<String>>(this.defaults.size());
        for (Entry<Object, Object> entry : defaults.entrySet())
        {
            setValue(entry.getKey().toString(),
                     entry.getValue().toString(),
                     true);
        }
    }

    /**
     * Copy the given properties to a new object.
     *
     * @param source
     *            the source from which to copy
     * @return a copy of the source or <code>null</code> if the source is
     *         <code>null</code>
     */
    private Properties copyProperties(Properties source)
    {
        Properties copy = new Properties();

        if (source != null)
        {
            copy.putAll(source);
        }

        return copy;
    }

    /**
     * Load the given file. The state of all properties present in this instance
     * will reflect the state of the file after this call. This means that any
     * properties that do not currently equal the value in the file will be
     * changed and any properties that do not exist in the file or the defaults
     * will be removed. It also means that after this call completes,
     * {@link #isModified()} will return <code>false</code>.
     *
     * @param file
     *            the file containing the current property values (this file
     *            does not have to exist, in which case all defaults are
     *            assumed)
     * @throws IOException
     *             if there is a file system error while attempting to read the
     *             file
     */
    public void load(File file) throws IOException
    {
        load(file, null);
    }

    /**
     * Load the given property from the given file. If the property's value does
     * not currently equal the value in the file, the value will be changed. If
     * the property does not exist in the file or the defaults, it will be
     * removed. Also, after this call completes, {@link #isModified(String)}
     * will return <code>false</code> for this property.
     *
     * @param file
     *            the file containing the current property values (this file
     *            does not have to exist, in which case the default value is
     *            assumed)
     * @param propertyName
     *            the property to update from the file (this can be
     *            <code>null</code>, in which case all properties will be
     *            updated)
     * @throws IOException
     *             if there is a file system error while attempting to read the
     *             file
     */
    public void load(File file, String propertyName) throws IOException
    {
        Properties tmpProperties = new Properties(defaults);

        /*
         * Do not throw a FileNotFoundException here because it is OK if the
         * file does not exist. In this case, default values will be used.
         */
        if (file.isFile())
        {
            InputStream inputStream = new FileInputStream(file);
            try
            {
                tmpProperties.load(inputStream);
            }
            finally
            {
                inputStream.close();
            }
        }

        /*
         * If a property name was specified, only load that property and leave
         * the rest alone.
         */
        if (propertyName != null)
        {
            String value = tmpProperties.getProperty(propertyName);

            if (value == null)
            {
                properties.remove(propertyName);
            }
            else
            {
                setValue(propertyName, value, true);
            }

            return;
        }

        Set<String> tmpPropertyNames = tmpProperties.stringPropertyNames();

        gatekeeper.signIn();
        try
        {

            /*
             * Throw away any property that is not in the file or in the
             * defaults.
             */
            properties.keySet().retainAll(tmpPropertyNames);

            /*
             * Set every value to either the value read from the file or the
             * default.
             */
            for (String tmpPropertyName : tmpPropertyNames)
            {
                setValue(tmpPropertyName,
                         tmpProperties.getProperty(tmpPropertyName),
                         true);
            }
        }
        finally
        {
            gatekeeper.signOut();
        }
    }

    /**
     * Save the current state of the properties within this instance to the
     * given file.
     *
     * @param file
     *            the file to which the current properties and their values will
     *            be written
     * @param comment
     *            an optional comment to put at the top of the file (
     *            <code>null</code> means no comment)
     * @param saveDefaults
     *            if <code>true</code>, values that match the default will be
     *            written to the file; otherwise values matching the default
     *            will be skipped
     * @throws IOException
     *             if there is an error writing the given file
     */
    public void save(File file, String comment, boolean saveDefaults) throws IOException
    {
        save(file, comment, saveDefaults, null);
    }

    /**
     * Save the current state of the given property to the given file without
     * saving all of the other properties within this instance.
     *
     * @param file
     *            the file to which the current properties and their values will
     *            be written
     * @param comment
     *            an optional comment to put at the top of the file (
     *            <code>null</code> means no comment)
     * @param saveDefaults
     *            if <code>true</code>, values that match the default will be
     *            written to the file; otherwise values matching the default
     *            will be skipped
     * @param propertyName
     *            the name of the property to save at its current value while
     *            the others will retain the last saved value (if
     *            <code>null</code>, all properties will be saved with their
     *            current values)
     * @throws IOException
     *             if there is an error writing the given file
     */
    public void save(File file,
                     String comment,
                     boolean saveDefaults,
                     String propertyName) throws IOException
    {
        gatekeeper.lock();
        try
        {
            File parent = file.getParentFile();
            if (!parent.exists() && !parent.mkdirs())
            {
                throw new IOException("Directory at \""
                                      + parent.getAbsolutePath()
                                      + "\" does not exist and cannot be created");
            }

            FileOutputStream outputStream = new FileOutputStream(file);
            try
            {
                Properties tmpProperties = getProperties(saveDefaults,
                                                         propertyName);
                tmpProperties.store(outputStream, comment);

                /*
                 * If we only saved a single property, only that property should
                 * be marked synced.
                 */
                if (propertyName != null)
                {
                    properties.get(propertyName).synced();
                }
                else
                {
                    for (ChangeStack<String> stack : properties.values())
                    {
                        stack.synced();
                    }
                }
            }
            finally
            {
                outputStream.close();
            }
        }
        finally
        {
            gatekeeper.unlock();
        }
    }

    /**
     * Retrieve the value associated with the given property.
     *
     * @param propertyName
     *            the property whose value is requested
     * @return the value associated with the given property or <code>null</code>
     *         if no such property exists
     */
    public String getProperty(String propertyName)
    {
        ChangeStack<String> stack = properties.get(propertyName);
        if (stack == null)
        {
            return null;
        }

        return stack.getCurrentValue();
    }

    /**
     * Set a new value for the given property.
     *
     * @param propertyName
     *            the property whose value will be set
     * @param value
     *            the new value to set
     * @return <code>true</code> if the value of the given property changed as a
     *         result of this call; <code>false</code> otherwise
     * @throws NullPointerException
     *             if the give value is <code>null</code>
     */
    public boolean setProperty(String propertyName, String value) throws NullPointerException
    {
        return setValue(propertyName, value, false);
    }

    /**
     * Push or sync the given value to the appropriate stack. This method will
     * create a new stack if this property has never had a value before.
     *
     * @param propertyName
     *            the property whose value will be set
     * @param value
     *            the value to set
     * @param sync
     *            a flag to determine whether the value is
     *            {@link ChangeStack#sync(Object) synced} or simply
     *            {@link ChangeStack#push(Object) pushed}
     * @return <code>true</code> if the value of the given property changed as a
     *         result of this call; <code>false</code> otherwise
     * @throws NullPointerException
     *             if the given value is <code>null</code>
     */
    private boolean setValue(String propertyName, String value, boolean sync) throws NullPointerException
    {
        gatekeeper.signIn();
        try
        {
            ChangeStack<String> stack = properties.get(propertyName);
            if (stack == null)
            {
                ChangeStack<String> newStack = new ChangeStack<String>(value,
                                                                       sync);
                stack = properties.putIfAbsent(propertyName, newStack);
                if (stack == null)
                {
                    return true;
                }
            }

            return sync ? stack.sync(value) : stack.push(value);
        }
        finally
        {
            gatekeeper.signOut();
        }
    }

    /**
     * Get the default value for the given property.
     *
     * @param propertyName
     *            the property whose associated default value is requested
     * @return the default value for the given property or <code>null</code> if
     *         there is no default value
     */
    public String getDefaultValue(String propertyName)
    {
        return defaults.getProperty(propertyName);
    }

    /**
     * Reset the value associated with specified property to its default value.
     *
     * @param propertyName
     *            the property whose associated value should be reset
     * @return <code>true</code> if the value of the given property changed as a
     *         result of this call; <code>false</code> otherwise
     */
    public boolean resetToDefault(String propertyName)
    {
        gatekeeper.signIn();
        try
        {
            /*
             * If this property was added with no default value, all we can do
             * is remove the property entirely.
             */
            String defaultValue = getDefaultValue(propertyName);
            if (defaultValue == null)
            {
                return properties.remove(propertyName) != null;
            }

            /*
             * Every property with a default value is guaranteed to have a
             * stack. Since we just confirmed the existence of a default value,
             * we know the stack is available.
             */
            return properties.get(propertyName).push(defaultValue);
        }
        finally
        {
            gatekeeper.signOut();
        }
    }

    /**
     * Reset all values to the default values.
     */
    public void resetToDefaults()
    {
        gatekeeper.signIn();
        try
        {
            for (Iterator<Entry<String, ChangeStack<String>>> iter = properties.entrySet()
                                                                               .iterator(); iter.hasNext();)
            {
                Entry<String, ChangeStack<String>> entry = iter.next();

                String defaultValue = getDefaultValue(entry.getKey());
                if (defaultValue == null)
                {
                    iter.remove();
                    continue;
                }

                entry.getValue().push(defaultValue);
            }
        }
        finally
        {
            gatekeeper.signOut();
        }
    }

    /**
     * Determine whether or not the given property has been modified since it
     * was last load or saved.
     *
     * @param propertyName
     *            the property to check
     * @return <code>true</code> if this property has been modified since the
     *         last time it was loaded or saved; <code>false</code> otherwise
     */
    public boolean isModified(String propertyName)
    {
        gatekeeper.signIn();
        try
        {
            ChangeStack<String> stack = properties.get(propertyName);
            if (stack == null)
            {
                return false;
            }

            return stack.isModified();
        }
        finally
        {
            gatekeeper.signOut();
        }
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
        gatekeeper.signIn();
        try
        {
            for (ChangeStack<String> stack : properties.values())
            {
                if (stack.isModified())
                {
                    return true;
                }
            }

            return false;
        }
        finally
        {
            gatekeeper.signOut();
        }
    }

    /**
     * Retrieve a set of property names currently in use by this instance. This
     * includes default and non-default properties.
     *
     * @return the set of property names currently in use
     */
    public Set<String> getPropertyNames()
    {
        return Collections.unmodifiableSet(properties.keySet());
    }

    /**
     * Retrieve a {@link Properties} object that contains the properties managed
     * by this instance.<br>
     * <br>
     * Please note that the returned {@link Properties} object is not connected
     * in any way to this instance and is only a snapshot of what the properties
     * looked like at the time the request was fulfilled.
     *
     * @param includeDefaults
     *            if <code>true</code>, values that match the default will be
     *            stored directly in the properties map; otherwise values
     *            matching the default will only be available through the
     *            {@link Properties} concept of defaults (as a fallback and not
     *            written to the file system if this object is stored)
     *
     * @return a {@link Properties} instance containing the properties managed
     *         by this instance (including defaults as defined by the given
     *         flag)
     */
    public Properties getProperties(boolean includeDefaults)
    {
        return getProperties(includeDefaults, null);
    }

    /**
     * Retrieve a {@link Properties} object that contains the properties managed
     * by this instance. If a non-<code>null</code> property name is given, the
     * values will be the last saved value for each property except the given
     * one. Otherwise, the properties will all be the current values. This is
     * useful for saving a change to a single property to disk without also
     * saving any other changes that have been made. <br>
     * <br>
     * Please note that the returned {@link Properties} object is not connected
     * in any way to this instance and is only a snapshot of what the properties
     * looked like at the time the request was fulfilled.
     *
     * @param includeDefaults
     *            if <code>true</code>, values that match the default will be
     *            stored directly in the properties map; otherwise values
     *            matching the default will only be available through the
     *            {@link Properties} concept of defaults (as a fallback and not
     *            written to the file system if this object is stored)
     * @param propertyName
     *            the name of the property whose current value should be
     *            provided while all others will be the last saved value (if
     *            this is <code>null</code>, all values will be current)
     *
     * @return a {@link Properties} instance containing the properties managed
     *         by this instance (including defaults as defined by the given
     *         flag)
     */
    public Properties getProperties(boolean includeDefaults, String propertyName)
    {
        Properties tmpProperties = new Properties(defaults);

        for (Entry<String, ChangeStack<String>> entry : properties.entrySet())
        {
            String entryName = entry.getKey();

            /*
             * If we are only concerned with a single property, we need to grab
             * the last saved value for all of the other properties.
             */
            String value = propertyName == null
                           || propertyName.equals(entryName)
                    ? entry.getValue().getCurrentValue()
                    : entry.getValue().getSyncedValue();

            /*
             * The value could be null if the property has no default, was set
             * without saving, and now the saved value is requested. In which
             * case, like the case of a default value where defaults are not
             * being included, the property can be skipped.
             */
            if (value == null
                || (!includeDefaults && value.equals(getDefaultValue(entryName))))
            {
                continue;
            }

            tmpProperties.setProperty(entryName, value);
        }

        return tmpProperties;
    }

    /**
     * Retrieve the default property values used by this instance.
     *
     * @return a copy of this instance's default properties
     */
    public Properties getDefaults()
    {
        return copyProperties(defaults);
    }

    /**
     * This class is basically a syntactic wrapper to {@link ReadWriteLock}. The
     * point here is that there is a normal flow that covers most of the actions
     * and no special locking is required for this. These actions will call
     * {@link #signIn()} before and {@link #signOut()} afterwards (with a proper
     * try-finally as with any other {@link Lock}). However, when the infrequent
     * operation comes along that must have some critical code to itself, it
     * will call {@link #lock()} before and {@link #unlock()} after (again in a
     * proper try-finally).<br>
     * <br> {@link #lock()} will not return until all {@link #signIn() signed in}
     * threads have {@link #signOut() signed out}. While locked, no other
     * threads may {@link #signIn()}. When a lock is requested, no other threads
     * requesting to {@link #signIn()} will be allowed until {@link #unlock()}
     * is issued.
     *
     * @author Gregory P. Moyer
     */
    private static class Gatekeeper
    {
        /**
         * This lock provides the multiple thread sign in/out as a read lock and
         * the single thread lock/unlock as a write lock. The lock itself must
         * be declared &quot;fair&quot; so that acquiring the write lock takes
         * precedence over another thread acquiring the read lock. In other
         * words, {@link #lock()} wins over {@link #signIn()}.
         */
        private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

        /**
         * Register that this thread is entering a protected section, but with
         * no requirement for atomic access.
         */
        public void signIn()
        {
            lock.readLock().lock();
        }

        /**
         * Unregister this thread from the multi-threaded protected section.
         */
        public void signOut()
        {
            lock.readLock().unlock();
        }

        /**
         * Request a lock on the protected section. This method will return once
         * all currently {@link #signIn() signed in} threads have
         * {@link #signOut() signed out}. New threads requesting to
         * {@link #signIn() sign in} will have to wait until {@link #unlock()}
         * is called starting as soon as a lock is requested (potentially before
         * it is granted).
         */
        public void lock()
        {
            lock.writeLock().lock();
        }

        /**
         * Release the protected section and allow threads waiting to
         * {@link #signIn()} to do so.
         */
        public void unlock()
        {
            lock.writeLock().unlock();
        }
    }
}