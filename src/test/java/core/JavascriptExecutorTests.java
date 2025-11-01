package core;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.JavascriptExecutorPage;

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
	
	JavascriptExecutorPage jp;

    @Story("Scroll vertically and verify page movement")
    @Test(description = "Scrolls page up and down using JS commands")
    @Severity(SeverityLevel.MINOR)
    @Description("Uses JavaScriptExecutor to scroll down, scroll to bottom, and return to top of the page.")
    public void scrollTest() throws InterruptedException {
    	
    	jp = new JavascriptExecutorPage(driver, js, wait);

        // Pause to visually observe the demo
        pauseForDemo();

        // Scroll down by 200 pixels
        jp.scrollPageBy200Px();
        //js.executeScript("window.scrollBy(0, 200);");

        // Pause to visually observe the demo
        pauseForDemo();

        // Scroll to the bottom of the page
        jp.scrollPageToBottom();
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Pause to visually observe the demo
        pauseForDemo();

        // Scroll back to the top
        jp.scrollPageToTop();
        //js.executeScript("window.scrollTo(0,0);");

        // Pause to visually observe the demo
        pauseForDemo();
    }
	
    @Story("Click elements using JavaScriptExecutor")
    @Test(description = "Clicks a button using JS and verifies success message")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Executes JavaScript click on 'Click Me' button and verifies dynamic success message.")
    public void clickTest() throws InterruptedException {
    	
    	jp = new JavascriptExecutorPage(driver, js, wait);

        // Open demo site with button click functionality
    	jp.openButtonsPage();

    	// Click the button using JS
    	jp.click_button_ClickMe();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Assertion to confirm click worked
        Assert.assertTrue(jp.get_p_message_Text().contains("You have done a dynamic click"));
    }
	
    @Story("Set and verify input field values using JavaScriptExecutor")
    @Test(description = "Fills form using JS, submits, and validates entered data")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Fills out form fields via JS, submits form, retrieves data from table, and validates values.")
    public void setValuesTest2() throws InterruptedException {
    	
    	jp = new JavascriptExecutorPage(driver, js, wait);

        // Open Demo QA Form page
    	jp.openFormPage();
  
        // Populate fields using JSExecutor
    	jp.fillOutForm();

        // Click the submit button via JS
    	jp.clickSubmit();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Retrieve field values via JS
        String input_firstName_value = jp.get_input_firstName_value();
        String input_lastName_value = jp.get_input_lastName_value();
        String input_email_value = jp.get_input_email_value();
        String input_gender_value = jp.get_input_gender_value();
        String input_phone_value = jp.get_input_phone_value();
        String input_dob_value = jp.get_input_dob_value();
        String input_address_value = jp.get_input_address_value();

        // Retrieve submitted data from output table
        List<String> formData = jp.retrieveValuesFromTable(driver, "//table//tbody//tr//td[2]");
        
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
        jp.assertInputOutputDates(formData, 4, "dd MMM yyyy", "dd MMMM,yyyy", input_dob_value);
        Assert.assertEquals(input_address_value, "123 QA Lane");
    }
}
