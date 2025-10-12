package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Utility class providing helper methods for JavaScript-based interactions
 * and data verification used in Selenium tests.
 */
public class JavascriptExecutorTestsUtils {
	
    /**
     * Opens the DemoQA Buttons page, zooms out for better visibility,
     * and scrolls to the buttons section.
     *
     * @param driver WebDriver instance
     * @param js     JavascriptExecutor used to execute JavaScript commands
     */
	public static void openDemoQASite(WebDriver driver, JavascriptExecutor js) {
		driver.get("https://demoqa.com/buttons");
		
		// Zoom out the page to 65% for better visibility during automation
		js.executeScript("document.body.style.zoom='65%';");
		
		// Locate the main content area and scroll it into view
		WebElement div_Buttons_body = driver.findElement(By.xpath("//div[@id='app']//div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", div_Buttons_body);
	}
	
    /**
     * Opens the DemoQA Automation Practice Form page, zooms out,
     * and scrolls to the main form area.
     *
     * @param driver WebDriver instance
     * @param js     JavascriptExecutor used to execute JavaScript commands
     */
	public static void openDemoQASite_Form(WebDriver driver, JavascriptExecutor js) {
		driver.get("https://demoqa.com/automation-practice-form");
		
		// Zoom out the page for better layout visibility
		js.executeScript("document.body.style.zoom='65%';");
		
		// Scroll to the form section to ensure it’s visible
		WebElement div_Buttons_body = driver.findElement(By.xpath("//div[@id='app']//div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", div_Buttons_body);
	}
	
    /**
     * Pauses execution for demonstration or debugging purposes.
     * Typically used to visually verify browser actions.
     *
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
	public static void pauseForDemo() throws InterruptedException {
		Thread.sleep(3000);
	}
	
    /**
     * Retrieves all non-empty text values from a given table column.
     *
     * @param driver WebDriver instance
     * @param xpath  XPath expression locating the table column cells
     * @return a List of non-empty text values found in the specified column
     */
	public static List<String> retrieveValuesFromTableColumn(WebDriver driver, String xpath) {
		
		// Find all elements matching the provided XPath
		List<WebElement> tableValues = driver.findElements(By.xpath(xpath));
		
		// Store only non-empty text values
		List<String> nonEmptyTableValues = new ArrayList<String>();
		
		for(WebElement value : tableValues) {
			String valueText = value.getText().trim();
			if(!valueText.isEmpty()) {
				nonEmptyTableValues.add(valueText);
			}
		}
		return nonEmptyTableValues;
	}
	
    /**
     * Validates that a parsed input date matches the corresponding
     * output date string from a list, based on given date formats.
     *
     * @param list             List of output date strings (e.g., from a table)
     * @param index            Index of the date to validate
     * @param inputDateFormat  Format of the input date (e.g., "dd MMM yyyy")
     * @param outputDateFormat Format of the output date (e.g., "dd MMMM,yyyy")
     * @param inputDateValue   Input date string to compare against the output
     */
	public static void assertInputOutputDates(List<String> list, int index, String inputDateFormat, String outputDateFormat, String inputDateValue) {
		
		// Retrieve the corresponding output date from the list
		String outputDateValue = list.get(index);
		
	    // Format patterns for parsing input and output date strings
	    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern(inputDateFormat); // e.g., "dd MMM yyyy"
	    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern(outputDateFormat); // e.g., "dd MMMM,yyyy"

	    // Parse both input and output dates using their respective formats
	    LocalDate inputDate = LocalDate.parse(inputDateValue, inputFormat);
	    LocalDate outputDate = LocalDate.parse(outputDateValue, outputFormat);
	    
	    // Assertion: verify that the parsed dates match exactly
	    Assert.assertEquals(inputDate, outputDate, "Input and output date mismatch!");
	}
}
