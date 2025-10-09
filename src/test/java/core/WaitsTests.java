package core;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WaitsTests extends BaseTest {
	
	@Epic("Core Selenium Waits")
	@Feature("Implicit Wait")
	@Story("Verify element presence using implicit wait")
	@Test(description = "Demonstrate Implicit Wait")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verifies the 'Start' button is present and visible using implicit wait")
	public void implicitWaitTest() {
		
		// Implicit wait only applies to elements present in the DOM at page load.
		// The test verifies the visibility of 'button_start' since dynamically loaded elements would require explicit/fluent waits.
		
		// Click the "Start" button to trigger the dynamic loading of the "Hello World!" element
		WebElement button_start = driver.findElement(By.tagName("button"));
	
        // Assertion: Verify that the element is displayed and provide a clear assertion message
        Assert.assertTrue(button_start.isDisplayed(), "'Start' button is not visible (Implicit Wait)");
	}
	
	@Epic("Core Selenium Waits")
	@Feature("Explicit Wait")
	@Story("Wait for dynamically loaded element to appear")
	@Test(description = "Demonstrate Explicit Wait")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Clicks the Start button and explicitly waits for the 'Hello World!' element to become visible")
	public void explicitWaitTest() {
		
		// Click the "Start" button to trigger the dynamic loading of the "Hello World!" element
		WebElement button_start = driver.findElement(By.tagName("button"));
		button_start.click();
		
		// Set up Explicit Wait: wait up to 10 seconds for the element to become visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Wait until the "Hello World!" element is visible
		WebElement h4_HelloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Hello World!']")));
		
		// Assertion: Verify that the "Hello World!" element is displayed
		Assert.assertTrue(h4_HelloWorld.isDisplayed(), "'Hello World!' element is not visible (Explicit Wait)");
			
	}
	
	@Epic("Core Selenium Waits")
	@Feature("Fluent Wait")
	@Story("Wait for dynamically loaded element using custom polling")
	@Test(description = "Demonstrate Fluent Wait")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Clicks the Start button and waits for the 'Hello World!' element using Fluent Wait with polling every 2 seconds")
	public void fluentWaitTest() {
		
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
		
		// Assertion: Verify that the "Hello World!" element is displayed
		Assert.assertTrue(h4_HelloWorld.isDisplayed(), "'Hello World!' element is not visible (Fluent Wait)");
			
		
	}

}
