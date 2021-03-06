package com.brainacad.def;

import com.brainacad.HttpClientHelper;
import com.brainacad.JsonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import java.io.IOException;
import java.util.List;

@Log4j
public class StepDefinition {
    private String URL;
    private HttpResponse response;
    private int userId;
    private String body;

    @Step
    @Given("I have server by url {string}")
    public void iHaveServerByUrl(String url) {
        URL = url;
    }

    @Step
    @When("I send GET request on endpoint {string} and parameters {string}")
    public void i_send_GET_request_on_endpoint_and_parameters(String endpoint, String parameters) throws IOException {
        response = HttpClientHelper.get(URL + endpoint, parameters);
        body = HttpClientHelper.getBodyFromResponse(response);
    }

    @Step
    @When("I send POST request on endpoint {string} and parameters {string} and {string}")
    public void iSendPOSTRequestOnEndpointAndParametersAnd(String endpoint, String name, String job) throws IOException {

        String requestBody = "{\"name\":\"" + name + "\",\"job\":\"" + job + "\"}";
        log.info("Request is: " + requestBody);
        response = HttpClientHelper.post(URL + endpoint, requestBody);
        body = HttpClientHelper.getBodyFromResponse(response);
    }

    @Step
    @When("I send PUT request on endpoint {string} and parameters {string} and {string}")
    public void iSendPUTRequestOnEndpointAndParametersAnd(String endpoint, String name, String job) throws IOException {
        String requestBody = "{\"name\":\"" + name + "\",\"job\":\"" + job + "\"}";
        log.info("Request is: " + requestBody);
        response = HttpClientHelper.put(URL + endpoint, requestBody);
        body = HttpClientHelper.getBodyFromResponse(response);

    }

    @Step
    @Then("I get response status code {int}")
    public void i_get_response_status_code(int responseCode) {
        Assert.assertEquals("Response code=" + responseCode, response.getStatusLine().getStatusCode(), responseCode);
    }

    @Step
    @Then("I got total number of all users {int}")
    public void iGotTotalNumberOfAllUsers(int numUsers) throws IOException {

        int actNumbOgUsers = JsonUtils.intFromJSONByPath(body, "$.total");
        Assert.assertEquals("Total number of users = 12", numUsers, actNumbOgUsers);
    }

    @Step
    @And("I get id of first user = {int}")
    public void iGetIdOfFirstUser(int id) throws IOException {
        userId = id;
        List idList = JsonUtils.listFromJSONByPath(body, "$..id");
        Assert.assertEquals("First element id = 1", id, idList.get(0));
    }

    @Step
    @And("I get name of this user as {string}")
    public void iGetNameOfThisUserAs(String userName) throws IOException {
        List namesList = JsonUtils.listFromJSONByPath(body, "$..name");
        Assert.assertEquals("Second name = 'fuchsia rose'", userName, namesList.get(userId));
    }


    @And("I get updated timestamp not null")
    public void iGetUpdatedTimestampNotNull() {
        String timeStamp = JsonUtils.stringFromJSONByPath(body, "$.updatedAt");
        Assert.assertNotNull(timeStamp);

    }

}




