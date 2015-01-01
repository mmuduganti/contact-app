package com.nisum.contact.api.resources.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactApiStepDef {

	private Response response;
	private String responseBody;
	private JsonPath jsonPath;
	private final String PATH = "/contact-service/contact";

	// @Given("^I have firstName (\\w+), lastName (\\w+) and phoneNum (\\w+)$")
	// public void i_have_firstName_maria_lastName_testcase_and_phoneNum(String
	// firstName, String lastName, String phoneNum) throws Throwable {

	@Given("^I have firstName maria, lastName testcase and phoneNum (\\d+)-(\\d+)-(\\d+)$")
	public void i_have_firstName_maria_lastName_testcase_and_phoneNum(int firstName,
			int lastName, int phoneNum) throws Throwable {
		response = RestAssured.get("/contact-service/contact" + firstName);
		RestAssured.expect().statusCode(200).when().get(PATH);
		responseBody = response.getBody().asString();
		jsonPath = new JsonPath(responseBody);
	}

	@When("^I create contact$")
	public void i_create_contact() throws Throwable {
		response = RestAssured
				.given()
				.contentType("application/json")
				.body("{\"firstName\":\"maria\",\"lastName\":\"testcase\",\"phoneNum\":\"510-123-1234\"}")
				.when().post("/contact-service/contact");
		responseBody = response.getBody().asString();
		jsonPath = new JsonPath(responseBody);
	}

	@Then("^the contact is created$")
	public void the_contact_is_created() throws Throwable {
		RestAssured.expect().statusCode(200).when().get(PATH);
		assertThat(response.getStatusCode(), is(200));
	}

	@Then("^I see firstName maria, lastName testcase and phoneNum (\\d+)-(\\d+)-(\\d+) values in response$")
	public void i_see_firstName_maria_lastName_testcase_and_phoneNum_values_in_response(
			int firstName, int lastName, int phoneNum) throws Throwable {
		RestAssured.expect().statusCode(200).when().get(PATH);
		response = RestAssured.get(PATH);
		responseBody = response.getBody().asString();
		jsonPath = new JsonPath(responseBody);

		String resFirstName = jsonPath.get("firstName").toString();
		String resLastName = jsonPath.get("lastName").toString();
		String resPhoneNum = jsonPath.get("phoneNum").toString();

		assertEquals("maria",
				resFirstName.replaceAll("\\[", "").replaceAll("\\]", ""));
		assertEquals("testcase",
				resLastName.replaceAll("\\[", "").replaceAll("\\]", ""));
		assertEquals("510-123-1234", resPhoneNum.replaceAll("\\[", "")
				.replaceAll("\\]", ""));

	}
}
