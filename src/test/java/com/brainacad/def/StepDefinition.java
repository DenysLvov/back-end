package com.brainacad.def;

import com.brainacad.HttpClientHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpResponse;
import org.junit.Assert;

import java.io.IOException;

public class StepDefinition {
    private String URL;
    HttpResponse response;

    @Given("I have server by url {string}")
    public void iHaveServerByUrl(String url) {
        URL = url;
     }

    @When("I send GET request on endpoint {string} and parameters {string}")
    public void i_send_GET_request_on_endpoint_and_parameters(String endpoint, String parameters) throws IOException {
        response = HttpClientHelper.get(URL+endpoint,parameters);
    }

    @Then("I get response status code {int}")
    public void i_get_response_status_code(int responseCode) {
        Assert.assertEquals("Response code = 200 ",response.getStatusLine().getStatusCode(), responseCode);
    }


}
