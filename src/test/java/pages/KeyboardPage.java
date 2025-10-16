package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class KeyboardPage {

    WebDriver driver;

    // -------------------------
    // Constructor & Initialization
    // -------------------------
    public KeyboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // -------------------------
    // WebElement Locators
    // -------------------------
    @FindBy(id = "target") WebElement input_target;
    @FindBy(id = "result") WebElement p_result;

    // -------------------------
    // Text Retrieval Methods
    // -------------------------
    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String get_p_result_Text() {
        return getElementText(p_result);
    }

    // -------------------------
    // Input Sending Methods
    // -------------------------
    public void sendCharacter(char letter) throws InterruptedException {
        input_target.sendKeys(String.valueOf(letter));
        BaseTest.pauseForDemo();
    }

    public void sendSpecialKey(Keys key) throws InterruptedException {
        input_target.sendKeys(key);
        BaseTest.pauseForDemo();
    }

    // -------------------------
    // Verification Methods
    // -------------------------
    public boolean isKeyDisplayed(char letter) {
        String expected = "You entered: " + String.valueOf(letter).toUpperCase();
        return get_p_result_Text().contains(expected);
    }

    public boolean isSpecialKeyDisplayed(Keys key) {
        String expected = "You entered: " + key.name();
        return get_p_result_Text().contains(expected);
    }
}
