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

/**
 * This listener defines the events that a client can react to when monitoring a single
 * property or a set of properties.
 *
 * @param <T>
 *            the type of objects used to defined the property keys
 *
 * @author Gregory P. Moyer
 */
public interface PropertyListener<T>
{
    /**
     * Signal that one or more properties have been loaded.
     *
     * @param event
     *            the corresponding event
     */
    public void loaded(PropertyEvent<T> event);

    /**
     * Signal that one or more properties have been saved.
     *
     * @param event
     *            the corresponding event
     */
    public void saved(PropertyEvent<T> event);

    /**
     * Signal that one or more properties have been modified.
     *
     * @param event
     *            the corresponding event
     */
    public void changed(PropertyEvent<T> event);

    /**
     * Signal that one or more properties have been reset.
     *
     * @param event
     *            the corresponding event
     */
    public void reset(PropertyEvent<T> event);
}
