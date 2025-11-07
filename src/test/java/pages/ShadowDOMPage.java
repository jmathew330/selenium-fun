package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ShadowDOMPage contains methods to interact with elements inside Shadow DOM.
 * 
 * Provides functionality to read text from spans, links, and divs, 
 * interact with input fields, checkboxes, and file inputs within Shadow DOM.
 * 
 * Includes support for nested Shadow DOM elements.
 */
public class ShadowDOMPage {

    WebDriver driver;
    JavascriptExecutor js;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    
    /**
     * Constructor initializes the WebDriver and JavascriptExecutor.
     * Also initializes PageFactory elements (e.g., shadowDOM element).
     */
    public ShadowDOMPage(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = js;
        PageFactory.initElements(driver, this);
    }
    
    // Example Shadow DOM container element
    @FindBy(xpath="//div[@id='HTML16']") 
    WebElement shadowDOM;
    
    /**
     * Scrolls the page until the shadowDOM element is in view.
     */
    public void scrollToShadowDOM() {
        js.executeScript("arguments[0].scrollIntoView(true);", shadowDOM);
    }


    // ------------------------------------------
    // Public Methods: High-Level Actions
    // ------------------------------------------
    
    /** Retrieves the text of a <span> inside the shadow host */
    public String getShadowHostSpanText() {
        return locateShadowHostSpanElement().getText();
    }

    /** Retrieves the text of a <div> inside a nested shadow host */
    public String getNestedShadowHostDivText() {
        return locateNestedShadowHostDivElement().getText();
    }

    /** Retrieves the text of a <a> link inside the shadow host */
    public String getShadowHostLinkText() {
        return locateShadowHostLinkElement().getText();
    }

    /** Enters text into a text input inside the shadow host */
    public void enterTextToInput() {
        locateShadowHostTextInputElement().sendKeys("This is a Shadow DOM input");
    }

    /** Retrieves the current value of the text input inside the shadow host */
    public String getInputValue() {
        return locateShadowHostTextInputElement().getAttribute("value");
    }

    /** Selects a checkbox input inside the shadow host */
    public void selectCheckbox() {
        locateShadowHostCheckboxInputElement().click();
    }

    /** Checks if the checkbox inside the shadow host is selected */
    public boolean isCheckboxSelected() {
        return locateShadowHostCheckboxInputElement().isSelected();
    }

    /** Checks if a file input element inside the shadow host is visible */
    public boolean isFileInputElementVisible() {
        return locateShadowHostFileInputElement().isDisplayed();
    }

    // ------------------------------------------
    // Generic Shadow DOM Locator
    // ------------------------------------------

    /**
     * Locates a WebElement inside Shadow DOM, supporting nested shadow hosts.
     * 
     * @param context The starting SearchContext (usually the driver)
     * @param selectors CSS selectors for shadow hosts and final element
     * @return The located WebElement
     * 
     * Example usage:
     * locateShadowDOMElement(driver, "div#shadow_host", "div#nested_shadow_host", "span")
     *   → finds <span> inside nested shadow host
     */
    public WebElement locateShadowDOMElement(SearchContext context, String... selectors) {

        SearchContext currentContext = context;
        WebElement element = null;

        for (int i = 0; i < selectors.length; i++) {
            String selector = selectors[i];

            // If not the last selector, traverse into shadow root
            if (i < selectors.length - 1) {
                WebElement shadowHost = currentContext.findElement(By.cssSelector(selector));
                
                // ShadowRoot is the context for the next element
                currentContext = shadowHost.getShadowRoot();
            } 
            // If last selector, locate the final element inside the last shadow root
            else {
                element = currentContext.findElement(By.cssSelector(selector));
            }
        }
        return element;
    }

    // ------------------------------------------
    // Specific Element Locators
    // ------------------------------------------

    /** Locates <span> inside shadow host */
    public WebElement locateShadowHostSpanElement() {
        return locateShadowDOMElement(driver, "div#shadow_host", "span.info");
    }

    /** Locates <div> inside a nested shadow host */
    public WebElement locateNestedShadowHostDivElement() {
        return locateShadowDOMElement(driver, "div#shadow_host", "div#nested_shadow_host", "div");
    }

    /** Locates <a> link inside shadow host */
    public WebElement locateShadowHostLinkElement() {
        return locateShadowDOMElement(driver, "div#shadow_host", "a");
    }

    /** Locates text input inside shadow host */
    public WebElement locateShadowHostTextInputElement() {
        return locateShadowDOMElement(driver, "div#shadow_host", "input[type='text']");
    }

    /** Locates checkbox input inside shadow host */
    public WebElement locateShadowHostCheckboxInputElement() {
        return locateShadowDOMElement(driver, "div#shadow_host", "input[type='checkbox']");
    }

    /** Locates file input element inside shadow host */
    public WebElement locateShadowHostFileInputElement() {
        return locateShadowDOMElement(driver, "div#shadow_host", "input[type='file']");
    }

}
