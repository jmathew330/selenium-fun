package pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * DatePickerPage contains methods to interact with a jQuery UI datepicker.
 * 
 * Includes scrolling to the datepicker, clicking it, retrieving selected date,
 * and selecting a specific date by navigating months and years.
 */

public class DatePickerPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	// ------------------------------------------
	// Constructor & PageFactory Initialization
	// ------------------------------------------
	public DatePickerPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
		PageFactory.initElements(driver, this);
	}
	
	// ------------------------------------------
	// WebElement Locators
	// ------------------------------------------
	@FindBy(xpath="//input[@id='datepicker']") WebElement input_datepicker;  // Input field for datepicker
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']") WebElement nextBtn;  // Button to go to next month
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-w']") WebElement prevBtn;  // Button to go to previous month
	
	// ------------------------------------------
	// Basic DatePicker Actions
	// ------------------------------------------
	/** Clicks the datepicker input field to open the calendar popup */
	public void click_input_datepicker() {
		input_datepicker.click();
	}
	
	/** Scrolls to the datepicker input field into view using JavaScript */
	public void scrollToDatePicker() {
		js.executeScript("arguments[0].scrollIntoView(true);", input_datepicker);
	}
	
	/** Retrieves the currently selected date from the datepicker input field */
	public String getSelectedDate() {
		return input_datepicker.getAttribute("value");
	}
	
	// ------------------------------------------
	// Month Mapping for Date Navigation
	// ------------------------------------------
	private static final Map<String, Integer> months = new HashMap<>();
	
	static {
		months.put("January", 1);
		months.put("February", 2);
		months.put("March", 3);
		months.put("April", 4);
		months.put("May", 5);
		months.put("June", 6);
		months.put("July", 7);
		months.put("August", 8);
		months.put("September", 9);
		months.put("October", 10);
		months.put("November", 11);
		months.put("December", 12);
	}
	
	// ------------------------------------------
	// Advanced Date Selection
	// ------------------------------------------
	/**
	 * Selects a specific date from the datepicker by navigating through months and years.
	 * 
	 * @param expectedMonth Month to select (e.g., "January")
	 * @param expectedDate Day of the month to select (e.g., "15")
	 * @param expectedYear Year to select (e.g., "2025")
	 */
	public void selectDate(String expectedMonth, String expectedDate, String expectedYear) {
		
		int expectedMonthInt = months.get(expectedMonth);  // Convert month name to integer
		int expectedYearInt = Integer.parseInt(expectedYear);  // Convert year string to integer
		
		while(true) {
			
			// Get the current month and year displayed on the datepicker
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			int currentMonthInt = months.get(currentMonth);
			int currentYearInt = Integer.parseInt(currentYear);
			
			// Break the loop if the expected month and year are displayed
			if(currentMonthInt == expectedMonthInt && currentYearInt == expectedYearInt ){
				break;
			}
			
			// Navigate to next or previous month/year depending on the target
			if(currentYearInt < expectedYearInt || (currentYearInt == expectedYearInt && currentMonthInt < expectedMonthInt)) {
				nextBtn.click();		
			} else {
				prevBtn.click();
			}
		}
		
		// Click the expected date once the correct month/year is displayed
		driver.findElement(By.xpath("//a[text()='" + expectedDate + "']")).click();
	}

}
