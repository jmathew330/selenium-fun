package core;

import java.io.IOException;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.ScreenshotsPage;

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
	
	ScreenshotsPage sp;

    @Story("Capture full-page screenshot")
    @Test(description = "Captures the full page of DemoQA homepage as an image")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Captures a full-page screenshot of the DemoQA homepage and saves it to the screenshots folder.")
    public void captureFullPageTest() throws IOException {
    	
    	//Initialize the ScreenshotsPage object with driver and TakesScreenshot
    	sp = new ScreenshotsPage(driver, ts);

        // Capture a full-page screenshot
    	sp.captureFullPage(driver, "FullPage_Home");
    }

    @Story("Capture specific element screenshot")
    @Test(description = "Captures a screenshot of the ToolsQA logo element")
    @Severity(SeverityLevel.NORMAL)
    @Description("Captures a screenshot of the ToolsQA logo element and saves it to the screenshots folder.")
    public void captureElementTest() throws IOException {
    	
    	//Initialize the ScreenshotsPage object with driver and TakesScreenshot
    	sp = new ScreenshotsPage(driver, ts);

        // Capture a screenshot of the specific element
    	sp.captureLogoElement();
    }
}
