package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StaticTablePages {
	
	WebDriver driver;
	
	// ------------------------------------------
	// Constructor & PageFactory Initialization
	// ------------------------------------------
	public StaticTablePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// ------------------------------------------
	// Core Method: Read All Data from Table (Generic)
	// ------------------------------------------
	/**
	 * Reads all data from a static table located by a given XPath.
	 * 
	 * @param tableXPath XPath of the table rows (usually ending with //tr)
	 * @return List of lists, where each inner list represents a single row’s data.
	 */
	public List<List<String>> readAllDataFromTable(String tableXPath) {
		List<List<String>> allData = new ArrayList<>(); // stores all table data
		
		List<WebElement> tableRows = driver.findElements(By.xpath(tableXPath)); // find all rows
		int rowCount = getRowCount(tableXPath); // get total number of data rows
		
		// Loop through all table rows
		for (int r = 1; r <= rowCount; r++) {
			List<WebElement> tableColumns = tableRows.get(r).findElements(By.tagName("td")); // get all columns in the current row
			List<String> rowData = new ArrayList<>(); // store current row’s data
			
			// Loop through all columns in current row
			for (WebElement column : tableColumns) {
				String columnData = column.getText(); // extract text from each cell
				rowData.add(columnData); // add cell data to row list
			}
			
			allData.add(rowData); // add complete row to overall table data
		}
		
		return allData; // return full table as list of rows
	}
	
	
	// ------------------------------------------
	// Helper Method: Read All Data from Specific Static Table
	// ------------------------------------------
	/**
	 * Reads data specifically from the static table with name attribute "BookTable".
	 * 
	 * @return List of lists containing all row data from the BookTable.
	 */
	public List<List<String>> readAllDataFromStaticTable() {
		return readAllDataFromTable("//table[@name='BookTable']//tr");
	}
	
	
	// ------------------------------------------
	// Helper Method: Get Row Count
	// ------------------------------------------
	/**
	 * Returns the number of data rows in the table (excluding header).
	 * 
	 * @param tableXPath XPath of the table rows (usually ending with //tr)
	 * @return The number of data rows.
	 */
	public int getRowCount(String tableXPath) {
		// Subtract 1 to exclude the header row (if the first row is header)
		return driver.findElements(By.xpath(tableXPath)).size() - 1;
	}

}
