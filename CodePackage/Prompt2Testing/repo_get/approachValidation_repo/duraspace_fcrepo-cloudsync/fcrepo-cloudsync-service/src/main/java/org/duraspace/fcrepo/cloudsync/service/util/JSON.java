package org.duraspace.fcrepo.cloudsync.service.util;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class JSON {

    private JSON() { }

    public static JsonNode parse(String string)
            throws IllegalArgumentException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(string, JsonNode.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Malformed JSON: " + string, e);
        }
    }

    public static Map<String, String> getMap(JsonNode node)
            throws IllegalArgumentException {
        Map<String, String> map = new HashMap<String, String>();
        Iterator<String> names = node.getFieldNames();
        while (names.hasNext()) {
            String name = names.next();
            map.put(name, node.get(name).getTextValue());
        }
        return map;
    }

}
