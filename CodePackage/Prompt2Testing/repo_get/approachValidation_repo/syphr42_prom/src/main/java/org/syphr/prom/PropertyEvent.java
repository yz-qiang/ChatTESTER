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

import java.util.EventObject;

/**
 * This event class encapsulates an event concerning a single property or a set of
 * properties.
 *
 * @param <T>
 *            the type of objects used to defined the property keys
 *
 * @author Gregory P. Moyer
 */
public class PropertyEvent<T> extends EventObject
{
    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * The property to which this event corresponds. For events concerning multiple
     * properties, this will be <code>null</code>.
     */
    private final T property;

    /**
     * Construct a new event.
     *
     * @param source
     *            the manager that triggered this event
     * @param property
     *            the property to which this event corresponds (may be <code>null</code>
     *            for multi-property events)
     */
    public PropertyEvent(PropertiesManager<T> source, T property)
    {
        super(source);
        this.property = property;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PropertiesManager<T> getSource()
    {
        return (PropertiesManager<T>)super.getSource();
    }

    /**
     * Get the property associated with this event.
     *
     * @return the property associated with this event or <code>null</code> in the case of
     *         a multi-property event
     */
    public T getProperty()
    {
        return property;
    }
}
