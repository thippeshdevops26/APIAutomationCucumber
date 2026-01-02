package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.takeScreenshot(
                DriverFactory.getDriver(),
                result.getMethod().getMethodName()
        );
    }
}
