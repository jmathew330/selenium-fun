package core;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.*;
import utils.JavascriptExecutorTestsUtils;

/**
 * JavascriptExecutorTests demonstrates how to use Selenium's JavaScriptExecutor 
 * for advanced web interactions that are not easily achievable with standard WebDriver commands.
 * 
 * The class covers:
 * 1. Scrolling: Scrolls the page vertically by pixels, to the bottom, and back to the top.
 * 2. Clicking elements: Performs a click via JavaScript on a button and verifies the resulting message.
 * 3. Setting and retrieving input values: Populates form fields using JS, submits the form, 
 *    retrieves values from the output table, and validates that the entered data matches expectations.
 * 
 * These tests highlight the ability to execute JavaScript directly within the browser context, 
 * providing control over actions such as dynamic clicks, form manipulation, and scrolling, 
 * which are useful when standard WebDriver actions are insufficient.
 */

@Epic("Core Selenium Tests")
@Feature("JavaScript Executor Module")
public class JavascriptExecutorTests extends BaseTest {

    @Story("Scroll vertically and verify page movement")
    @Test(description = "Scrolls page up and down using JS commands")
    @Severity(SeverityLevel.MINOR)
    @Description("Uses JavaScriptExecutor to scroll down, scroll to bottom, and return to top of the page.")
    public void scrollTest() throws InterruptedException {

        // Pause to visually observe the demo
        pauseForDemo();

        // Scroll down by 200 pixels
        js.executeScript("window.scrollBy(0, 200);");

        // Pause to visually observe the demo
        pauseForDemo();

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Pause to visually observe the demo
        pauseForDemo();

        // Scroll back to the top
        js.executeScript("window.scrollTo(0,0);");

        // Pause to visually observe the demo
        pauseForDemo();
    }
	
    @Story("Click elements using JavaScriptExecutor")
    @Test(description = "Clicks a button using JS and verifies success message")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Executes JavaScript click on 'Click Me' button and verifies dynamic success message.")
    public void clickTest() throws InterruptedException {

        // Open demo site with button click functionality
        JavascriptExecutorTestsUtils.openDemoQASite(driver, js);

        // Locate the 'Click Me' button
        WebElement button_ClickMe = driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])"));

        // Click the button using JS
        js.executeScript("arguments[0].click();", button_ClickMe);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Locate and verify success message
        WebElement p_message = driver.findElement(By.id("dynamicClickMessage"));
        String p_message_text = p_message.getText();

        // Assertion to confirm click worked
        Assert.assertTrue(p_message_text.contains("You have done a dynamic click"));
    }
	
    @Story("Set and verify input field values using JavaScriptExecutor")
    @Test(description = "Fills form using JS, submits, and validates entered data")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Fills out form fields via JS, submits form, retrieves data from table, and validates values.")
    public void setValuesTest2() throws InterruptedException {

        // Open Demo QA Form page
        JavascriptExecutorTestsUtils.openDemoQASite_Form(driver, js);

        // Locate all input fields
        WebElement input_firstName = driver.findElement(By.id("firstName"));
        WebElement input_lastName = driver.findElement(By.id("lastName"));
        WebElement input_email = driver.findElement(By.id("userEmail"));
        WebElement input_gender = driver.findElement(By.xpath("//input[@value='Male']"));
        WebElement input_phone = driver.findElement(By.id("userNumber"));
        WebElement input_dob = driver.findElement(By.id("dateOfBirthInput"));
        WebElement input_address = driver.findElement(By.id("currentAddress"));

        // Populate fields using JSExecutor
        js.executeScript("arguments[0].value = 'FNTest';", input_firstName);
        js.executeScript("arguments[0].value = 'LNTest';", input_lastName);
        js.executeScript("arguments[0].value = 'testemail123@email.com';", input_email);
        js.executeScript("arguments[0].click();", input_gender);
        js.executeScript("arguments[0].value = '1234567890';", input_phone);
        js.executeScript("arguments[0].value = '11 Jan 2005';", input_dob);
        js.executeScript("arguments[0].value = '123 QA Lane';", input_address);

        // Wait for the submit button to be clickable
        WebElement button_submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")));

        // Click the submit button via JS
        js.executeScript("arguments[0].click();", button_submit);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Retrieve field values via JS
        String input_firstName_value = (String) js.executeScript("return arguments[0].value;", input_firstName);
        String input_lastName_value = (String) js.executeScript("return arguments[0].value;", input_lastName);
        String input_email_value = (String) js.executeScript("return arguments[0].value;", input_email);
        String input_gender_value = (String) js.executeScript("return arguments[0].value;", input_gender);
        String input_phone_value = (String) js.executeScript("return arguments[0].value;", input_phone);
        String input_dob_value = (String) js.executeScript("return arguments[0].value;", input_dob);
        String input_address_value = (String) js.executeScript("return arguments[0].value;", input_address);

        // Retrieve submitted data from output table
        List<String> formData = JavascriptExecutorTestsUtils.retrieveValuesFromTableColumn(driver, "//table//tbody//tr//td[2]");

        // Split full name for comparison
        String[] name = formData.get(0).split(" ");
        input_firstName_value = name[0];
        input_lastName_value = name[1];
        input_email_value = formData.get(1);
        input_gender_value = formData.get(2);
        input_phone_value = formData.get(3);
        input_address_value = formData.get(5);

        // Assertions to verify data integrity
        Assert.assertEquals(input_firstName_value, "FNTest");
        Assert.assertEquals(input_lastName_value, "LNTest");
        Assert.assertEquals(input_email_value, "testemail123@email.com");
        Assert.assertEquals(input_gender_value, "Male");
        Assert.assertEquals(input_phone_value, "1234567890");
        JavascriptExecutorTestsUtils.assertInputOutputDates(formData, 4, "dd MMM yyyy", "dd MMMM,yyyy", input_dob_value);
        Assert.assertEquals(input_address_value, "123 QA Lane");
    }
}
