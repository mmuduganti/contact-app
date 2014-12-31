package com.nisum.contact.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import lombok.ToString;

@ToString
public class ObjectMapperBuilder {
    private final ObjectMapper objectMapper;

    public ObjectMapperBuilder() {
        objectMapper = new ObjectMapper();
    }

    public ObjectMapper build() {
        objectMapper.registerModule(new JodaModule());
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        return objectMapper;
    }
}
