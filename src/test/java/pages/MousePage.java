package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class MousePage {

    WebDriver driver;
    JavascriptExecutor js;
    Actions act;

    // ------------------------------------------
    // Constructor & PageFactory Initialization
    // ------------------------------------------
    public MousePage(WebDriver driver, JavascriptExecutor js, Actions act) {
        this.driver = driver;
        this.js = js;
        this.act = act;
        PageFactory.initElements(driver, this);
    }

    // ------------------------------------------
    // WebElement Locators
    // ------------------------------------------
    @FindBy(id = "textbox") WebElement input_textbox;
    @FindBy(id = "dblclick") WebElement button_DoubleClickMe;
    @FindBy(id = "rightclick") WebElement button_RightClickMe;
    @FindBy(id = "demo") WebElement p_result;
    @FindBy(id = "draggableElement") WebElement div_draggable;
    @FindBy(id = "droppableElement") WebElement div_droppable;

    // ------------------------------------------
    // Highlight Methods
    // ------------------------------------------
    public void highlight_input_textbox() {
        BaseTest.highlightElement(js, input_textbox);
    }

    public void highlight_button_DoubleClickMe() {
        BaseTest.highlightElement(js, button_DoubleClickMe);
    }

    public void highlight_button_RightClickMe() {
        BaseTest.highlightElement(js, button_RightClickMe);
    }

    public void higlight_div_draggable() {
        BaseTest.highlightElement(js, div_draggable);
    }

    public void highlight_div_droppable() {
        BaseTest.highlightElement(js, div_droppable);
    }

    // ------------------------------------------
    // Basic Element State Methods
    // ------------------------------------------
    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public boolean is_input_textbox_Enabled() {
        return isElementEnabled(input_textbox);
    }

    public boolean is_p_result_Displayed() {
        return isElementDisplayed(p_result);
    }

    public String get_p_result_Text() {
        return p_result.getText();
    }

    // ------------------------------------------
    // Mouse Actions
    // ------------------------------------------
    public void moveToElement(WebElement element) {
        act.moveToElement(element).click().perform();
    }

    public void doubleClickElement(WebElement element) {
        act.doubleClick(element).perform();
    }

    public void rightClickElement(WebElement element) {
        act.contextClick(element).perform();
    }

    public void dragAndDropElement(WebElement draggable, WebElement droppable) {
        act.dragAndDrop(draggable, droppable).perform();
    }

    public void moveTo_input_textbox() {
        moveToElement(input_textbox);
    }

    public void doubleClick_button_DoubleClickMe() {
        doubleClickElement(button_DoubleClickMe);
    }

    public void rightClick_button_RightClickMe() {
        rightClickElement(button_RightClickMe);
    }

    public void dragAndDrop_div_draggable() {
        dragAndDropElement(div_draggable, div_droppable);
    }

    // ------------------------------------------
    // Assertions for Right-Click Menu
    // ------------------------------------------
    public boolean assertRightClickMenuLinksVisibility() {
        List<WebElement> rightClickMenuLinks = driver.findElements(By.xpath("//div[@id='myDiv']//a"));
        for (WebElement link : rightClickMenuLinks) {
            if (!link.isDisplayed())
                return false;
        }
        return true;
    }

    public boolean assertRightClickMenuLinksText() {
        String[] expectedTexts = { "Registration Form", "Alert Popup", "Mouse Event" };
        List<WebElement> rightClickMenuLinks = driver.findElements(By.xpath("//div[@id='myDiv']//a"));

        if (rightClickMenuLinks.size() != expectedTexts.length) {
            return false;
        }

        for (int i = 0; i < rightClickMenuLinks.size(); i++) {
            WebElement link = rightClickMenuLinks.get(i);
            String linkText = link.getText();
            if (!linkText.equals(expectedTexts[i])) {
                return false;
            }
        }
        return true;
    }
}
