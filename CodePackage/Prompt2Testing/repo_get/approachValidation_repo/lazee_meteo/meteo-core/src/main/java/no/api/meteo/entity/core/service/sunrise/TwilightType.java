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

package no.api.meteo.entity.core.service.sunrise;

import java.util.Optional;

public enum TwilightType {

    CIVILIAN("civilian"),
    NAUTICAL("nautical"),
    ASTRONOMICAL("astronomical");

    private final String value;

    TwilightType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<TwilightType> findByValue(String value) {
        if (value == null) {
            return Optional.empty();
        }
        for (TwilightType type : TwilightType.values()) {
            if (type.getValue().equals(value)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}
