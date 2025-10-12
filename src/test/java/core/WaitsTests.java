package core;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * WaitsTests demonstrates different types of Selenium waits to handle
 * elements that may not be immediately available or visible on the page.
 * 
 * The class includes:
 * 1. Implicit Wait: Automatically waits for elements to appear in the DOM 
 *    for a specified time when using findElement/findElements.
 * 2. Explicit Wait: Waits for a specific condition (like visibility or clickability)
 *    for a targeted element before proceeding.
 * 3. Fluent Wait: Similar to explicit wait but with customizable polling intervals
 *    and the ability to ignore specific exceptions during the wait period.
 * 
 * These tests showcase best practices for handling dynamic content in Selenium
 * and demonstrate how to avoid common timing-related test failures.
 */

@Epic("Core Selenium Waits")
@Feature("Implicit Wait")
public class WaitsTests extends BaseTest {
	
	@Story("Verify element presence using implicit wait")
	@Test(description = "Demonstrate Implicit Wait")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verifies the 'Start' button is present and visible using implicit wait")
	public void implicitWaitTest() throws InterruptedException {
		
		// Implicit wait only applies to elements present in the DOM at page load.
		// The test verifies the visibility of 'button_start' since dynamically loaded elements would require explicit/fluent waits.
		WebElement button_start = driver.findElement(By.tagName("button"));
	
		// Highlight the element for demo
		highlightElement(js, button_start);
		
        // Pause to visually observe the demo
        pauseForDemo();
       
        // Assertion: Verify that the element is displayed and provide a clear assertion message
        Assert.assertTrue(button_start.isDisplayed(), "'Start' button is not visible (Implicit Wait)");
	}
	
	@Story("Wait for dynamically loaded element to appear")
	@Test(description = "Demonstrate Explicit Wait")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Clicks the Start button and explicitly waits for the 'Hello World!' element to become visible")
	public void explicitWaitTest() throws InterruptedException {
		
		// Click the "Start" button to trigger the dynamic loading of the "Hello World!" element
		WebElement button_start = driver.findElement(By.tagName("button"));
		button_start.click();
		
		// Wait until the "Hello World!" element is visible
		WebElement h4_HelloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Hello World!']")));
		
        // Highlight the element for demo
		highlightElement(js, h4_HelloWorld);
		
        // Pause to visually observe the demo
        pauseForDemo();
		
		// Assertion: Verify that the "Hello World!" element is displayed
		Assert.assertTrue(h4_HelloWorld.isDisplayed(), "'Hello World!' element is not visible (Explicit Wait)");
			
	}
	
	@Story("Wait for dynamically loaded element using custom polling")
	@Test(description = "Demonstrate Fluent Wait")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Clicks the Start button and waits for the 'Hello World!' element using Fluent Wait with polling every 2 seconds")
	public void fluentWaitTest() throws InterruptedException {
		
		// Click the "Start" button to trigger the dynamic loading of the "Hello World!" element
		WebElement button_start = driver.findElement(By.tagName("button"));
		button_start.click();
		
		// Set up Fluent Wait: wait up to 15 seconds, polling every 2 seconds, ignoring NoSuchElementException
		FluentWait<WebDriver>wait = new FluentWait<>(driver)
			.withTimeout(Duration.ofSeconds(15))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);
		
		// Wait until the "Hello World!" element is visible
		WebElement h4_HelloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Hello World!']")));
		
        // Highlight the element for demo
		highlightElement(js, h4_HelloWorld);
		
        // Pause to visually observe the demo
        pauseForDemo();
		
		// Assertion: Verify that the "Hello World!" element is displayed
		Assert.assertTrue(h4_HelloWorld.isDisplayed(), "'Hello World!' element is not visible (Fluent Wait)");
			
		
	}

}
