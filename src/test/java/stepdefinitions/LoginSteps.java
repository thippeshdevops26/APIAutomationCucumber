package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.getDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("login should be successful")
    public void login_should_be_successful() {
        boolean successMessage =
                driver.findElement(By.id("flash")).getText().contains("You logged into");

        Assert.assertTrue(
                successMessage,
                "Login success message NOT displayed"
        );
    }

    // THIS IS THE CRITICAL NEGATIVE ASSERTION
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        String actualErrorMessage =
                driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(
                actualErrorMessage.contains("Your username is invalid"),
                "Expected error message NOT displayed. Actual message: "
                        + actualErrorMessage
        );
    }
}
