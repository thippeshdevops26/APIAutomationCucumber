package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))).isDisplayed(),
                "Error message not displayed"
        );
    }
}
