package core;


import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.AlertsPage;

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
	
AlertsPage ap;


    @Story("Verify simple alert behavior")
    @Test(description = "Verify simple alert text and result after accepting")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a simple JavaScript alert: verifies its text and the page result after accepting it")
    public void simpleAlertTest() throws InterruptedException {
    	
    	//Initialize the AlertsPage object with driver
		ap = new AlertsPage(driver);
		
        // Pause to visually observe the demo
        pauseForDemo();
        
        //Click the button that triggers the simple alert
        ap.click_button_SimpleAlert();

        // Switch focus to the alert
        ap.switchToAlert();
     
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify alert displays the correct message
        Assert.assertTrue(ap.getAlertText().contains("I am a JS Alert"), "Alert text mismatch for simple alert");

        // Accept the alert
        ap.acceptAlert();
        
        // Pause to visually observe the demo
        pauseForDemo();
       
        // Assertion: Verify page shows expected result message after accepting alert
        Assert.assertTrue(ap.get_p_result_Text().contains("You successfully clicked an alert"), "Result text mismatch for simple alert");

    }
	
    @Story("Verify confirmation alert behavior")
    @Test(description = "Verify confirmation alert text and result after dismissing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a JavaScript confirmation alert: verifies alert text and the page result after dismissing it")
    public void confirmationAlertTest() throws InterruptedException {
		
    	//Initialize the AlertsPage object with driver
    	ap = new AlertsPage(driver);
		
        // Pause to visually observe the demo
        pauseForDemo();
        
        //Click the button that triggers the confirmation alert
        ap.clickButton_ConfirmAlert();

        // Switch focus to the alert
        ap.switchToAlert();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify alert displays the correct confirmation message
        Assert.assertTrue(ap.getAlertText().contains("I am a JS Confirm"), "Alert text mismatch for confirmation alert");
        
        // Dismiss the alert (simulate clicking 'Cancel')
        ap.dismissAlert();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify page shows correct result message after dismissing alert
        Assert.assertTrue(ap.get_p_result_Text().contains("You clicked: Cancel"), "Result text mismatch for confirmation alert");
        
    }
    
    @Story("Verify prompt alert behavior")
    @Test(description = "Verify prompt alert text, enter input, and check result")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a JavaScript prompt alert: enters text, verifies alert text, and the page result")
    public void promptAlertTest() throws InterruptedException {
    	
    	//Initialize the AlertsPage object with driver
		ap = new AlertsPage(driver);
		
		// Click the button that triggers the prompt alert
    	ap.clickButton_PromptAlert();
    	
        // Pause to visually observe the demo
        pauseForDemo();

        // Switch focus to the alert
        ap.switchToAlert();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Enter text into the prompt alert
        ap.sendKeysToAlert("Testing is fun");
        
        // Assertion: Verify prompt displays correct message
        Assert.assertTrue(ap.getAlertText().contains("I am a JS prompt"), "Alert text mismatch for prompt alert");

        // Accept the prompt alert
        ap.acceptAlert();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify page shows the text entered in the prompt
        Assert.assertTrue(ap.get_p_result_Text().contains("You entered: Testing is fun"), "Result text mismatch for prompt alert");

    }
}