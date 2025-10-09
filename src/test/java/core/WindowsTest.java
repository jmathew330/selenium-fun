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

public class WindowsTest extends BaseTest {

	
	@Epic("Core Selenium Tests")
	@Feature("Window Handling Module")
	@Story("Switch to new window and verify title")
	@Test(description = "Click a link to open a new window, switch to it, verify title, and close it")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Clicks a link that opens a new window, switches to it, verifies its title, and closes it")
    public void windowsTest() {
        
		// Locate the link that opens a new window
        WebElement a_ClickHere = driver.findElement(By.linkText("Click Here"));
        
        // Click the link to open a new window
        a_ClickHere.click();
        
        //Store the original window handle
        String originalWindow = driver.getWindowHandle();
        
        // Retrieve all window handles
        Set<String> allWindowsSet = driver.getWindowHandles();
       
        List<String> allWindows = new ArrayList<String>(allWindowsSet);
        
        //Switch to the new window (index 1)
        driver.switchTo().window(allWindows.get(1));
        
        // Assertion: Verify the title of the new windowdriver.getTitle();
        Assert.assertEquals(driver.getTitle(), "New Window", "New window title mismatch!");
        
        // Assertion: Verify the URL of the new window
        Assert.assertTrue(driver.getCurrentUrl().contains("new"));
        
        // Close the new window
        driver.close();
        
        // Switch back to the original window
        driver.switchTo().window(originalWindow);
        
        // Assertion: Verify the title of the original window
        Assert.assertEquals(driver.getTitle(), "The Internet", "New window title mismatch!");
    }
}
