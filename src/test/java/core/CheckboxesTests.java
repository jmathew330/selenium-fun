package core;

import org.openqa.selenium.By;
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

/**
 * CheckboxesTests contains Selenium tests to validate single and multiple
 * checkbox selection functionality.
 */
@Epic("Core Selenium Tests")
@Feature("Checkbox Handling Module")
public class CheckboxesTests extends BaseTest {

    // ----------------------
    // Single checkbox test
    // ----------------------
    @Story("Select a single checkbox")
    @Test(description = "Select the first checkbox and validate that it is selected")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks the first checkbox on the page and verifies it is selected")
    public void testSingleCheckbox() throws InterruptedException {
        // Locate the first checkbox on the page
        WebElement input_checkbox1 = driver.findElement(By.xpath("//input[1]"));

        // Click the checkbox to select it
        input_checkbox1.click();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify that the checkbox is now selected
        Assert.assertTrue(input_checkbox1.isSelected(), "Checkbox 1 should be selected.");
    }

    // ----------------------
    // Multiple checkboxes test
    // ----------------------
    @Story("Select multiple checkboxes")
    @Test(description = "Select multiple checkboxes, validate selections, and uncheck one")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects two checkboxes, verifies both are selected, then deselects one and verifies it is unselected")
    public void testMultipleCheckboxes() throws InterruptedException {
        // Locate the first and second checkboxes
        WebElement input_checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement input_checkbox2 = driver.findElement(By.xpath("//input[2]"));

        // Ensure both checkboxes are selected
        if (!input_checkbox1.isSelected()) { input_checkbox1.click(); }
        if (!input_checkbox2.isSelected()) { input_checkbox2.click(); }
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify both checkboxes are selected
        Assert.assertTrue(input_checkbox1.isSelected(), "Checkbox 1 should be selected.");
        Assert.assertTrue(input_checkbox2.isSelected(), "Checkbox 2 should be selected.");

        // Deselect the second checkbox
        input_checkbox2.click();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify the second checkbox is now unselected
        Assert.assertFalse(input_checkbox2.isSelected(), "Checkbox 2 should be unselected after clicking.");
    }
}
