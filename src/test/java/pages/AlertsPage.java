package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    WebDriver driver;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // WebElement Locators
    // ------------------------------------------
    @FindBy(xpath = "//button[@onclick='jsAlert()']") WebElement button_SimpleAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']") WebElement button_ConfirmAlert;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']") WebElement button_PromptAlert;

    @FindBy(id = "result") WebElement p_result;

    // ------------------------------------------
    // Generic Helper Methods
    // ------------------------------------------
    public String getElementText(WebElement element) {
        return element.getText();
    }

    // ------------------------------------------
    // Simple Alert Methods
    // ------------------------------------------
    public void click_button_SimpleAlert() {
        button_SimpleAlert.click();
    }

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // ------------------------------------------
    // Confirm Alert Methods
    // ------------------------------------------
    public void clickButton_ConfirmAlert() {
        button_ConfirmAlert.click();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // ------------------------------------------
    // Prompt Alert Methods
    // ------------------------------------------
    public void clickButton_PromptAlert() {
        button_PromptAlert.click();
    }

    public void sendKeysToAlert(String message) {
        driver.switchTo().alert().sendKeys(message);
    }

    // ------------------------------------------
    // Result Element Methods
    // ------------------------------------------
    public String get_p_result_Text() {
        return getElementText(p_result);
    }

}
