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

package no.api.meteo.examples.extras;

import no.api.meteo.MeteoException;
import no.api.meteo.client.DefaultMeteoClient;
import no.api.meteo.client.MeteoClient;
import no.api.meteo.client.MeteoData;
import no.api.meteo.entity.core.service.locationforecast.LocationForecast;
import no.api.meteo.entity.extras.MeteoExtrasForecast;
import no.api.meteo.examples.AbstractExample;
import no.api.meteo.service.locationforecast.LocationforecastLTSService;
import no.api.meteo.service.locationforecast.extras.LocationForecastHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class ForecastsByHourExample extends AbstractExample {

    private static final double LONGITUDE_OSLO = 10.7460923576733;

    private static final double LATITUDE_OSLO = 59.912726542422;

    private static final int ALTITUDE_OSLO = 14;

    private static final Logger log = LoggerFactory.getLogger(ForecastsByHourExample.class);

    private static final int HOURS = 10;

    private static final int TWELVE_O_CLOCK = 12;

    private final MeteoClient meteoClient;

    private ForecastsByHourExample() {
        meteoClient = new DefaultMeteoClient("MyExampleApp");
    }

    private void runExample() {
        try {
            LocationforecastLTSService service = new LocationforecastLTSService(meteoClient);
            MeteoData<LocationForecast> meteoData = service.fetchContent(LONGITUDE_OSLO, LATITUDE_OSLO, ALTITUDE_OSLO);
            LocationForecastHelper locationForecastHelper = new LocationForecastHelper(meteoData.getResult());
            List<MeteoExtrasForecast> list = locationForecastHelper.findHourlyPointForecastsFromNow(HOURS);

            log.info("Got " + list.size() + " forecasts.");
            for (MeteoExtrasForecast extras : list) {
                prettyLogPeriodForecast(extras.getPeriodForecast());
            }

            ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Z"));
            dateTime = dateTime.withHour(TWELVE_O_CLOCK).withMinute(0).withSecond(0);
            locationForecastHelper.findNearestForecast(dateTime.plusDays(2));

        } catch (MeteoException e) {
            log.error("Something went wrong", e);
        }
        meteoClient.shutdown();
    }

    public static void main(String[] args) {
        ForecastsByHourExample example = new ForecastsByHourExample();
        example.runExample();
    }
}
