package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotsPage {

    WebDriver driver;
    TakesScreenshot ts;

    // -------------------------
    // Constructor & Initialization
    // -------------------------
    public ScreenshotsPage(WebDriver driver, TakesScreenshot ts) {
        this.driver = driver;
        this.ts = ts;
    }

    // -------------------------
    // Screenshot Capture Methods
    // -------------------------

    /**
     * Captures a screenshot of the entire page and saves it with a timestamp.
     *
     * @param driver   WebDriver instance
     * @param fileName Base name of the file (without extension)
     * @throws IOException if an error occurs during file copying
     */
    public void captureFullPage(WebDriver driver, String fileName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String finalFileName = "screenshots/" + fileName + "_" + timestamp + ".png";

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
    public void captureElement(WebDriver driver, WebElement element, String fileName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String finalFileName = "screenshots/" + fileName + "_" + timestamp + ".png";

        File src = element.getScreenshotAs(OutputType.FILE);
        File dest = new File(finalFileName);
        FileUtils.copyFile(src, dest);
    }

    // -------------------------
    // Specific Element Capture
    // -------------------------
    public void captureLogoElement() throws IOException {
        WebElement elementToCapture = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
        captureElement(driver, elementToCapture, "ElementToCapture");
    }

}
