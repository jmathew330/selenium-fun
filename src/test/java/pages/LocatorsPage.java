package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LocatorsPage {

    WebDriver driver;
    JavascriptExecutor js;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    public LocatorsPage(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = js;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // WebElement Locators
    // ------------------------------------------
    @FindBy(id = "name") WebElement input_name;

    @FindBy(className = "title") WebElement h1_title;

    @FindBy(name = "start") WebElement button_start;

    @FindBy(linkText = "Udemy Courses") WebElement a_UdemyCourses;

    @FindBy(partialLinkText = "Playwright") WebElement a_PlayWrightPractice;

    @FindBy(xpath = "//img[contains(@class,'wikipedia-icon')]") WebElement img_Wiki_icon;

    @FindBy(css = "input.wikipedia-search-input") WebElement input_search;

    // ------------------------------------------
    // Generic Helper Methods
    // ------------------------------------------
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public String getElementAttribute(WebElement element, String attributeName) {
        return element.getDomAttribute(attributeName);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    // ------------------------------------------
    // input_name Methods
    // ------------------------------------------
    public boolean is_input_name_Displayed() {
        return isElementDisplayed(input_name);
    }

    public String get_input_name_Attribute() {
        return getElementAttribute(input_name, "placeholder");
    }

    public void highlight_input_name() {
        BaseTest.highlightElement(js, input_name);
    }

    // ------------------------------------------
    // h1_title Methods
    // ------------------------------------------
    public boolean is_h1_title_Displayed() {
        return isElementDisplayed(h1_title);
    }

    public String get_h1_title_Text() {
        return h1_title.getText();
    }

    public void highlight_h1_title() {
        BaseTest.highlightElement(js, h1_title);
    }

    // ------------------------------------------
    // button_start Methods
    // ------------------------------------------
    public boolean is_button_start_Displayed() {
        return isElementDisplayed(button_start);
    }

    public String get_button_start_Text() {
        return button_start.getText();
    }

    public void highlight_button_start() {
        BaseTest.highlightElement(js, button_start);
    }

    // ------------------------------------------
    // a_UdemyCourses Methods
    // ------------------------------------------
    public boolean is_a_UdemyCourses_Displayed() {
        return isElementDisplayed(a_UdemyCourses);
    }

    public String get_a_UdemyCourses_Text() {
        return a_UdemyCourses.getText();
    }

    public void highlight_a_UdemyCourses() {
        BaseTest.highlightElement(js, a_UdemyCourses);
    }

    // ------------------------------------------
    // a_PlayWrightPractice Methods
    // ------------------------------------------
    public boolean is_a_PlayWrightPractice_Displayed() {
        return isElementDisplayed(a_PlayWrightPractice);
    }

    public String get_a_PlayWrightPractice_Text() {
        return a_PlayWrightPractice.getText();
    }

    public void highlight_a_PlayWrightPractice() {
        BaseTest.highlightElement(js, a_PlayWrightPractice);
    }

    // ------------------------------------------
    // img_Wiki_icon Methods
    // ------------------------------------------
    public boolean is_img_Wiki_icon_Displayed() {
        return isElementDisplayed(img_Wiki_icon);
    }

    public String get_img_Wiki_icon_Attribute() {
        return getElementAttribute(img_Wiki_icon, "src");
    }

    public void highlight_img_Wiki_icon() {
        BaseTest.highlightElement(js, img_Wiki_icon);
    }

    // ------------------------------------------
    // input_search Methods
    // ------------------------------------------
    public boolean is_input_search_Displayed() {
        return isElementDisplayed(input_search);
    }

    public String get_input_search_Attribute() {
        return getElementAttribute(input_search, "type");
    }

    public void highlight_input_search() {
        BaseTest.highlightElement(js, input_search);
    }

}
