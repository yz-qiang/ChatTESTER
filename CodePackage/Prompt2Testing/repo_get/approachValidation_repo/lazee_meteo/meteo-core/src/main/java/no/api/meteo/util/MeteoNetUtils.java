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

package no.api.meteo.util;

import no.api.meteo.MeteoException;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Util class for dealing with different net issues.
 */
public final class MeteoNetUtils {

    private MeteoNetUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Wrap the construction of URL's to avoid throwing of checked MalformedURLException. Instead MeteoException
     * is thrown.
     *
     * @param uri The url string to be used as the spec for the create URL object.
     * @return URL object created from the given url spec.
     * @throws no.api.meteo.MeteoException If a URL couldn't be created from the given url spec.
     */
    public static URI createUri(String uri) throws MeteoException {
        if (uri == null) {
            throw new MeteoException("URI is null");
        }
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new MeteoException(e);
        }
    }

}
