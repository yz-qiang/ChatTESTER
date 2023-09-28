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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Solar related information, including solar noon.  All timestamps are given in UTC. Daylenght is given in hours.
The rise and set values are computed when the angle to the Sun is -0.21 degrees.  Civil twilight is -6 degrees,
nautical -12 and astronomical -18.
*/
@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class Sun extends AbstractType {

    @JsonProperty
    private final Double daylength;

    @JsonProperty
    private final List<Noon> noon;

    @JsonProperty
    private final List<TwilightType> twilight;

    @JsonCreator
    public Sun(@JsonProperty("rise") ZonedDateTime rise,
               @JsonProperty("set") ZonedDateTime set,
               @JsonProperty("neverRise") Boolean neverRise,
               @JsonProperty("neverSet") Boolean neverSet,
               @JsonProperty("error") List<ErrorType> error,
               @JsonProperty("daylength") Double daylength,
               @JsonProperty("noon") List<Noon> noon,
               @JsonProperty("twilight") List<TwilightType> twilight) {
        super(rise, set, neverRise, neverSet, error);
        this.daylength = daylength;
        this.noon = noon;
        this.twilight = twilight;
    }

    public List<Noon> getNoon() {
        return noon == null ? new ArrayList<>() : Collections.unmodifiableList(noon);
    }

    public List<TwilightType> getTwilight() {
        return noon == null ? new ArrayList<>() : Collections.unmodifiableList(twilight);
    }


}
