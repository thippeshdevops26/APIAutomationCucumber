package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class ApiSteps {

    private static final String BASE_URL = "https://postman-echo.com";

    private String username;
    private String password;
    private Response response;   // ✅ Instance variable (SAFE)

    @Given("I have valid basic authentication credentials")
    public void i_have_valid_basic_authentication_credentials() {

        username = ConfigReader.get("uname");
        password = ConfigReader.get("pwd");

        if (username == null || password == null) {
            throw new RuntimeException("Basic authentication credentials missing in config.properties");
        }
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {

        response = given()
                .auth()
                .preemptive()
                .basic(username, password)
                .when()
                .get(BASE_URL + endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain {string} as true")
    public void the_response_should_contain_as_true(String key) {
        assertTrue(response.jsonPath().getBoolean(key));
    }
}
