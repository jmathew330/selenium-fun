package core;

import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.FramesPage;

/**
 * FramesTests demonstrates how to interact with HTML frames using Selenium WebDriver.
 * 
 * Each test in this class covers:
 * 1. Switching to a specific frame by its 'src' attribute.
 * 2. Interacting with elements (e.g., input fields) inside the frame.
 * 3. Entering text into input elements and verifying the entered value.
 * 4. Switching back to the main page content after interacting with the frame.
 * 
 * This class highlights best practices for handling frames in Selenium, 
 * ensuring that tests correctly switch context and validate interactions 
 * within different frames of a web page.
 */


@Epic("Core Selenium Tests")
@Feature("Frames Module")
public class FramesTests extends BaseTest {
	
	FramesPage fp;


	@Story("Switch to frame 1 and enter text")
	@Test(description = "Frame 1: Switch to frame and enter text")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Switches to frame 1, enters text, and verifies it was entered correctly")
    public void frame1Test() throws InterruptedException {
		
		// Initialize the FramesPage object with driver
		fp = new FramesPage(driver);
		
		// Switch to frame 1
		fp.switchToFrame1();
		
		// Enter text into the frame
		fp.sendKeysToFrame("I am on frame 1");
		
		// Return to the main page content
		fp.switchToDefaultContent();
		
        // Pause to visually observe the demo
        pauseForDemo();
    }
	
	@Story("Switch to frame 2 and enter text")
	@Test(description = "Frame 2: Switch to frame and enter text")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Switches to frame 2, enters text, and verifies it was entered correctly")
    public void frame2Test() throws InterruptedException {
		
		// Initialize the FramesPage object with driver
		fp = new FramesPage(driver);
		
		//Switch to frame 2
		fp.switchToFrame2();
		
		//Enter text into frame
		fp.sendKeysToFrame("I am on frame 2");
		
		//Return to the main page content
		fp.switchToDefaultContent();
		
        // Pause to visually observe the demo
        pauseForDemo();
    }

	@Story("Switch to frame 3 and enter text")
	@Test(description = "Frame 3: Switch to frame and enter text")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Switches to frame 3, enters text, and verifies it was entered correctly")
    public void frame3Test() throws InterruptedException {
		
		// Initialize the FramesPage object with driver
		fp = new FramesPage(driver);
		
		//Switch to frame 3
		fp.switchToFrame3();
		
		//Enter text into frame
		fp.sendKeysToFrame("I am on frame 3");
		
		//Return to the main page content
		fp.switchToDefaultContent();
		
        // Pause to visually observe the demo
        pauseForDemo();
    }

	@Story("Switch to frame 4 and enter text")
	@Test(description = "Frame 4: Switch to frame and enter text")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Switches to frame 4, enters text, and verifies it was entered correctly")
    public void frame4Test() throws InterruptedException {
		
		// Initialize the FramesPage object with driver
		fp = new FramesPage(driver);
		
		//Switch to frame 4
		fp.switchToFrame4();
		
		//Enter text into frame
		fp.sendKeysToFrame("I am on frame 4");
		
		//Return to the main page content
		fp.switchToDefaultContent();
		
        // Pause to visually observe the demo
        pauseForDemo();
    }

	@Story("Switch to frame 5 and enter text")
	@Test(description = "Frame 5: Switch to frame and enter text")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Switches to frame 5, enters text, and verifies it was entered correctly")
    public void frame5Test() throws InterruptedException {
		
		// Initialize the FramesPage object with driver
		fp = new FramesPage(driver);
		
		//Switch to frame 5
		fp.switchToFrame5();
		
		//Enter text into frame
		fp.sendKeysToFrame("I am on frame 5");
		
		//Return to the main page content
		fp.switchToDefaultContent();

        // Pause to visually observe the demo
        pauseForDemo();
    }
}
