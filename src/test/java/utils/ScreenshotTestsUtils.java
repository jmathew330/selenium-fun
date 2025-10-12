package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ScreenshotTestsUtils provides helper methods to capture screenshots
 * of the full page or specific web elements in Selenium tests.
 * Each screenshot is saved with a timestamp to prevent overwriting.
 */
public class ScreenshotTestsUtils {

    /**
     * Captures a screenshot of the entire page and saves it with a timestamp.
     *
     * @param driver   WebDriver instance
     * @param fileName Base name of the file (without extension)
     * @throws IOException if an error occurs during file copying
     */
    public static void captureFullPage(WebDriver driver, String fileName) throws IOException {
        // Generate timestamp string
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        
        // Append timestamp to the filename
        String finalFileName = "screenshots/" + fileName + "_" + timestamp + ".png";
        
        // Capture screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(finalFileName);
        FileUtils.copyFile(src, dest);
    }

    /**
     * Captures a screenshot of a specific WebElement and saves it with a timestamp.
     *
     * @param driver   WebDriver instance
     * @param element  WebElement to capture
     * @param fileName Base name of the file (without extension)
     * @throws IOException if an error occurs during file copying
     */
    public static void captureElement(WebDriver driver, WebElement element, String fileName) throws IOException {
        // Generate timestamp string
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        
        // Append timestamp to the filename
        String finalFileName = "screenshots/" + fileName + "_" + timestamp + ".png";
        
        // Capture element screenshot
        File src = element.getScreenshotAs(OutputType.FILE);
        File dest = new File(finalFileName);
        FileUtils.copyFile(src, dest);
    }
}
