package RestAssured;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserSteps {
    private Response response;


    @Given("the user sets the base url {string}")
    public void the_User_Sets_TheBase_Url(String url) {
        RestAssured.baseURI = url;
    }

    @When("the user sends a GET request")
    public void the_user_sends_a_GET_request() {
        response = RestAssured.when().get();
    }

    @Then("the response status code should be 200")
    public void the_response_status_code_should_be_200() {
        response.then().statusCode( 200);
    }

}
