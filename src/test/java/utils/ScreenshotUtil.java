package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            Files.createDirectories(Paths.get("target/screenshots"));
            String time = new SimpleDateFormat("HHmmss").format(new Date());

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(),
                    Paths.get("target/screenshots/" + name + "_" + time + ".png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
