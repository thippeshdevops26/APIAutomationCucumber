package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user opens login page")
    public void openLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("user logs in with valid credentials")
    public void validLogin() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();
    }

    @When("user logs in with invalid credentials")
    public void invalidLogin() {
        driver.findElement(By.id("username")).sendKeys("wrong");
        driver.findElement(By.id("password")).sendKeys("wrong");
        driver.findElement(By.cssSelector("button")).click();
    }

    @Then("user should see success message")
    public void successMessage() {
        Assert.assertTrue(driver.getPageSource().contains("secure area"));
    }

    @Then("error message should be shown")
    public void errorMessage() {
        // ❌ INTENTIONAL FAILURE → SCREENSHOT
        Assert.assertTrue(driver.getPageSource().contains("THIS TEXT DOES NOT EXIST"));
    }

    @Then("logout button should be visible")
    public void logoutButton() {
        // ❌ INTENTIONAL FAILURE → SCREENSHOT
        Assert.assertTrue(driver.getPageSource().contains("Logouttt"));
    }
}
