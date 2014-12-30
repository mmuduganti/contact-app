package com.nisum.contact.util;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonUtil {

    public static String asString(JsonNode node, String nodeName) {
        return (node != null) ? node.get(nodeName).asText() : null;
    }

}
