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

package no.api.meteo.service.textforecast.available.builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import no.api.meteo.entity.core.service.textforecast.available.Parameter;
import no.api.meteo.util.EntityBuilder;

@NoArgsConstructor
@Setter
@Getter
@Slf4j
public class ParameterBuilder implements EntityBuilder<Parameter> {

    private String name;

    private String value;

    private String label;

    @Override
    public Parameter build() {
        return new Parameter(getName(), getValue(), getLabel());
    }
}

