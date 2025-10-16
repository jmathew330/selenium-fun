package pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage {

    WebDriver driver;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    public WindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // WebElement Locators
    // ------------------------------------------
    @FindBy(linkText = "Click Here") WebElement a_ClickHere;

    // ------------------------------------------
    // Element Actions
    // ------------------------------------------
    public void click_a_ClickHere() {
        a_ClickHere.click();
    }

    // ------------------------------------------
    // Window Handling Methods
    // ------------------------------------------
    public void switchToNewWindow(String originalWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchToOriginalWindow(String originalWindow) {
        driver.switchTo().window(originalWindow);
    }

    public void closeWindow() {
        driver.close();
    }
}
