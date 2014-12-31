package com.nisum.contact.util;

import java.io.IOException;
import java.io.StringReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtility {

	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

	private JsonUtility() {
	}
	
	public static String getAsJSONString(Object obj) {
		try {
			return JSON_MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	public static Object getObjectFromJSONString(String jsonString, Class<?> classType) {
		try {
			return JSON_MAPPER.readValue(new StringReader(jsonString), classType);
		} catch (IOException exception) {
			return null;
		}
	}
}
