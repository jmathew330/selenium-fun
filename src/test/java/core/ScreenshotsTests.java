package core;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import base.BaseTest;
import utils.ScreenshotTestsUtils;

public class ScreenshotsTests extends BaseTest {

	@Epic("Core Selenium Tests")
	@Feature("Screenshot Capturing Module")
    @Story("Capture full-page screenshot")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Captures a full-page screenshot of the DemoQA homepage and saves it to the screenshots folder.")
    @Test
    public void captureFullPageTest() throws IOException {
        // Navigate to the page to capture
        driver.get("https://demoqa.com");

        // Capture a full-page screenshot
        ScreenshotTestsUtils.captureFullPage(driver, "FullPage_Home.png");
    }

	@Epic("Core Selenium Tests")
	@Feature("Screenshot Capturing Module")
    @Story("Capture specific element screenshot")
    @Severity(SeverityLevel.NORMAL)
    @Description("Captures a screenshot of the ToolsQA logo element and saves it to the screenshots folder.")
    @Test
    public void captureElementTest() throws IOException {
        // Navigate to the page that contains the element
        driver.get("https://demoqa.com");

        // Locate the specific element (ToolsQA logo)
        WebElement elementToCapture = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));

        // Capture a screenshot of the specific element
        ScreenshotTestsUtils.captureElement(driver, elementToCapture, "Element_Logo.png");
    }
}
