package core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utils.DropdownsTestsUtils;

/**
 * DropdownsTests contains Selenium tests to validate dropdown selection
 * functionality. Includes selection by visible text, value, index, and 
 * handling of multi-select dropdowns.
 */

@Epic("Core Selenium Tests")
@Feature("Dropdown Handling Module")
public class DropdownsTests extends BaseTest {

    // ----------------------
    // Single-selection dropdown tests
    // ----------------------

    @Story("Select option by visible text")
    @Test(description = "Select 'Brazil' from country dropdown by visible text and validate selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects an option by visible text from the dropdown and verifies it was selected correctly.")
    public void selectByVisibleText() throws InterruptedException {
        DropdownsTestsUtils.scrollToDropdowns(driver, js);
        WebElement select_country_element = driver.findElement(By.id("country"));
        Select select_country = new Select(select_country_element);
        // Highlight the element for demo
        highlightElement(js, select_country_element);
        // Pause to visually observe the demo
        pauseForDemo();
        select_country.selectByVisibleText("Brazil");
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify selected option
        WebElement selectedOption = select_country.getFirstSelectedOption();
        String selectedOptionText = selectedOption.getText();
        Assert.assertTrue(selectedOption.isSelected(), "Option should be selected.");
        Assert.assertTrue(selectedOptionText.contains("Brazil"), "Selected option text should contain 'Brazil'.");
    }

    @Story("Select option by value")
    @Test(description = "Select 'France' from country dropdown by value and validate selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects an option by value from the dropdown and verifies the correct option was selected.")
    public void selectByValue() throws InterruptedException {
        DropdownsTestsUtils.scrollToDropdowns(driver, js);
        WebElement select_country_element = driver.findElement(By.id("country"));
        Select select_country = new Select(select_country_element);
        // Highlight the element for demo
        highlightElement(js, select_country_element);
        // Pause to visually observe the demo
        pauseForDemo();
        select_country.selectByValue("france");
        // Pause to visually observe the demo
        pauseForDemo();

        WebElement selectedOption = select_country.getFirstSelectedOption();
        String selectedOptionText = selectedOption.getText();
        Assert.assertTrue(selectedOption.isSelected(), "Option should be selected.");
        Assert.assertTrue(selectedOptionText.contains("France"), "Selected option text should contain 'France'.");
    }

    @Story("Select option by index")
    @Test(description = "Select 'India' from country dropdown by index and validate selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects an option by index from the dropdown and validates that the expected option is chosen.")
    public void selectByIndex() throws InterruptedException {
        DropdownsTestsUtils.scrollToDropdowns(driver, js);
        WebElement select_country_element = driver.findElement(By.id("country"));
        Select select_country = new Select(select_country_element);
        // Highlight the element for demo
        highlightElement(js, select_country_element);
        // Pause to visually observe the demo
        pauseForDemo();
        select_country.selectByIndex(9);
        // Pause to visually observe the demo
        pauseForDemo();

        WebElement selectedOption = select_country.getFirstSelectedOption();
        String selectedOptionText = selectedOption.getText();
        Assert.assertTrue(selectedOption.isSelected(), "Option should be selected.");
        Assert.assertTrue(selectedOptionText.contains("India"), "Selected option text should contain 'India'.");
    }

    // ----------------------
    // Multi-selection dropdown test
    // ----------------------

    @Story("Select multiple options")
    @Test(description = "Select multiple options from colors dropdown and validate selections")
    @Severity(SeverityLevel.NORMAL)
    @Description("Selects multiple options in a multi-select dropdown and validates the selections.")
    public void selectMultiDropdown() throws InterruptedException {
        DropdownsTestsUtils.scrollToDropdowns(driver, js);
        WebElement select_colors_element = driver.findElement(By.id("colors"));
        Select select_colors = new Select(select_colors_element);
        Assert.assertTrue(select_colors.isMultiple(), "Dropdown should support multiple selections.");
        // Highlight the element for demo
        highlightElement(js, select_colors_element);
        // Pause to visually observe the demo
        pauseForDemo();
        select_colors.selectByVisibleText("Blue");
        // Pause to visually observe the demo before making selection
        pauseForDemo();
        select_colors.selectByValue("white");
        // Pause to visually observe the demo before making selection
        pauseForDemo();
        select_colors.selectByIndex(3);
        // Pause to visually observe the demo before making selection
        pauseForDemo();

        List<WebElement> selectedOptions = select_colors.getAllSelectedOptions();
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : selectedOptions) {
            Assert.assertTrue(option.isSelected(), "Option should be selected: " + option.getText());
            actualOptions.add(option.getText());
        }

        Assert.assertTrue(actualOptions.contains("Blue"), "Multi-select should contain 'Blue'.");
        Assert.assertTrue(actualOptions.contains("White"), "Multi-select should contain 'White'.");
        Assert.assertTrue(actualOptions.contains("Yellow"), "Multi-select should contain 'Yellow'.");
    }
}