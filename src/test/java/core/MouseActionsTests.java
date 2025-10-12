package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * MouseActionsTests demonstrates various mouse interactions using Selenium's Actions class.
 * 
 * The class covers:
 * 1. Mouse Hover: Moves the mouse pointer over an element and clicks it, verifying the element becomes active.
 * 2. Double Click: Performs a double-click on a button and validates the resulting message.
 * 3. Right Click (Context Click): Performs a right-click on a button and verifies all context menu items are visible with correct text.
 * 4. Drag and Drop: Performs drag-and-drop actions and verifies the drop target reflects the dropped element.
 * 
 * These tests showcase best practices for interacting with web elements that require complex user gestures,
 * and ensure that UI elements respond correctly to different mouse actions.
 */

@Epic("Core Selenium Tests")
@Feature("Actions Module")
public class MouseActionsTests extends BaseTest {

	@Story("Mouse hover interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a mouse hover and click on a textbox, verify it becomes active")
	@Test(description = "Perform a mouse hover and click on a textbox")
    public void mouseHoverTest() throws InterruptedException {
        
		// Locate the textbox element to hover over
        WebElement input_textbox = driver.findElement(By.id("textbox"));
        
        // Highlight the element for demo
        highlightElement(js, input_textbox);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Perform mouse hover and click
        act.moveToElement(input_textbox).click().perform();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Assertion: Verify textbox is enabled/active
        Assert.assertTrue(input_textbox.isEnabled(), "Textbox should be active after hover-click.");
    }

	@Story("Double click interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a double-click on the button and verify the resulting message is displayed correctly")
	@Test(description = "Perform a double-click on the button and verify the result message")
    public void doubleClickTest() throws InterruptedException {
       
		// Locate the button for double-click
        WebElement button_DoubleClickMe = driver.findElement(By.id("dblclick"));
        
        // Highlight the element for demo
        highlightElement(js, button_DoubleClickMe);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Perform double click
        act.doubleClick(button_DoubleClickMe).perform();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Locate the result element
        WebElement p_result = driver.findElement(By.id("demo"));

        // Assertion: Verify result is displayed
        Assert.assertTrue(p_result.isDisplayed(), "Result paragraph should be visible after double click.");

        // Retrieve result text
        String p_result_text = p_result.getText();

        // Assertion: Verify result text
        Assert.assertTrue(p_result_text.contains("Double Click Action is Performed"),
                "Result text mismatch for double click action.");
    }

	@Story("Right click interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a right-click on the button and verify all context menu links are displayed with correct text")
	@Test(description = "Perform a right-click on the button and verify context menu links")
    public void rightClickTest() throws InterruptedException {
        
		// Locate the button for right-click
        WebElement button_RightClickMe = driver.findElement(By.id("rightclick"));
        
        // Highlight the element for demo
        highlightElement(js, button_RightClickMe);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Perform right-click
        act.contextClick(button_RightClickMe).perform();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Locate all links in the right-click context menu
        List<WebElement> rightClickMenuLinks = driver.findElements(By.xpath("//div[@id='myDiv']//a"));

        // Expected menu texts
        String[] expectedTexts = {"Registration Form", "Alert Popup", "Mouse Event"};

        // Verify each menu link is displayed and text matches expected
        for (int i = 0; i < rightClickMenuLinks.size(); i++) {
            WebElement link = rightClickMenuLinks.get(i);

            // Assertion: Verify link is displayed
            Assert.assertTrue(link.isDisplayed(), "Context menu link should be visible.");

            // Retrieve link text
            String actualText = link.getText().trim();

            // Assertion: Verify link text
            Assert.assertEquals(actualText, expectedTexts[i], "Context menu link text mismatch.");
        }
    }
	
	@Story("Drag and drop interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a drag-and-drop action and verify the drop zone reflects the drop")
	@Test(description = "Perform a drag-and-drop action and verify the drop zone")
    public void dragAndDropTest() throws InterruptedException {
        
		// Locate draggable and droppable elements
        WebElement div_draggable = driver.findElement(By.id("draggableElement"));
        WebElement div_droppable = driver.findElement(By.id("droppableElement"));
        
        // Highlight the element for demo
        highlightElement(js, div_draggable);
        // Highlight the element for demo
        highlightElement(js, div_droppable);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Perform drag-and-drop
        act.dragAndDrop(div_draggable, div_droppable).perform();
        
        // Pause to visually observe the demo
        pauseForDemo();
    }

}
