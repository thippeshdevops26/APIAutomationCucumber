package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"stepdefinitions", "hooks"},
        tags = "@ui"
)
public class LoginRunner extends AbstractTestNGCucumberTests {}
