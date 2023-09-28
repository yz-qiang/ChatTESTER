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

package no.api.meteo.entity.extras;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public final class MeteoExtrasForecastDay {

    @JsonProperty
    private final LocalDate day;

    @JsonProperty
    private final List<MeteoExtrasForecast> forecasts;

    @JsonCreator
    public MeteoExtrasForecastDay(@JsonProperty("day") LocalDate day,
                                  @JsonProperty("forecasts") List<MeteoExtrasForecast> forecasts) {
        this.day = day;
        this.forecasts = forecasts;
    }
}
