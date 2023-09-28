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

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

/**
 * This class provides the properties management API of {@link PropertiesManager} with
 * respect to a single property.<br>
 * <br>
 * To get access to an instance of this class, use
 * {@link PropertiesManager#getPropertyManager(Object)}.
 *
 * @param <T>
 *            the property key type
 *
 * @author Gregory P. Moyer
 */
public class PropertyManager<T>
{
    /**
     * Listeners that are waiting for notifications specific to the property managed by
     * this instance.
     */
    private final List<PropertyListener<T>> listeners;

    /**
     * The specific property that is managed by this instance.
     */
    private final T propertyKey;

    /**
     * The parent manager that created this instance.
     */
    private final PropertiesManager<T> manager;

    /**
     * A listener that will relay notifications from the parent manager to local listeners
     * when that notification is relevant to the property managed by this instance.
     */
    private final PropertyListener<T> delegateListener = new PropertyListener<T>()
    {
        @Override
        public void changed(PropertyEvent<T> event)
        {
            if (isRelevant(event))
            {
                for (PropertyListener<T> listener : listeners)
                {
                    listener.changed(event);
                }
            }
        }

        @Override
        public void loaded(PropertyEvent<T> event)
        {
            if (isRelevant(event))
            {
                for (PropertyListener<T> listener : listeners)
                {
                    listener.loaded(event);
                }
            }
        }

        @Override
        public void saved(PropertyEvent<T> event)
        {
            if (isRelevant(event))
            {
                for (PropertyListener<T> listener : listeners)
                {
                    listener.saved(event);
                }
            }
        }

        @Override
        public void reset(PropertyEvent<T> event)
        {
            if (isRelevant(event))
            {
                for (PropertyListener<T> listener : listeners)
                {
                    listener.reset(event);
                }
            }
        }

        /**
         * Determine whether or not the given event is relevant to the property
         * managed by this instance.
         *
         * @param event
         *            the event
         * @return <code>true</code> if the event is relevant to this instance;
         *         <code>false</code> otherwise
         */
        private boolean isRelevant(PropertyEvent<T> event)
        {
            T eventProperty = event.getProperty();

            return eventProperty == null
                   || eventProperty.equals(propertyKey)
                   || isReferencing(eventProperty);
        }
    };

    /**
     * Create a new instance.
     *
     * @param propertyKey
     *            the property that will be managed by this instance
     * @param manager
     *            the parent manager
     */
    /* default */PropertyManager(T propertyKey, PropertiesManager<T> manager)
    {
        listeners = new CopyOnWriteArrayList<PropertyListener<T>>();

        this.propertyKey = propertyKey;
        this.manager = manager;

        manager.addPropertyListener(delegateListener);
    }

    /**
     * Retrieve the property key that is managed by this instance.
     *
     * @return the managed property key
     */
    public T getPropertyKey()
    {
        return propertyKey;
    }

    /**
     * @return delegate to PropertiesManager#getProperty(Object)
     */
    public String getProperty()
    {
        return manager.getProperty(propertyKey);
    }

    /**
     * @return delegate to {@link PropertiesManager#getRawProperty(Object)}
     */
    public String getRawProperty()
    {
        return manager.getRawProperty(propertyKey);
    }

    /**
     * @return delegate to {@link PropertiesManager#getBooleanProperty(Object)}
     */
    public boolean getBooleanProperty()
    {
        return manager.getBooleanProperty(propertyKey);
    }

    /**
     * @return delegate to {@link PropertiesManager#getIntegerProperty(Object)}
     */
    public int getIntegerProperty()
    {
        return manager.getIntegerProperty(propertyKey);
    }

    /**
     * @return delegate to
     *         {@link PropertiesManager#getIntegerPropertyFallback(Object)}
     */
    public int getIntegerPropertyFallback()
    {
        return manager.getIntegerPropertyFallback(propertyKey);
    }

    /**
     * @return delegate to {@link PropertiesManager#getLongProperty(Object)}
     */
    public long getLongProperty()
    {
        return manager.getLongProperty(propertyKey);
    }

    /**
     * @return delegate to
     *         {@link PropertiesManager#getLongPropertyFallback(Object)}
     */
    public long getLongPropertyFallback()
    {
        return manager.getLongPropertyFallback(propertyKey);
    }

    /**
     * @return delegate to {@link PropertiesManager#getFloatProperty(Object)}
     */
    public float getFloatProperty()
    {
        return manager.getFloatProperty(propertyKey);
    }

    /**
     * @return delegate to
     *         {@link PropertiesManager#getFloatPropertyFallback(Object)}
     */
    public float getFloatPropertyFallback()
    {
        return manager.getFloatPropertyFallback(propertyKey);
    }

    /**
     * @return delegate to {@link PropertiesManager#getDoubleProperty(Object)}
     */
    public double getDoubleProperty()
    {
        return manager.getDoubleProperty(propertyKey);
    }

