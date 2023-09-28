/*******************************************************************************
 * Copyright 2015 Adobe Systems Incorporated
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package sightlytck.scripts.exprlang.filters;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;

public class FiltersPojo {

    private Map<String, String> collection = new LinkedHashMap<String, String>();

    private Date date = new Date(-1612137600000l);

    private Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+00:30"));

    public FiltersPojo() {
        collection.put("a", "1");
        collection.put("b", "2");
        collection.put("c", "3");
        calendar.setTime((Date)date.clone());
    }

    public Map<String, String> collection() {
        return collection;
    }

    public Date getDate() {
        return date;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public double getNumber() {
        return 100.789;
    }

    public double getNegativeNumber() {
        return -3.14;
    }

}
