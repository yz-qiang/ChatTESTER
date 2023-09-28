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

package no.api.meteo.entity.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;
import no.api.meteo.util.jackson.ZonedDateTimeDeserializer;
import no.api.meteo.util.jackson.ZonedDateTimeSerializer;

import java.time.ZonedDateTime;

@Value
public final class Model {

    @JsonProperty
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private final ZonedDateTime to;

    @JsonProperty
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private final ZonedDateTime from;

    @JsonProperty
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private final ZonedDateTime runEnded;

    @JsonProperty
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private final ZonedDateTime nextRun;

    @JsonProperty
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private final ZonedDateTime termin;

    @JsonProperty
    private final String name;

    @JsonCreator
    public Model(@JsonProperty("to") ZonedDateTime to,
                 @JsonProperty("from") ZonedDateTime from,
                 @JsonProperty("runEnded") ZonedDateTime runEnded,
                 @JsonProperty("nextRun") ZonedDateTime nextRun,
                 @JsonProperty("termin") ZonedDateTime termin,
                 @JsonProperty("name") String name) {
        this.to = to;
        this.from = from;
        this.runEnded = runEnded;
        this.nextRun = nextRun;
        this.termin = termin;
        this.name = name;
    }
}
