package com.nisum.contact.rest.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RestClient {
    @Autowired
    private RestTemplate restTemplate;

    public <T extends Object> T getResponse(String endpointUrl, Class responseType) {
        return (T) restTemplate.getForObject(endpointUrl, responseType);
    }
}
