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
import pages.RadioButtonsPage;

/**
 * RadioButtonsTests contains Selenium tests to validate single radio button selection
 * and confirmation message functionality.
 */
@Epic("Core Selenium Tests")
@Feature("Radio Button Handling Module")
public class RadioButtonsTests extends BaseTest {
	
	// Declare an instance of the RadioButtonsPage
	RadioButtonsPage rp;

    // ----------------------------
    // Select 'Yes' radio button
    // ----------------------------
    @Story("Select the 'Yes' radio button")
    @Test(description = "Click the 'Yes' radio button and verify that it is selected")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks the 'Yes' radio button and verifies that it is selected and the confirmation message displays 'You have selected Yes'.")
    public void selectRadioButtonTest() throws InterruptedException {

    	// Initialize the RadioButtonsPage with driver and JavaScript executor
    	rp = new RadioButtonsPage(driver, js);
    	
    	// Click on the 'Yes' radio button
    	rp.clickinput_radio_Yes();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assert that the 'Yes' radio button is selected
        Assert.assertTrue(rp.is_input_radio_Yes_Selected(), "'Yes' radio button should be selected.");
        
        // Assert that the confirmation message contains the correct text
        Assert.assertTrue(rp.get_p_confirmSelect_Text().contains("You have selected Yes"),
                "Confirmation message should contain 'You have selected Yes'.");
    }

    // ----------------------------
    // Select 'Impressive' radio button
    // ----------------------------
    @Story("Select the 'Impressive' radio button")
    @Test(description = "Click the 'Impressive' radio button and verify that it is selected")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks the 'Impressive' radio button and verifies that it is selected and the confirmation message displays 'You have selected Impressive'.")
    public void selectOtherRadioButtonTest() throws InterruptedException {
    
    	// Initialize the RadioButtonsPage with driver and JavaScript executor
    	rp = new RadioButtonsPage(driver, js);
    	
    	// Click on the 'Impressive' radio button
    	rp.click_input_radio_Impressive();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Assert that the 'Impressive' radio button is selected
        Assert.assertTrue(rp.is_input_radio_Impressive_Selected(), "'Impressive' radio button should be selected.");

        // Assert that the confirmation message contains the correct text
        Assert.assertTrue(rp.get_p_confirmSelect_Text().contains("You have selected Impressive"),
                "Confirmation message should contain 'You have selected Impressive'.");
    }
    
    // ----------------------------
    // Verify 'No' radio button is disabled
    // ----------------------------
    @Story("Verify that the 'No' radio button is disabled")
    @Test(description = "Verify that the 'No' radio button is not clickable or selectable")
    @Severity(SeverityLevel.MINOR)
    @Description("Checks that the 'No' radio button is disabled and cannot be interacted with or selected by the user.")
    public void verifyDisabledRadioButtonTest() throws InterruptedException {
    	
    	// Initialize the RadioButtonsPage with driver and JavaScript executor
    	rp = new RadioButtonsPage(driver, js);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify that the radio button is disabled
        Assert.assertFalse(rp.is_input_radio_No_Enabled(), "'No' radio button should be disabled.");

        // Try clicking it via JS (should have no effect)
        rp.click_input_radio_No();

        // Confirm it’s still not selected
        Assert.assertFalse(rp.is_input_radio_No_Selected(), "'No' radio button should remain unselected.");
    }
}
