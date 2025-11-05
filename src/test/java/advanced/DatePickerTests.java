package advanced;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.DatePickerPage;

/**
 * DatePickerTests contains Selenium tests for interacting with a jQuery UI datepicker.
 * 
 * Includes tests for selecting future and past dates, validating that the selected
 * date appears correctly in the input field.
 */

@Epic("Advanced Selenium Tests") // Group tests under an Epic for Allure reporting
@Feature("DatePicker Handling Module") // Identify the feature under test
public class DatePickerTests extends BaseTest {
	
	DatePickerPage dp; // Page object for datepicker-related actions

	// ----------------------
	// Test: Selecting a Future Date
	// ----------------------
	@Story("Select a future date") // Describe the user story
	@Test(description = "Select January 26, 2026 from the datepicker and validate the input field")
	@Severity(SeverityLevel.NORMAL)
	@Description("Scrolls to the datepicker, opens it, selects a future date, and validates the formatted date value in the input field.")
	public void selectFutureDateTest() throws InterruptedException {

		// Initialize the DatePickerPage object with driver and JavascriptExecutor
		dp = new DatePickerPage(driver, js);
		
		// Define the expected date to select
		String expectedMonth = "January";
		String expectedDate = "26";
		String expectedYear = "2026";
		String expectedFormattedValue = "01/26/2026";
		
		// Scroll to the datepicker input field
		dp.scrollToDatePicker();
		
		// Click the datepicker input to open the calendar popup
		dp.click_input_datepicker();
		
		// Select the expected date
		dp.selectDate(expectedMonth, expectedDate, expectedYear);
		
		// Retrieve the actual selected value from the input
		String actualFormattedValue = dp.getSelectedDate();
		
        // Pause to visually observe the demo
		pauseForDemo();

		// Assert that the selected date matches the expected value
		Assert.assertEquals(actualFormattedValue, expectedFormattedValue, "Selected date should match expected future date.");
	}
	
	// ----------------------
	// Test: Selecting a Past Date
	// ----------------------
	@Story("Select a past date")
	@Test(description = "Select March 30, 2021 from the datepicker and validate the input field")
	@Severity(SeverityLevel.NORMAL)
	@Description("Scrolls to the datepicker, opens it, selects a past date, and validates the formatted date value in the input field.")
	public void selectPastDateTest() throws InterruptedException {

		// Initialize the DatePickerPage object with driver and JavascriptExecutor
		dp = new DatePickerPage(driver, js);
		
		// Define the expected past date to select
		String expectedMonth = "March";
		String expectedDate = "30";
		String expectedYear = "2021";
		String expectedFormattedValue = "03/30/2021";
		
		// Scroll to the datepicker input field
		dp.scrollToDatePicker();
		
		// Click the datepicker input to open the calendar popup
		dp.click_input_datepicker();
		
		// Select the expected date
		dp.selectDate(expectedMonth, expectedDate, expectedYear);
		
		// Retrieve the actual selected value from the input
		String actualFormattedValue = dp.getSelectedDate();
		
        // Pause to visually observe the demo
		pauseForDemo();
		
		// Assert that the selected date matches the expected value
		Assert.assertEquals(actualFormattedValue, expectedFormattedValue, "Selected date should match expected past date.");
	}

}
