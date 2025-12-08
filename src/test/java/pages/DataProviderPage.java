package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * DataProviderPage handles interactions with the login form for data-driven testing.
 * 
 * Provides functionality to:
 *  - Enter username and password
 *  - Submit the login form
 *  - Validate success message after login
 */
public class DataProviderPage {

    WebDriver driver;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------

    /**
     * Constructor initializes the WebDriver and PageFactory elements.
     * 
     * @param driver the WebDriver instance used for browser interaction
     */
    public DataProviderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // Page Elements (Locators)
    // ------------------------------------------

    /** Username input field */
    @FindBy(xpath = "//input[@id='username']")
    WebElement input_username;

    /** Password input field */
    @FindBy(xpath = "//input[@id='password']")
    WebElement input_password;

    /** Submit button for login form */
    @FindBy(xpath = "//button[@type='submit']")
    WebElement button_submit;

    /** Login success message element */
    @FindBy(xpath = "//div[@id='flash']")
    WebElement loginSuccessMessage;

    // ------------------------------------------
    // Public Methods: High-Level User Actions
    // ------------------------------------------

    /**
     * Performs login by entering username and password and clicking submit.
     * 
     * @param username The username to enter
     * @param password The password to enter
     */
    public void login(String username, String password) {
        input_username.sendKeys(username);
        input_password.sendKeys(password);
        button_submit.click();
    }

    /**
     * Checks whether the login success message is visible.
     * 
     * @return true if the success message is displayed, false otherwise
     */
    public boolean isLoginSuccessMessageDisplayed() {
        return loginSuccessMessage.isDisplayed();
    }

    /**
     * Retrieves the text content of the login success message.
     * 
     * @return The text of the message
     */
    public String getLoginSuccessMessageText() {
        return loginSuccessMessage.getText();
    }

}
