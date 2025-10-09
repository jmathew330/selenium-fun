package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LocatorsTest extends BaseTest {
	
	@Epic("Core Selenium Tests")
	@Feature("Locators Module")
    @Story("Verify all locator types")
    @Test(description = "Verify various locators and element visibility")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test locates elements using id, className, name, linkText, XPath, and CSS selector, and verifies their text and visibility")
	public void locatorsTest() {
	
		// Locate input field using 'id' and verify visibility
		WebElement input_name = driver.findElement(By.id("name"));
		
		// Locate page heading using 'className' and retrieve its text
		WebElement h1_title = driver.findElement(By.className("title"));
		
		// Locate 'Udemy Courses' link using 'linkText' and retrieve its text
		WebElement a_UdemyCourses = driver.findElement(By.linkText("Udemy Courses"));
		
		// Locate the start button using 'name' and verify visibility
		WebElement button_start = driver.findElement(By.name("start"));
		
		// Locate Wikipedia icon using 'XPath' and verify visibility
		WebElement img_Wiki_icon = driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
		
		// Locate search input using 'CSS selector' and verify visibility
		WebElement input_search = driver.findElement(By.cssSelector("input.wikipedia-search-input"));
		
		// Retrieve the heading text
		String h1_title_text = h1_title.getText();
		// Assertion: Verify the heading contains the expected text
		Assert.assertTrue(h1_title_text.contains("Automation Testing Practice"), "Page title text mismatch!");

		// Retrieve the 'Udemy Courses' link text
		String a_UdemyCourses_text = a_UdemyCourses.getText();
		// Assertion: Verify the link text contains 'Udemy Courses'
		Assert.assertTrue(a_UdemyCourses_text.contains("Udemy Courses"), "'Udemy Courses' link text mismatch!");
		
		// Assertion: Verify visibility of all located elements
		Assert.assertTrue(input_name.isDisplayed(), "Input field 'name' is not displayed");
		Assert.assertTrue(button_start.isDisplayed(), "Start button is not displayed");
		Assert.assertTrue(img_Wiki_icon.isDisplayed(), "Wikipedia icon is not displayed");
		Assert.assertTrue(input_search.isDisplayed(), "Search input is not displayed");
		
	}

}
