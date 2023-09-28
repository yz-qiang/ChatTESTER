/*
 * Copyright (c) 2011-2015 Amedia Utvikling AS.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package no.api.meteo.client;

import no.api.meteo.MeteoException;

/**
 * Exception thrown by client implementations if any exception occurs during fetching and parsing of date from
 * https://api.met.no.
 */
public class MeteoClientException extends MeteoException {

    public MeteoClientException(String message) {
        super(message);
    }

    public MeteoClientException(String message, Throwable cause) {
        super(message, cause);
    }

}
