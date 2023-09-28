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

package no.api.meteo.service.locationforecast.builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.api.meteo.entity.core.service.locationforecast.PeriodForecast;
import no.api.meteo.entity.core.service.locationforecast.Precipitation;
import no.api.meteo.entity.core.service.locationforecast.Symbol;
import no.api.meteo.entity.core.service.locationforecast.SymbolProbability;
import no.api.meteo.entity.core.service.locationforecast.Temperature;
import no.api.meteo.util.EntityBuilder;

import java.time.ZonedDateTime;

@NoArgsConstructor
public class PeriodForecastBuilder implements EntityBuilder<PeriodForecast> {

    @Getter
    @Setter
    private ZonedDateTime from;

    @Getter
    @Setter
    private ZonedDateTime to;

    @Getter
    @Setter
    private Precipitation precipitation;

    @Getter
    @Setter
    private Temperature minTemperature;

    @Getter
    @Setter
    private Temperature maxTemperature;

    @Getter
    @Setter
    private Symbol symbol;

    @Getter
    @Setter
    private SymbolProbability symbolProbability;

    @Override
    public PeriodForecast build() {
        return new PeriodForecast(getFrom(), getTo(), getPrecipitation(), getMinTemperature(), getMaxTemperature(),
                                  getSymbol(), getSymbolProbability());
    }
}
