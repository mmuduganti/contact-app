package com.nisum.contact.api.resources.steps;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.nisum.contact.api.resources.support.domain.Contact;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContactApiStepDef {
    private static final String SAVE_PATH = "/contact-service/contact/save";
    private static final String SEARCH_PATH = "/contact-service/contact/search";
    private Response response;
    private Contact request;

    @Given("^I have the following details:$")
    public void i_have_the_following_details(List<Contact> contactList) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        request = contactList.get(0);
    }

    @When("^I create contact$")
    public void i_create_contact() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        RequestSpecification spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setBody(request).
                build();
        response = given().
                spec(spec).
                when().
                post(SAVE_PATH);
    }

    @Then("^the contact is created$")
    public void the_contact_is_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        should_get_a_response(200);
    }

    @Then("^I see contact created with following values:$")
    public void i_see_contact_created_with_following_values(List<Contact> expectedContactList) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        should_get_a_response(200);
        List<Contact> contactList = Arrays.asList(response.as(Contact[].class));
        assertThat(expectedContactList.get(0).getFirstName(), is(contactList.get(0).getFirstName()));
        assertThat(expectedContactList.get(0).getLastName(), is(contactList.get(0).getLastName()));
        assertThat(expectedContactList.get(0).getPhoneNum(), is(contactList.get(0).getPhoneNum()));
    }

    @Then("^should get a (\\d+) response$")
    public void should_get_a_response(int status) throws Throwable {
        assertThat(response.getStatusCode(), is(status));
    }

    @When("^I lookup contact with first name \"(.*?)\"$")
    public void I_lookup_contact_with_first_name_fname(String fname) throws Throwable {
       response = get(SEARCH_PATH + "?firstName={fname}", fname).then().extract().response();
    }
}