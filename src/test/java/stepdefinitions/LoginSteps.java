package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user opens login page")
    public void user_opens_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @When("user logs in with invalid credentials")
    public void user_logs_in_with_invalid_credentials() {
        driver.findElement(By.id("username")).sendKeys("invalid");
        driver.findElement(By.id("password")).sendKeys("invalid");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("user should see success message")
    public void user_should_see_success_message() {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(
                pageSource.contains("You logged into a secure area!"),
                "Success message not found"
        );
    }

    @Then("error message should be shown")
    public void error_message_should_be_shown() {
        String pageSource = driver.getPageSource();

        Assert.assertTrue(
                pageSource.contains("Your username is invalid!"),
                "Expected error message not displayed"
        );
    }

    @Then("logout button should be visible")
    public void logout_button_should_be_visible() {
        Assert.assertTrue(
                driver.findElements(By.cssSelector("a[href='/logout']")).size() > 0,
                "Logout button not visible"
        );
    }
}
