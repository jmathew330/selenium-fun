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
import pages.WindowsPage;

/**
 * WindowsTest demonstrates handling multiple browser windows or tabs using Selenium WebDriver.
 * 
 * The test covers:
 * 1. Clicking a link that opens a new window.
 * 2. Switching focus from the original window to the newly opened window.
 * 3. Verifying the title and URL of the new window.
 * 4. Closing the new window and switching back to the original window.
 * 5. Validating that the original window is active and its title is correct.
 * 
 * These tests showcase best practices for managing multiple windows or tabs
 * in Selenium and ensure that window switching and validations work as expected.
 */


@Epic("Core Selenium Tests")
@Feature("Window Handling Module")
public class WindowsTest extends BaseTest {

	WindowsPage wp;

	@Story("Switch to new window and verify title")
	@Test(description = "Click a link to open a new window, switch to it, verify title, and close it")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Clicks a link that opens a new window, switches to it, verifies its title, and closes it")
    public void windowsTest() throws InterruptedException {
        
		// Initialize the WindowsPage object with driver
		wp = new WindowsPage(driver);
        
		// Store the handle of the current (original) window before opening a new one
        String originalWindow = driver.getWindowHandle();

        // Click the link to open a new window
		wp.click_a_ClickHere();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        //Switch to the new window
        wp.switchToNewWindow(originalWindow);
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify the title of the new windowdriver.getTitle();
        Assert.assertEquals(driver.getTitle(), "New Window", "New window title mismatch!");
        
        // Assertion: Verify the URL of the new window
        Assert.assertTrue(driver.getCurrentUrl().contains("new"));
        
        // Close the new window
        wp.closeWindow();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Switch back to the original window
        wp.switchToOriginalWindow(originalWindow);
        
        // Assertion: Verify the title of the original window
        Assert.assertEquals(driver.getTitle(), "The Internet", "New window title mismatch!");
    }
}
