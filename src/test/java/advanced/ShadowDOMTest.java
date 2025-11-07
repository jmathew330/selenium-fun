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
 * Tests include reading text from shadow elements, entering text into inputs,
 * selecting checkboxes, and verifying the visibility of file input elements.
 */

@Epic("Advanced Selenium Tests") // Group tests under an Epic for Allure reporting
@Feature("Shadow DOM Handling Module") // Identify the feature under test
public class ShadowDOMTest extends BaseTest {

    ShadowDOMPage sp; // Page object for Shadow DOM actions

    // ----------------------
    // Test: Interacting with Shadow DOM Elements
    // ----------------------
    @Story("Read and interact with Shadow DOM elements") // Describe the user story
    @Test(description = "Validate text, input, checkbox, and file input inside Shadow DOM")
    @Severity(SeverityLevel.NORMAL)
    @Description("Validates reading text from shadow elements, entering text into shadow input, selecting checkboxes, and verifying file input visibility.")
    public void shadowDOMTextTest() throws InterruptedException {

        // Initialize the ShadowDOMPage object with WebDriver
        sp = new ShadowDOMPage(driver, js);
        
        sp.scrollToShadowDOM();

        // Validate that the <span> inside shadow host contains the text "Mobiles"
        Assert.assertTrue(sp.getShadowHostSpanText().contains("Mobiles"), "<span> text should contain 'Mobiles'");

        // Validate that the nested <div> inside nested shadow host contains the text "Laptops"
        Assert.assertTrue(sp.getNestedShadowHostDivText().contains("Laptops"), "Nested <div> text should contain 'Laptops'");

        // Validate that the <a> link inside shadow host contains the text "Blog"
        Assert.assertTrue(sp.getShadowHostLinkText().contains("Blog"), "<a> link text should contain 'Blog'");

        // Enter text into the text input inside the shadow host
        sp.enterTextToInput();

        // Pause for demo purposes to visually observe the input
        pauseForDemo();

        // Validate that the input value matches the entered text
        Assert.assertTrue(sp.getInputValue().contains("This is a Shadow DOM input"), "Input value should match entered text");

        // Select the checkbox inside the shadow host
        sp.selectCheckbox();

        // Pause for demo purposes to visually observe the checkbox selection
        pauseForDemo();

        // Validate that the checkbox is selected
        Assert.assertTrue(sp.isCheckboxSelected(), "Checkbox should be selected");

        // Validate that the file input element inside the shadow host is visible
        Assert.assertTrue(sp.isFileInputElementVisible(), "File input element should be visible");
    }
}