    /**
     * @return delegate to
     *         {@link PropertiesManager#getDoublePropertyFallback(Object)}
     */
    public double getDoublePropertyFallback()
    {
        return manager.getDoublePropertyFallback(propertyKey);
    }

    /**
     * @param <E>
     *            see delegate
     * @param type
     *            see delegate
     * @return delegate to {@link PropertiesManager#getEnumProperty(Object, Class)}
     */
    public <E extends Enum<E>> E getEnumProperty(Class<E> type)
    {
        return manager.getEnumProperty(propertyKey, type);
    }

    /**
     * @param <E>
     *            see delegate
     * @param type
     *            see delegate
     * @return delegate to
     *         {@link PropertiesManager#getEnumPropertyFallback(Object, Class)}
     */
    public <E extends Enum<E>> E getEnumPropertyFallback(Class<E> type)
    {
        return manager.getEnumPropertyFallback(propertyKey, type);
    }

    /**
     * @return delegate to {@link PropertiesManager#isDefault(Object)}
     */
    public boolean isDefault()
    {
        return manager.isDefault(propertyKey);
    }

    /**
     * @param property
     *            see delegate
     * @return delegate to {@link PropertiesManager#isReferencing(Object, Object)}
     */
    public boolean isReferencing(T property)
    {
        return manager.isReferencing(propertyKey, property);
    }

    /**
     * @param position
     *            see delegate
     * @return delegate to {@link PropertiesManager#referenceAt(Object, int)}
     */
    public Reference referenceAt(int position)
    {
        return manager.referenceAt(propertyKey, position);
    }

    /**
     * Delegate to {@link PropertiesManager#loadProperty(Object)}.
     *
     * @throws IOException
     *             see delegate
     */
    public void loadProperty() throws IOException
    {
        manager.loadProperty(propertyKey);
    }

    /**
     * Delegate to {@link PropertiesManager#loadPropertyNB(Object)}.
     *
     * @return see delegate
     */
    public Future<Void> loadPropertyNB()
    {
        return manager.loadPropertyNB(propertyKey);
    }

    /**
     * Delegate to {@link PropertiesManager#setProperty(Object, Enum)}.
     *
     * @param <E>
     *            see delegate
     * @param value
     *            see delegate
     */
    public <E extends Enum<E>> void setProperty(E value)
    {
        manager.setProperty(propertyKey, value);
    }

    /**
     * Delegate to {@link PropertiesManager#setProperty(Object, Object)}.
     *
     * @param value
     *            see delegate
     */
    public void setProperty(Object value)
    {
        manager.setProperty(propertyKey, value);
    }

    /**
     * Delegate to {@link PropertiesManager#setProperty(Object, String)}.
     *
     * @param value
     *            see delegate
     */
    public void setProperty(String value)
    {
        manager.setProperty(propertyKey, value);
    }

    /**
     * Delegate to {@link PropertiesManager#saveProperty(Object, Enum)}.
     *
     * @param <E>
     *            see delegate
     * @param value
     *            see delegate
     * @throws IOException
     *             see delegate
     */
    public <E extends Enum<E>> void saveProperty(E value) throws IOException
    {
        manager.saveProperty(propertyKey, value);
    }

    /**
     * Delegate to {@link PropertiesManager#saveProperty(Object, Object)}.
     *
     * @param value
     *            see delegate
     * @throws IOException
     *             see delegate
     */
    public void saveProperty(Object value) throws IOException
    {
        manager.saveProperty(propertyKey, value);
    }

    /**
     * Delegate to {@link PropertiesManager#saveProperty(Object, String)}.
     *
     * @param value
     *            see delegate
     * @throws IOException
     *             see delegate
     */
    public void saveProperty(String value) throws IOException
    {
        manager.saveProperty(propertyKey, value);
    }

    /**
     * Delegate to {@link PropertiesManager#saveProperty(Object)}.
     *
     * @throws IOException
     *             see delegate
     */
    public void saveProperty() throws IOException
    {
        manager.saveProperty(propertyKey);
    }

    /**
     * Delegate to {@link PropertiesManager#savePropertyNB(Object)}.
     *
     * @return see delegate
     */
    public Future<Void> savePropertyNB()
    {
        return manager.savePropertyNB(propertyKey);
    }

    /**
     * Delegate to {@link PropertiesManager#resetProperty(Object)}.
     */
    public void resetProperty()
    {
        manager.resetProperty(propertyKey);
    }

    /**
     * Delegate to {@link PropertiesManager#isModified(Object)}.
     */
    public void isModified()
    {
        manager.isModified(propertyKey);
    }

    /**
     * Add a new listener to be notified of events relevant to the property managed by
     * this instance.
     *
     * @param listener
     *            the listener to add
     */
    public void addPropertyListener(PropertyListener<T> listener)
    {
        listeners.add(listener);
    }

    /**
     * Remove an existing listener.
     *
     * @param listener
     *            the listener to remove
     */
    public void removePropertyListener(PropertyListener<T> listener)
    {
        listeners.remove(listener);
    }
}
