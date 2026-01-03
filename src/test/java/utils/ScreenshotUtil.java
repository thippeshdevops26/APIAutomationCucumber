package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path destDir = Path.of("target", "screenshots");
            Files.createDirectories(destDir);

            Path dest = destDir.resolve(
                    scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + ".png"
            );

            Files.copy(src.toPath(), dest);

            System.out.println("📸 Screenshot saved at: " + dest.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
