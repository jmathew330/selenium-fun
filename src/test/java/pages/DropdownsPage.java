package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

public class DropdownsPage {

    WebDriver driver;
    JavascriptExecutor js;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    public DropdownsPage(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = js;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // WebElement Locators
    // ------------------------------------------
    @FindBy(xpath = "//div[@class='form-group'][5]") WebElement div_form_group;

    @FindBy(id = "country") WebElement select_country_element;

    @FindBy(id = "colors") WebElement select_colors_element;

    // ------------------------------------------
    // Helper Methods
    // ------------------------------------------
    private Select getCountrySelect() {
        return new Select(select_country_element);
    }

    private Select getColorsSelect() {
        return new Select(select_colors_element);
    }

    public WebElement getFirstSelectedOption(Select select) {
        return select.getFirstSelectedOption();
    }

    public String getFirstSelectedOptionText(Select select) {
        return select.getFirstSelectedOption().getText();
    }

    public boolean isMultiSelect(Select select) {
        return select.isMultiple();
    }

    // ------------------------------------------
    // Scrolling & Highlighting
    // ------------------------------------------
    public void scrollToDropdowns() {
        js.executeScript("arguments[0].scrollIntoView();", div_form_group);
    }

    public void highlight_select_country_element() {
        BaseTest.highlightElement(js, select_country_element);
    }

    public void highlight_select_colors_element() {
        BaseTest.highlightElement(js, select_colors_element);
    }

    // ------------------------------------------
    // Country Dropdown Methods
    // ------------------------------------------
    public void selectCountryByVisibleText(String text) {
        getCountrySelect().selectByVisibleText(text);
    }

    public void selectCountryByValue(String text) {
        getCountrySelect().selectByValue(text);
    }

    public void selectCountryByIndex(int index) {
        getCountrySelect().selectByIndex(index);
    }

    public WebElement getFirstSelectedCountryOption() {
        return getCountrySelect().getFirstSelectedOption();
    }

    public String getFirstSelectedCountryOptionText() {
        return getFirstSelectedOptionText(getCountrySelect());
    }

    public boolean isCountryOptionSelected() {
        return getFirstSelectedCountryOption().isSelected();
    }

    // ------------------------------------------
    // Colors Dropdown Methods
    // ------------------------------------------
    public void selectColorByVisibleText(String text) {
        getColorsSelect().selectByVisibleText(text);
    }

    public void selectColorByValue(String text) {
        getColorsSelect().selectByValue(text);
    }

    public void selectColorByIndex(int index) {
        getColorsSelect().selectByIndex(index);
    }

    public boolean isColorsMultiSelect() {
        return isMultiSelect(getColorsSelect());
    }

    public List<WebElement> getAllSelectedColorOptions() {
        return getColorsSelect().getAllSelectedOptions();
    }

}
