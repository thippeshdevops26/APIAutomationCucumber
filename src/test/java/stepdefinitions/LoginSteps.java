package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on login page")
    @Given("user opens login page")
    public void user_is_on_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        user_logs_in_with_username_and_password("tomsmith", "SuperSecretPassword!");
    }

    @Then("login should be successful")
    public void login_should_be_successful() {
        WebElement successMsg = driver.findElement(By.id("flash"));
        Assert.assertTrue(
                successMsg.getText().contains("You logged into a secure area!"),
                "Login success message not displayed"
        );
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        WebElement errorMessage = driver.findElement(By.id("flash"));

        String actualText = errorMessage.getText().trim();

        Assert.assertTrue(
                actualText.contains("Your username is invalid!"),
                "Expected invalid login message, but found: " + actualText
        );
    }

    @Then("logout button should be visible")
    public void logout_button_should_be_visible() {
        boolean isPresent = driver.findElements(By.id("logout-does-not-exist")).size() > 0;

        Assert.assertTrue(
                isPresent,
                "Logout button SHOULD exist but was NOT found (Intentional failure)"
        );
    }
}
