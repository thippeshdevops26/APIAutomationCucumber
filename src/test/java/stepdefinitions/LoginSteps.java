package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials() {
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        String actualError =
            driver.findElement(By.id("flash")).getText();

        Assert.assertEquals(
            actualError.trim(),
            "Your username is invalid!",
            "❌ Invalid login message mismatch"
        );
    }
}
