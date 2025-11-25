package advanced;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.ShadowDOMPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * ShadowDOMTest contains Selenium tests for interacting with Shadow DOM elements.
 * 
 * Each test validates a different element or interaction inside a Shadow DOM structure,
 * including text validation, input typing, checkbox selection, and file input visibility.
 */

@Epic("Advanced Selenium Tests")
@Feature("Shadow DOM Handling Module")
public class ShadowDOMTest extends BaseTest {

    // Declare the page object reference
    ShadowDOMPage sp;

    // ----------------------
    // Separate Allure-enhanced tests
    // ----------------------

    /**
     * Test 1: Validate the <span> text inside the Shadow DOM
     * 
     * Objective: Ensure the text inside the shadow-hosted <span> contains "Mobiles"
     */
    @Story("Validate Shadow DOM text elements")
    @Test(description = "Validate <span> text inside Shadow DOM")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ensures that the <span> element inside the shadow host displays 'Mobiles'.")
    public void validateShadowSpanText() throws InterruptedException {
    	
        // Initialize the ShadowDOMPage object with driver and JavascriptExecutor
        sp = new ShadowDOMPage(driver, js);
    	
        // Scroll to the Shadow DOM area on the page
        sp.scrollToShadowDOM();

        // Pause to visually observe the demo
        pauseForDemo();

        // Verify that the <span> element inside the Shadow DOM contains the expected text
        Assert.assertTrue(sp.getShadowHostSpanText().contains("Mobiles"),
                "<span> text should contain 'Mobiles'");
    }

    /**
     * Test 2: Validate the nested <div> text inside Shadow DOM
     * 
     * Objective: Ensure that text inside the nested shadow host’s <div> contains "Laptops"
     */
    @Story("Validate Shadow DOM nested elements")
    @Test(description = "Validate nested <div> text inside Shadow DOM")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ensures that the nested <div> inside the nested shadow host displays 'Laptops'.")
    public void validateNestedShadowDivText() throws InterruptedException {
    	
        // Initialize the ShadowDOMPage object with driver and JavascriptExecutor
        sp = new ShadowDOMPage(driver, js);
        
        // Scroll to the Shadow DOM section
        sp.scrollToShadowDOM();

        // Pause to visually observe the demo
        pauseForDemo();

        // Verify that the nested <div> inside the Shadow DOM contains the expected text
        Assert.assertTrue(sp.getNestedShadowHostDivText().contains("Laptops"),
                "Nested <div> text should contain 'Laptops'");
    }

    /**
     * Test 3: Validate the link (<a>) text inside the Shadow DOM
     * 
     * Objective: Ensure the link text inside the shadow host contains "Blog"
     */
    @Story("Validate Shadow DOM links")
    @Test(description = "Validate <a> link text inside Shadow DOM")
    @Severity(SeverityLevel.MINOR)
    @Description("Checks that the <a> link inside the shadow host displays 'Blog'.")
    public void validateShadowLinkText() throws InterruptedException {
    	
        // Initialize the ShadowDOMPage object with driver and JavascriptExecutor
        sp = new ShadowDOMPage(driver, js);
        
        // Scroll to the Shadow DOM
        sp.scrollToShadowDOM();

        // Pause to visually observe the demo
        pauseForDemo();

        // Verify the <a> link text inside the Shadow DOM
        Assert.assertTrue(sp.getShadowHostLinkText().contains("Blog"),
                "<a> link text should contain 'Blog'");
    }

    /**
     * Test 4: Validate entering text into a Shadow DOM input field
     * 
     * Objective: Type text into a shadow-hosted input and verify that the input value matches
     */
    @Story("Validate Shadow DOM input fields")
    @Test(description = "Validate entering text into Shadow DOM input")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies that text can be entered into the shadow DOM input and the entered value is retained.")
    public void validateShadowInput() throws InterruptedException {
    	
        // Initialize the ShadowDOMPage object with driver and JavascriptExecutor
        sp = new ShadowDOMPage(driver, js);
        
        // Scroll to the Shadow DOM
        sp.scrollToShadowDOM();

        // Enter text into the input field inside the Shadow DOM
        sp.enterTextToInput();

        // Pause to visually observe the demo
        pauseForDemo();

        // Validate that the text entered into the input matches the expected value
        Assert.assertTrue(sp.getInputValue().contains("This is a Shadow DOM input"),
                "Input value should match entered text");
    }

    /**
     * Test 5: Validate selecting a checkbox inside the Shadow DOM
     * 
     * Objective: Select a checkbox inside the shadow host and confirm its selection status
     */
    @Story("Validate Shadow DOM checkboxes")
    @Test(description = "Validate selecting Shadow DOM checkbox")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensures that the checkbox inside the shadow host can be selected and remains checked.")
    public void validateShadowCheckbox() throws InterruptedException {
    	
        // Initialize the ShadowDOMPage object with driver and JavascriptExecutor
        sp = new ShadowDOMPage(driver, js);
        
        // Scroll to the Shadow DOM
        sp.scrollToShadowDOM();

        // Select the checkbox inside the Shadow DOM
        sp.selectCheckbox();

        // Pause to visually observe the demo
        pauseForDemo();

        // Verify that the checkbox is selected successfully
        Assert.assertTrue(sp.isCheckboxSelected(), "Checkbox should be selected");
    }

    /**
     * Test 6: Validate visibility of file input inside Shadow DOM
     * 
     * Objective: Ensure that the file input element inside the shadow host is visible to the user
     */
    @Story("Validate Shadow DOM file inputs")
    @Test(description = "Validate visibility of file input inside Shadow DOM")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifies that the file input element inside the shadow host is visible on the page.")
    public void validateFileInputVisibility() throws InterruptedException {
    	
        // Initialize the ShadowDOMPage object with driver and JavascriptExecutor
        sp = new ShadowDOMPage(driver, js);
        
        // Scroll to the Shadow DOM
        sp.scrollToShadowDOM();

        // Pause to visually observe the demo
        pauseForDemo();

        // Assert that the file input element inside the Shadow DOM is displayed on the page
        Assert.assertTrue(sp.isFileInputElementVisible(),
                "File input element should be visible");
    }
}
