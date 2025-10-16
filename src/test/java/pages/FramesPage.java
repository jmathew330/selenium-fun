package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {

    WebDriver driver;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    public FramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // WebElement Locators
    // ------------------------------------------
    @FindBy(xpath = "//frame[@src='frame_1.html']") WebElement frame1;

    @FindBy(xpath = "//frame[@src='frame_2.html']") WebElement frame2;

    @FindBy(xpath = "//frame[@src='frame_3.html']") WebElement frame3;

    @FindBy(xpath = "//frame[@src='frame_4.html']") WebElement frame4;

    @FindBy(xpath = "//frame[@src='frame_5.html']") WebElement frame5;

    @FindBy(xpath = "//input[contains(@name, 'mytext')]") WebElement input_frame;

    // ------------------------------------------
    // Frame Switching Methods
    // ------------------------------------------
    public void switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToFrame1() {
        switchToFrame(frame1);
    }

    public void switchToFrame2() {
        switchToFrame(frame2);
    }

    public void switchToFrame3() {
        switchToFrame(frame3);
    }

    public void switchToFrame4() {
        switchToFrame(frame4);
    }

    public void switchToFrame5() {
        switchToFrame(frame5);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // ------------------------------------------
    // Frame Interaction Methods
    // ------------------------------------------
    public void sendKeysToFrame(String message) {
        input_frame.sendKeys(message);
    }
}
