package core;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.qameta.allure.*;
import base.BaseTest;
import utils.ScreenshotTestsUtils;

/**
 * ScreenshotsTests demonstrates how to capture screenshots using Selenium WebDriver.
 * 
 * The class covers:
 * 1. Full-page screenshots: Captures the entire page view of a website and saves it as an image file.
 * 2. Element-specific screenshots: Captures only a specific web element (e.g., logo) and saves it as an image file.
 * 
 * These tests showcase best practices for visual validation, debugging, and reporting, 
 * allowing testers to capture and store screenshots for documentation or verification purposes.
 */

@Epic("Core Selenium Tests")
@Feature("Screenshot Capturing Module")
public class ScreenshotsTests extends BaseTest {

    @Story("Capture full-page screenshot")
    @Test(description = "Captures the full page of DemoQA homepage as an image")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Captures a full-page screenshot of the DemoQA homepage and saves it to the screenshots folder.")
    public void captureFullPageTest() throws IOException {
        // Navigate to the page to capture
        driver.get("https://demoqa.com");

        // Capture a full-page screenshot
        ScreenshotTestsUtils.captureFullPage(driver, "FullPage_Home.png");
    }

    @Story("Capture specific element screenshot")
    @Test(description = "Captures a screenshot of the ToolsQA logo element")
    @Severity(SeverityLevel.NORMAL)
    @Description("Captures a screenshot of the ToolsQA logo element and saves it to the screenshots folder.")
    public void captureElementTest() throws IOException {
        // Navigate to the page that contains the element
        driver.get("https://demoqa.com");

        // Locate the specific element (ToolsQA logo)
        WebElement elementToCapture = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));

        // Capture a screenshot of the specific element
        ScreenshotTestsUtils.captureElement(driver, elementToCapture, "Element_Logo.png");
    }
}
