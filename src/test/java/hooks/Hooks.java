package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(driver, scenario.getName());
        }

        DriverFactory.quitDriver();
    }
}
