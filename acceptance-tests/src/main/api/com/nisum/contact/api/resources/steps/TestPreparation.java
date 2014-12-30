package com.nisum.contact.api.resources.steps;

import com.jayway.restassured.RestAssured;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.UnknownHostException;

public class TestPreparation {

    @Before
    public void setUp() throws UnknownHostException {
        RestAssured.baseURI = System.getProperty("apiTest.baseUri");
        RestAssured.port = Integer.parseInt(System.getProperty("apiTest.port"));
    }

    @After
    public void tearDown() {
        RestAssured.reset();
    }
}
