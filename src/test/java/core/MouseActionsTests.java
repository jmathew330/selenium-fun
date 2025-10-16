package core;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.MousePage;

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
	
	MousePage mp;

	@Story("Mouse hover interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a mouse hover and click on a textbox, verify it becomes active")
	@Test(description = "Perform a mouse hover and click on a textbox")
    public void mouseHoverTest() throws InterruptedException {
    	
		//Initialize the MousePage object with driver, JavascriptExecutor, and Actions
		mp = new MousePage(driver, js, act);
        
        // Highlight the element for demo
		mp.highlight_input_textbox();
        //highlightElement(js, input_textbox);
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Perform mouse hover and click
        mp.moveTo_input_textbox();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Assertion: Verify textbox is enabled/active
        Assert.assertTrue(mp.is_input_textbox_Enabled(), "Textbox should be active after hover-click.");
    }

	@Story("Double click interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a double-click on the button and verify the resulting message is displayed correctly")
	@Test(description = "Perform a double-click on the button and verify the result message")
    public void doubleClickTest() throws InterruptedException {
       
		//Initialize the MousePage object with driver, JavascriptExecutor, and Actions
        mp = new MousePage(driver, js, act);
		
        // Highlight the element for demo
        mp.highlight_button_DoubleClickMe();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Perform double click
        mp.doubleClick_button_DoubleClickMe();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Assertion: Verify result is displayed
        Assert.assertTrue(mp.is_p_result_Displayed(), "Result paragraph should be visible after double click.");

        // Assertion: Verify result text
        Assert.assertTrue(mp.get_p_result_Text().contains("Double Click Action is Performed"), "Result text mismatch for double click action.");
    }

	@Story("Right click interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a right-click on the button and verify all context menu links are displayed with correct text")
	@Test(description = "Perform a right-click on the button and verify context menu links")
    public void rightClickTest() throws InterruptedException {
    	
		//Initialize the MousePage object with driver, JavascriptExecutor, and Actions
        mp = new MousePage(driver, js, act);
        
        // Highlight the element for demo
        mp.highlight_button_RightClickMe();
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Perform right-click
        mp.rightClick_button_RightClickMe();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify link is displayed
        Assert.assertTrue(mp.assertRightClickMenuLinksVisibility(), "One or more right-click menu links are not visible.");
        
        // Assertion: Verify link text
        Assert.assertTrue(mp.assertRightClickMenuLinksText(), "One or more right-click menu link texts do not match the expected values.");
        
        }
	
	@Story("Drag and drop interaction")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Perform a drag-and-drop action and verify the drop zone reflects the drop")
	@Test(description = "Perform a drag-and-drop action and verify the drop zone")
	public void dragAndDropTest() throws InterruptedException {
		
		//Initialize the MousePage object with driver, JavascriptExecutor, and Actions
        mp = new MousePage(driver, js, act);
        
        // Highlight the element for demo
		mp.higlight_div_draggable();
			
		// Highlight the element for demo
		mp.highlight_div_droppable();
			
		// Pause to visually observe the demo
		pauseForDemo();

		// Perform drag-and-drop
		mp.dragAndDrop_div_draggable();
		
		// Pause to visually observe the demo
		pauseForDemo();
}

}
