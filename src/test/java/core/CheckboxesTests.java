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
import pages.CheckboxesPage;

/**
 * CheckboxesTests contains Selenium tests to validate single and multiple
 * checkbox selection functionality.
 */
@Epic("Core Selenium Tests")
@Feature("Checkbox Handling Module")
public class CheckboxesTests extends BaseTest {
	
	CheckboxesPage cp;

    // ----------------------
    // Single checkbox test
    // ----------------------
    @Story("Select a single checkbox")
    @Test(description = "Select the first checkbox and validate that it is selected")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks the first checkbox on the page and verifies it is selected")
    public void testSingleCheckbox() throws InterruptedException {
    	
    	//Initialize the CheckboxesPage object with driver
    	cp = new CheckboxesPage(driver);

        // Click the checkbox to select it
    	cp.clickCheckbox1();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify that the checkbox is now selected
        Assert.assertTrue(cp.is_input_checkbox1_Selected(),  "Checkbox 1 should be selected.");
    }

    // ----------------------
    // Multiple checkboxes test
    // ----------------------
    @Story("Select multiple checkboxes")
    @Test(description = "Select multiple checkboxes, validate selections, and uncheck one")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects two checkboxes, verifies both are selected, then deselects one and verifies it is unselected")
    public void testMultipleCheckboxes() throws InterruptedException {
    	
    	//Initialize the CheckboxesPage object with driver
    	cp = new CheckboxesPage(driver);
    	
        // Ensure both checkboxes are selected
    	cp.verifyCheckboxesAreSelected();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify both checkboxes are selected
        Assert.assertTrue(cp.is_input_checkbox1_Selected(), "Checkbox 1 should be selected.");
        Assert.assertTrue(cp.is_input_checkbox2_Selected(), "Checkbox 2 should be selected.");

        // Deselect the second checkbox
        cp.clickCheckbox2();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify the second checkbox is now unselected
        Assert.assertFalse(cp.is_input_checkbox2_Selected(), "Checkbox 2 should be unselected after clicking.");
       
    }
}
