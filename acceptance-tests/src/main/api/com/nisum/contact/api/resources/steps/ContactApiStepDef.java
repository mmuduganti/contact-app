package com.nisum.contact.api.resources.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContactApiStepDef {

    private Response response;
    private JSONObject poObj;

    @Given("^There is a DPO with ID '(\\d+)'$")
    public void there_is_a_DPO_with_ID(int arg1) throws Throwable {
       //noop
    }

    @When("^a request for DPO with ID '(\\w+)' is made$")
    public void a_request_for_DPO_with_ID_is_made(String dpoId) throws Throwable {
        response = RestAssured.get("order-service/sourcing/order/dpo/" + dpoId);
        poObj = new JSONObject(response.getBody().asString());
        System.out.println(poObj);
    }

    @Then("^should get a (\\d+) response$")
    public void should_get_a_response(int status) throws Throwable {
        assertThat(response.getStatusCode(), is(200));
    }

    @Then("^I should see the response in the expected format with an id (\\w+)$")
    public void Get_DPO_Response(String dpoId) throws Throwable {
        assertThat(dpoId, is(poObj.getJSONObject("_resource").get("id")));
    }

    @Then("^I should see the response with error \"([^\"]*)\"$")
    public void Get_Error_Message(String message){
        assertThat(message,is(poObj.getJSONArray("errors").getJSONObject(0).get("message")));
    }
}

