package advanced;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.StaticTablePages;

/**
 * StaticTableTest validates that all data from a static web table
 * is correctly read and matches the expected table contents.
 * 
 * This test demonstrates reading table data using the Page Object Model (POM)
 * and verifying it against a known expected dataset.
 */

public class StaticTableTest extends BaseTest {
	
	StaticTablePages sp; // Page object for static table interactions
	
	// ------------------------------------------
	// Test: Read and Validate All Table Data
	// ------------------------------------------
	@Test(description = "Read all rows and columns from the static table and validate data accuracy")
	public void readAllDataFromStaticTableTest() {
		
		// Initialize the StaticTablePages object with WebDriver
		sp = new StaticTablePages(driver);
		
		// Read all table data using Page Object method
		List<List<String>> actualTableData = sp.readAllDataFromStaticTable();
		
		// Define the expected table data for validation
		List<List<String>> expectedTableData = List.of(
		        List.of("Learn Selenium", "Amit", "Selenium", "300"),
		        List.of("Learn Java", "Mukesh", "Java", "500"),
		        List.of("Learn JS", "Animesh", "Javascript", "300"),
		        List.of("Master In Selenium", "Mukesh", "Selenium", "3000"),
		        List.of("Master In Java", "Amod", "JAVA", "2000"),
		        List.of("Master In JS", "Amit", "Javascript", "1000")
		);
		
		// ------------------------------------------
		// Validation: Compare actual vs. expected table data
		// ------------------------------------------
		Assert.assertEquals(
			actualTableData, 
			expectedTableData, 
			"Static table data does not match the expected values."
		);
	}
}
