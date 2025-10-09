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

public class MouseActionsTests extends BaseTest {

	@Epic("Core Selenium Tests")
	@Feature("Actions Module")
	@Story("Mouse hover interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a mouse hover and click on a textbox, verify it becomes active")
	@Test(description = "Perform a mouse hover and click on a textbox")
    public void mouseHoverTest() {
        
		// Locate the textbox element to hover over
        WebElement input_textbox = driver.findElement(By.id("textbox"));

        // Perform mouse hover and click
        act.moveToElement(input_textbox).click().perform();

        // Assertion: Verify textbox is enabled/active
        Assert.assertTrue(input_textbox.isEnabled(), "Textbox should be active after hover-click.");
    }

	@Epic("Core Selenium Tests")
	@Feature("Actions Module")
	@Story("Double click interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a double-click on the button and verify the resulting message is displayed correctly")
	@Test(description = "Perform a double-click on the button and verify the result message")
    public void doubleClickTest() {
       
		// Locate the button for double-click
        WebElement button_DoubleClickMe = driver.findElement(By.id("dblclick"));

        // Perform double click
        act.doubleClick(button_DoubleClickMe).perform();

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

	@Epic("Core Selenium Tests")
	@Feature("Actions Module")
	@Story("Right click interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a right-click on the button and verify all context menu links are displayed with correct text")
	@Test(description = "Perform a right-click on the button and verify context menu links")
    public void rightClickTest() {
        
		// Locate the button for right-click
        WebElement button_RightClickMe = driver.findElement(By.id("rightclick"));

        // Perform right-click
        act.contextClick(button_RightClickMe).perform();

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
	
	@Epic("Core Selenium Tests")
	@Feature("Actions Module")
	@Story("Drag and drop interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a drag-and-drop action and verify the drop zone reflects the drop")
	@Test(description = "Perform a drag-and-drop action and verify the drop zone")
    public void dragAndDropTest() {
        
		// Locate draggable and droppable elements
        WebElement div_draggable = driver.findElement(By.id("draggableElement"));
        WebElement div_droppable = driver.findElement(By.id("droppableElement"));

        // Perform drag-and-drop
        act.dragAndDrop(div_draggable, div_droppable).perform();
    }

}
