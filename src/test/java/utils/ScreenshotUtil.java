package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            File dest = new File(
                "target/screenshots/" + scenarioName + "_" + timestamp + ".png"
            );

            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
