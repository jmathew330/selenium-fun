package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

	

	@Story("Switch to new window and verify title")
	@Test(description = "Click a link to open a new window, switch to it, verify title, and close it")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Clicks a link that opens a new window, switches to it, verifies its title, and closes it")
    public void windowsTest() throws InterruptedException {
        
		// Locate the link that opens a new window
        WebElement a_ClickHere = driver.findElement(By.linkText("Click Here"));
        
        // Click the link to open a new window
        a_ClickHere.click();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        //Store the original window handle
        String originalWindow = driver.getWindowHandle();
        
        // Retrieve all window handles
        Set<String> allWindowsSet = driver.getWindowHandles();
       
        List<String> allWindows = new ArrayList<String>(allWindowsSet);
        
        //Switch to the new window (index 1)
        driver.switchTo().window(allWindows.get(1));
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify the title of the new windowdriver.getTitle();
        Assert.assertEquals(driver.getTitle(), "New Window", "New window title mismatch!");
        
        // Assertion: Verify the URL of the new window
        Assert.assertTrue(driver.getCurrentUrl().contains("new"));
        
        // Close the new window
        driver.close();
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Switch back to the original window
        driver.switchTo().window(originalWindow);
        
        // Assertion: Verify the title of the original window
        Assert.assertEquals(driver.getTitle(), "The Internet", "New window title mismatch!");
    }
}
