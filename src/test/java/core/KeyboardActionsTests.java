package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class KeyboardActionsTests extends BaseTest {
	
	@Epic("Core Selenium Tests")
	@Feature("Keyboard Actions Module")
	@Story("Type and verify keyboard input detection")
	@Test(description = "Type 'Selenium' and verify each key is detected correctly")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Types the word 'Selenium' and verifies that each key press is detected correctly")
    public void typeKeysTest() {
		
        // Locate the input field where keys will be typed
        WebElement input_target = driver.findElement(By.id("target"));

        // Locate the paragraph element where the site displays the last key pressed
        WebElement p_result = driver.findElement(By.id("result"));

        // Define the word we want to type
        String word = "Selenium";

        // Convert the word into a char array so we can loop through each letter
        char[] letters = word.toCharArray();

        // Loop through each character in the word
        for (char letter : letters) {

            // Convert each character to uppercase since the site reports in uppercase
            String key = String.valueOf(letter).toUpperCase();

            // Type the character into the input box
            input_target.sendKeys(String.valueOf(letter));

            // Capture the displayed message after each key press
            String p_result_text = p_result.getText();

            // Assertion: Verify the displayed message contains the expected text
            Assert.assertTrue(p_result_text.contains("You entered: " + key), 
            		"Expected 'You entered: " + key + "' but got: " + p_result_text);
        }
		
        }

	@Epic("Core Selenium Tests")
	@Feature("Keyboard Actions Module")
	@Story("Verify special key input detection")
	@Test(description = "Verify that special keys are detected correctly")
	@Severity(SeverityLevel.NORMAL)
	@Description("Sends special keys (Escape, Backspace, Tab, Shift) and verifies they are detected correctly")
    public void typeSpecialKeysTest() {
        // Locate the same input field where special keys will be pressed
        WebElement input_target = driver.findElement(By.id("target"));

        // Locate the element that shows which key was pressed
        WebElement p_result = driver.findElement(By.id("result"));

        // Create an array of special keys we want to test
        Keys[] specialKeys = {Keys.ESCAPE, Keys.BACK_SPACE, Keys.TAB, Keys.SHIFT};

        // Loop through each special key
        for (Keys key : specialKeys) {

            // Send the special key to the input field
            input_target.sendKeys(key);

            // Capture the displayed message for the special key
            String p_result_text = p_result.getText();
            
            // Assertion: Verify the correct special key name is displayed
            Assert.assertTrue(p_result_text.contains("You entered: " + key.name()),
                    "Expected 'You entered: " + key.name() + "' but got: " + p_result_text);
        }
    }
}