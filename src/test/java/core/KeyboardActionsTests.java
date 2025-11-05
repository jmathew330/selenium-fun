package core;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.*;
import pages.KeyboardPage;

/**
 * KeyboardActionsTests demonstrates how to simulate keyboard interactions using Selenium WebDriver.
 * 
 * The class covers:
 * 1. Typing regular text: Sends a sequence of characters to an input field and verifies that each key press is detected correctly.
 * 2. Sending special keys: Tests special keys such as Escape, Backspace, Tab, and Shift, and verifies that the web page detects them correctly.
 * 
 * These tests showcase best practices for interacting with input fields and validating user keyboard events,
 * ensuring that both standard and special keys are handled as expected.
 */

@Epic("Core Selenium Tests")
@Feature("Keyboard Actions Module")
public class KeyboardActionsTests extends BaseTest {
	
	KeyboardPage kp;
	
	@Story("Type and verify keyboard input detection")
	@Test(description = "Type 'Selenium' and verify each key is detected correctly")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Types the word 'Selenium' and verifies that each key press is detected correctly")
	public void typeKeysTest() throws InterruptedException {
    	
		// Initialize the KeyboardPage object with driver
		kp = new KeyboardPage(driver);
		
		// Define the word to type
		String word = "Selenium";
		
		// Loop through each character in the word
		for (char letter : word.toCharArray()) {

			// Type the character into the input field
			kp.sendCharacter(letter);

			// Assertion: Verify that the web page correctly displays the last entered key
			Assert.assertTrue(kp.isKeyDisplayed(letter),
				"Expected key '" + Character.toUpperCase(letter) + "' was not detected after typing."
			);
		}
	}
		
	@Story("Verify special key input detection")
	@Test(description = "Verify that special keys are detected correctly")
	@Severity(SeverityLevel.NORMAL)
	@Description("Sends special keys (Escape, Backspace, Tab, Shift) and verifies they are detected correctly")
	public void typeSpecialKeysTest() throws InterruptedException {
		
		// Initialize the KeyboardPage object with driver
		kp = new KeyboardPage(driver);
		
		// Define an array of special keys to test
		Keys[] specialKeys = {Keys.ESCAPE, Keys.BACK_SPACE, Keys.TAB, Keys.SHIFT};
		
		// Loop through each special key
		for (Keys key : specialKeys) {
			
			// Send the special key to the input field
			kp.sendSpecialKey(key);

			// Assertion: Verify that the correct key was detected on the page
			Assert.assertTrue(kp.isSpecialKeyDisplayed(key),
				"Expected special key '" + key.name() + "' was not detected after sending."
			);
		}
	}
}
