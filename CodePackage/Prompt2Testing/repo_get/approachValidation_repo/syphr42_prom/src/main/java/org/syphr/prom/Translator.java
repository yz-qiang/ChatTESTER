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
 * This interface defines the functionality required to translate back and forth
 * between key constants (Enums) and property names.<br>
 * <br>
 * It is required that any implementation be thread safe.
 *
 * @param <T>
 *            the type of objects used to defined the property keys
 *
 * @author Gregory P. Moyer
 */
public interface Translator<T>
{
    /**
     * This method translates the key object into a string property name that is
     * used in the properties file. There is not likely to be a need for client
     * code to call this method directly. The {@link PropertiesManager} API will
     * take care of reading and writing the actual file.
     *
     * @param propertyKey
     *            the key object to be translated into a property name
     *
     * @return the name that represents this property in the properties file
     */
    public String getPropertyName(T propertyKey);

    /**
     * This method translates the string property name into an key object that is
     * used to reference the property via the properties management API. There
     * is not likely to be a need for client code to call this method directly.
     * The {@link PropertiesManager} API will take care of reading and writing
     * the actual file.
     *
     * @param propertyName
     *            the property name to be translated into an key object
     * @return the associated key object
     */
    public T getPropertyKey(String propertyName);
}
