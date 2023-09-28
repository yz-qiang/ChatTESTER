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
import no.api.meteo.entity.core.MeteoServiceVersion;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public final class METServiceUriBuilder {

    private final MeteoServiceVersion serviceVersion;

    private final String serviceName;

    private final List<Pair> parameters;

    private final String metDomain;

    private boolean skipQuestionMarkInUrl = false;

    private METServiceUriBuilder(String serviceName, MeteoServiceVersion serviceVersion, String metDomain) {
        this.serviceName = serviceName;
        this.serviceVersion = serviceVersion;
        this.metDomain = metDomain;
        this.parameters = new ArrayList<>();
    }

    public METServiceUriBuilder addParameter(String name, Object value) {
        parameters.add(new Pair(name, value));
        return this;
    }

    public METServiceUriBuilder skipQuestionMarkInUrl() {
        skipQuestionMarkInUrl = true;
        return this;
    }

    public URI build() throws MeteoException {
        StringBuilder sb = new StringBuilder();
        sb.append("https://")
                .append(metDomain)
                .append("/weatherapi/")
                .append(serviceName)
                .append("/")
                .append(serviceVersion.toStringVersion())
                .append("/");

        if (!skipQuestionMarkInUrl) {
            sb.append("?");
        }

        boolean first = true;
        for (Pair pair : parameters) {
            sb.append(first ? "" : "&").append(pair.getKey());

            if (pair.getValue() != null) {
                sb.append("=").append(pair.getValue().toString());
            }
            first = false;
        }
        return MeteoNetUtils.createUri(sb.toString());
    }

    public static METServiceUriBuilder create(String serviceName, MeteoServiceVersion serviceVersion, String metDomain) {
        return new METServiceUriBuilder(serviceName, serviceVersion, metDomain);
    }

    private static final class Pair {

        private final String key;

        private final Object value;

        public Pair(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }
}
