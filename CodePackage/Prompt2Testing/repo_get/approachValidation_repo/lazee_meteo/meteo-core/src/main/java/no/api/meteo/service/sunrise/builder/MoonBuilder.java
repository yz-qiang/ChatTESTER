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

package no.api.meteo.service.sunrise.builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.api.meteo.entity.core.service.sunrise.ErrorType;
import no.api.meteo.entity.core.service.sunrise.Moon;
import no.api.meteo.entity.core.service.sunrise.PhaseType;
import no.api.meteo.util.EntityBuilder;

import java.time.ZonedDateTime;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class MoonBuilder implements EntityBuilder<Moon> {

    private ZonedDateTime rise;

    private ZonedDateTime set;

    private Boolean neverRise;

    private Boolean neverSet;

    private List<ErrorType> error;

    private PhaseType phase;

    @Override
    public Moon build() {
        return new Moon(getRise(),
                        getSet(),
                        getNeverRise(),
                        getNeverSet(),
                        getError(),
                        getPhase());
    }
}
