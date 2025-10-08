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

@Epic("Core Selenium Tests")
public class AlertsTests extends BaseTest {

    @Feature("Alerts Module")
    @Story("Verify simple alert behavior")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a simple JavaScript alert: verifies its text and the page result after accepting it")
    @Test(description = "Verify simple alert text and result after accepting")
    public void simpleAlertTest() {
        // Locate the button that triggers the simple alert
        WebElement button_SimpleAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button_SimpleAlert.click();

        // Switch focus to the alert
        Alert alert_simple = driver.switchTo().alert();

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

    @Feature("Alerts Module")
    @Story("Verify confirmation alert behavior")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a JavaScript confirmation alert: verifies alert text and the page result after dismissing it")
    @Test(description = "Verify confirmation alert text and result after dismissing")
    public void confirmationAlertTest() {
        // Locate the button that triggers the confirmation alert
        WebElement button_ConfirmAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button_ConfirmAlert.click();

        // Switch focus to the alert
        Alert alert_confirm = driver.switchTo().alert();

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

    @Feature("Alerts Module")
    @Story("Verify prompt alert behavior")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test handles a JavaScript prompt alert: enters text, verifies alert text, and the page result")
    @Test(description = "Verify prompt alert text, enter input, and check result")
    public void promptAlertTest() {
        // Locate the button that triggers the prompt alert
        WebElement button_PromptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button_PromptAlert.click();

        // Switch focus to the alert
        Alert alert_prompt = driver.switchTo().alert();

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