package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/logout.feature",
        glue = {"stepdefinitions", "hooks"},
        tags = "@ui"
)
public class LogoutRunner extends AbstractTestNGCucumberTests {}
