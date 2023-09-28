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

/**
 * Internal constants in use by Meteo.
 */
public final class MeteoConstants {

    private MeteoConstants() {
        throw new UnsupportedOperationException();
    }

    public static final String TAG_SUN = "sun";

    public static final String TAG_MOON = "moon";

    public static final String TAG_ERROR = "error";

    public static final String TAG_TWILIGHT = "twilight";

    public static final String ATTR_DAYLENGTH = "daylength";

    public static final String ATTR_RISE = "rise";

    public static final String ATTR_SET = "set";

    public static final String ATTR_NEVER_RISE = "never_rise";

    public static final String ATTR_NEVER_SET = "never_set";

    public static final String ATTR_DIRECTION = "direction";

    public static final String TIME = "time";

    public static final String TAG_NOON = "noon";

    public static final String ATTR_PHASE = "phase";

    public static final String PARAM_LONGITUDE = "lon";

    public static final String PARAM_LATITUDE = "lat";

    public static final String PARAM_ALTITUDE = "msl";

    public static final String PARAM_FROM = "from";

    public static final String PARAM_TO = "to";

    public static final String PARAM_DATE = "date";

    public static final String TAG_META = "meta";

    public static final String TAG_WIND_PROBABILITY = "windProbability";

    public static final String TAG_SYMBOL_PROBABILITY = "symbolProbability";

    public static final String TAG_TEMPERATURE_PROBABILITY = "temperatureProbability";
   
    public static final String TAG_WEATHERDATA = "weatherdata";

    public static final String TAG_LOCATION = "location";

    public static final String TAG_MODEL = "model";

    public static final String TAG_PRECIPITATION = "precipitation";

    public static final String TAG_SYMBOL = "symbol";

    public static final String TAG_FOG = "fog";

    public static final String TAG_PRESSURE = "pressure";

    public static final String TAG_HIGH_CLOUDS = "highClouds";

    public static final String TAG_MEDIUM_CLOUDS = "mediumClouds";

    public static final String TAG_LOW_CLOUDS = "lowClouds";

    public static final String TAG_WIND_DIRECTION = "windDirection";

    public static final String TAG_WIND_SPEED = "windSpeed";

    public static final String TAG_WIND_GUST = "windGust";

    public static final String TAG_CLOUDINESS = "cloudiness";

    public static final String TAG_HUMIDITY = "humidity";

    public static final String TAG_TEMPERATURE = "temperature";

    public static final String TAG_MIN_TEMPERATURE = "minTemperature";

    public static final String TAG_MAX_TEMPERATURE = "maxTemperature";

    public static final String TAG_DEWPOINT_TEMPERATURE = "dewpointTemperature";

    public static final String TAG_PRODUCT_DESCRIPTION = "productdescription";

    public static final String TAG_TITLE = "title";

    public static final String TAG_FORECAST_TYPE = "forecasttype";

    public static final String TAG_AREA = "area";

    public static final String TAG_HEADER = "header";

    public static final String TAG_IN = "in";

    public static final String TAG_AVAILABLE = "available";

    public static final String TAG_QUERY = "query";

    public static final String TAG_PARAMETER = "parameter";

    public static final String TAG_NAME = "name";

    public static final String TAG_VALUE = "value";

    public static final String TAG_LABEL = "label";

    public static final String TAG_URI = "uri";

    public static final String ATTR_LICENSEURL = "licenseurl";

    public static final String ATTR_DATE = "date";
    
    public static final String ATTR_CREATED = "created";

    public static final String ATTR_LONGITUDE = "longitude";

    public static final String ATTR_LATITUDE = "latitude";

    public static final String ATTR_ALTITUDE = "altitude";

    public static final String TAG_TIME = "time";

    public static final String ATTR_TO = "to";

    public static final String ATTR_FROM = "from";

    public static final String ATTR_ID = "id";

    public static final String ATTR_PERCENT = "percent";

    public static final String ATTR_UNIT = "unit";

    public static final String ATTR_VALUE = "value";

    public static final String ATTR_NUMBER = "number";

    public static final String ATTR_NAME = "name";

    public static final String ATTR_DEG = "deg";

    public static final String ATTR_BEAUFORT = "beaufort";

    public static final String ATTR_MPS = "mps";

    public static final String ATTR_MINVALUE = "minvalue";

    public static final String ATTR_PROBABILITY = "probability";

    public static final String ATTR_MAXVALUE = "maxvalue";

    public static final String ATTR_TYPE = "type";

    public static final String ATTR_FORECAST_ORIGIN = "forecast_origin";

    public static final String ATTR_PRODNAME = "prodname";

    public static final String ATTR_RUNENDED = "runended";

    public static final String ATTR_NEXTRUN = "nextrun";

    public static final String ATTR_TERMIN = "termin";


    public static final String MSG_UNHANDLED_START_TAG = "Unhandled start tag: %";

    public static final String MSG_UNHANDLED_END_TAG = "Unhandled end tag: %";


}
