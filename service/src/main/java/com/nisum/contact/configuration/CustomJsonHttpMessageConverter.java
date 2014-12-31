package com.nisum.contact.configuration;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class CustomJsonHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public CustomJsonHttpMessageConverter() {
        super();
        this.setObjectMapper(new ObjectMapperBuilder().build());
    }
}
