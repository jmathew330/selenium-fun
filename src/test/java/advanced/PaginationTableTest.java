package advanced;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.PaginationTablePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * PaginationTableTest contains Selenium tests for interacting with a paginated HTML table.
 * 
 * Includes tests for reading all data across multiple pages, selecting checkboxes, 
 * and validating that the table data matches expected values.
 */

@Epic("Advanced Selenium Tests") // Group tests under an Epic for Allure reporting
@Feature("Pagination Table Handling Module") // Identify the feature under test
public class PaginationTableTest extends BaseTest {

    PaginationTablePage pp; // Page object for pagination table actions

    // ----------------------
    // Test: Validate Paginated Table Data
    // ----------------------
    @Story("Read all pages of a paginated table and validate data") // Describe the user story
    @Test(description = "Read all data from a paginated table and validate against expected values")
    @Severity(SeverityLevel.NORMAL)
    @Description("Scrolls to the pagination table, reads data from all pages including checkboxes, and validates the complete dataset against expected values.")
    public void testPaginationTableData() throws InterruptedException {

        // Initialize the PaginationTablePage object with driver and JavascriptExecutor
        pp = new PaginationTablePage(driver, js);

        // Scroll the table into view to ensure it's interactable
        pp.scrollToPaginationTable();

        // Retrieve all table data from all pages
        // The data is stored as a 3D list: pages -> rows -> columns
        List<List<List<String>>> actualData = pp.beginPagination();

        // Define the expected table data across all pages
        List<List<List<String>>> expectedTableData = List.of(
            List.of(
                List.of("1", "Smartphone", "$10.99"),
                List.of("2", "Laptop", "$19.99"),
                List.of("3", "Tablet", "$5.99"),
                List.of("4", "Smartwatch", "$7.99"),
                List.of("5", "Wireless Earbuds", "$8.99")
            ),
            List.of(
                List.of("6", "Bluetooth Speaker", "$9.99"),
                List.of("7", "Television", "$20.99"),
                List.of("8", "Action Camera", "$15.99"),
                List.of("9", "Gaming Console", "$5.99"),
                List.of("10", "Digital Camera", "$16.99")
            ),
            List.of(
                List.of("11", "Smart Home Hub", "$20.99"),
                List.of("12", "Router", "$24.99"),
                List.of("13", "Portable Charger", "$30.99"),
                List.of("14", "Fitness Tracker", "$19.99"),
                List.of("15", "Desktop Computer", "$2.99")
            ),
            List.of(
                List.of("16", "E-Reader", "$10.99"),
                List.of("17", "VR Headset", "$11.99"),
                List.of("18", "Streaming Device", "$13.99"),
                List.of("19", "Soundbar", "$16.99"),
                List.of("20", "Wireless Mouse 20", "$17.99")
            )
        );

        // Assert that the actual table data matches the expected data
        Assert.assertEquals(actualData, expectedTableData, "The table data across all pages should match the expected values.");
    }
}
