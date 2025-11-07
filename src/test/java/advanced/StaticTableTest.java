package advanced;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.StaticTablePages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * StaticTableTest validates that all data from a static web table
 * is correctly read and matches the expected table contents.
 * 
 * This test demonstrates reading table data using the Page Object Model (POM)
 * and verifying it against a known expected dataset.
 */

@Epic("Advanced Selenium Tests") // Group tests under an Epic for Allure reporting
@Feature("Static Table Handling Module") // Identify the feature under test
public class StaticTableTest extends BaseTest {
	
	StaticTablePages sp; // Page object for static table interactions
	
	// ------------------------------------------
	// Test: Read and Validate All Table Data
	// ------------------------------------------
	@Story("Read all table rows and columns and validate data") // Describe the user story
	@Test(description = "Read all rows and columns from the static table and validate data accuracy")
	@Severity(SeverityLevel.NORMAL)
	@Description("Reads all data from a static table using Page Object methods and validates it against the expected dataset.")
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
