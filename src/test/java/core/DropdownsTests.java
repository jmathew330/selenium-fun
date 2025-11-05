package core;

import java.util.ArrayList;
import java.util.List;
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
import pages.DropdownsPage;

/**
 * DropdownsTests contains Selenium tests to validate dropdown selection
 * functionality. Includes selection by visible text, value, index, and 
 * handling of multi-select dropdowns.
 */

@Epic("Core Selenium Tests") // Allure annotation to group tests under a common Epic
@Feature("Dropdown Handling Module") // Allure annotation to identify the tested feature
public class DropdownsTests extends BaseTest {
	
	DropdownsPage dp; // Page object for dropdown-related actions

    // ----------------------
    // Single-selection dropdown tests
    // ----------------------

    @Story("Select option by visible text") // Allure annotation to describe user story
    @Test(description = "Select 'Brazil' from country dropdown by visible text and validate selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects an option by visible text from the dropdown and verifies it was selected correctly.")
    public void selectByVisibleText() throws InterruptedException {
    	
    	// Initialize the DropdownsPage object with driver and JavascriptExecutor
    	dp = new DropdownsPage(driver, js);
    	
    	// Scroll to dropdown section
    	dp.scrollToDropdowns();
    	
        // Highlight the element for demo
        dp.highlight_select_country_element();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Select option by visible text
        dp.selectCountryByVisibleText("Brazil");
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Get selected option (not used, but may be for debugging/logging)
        dp.getFirstSelectedCountryOption();
        
        // Get selected option text (used for validation)
        dp.getFirstSelectedCountryOptionText();
        
        // Assert the selected option is marked as selected
        Assert.assertTrue(dp.isCountryOptionSelected(), "Option should be selected.");
        
        // Assert the selected option text contains "Brazil"
        Assert.assertTrue(dp.getFirstSelectedCountryOptionText().contains("Brazil"), "Selected option text should contain 'Brazil'.");
    }

    @Story("Select option by value")
    @Test(description = "Select 'France' from country dropdown by value and validate selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects an option by value from the dropdown and verifies the correct option was selected.")
    public void selectByValue() throws InterruptedException {
       
    	// Initialize the DropdownsPage object with driver and JavascriptExecutor
    	dp = new DropdownsPage(driver, js);
        
        // Scroll to dropdown section
        dp.scrollToDropdowns();

        // Highlight the element for demo
        dp.highlight_select_country_element();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Select option by value
        dp.selectCountryByValue("france");
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assert the selected option is marked as selected
        Assert.assertTrue(dp.isCountryOptionSelected(), "Option should be selected.");
        
        // Assert the selected option text contains "France"
        Assert.assertTrue(dp.getFirstSelectedCountryOptionText().contains("France"), "Selected option text should contain 'France'.");
    }

    @Story("Select option by index")
    @Test(description = "Select 'India' from country dropdown by index and validate selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects an option by index from the dropdown and validates that the expected option is chosen.")
    public void selectByIndex() throws InterruptedException {
    	
    	// Initialize the DropdownsPage object with driver and JavascriptExecutor
    	dp = new DropdownsPage(driver, js);
    	
    	// Scroll to dropdown section
    	dp.scrollToDropdowns();

        // Highlight the element for demo
    	dp.highlight_select_country_element();
    	
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Select option by index (e.g., 9 = "India")
        dp.selectCountryByIndex(9);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Assert the selected option is marked as selected
        Assert.assertTrue(dp.isCountryOptionSelected(), "Option should be selected.");
        
        // Assert the selected option text contains "India"
        Assert.assertTrue(dp.getFirstSelectedCountryOptionText().contains("India"), "Selected option text should contain 'India'.");
    }

    // ----------------------
    // Multi-selection dropdown test
    // ----------------------

    @Story("Select multiple options")
    @Test(description = "Select multiple options from colors dropdown and validate selections")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects multiple options in a multi-select dropdown and validates the selections.")
    public void selectMultiDropdown() throws InterruptedException {
    	
    	// Initialize the DropdownsPage object with driver and JavascriptExecutor
    	dp  = new DropdownsPage(driver, js);
    	
    	// Scroll to multi-select dropdown section
    	dp.scrollToDropdowns();
    	
    	// Check if the colors dropdown supports multi-select
    	dp.isColorsMultiSelect();
    	
        // Highlight the element for demo
    	dp.highlight_select_colors_element();
    	
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Select "Blue" by visible text
        dp.selectColorByVisibleText("Blue");
        
        // Pause to visually observe the demo before making selection
        pauseForDemo();
        
        // Select "White" by value
        dp.selectColorByValue("white");
        
        // Pause to visually observe the demo before making selection
        pauseForDemo();
        
        // Select a color by index (e.g., index 3 = "Yellow")
        dp.selectColorByIndex(3);
        
        // Pause to visually observe the demo before making selection
        pauseForDemo();

        // Retrieve all selected options from the dropdown
        List<WebElement> selectedOptions = dp.getAllSelectedColorOptions();
        
        // Store selected option texts for assertion
        List<String> actualOptions = new ArrayList<>();
        
        // Validate each selected option is selected and collect its text
        for (WebElement option : selectedOptions) {
            Assert.assertTrue(option.isSelected(), "Option should be selected: " + option.getText());
            actualOptions.add(option.getText());
        }

        // Assert that all expected selections are present
        Assert.assertTrue(actualOptions.contains("Blue"), "Multi-select should contain 'Blue'.");
        Assert.assertTrue(actualOptions.contains("White"), "Multi-select should contain 'White'.");
        Assert.assertTrue(actualOptions.contains("Yellow"), "Multi-select should contain 'Yellow'.");
    }
}
