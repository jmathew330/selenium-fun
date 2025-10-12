package core;

import org.openqa.selenium.Alert;
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

/**
 * AlertsTests demonstrates handling of different types of JavaScript alerts
 * using Selenium WebDriver. The class covers:
 * 
 * 1. Simple Alert: A basic alert with only an OK button. Verifies the alert text
 *    and the resulting message on the page after accepting the alert.
 * 
 * 2. Confirmation Alert: An alert with OK and Cancel options. Verifies the alert
 *    text and the resulting message on the page after dismissing or accepting the alert.
 * 
 * 3. Prompt Alert: An alert that accepts user input. Verifies the alert text, sends
 *    input to the prompt, and validates the resulting message on the page.
 * 
 * These tests demonstrate best practices for interacting with JavaScript alerts
 * and validating both the alert content and its impact on the web page.
 */


@Epic("Core Selenium Tests")
@Feature("Alerts Module")
public class AlertsTests extends BaseTest {

    @Story("Verify simple alert behavior")
    @Test(description = "Verify simple alert text and result after accepting")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a simple JavaScript alert: verifies its text and the page result after accepting it")
    public void simpleAlertTest() throws InterruptedException {
		
        // Locate the button that triggers the simple alert
        WebElement button_SimpleAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        // Pause to visually observe the demo
        pauseForDemo();
        button_SimpleAlert.click();

        // Switch focus to the alert
        Alert alert_simple = driver.switchTo().alert();
        // Pause to visually observe the demo
        pauseForDemo();
        // Capture alert text
        String alert_simple_text = alert_simple.getText();
        // Assertion: Verify alert displays the correct message
        Assert.assertTrue(alert_simple_text.contains("I am a JS Alert"), 
                "Alert text mismatch for simple alert");

        // Accept the alert
        alert_simple.accept();

        // Capture the result text displayed on the page
        WebElement p_result = driver.findElement(By.id("result"));
        String p_result_text = p_result.getText();
        // Assertion: Verify page shows expected result message after accepting alert
        Assert.assertTrue(p_result_text.contains("You successfully clicked an alert"), 
                "Result text mismatch for simple alert");
    }
	
    @Story("Verify confirmation alert behavior")
    @Test(description = "Verify confirmation alert text and result after dismissing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a JavaScript confirmation alert: verifies alert text and the page result after dismissing it")
    public void confirmationAlertTest() throws InterruptedException {
		
        // Locate the button that triggers the confirmation alert
        WebElement button_ConfirmAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        // Pause to visually observe the demo
        pauseForDemo();
        button_ConfirmAlert.click();

        // Switch focus to the alert
        Alert alert_confirm = driver.switchTo().alert();
        // Pause to visually observe the demo
        pauseForDemo();

        // Capture alert text
        String alert_confirm_text = alert_confirm.getText();
        // Assertion: Verify alert displays the correct confirmation message
        Assert.assertTrue(alert_confirm_text.contains("I am a JS Confirm"), 
                "Alert text mismatch for confirmation alert");

        // Dismiss the alert (simulate clicking 'Cancel')
        alert_confirm.dismiss();

        // Capture the result text displayed on the page
        WebElement p_result = driver.findElement(By.id("result"));
        String p_result_text = p_result.getText();
        // Assertion: Verify page shows correct result message after dismissing alert
        Assert.assertTrue(p_result_text.contains("You clicked: Cancel"), 
                "Result text mismatch for confirmation alert");
    }
	
    @Story("Verify prompt alert behavior")
    @Test(description = "Verify prompt alert text, enter input, and check result")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a JavaScript prompt alert: enters text, verifies alert text, and the page result")
    public void promptAlertTest() throws InterruptedException {
		
        // Locate the button that triggers the prompt alert
        WebElement button_PromptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        // Pause to visually observe the demo
        pauseForDemo();
        button_PromptAlert.click();

        // Switch focus to the alert
        Alert alert_prompt = driver.switchTo().alert();
        // Pause to visually observe the demo
        pauseForDemo();

        // Enter text into the prompt alert
        alert_prompt.sendKeys("Testing is fun");

        // Capture alert text
        String alert_prompt_text = alert_prompt.getText();
        // Assertion: Verify prompt displays correct message
        Assert.assertTrue(alert_prompt_text.contains("I am a JS prompt"), 
                "Alert text mismatch for prompt alert");

        // Accept the prompt alert
        alert_prompt.accept();

        // Capture the result text displayed on the page
        WebElement p_result = driver.findElement(By.id("result"));
        String p_result_text = p_result.getText();
        // Assertion: Verify page shows the text entered in the prompt
        Assert.assertTrue(p_result_text.contains("You entered: Testing is fun"), 
                "Result text mismatch for prompt alert");
    }
}