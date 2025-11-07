package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PaginationTablePage contains methods to interact with a paginated HTML table.
 * 
 * Provides functionality to scroll to the table, read all table data across pages,
 * count rows/pages, select checkboxes, and perform actions across paginated tables.
 */
public class PaginationTablePage {

    WebDriver driver;
    JavascriptExecutor js;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    public PaginationTablePage(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = js;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // WebElement Locators
    // ------------------------------------------
    @FindBy(xpath="//table[@id='productTable']") WebElement paginationTable;  // Main table element

    // ------------------------------------------
    // Basic Table Actions
    // ------------------------------------------
    
    /** Scrolls the table into view using JavaScript */
    public void scrollToPaginationTable() {
        js.executeScript("arguments[0].scrollIntoView(true);", paginationTable);
    }

    /**
     * Reads all data from a table given its XPath.
     * Returns a list of rows, where each row is a list of cell values.
     * 
     * @param tableXPath XPath to locate table rows (<tr> elements)
     */
    public List<List<String>> readAllDataFromTable(String tableXPath) {
        List<List<String>> allTableData = new ArrayList<>();

        // Get all table rows using the provided XPath
        List<WebElement> tableRows = driver.findElements(By.xpath(tableXPath));
        int rowCount = getRowCount(tableXPath);

        // Iterate over each row and extract column data
        for (int r = 1; r <= rowCount; r++) {
            List<WebElement> tableColumns = tableRows.get(r).findElements(By.tagName("td"));
            List<String> rowData = new ArrayList<>();

            for (WebElement column : tableColumns) {
                String columnData = column.getText();
                if (!columnData.isEmpty()) {
                    rowData.add(columnData);  // Only add non-empty cells
                }
            }

            allTableData.add(rowData);
        }

        return allTableData;
    }

    /** Reads all data from the main paginated table */
    public List<List<String>> readAllDataFromPaginationTable() {
        return readAllDataFromTable("//table[@id='productTable']//tr");
    }

    // ------------------------------------------
    // Utility Methods
    // ------------------------------------------

    /**
     * Returns the number of rows in a table.
     * Subtracts 1 to exclude the header row.
     * 
     * @param tableXPath XPath to locate table rows (<tr>)
     */
    public int getRowCount(String tableXPath) {
        return driver.findElements(By.xpath(tableXPath)).size() - 1;
    }

    /**
     * Returns the number of pages in a paginated table
     * by counting the number of <a> tags in the pagination element.
     * 
     * @param aTagsXPath XPath to locate pagination links
     */
    public int getPageCount(String aTagsXPath) {
        return driver.findElements(By.xpath(aTagsXPath)).size();
    }

    /**
     * Selects all checkboxes matching the given XPath.
     * 
     * @param checkBoxXPath XPath to locate checkbox elements
     */
    public void selectCheckbox(String checkBoxXPath) {
        List<WebElement> checkBoxes = driver.findElements(By.xpath(checkBoxXPath));
        for (WebElement checkbox : checkBoxes) {
            checkbox.click();
        }
    }

    // ------------------------------------------
    // Pagination Handling
    // ------------------------------------------

    /**
     * Iterates through all pages of the paginated table,
     * collects table data from each page, and selects checkboxes on each page.
     * 
     * @return List of table data for each page (3D list: pages -> rows -> columns)
     * @throws InterruptedException
     */
    public List<List<List<String>>> beginPagination() throws InterruptedException {
        List<List<List<String>>> allTableData = new ArrayList<>();

        // Get total number of pages
        int pageCount = getPageCount("//ul[@id='pagination']//a");

        for (int p = 1; p <= pageCount; p++) {
            // Click on page number if not the first page
            if (p > 1) {
                WebElement button = driver.findElement(By.xpath("//ul[@id='pagination']//a[normalize-space()=" + p + "]"));
                button.click();
            }

            // Read table data from the current page
            List<List<String>> tableData = readAllDataFromPaginationTable();

            // Select all checkboxes on the current page
            selectCheckbox("//table[@id='productTable']//tr//input[1]");

            allTableData.add(tableData);
        }

        return allTableData;
    }
}
