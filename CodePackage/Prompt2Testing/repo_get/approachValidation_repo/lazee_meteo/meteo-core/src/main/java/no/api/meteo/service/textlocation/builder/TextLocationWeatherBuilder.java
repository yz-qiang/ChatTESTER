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

package no.api.meteo.service.textlocation.builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.api.meteo.MetaBuilder;
import no.api.meteo.entity.core.service.textlocation.TextLocationTime;
import no.api.meteo.entity.core.service.textlocation.TextLocationWeather;
import no.api.meteo.util.MetaEntityBuilder;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class TextLocationWeatherBuilder implements MetaEntityBuilder<TextLocationWeather> {

    private MetaBuilder metaBuilder = new MetaBuilder();

    private String productDescription;

    private List<TextLocationTime> times = new ArrayList<>();

    @Override
    public TextLocationWeather build() {
        return new TextLocationWeather(getMetaBuilder().build(), getProductDescription(), getTimes());
    }

    @Override
    public void setCreated(ZonedDateTime timestamp) {
        // To please the general meta interface
    }
}
