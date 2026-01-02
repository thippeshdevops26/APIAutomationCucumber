package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            if (driver == null) {
                System.out.println("Driver is null. Screenshot not captured.");
                return;
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destDir = new File("target/screenshots");
            destDir.mkdirs();

            File dest = new File(destDir, testName + ".png");
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
