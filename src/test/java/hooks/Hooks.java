package hooks;

import io.cucumber.java.*;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class Hooks {

    @Before("@ui")
    public void startBrowser() {
        DriverFactory.initDriver();
    }

    @After("@ui")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(
                    DriverFactory.getDriver(),
                    scenario.getName().replace(" ", "_")
            );
        }

        DriverFactory.quitDriver();
    }
}
