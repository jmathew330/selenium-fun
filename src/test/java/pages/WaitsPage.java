package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class WaitsPage {

    WebDriver driver;
    JavascriptExecutor js;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    public WaitsPage(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = js;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // WebElement Locators
    // ------------------------------------------
    @FindBy(tagName = "button") WebElement button_start;

    @FindBy(xpath = "//h4[normalize-space()='Hello World!']") WebElement h4_HelloWorld;

    // ------------------------------------------
    // Generic Helper Methods
    // ------------------------------------------
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    // ------------------------------------------
    // Wait Methods
    // ------------------------------------------
    public void startExplicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void startFluentWait(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ------------------------------------------
    // button_start Methods
    // ------------------------------------------
    public void highlight_button_Start() {
        BaseTest.highlightElement(js, button_start);
    }

    public boolean is_button_start_Displayed() {
        return isElementDisplayed(button_start);
    }

    public void click_button_start() {
        button_start.click();
    }

    // ------------------------------------------
    // h4_HelloWorld Methods
    // ------------------------------------------
    public void startExplicitWait_h4_HelloWorld() {
        startExplicitWait(h4_HelloWorld);
    }

    public boolean is_h4_HelloWorld_Displayed() {
        return h4_HelloWorld.isDisplayed();
    }

    public void highlight_h4_HelloWorld() {
        BaseTest.highlightElement(js, h4_HelloWorld);
    }

    public void startFluentWait_h4_HelloWorld() {
        startFluentWait(h4_HelloWorld);
    }

}
