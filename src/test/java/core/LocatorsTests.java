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
import pages.LocatorsPage;

/**
 * LocatorsTest demonstrates different ways to locate web elements using Selenium.
 * Each test validates that an element can be located using a specific locator strategy
 * (ID, className, name, linkText, partialLinkText, XPath, or CSS selector) and verifies
 * its visibility and/or relevant attributes like text, placeholder, src, or type.
 * 
 * This test class is intended to serve both as a functional verification and as a 
 * practical reference for learning various locator techniques in Selenium.
 */

@Epic("Core Selenium Tests")
@Feature("Locators Module")
public class LocatorsTests extends BaseTest {

	LocatorsPage lp;

    // -----------------------
    // Locate element by ID
    // -----------------------
    @Story("Locate element by ID")
    @Test(description = "Locate input field using 'id', verify visibility and placeholder text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates an input field using its ID, verifies it is displayed, and checks its placeholder text")
    public void locateById() throws InterruptedException {
    	
    	//Initialize the LocatorsPage object with driver and JavascriptExecutor
    	lp = new LocatorsPage(driver, js);
    	
        // Highlight the element for demo
    	lp.highlight_input_name();
    	
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify that the element is displayed and provide a clear assertion message
        Assert.assertTrue(lp.is_input_name_Displayed(), "Input field with ID 'name' is not displayed");

        // Assertion: Verify that the placeholder text of the input field matches the expected value
        Assert.assertEquals(lp.get_input_name_Attribute(), "Enter Name", "Placeholder text mismatch for input 'name'");
    }

    // -----------------------
    // Locate element by Class Name
    // -----------------------
    @Story("Locate element by Class Name")
    @Test(description = "Locate heading using 'className', verify visibility and text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a heading using className, verifies it is displayed, and checks the text content")
    public void locateByClassName() throws InterruptedException {
    	
    	//Initialize the LocatorsPage object with driver and JavascriptExecutor
    	lp = new LocatorsPage(driver, js);
    	
        // Highlight the element for demo
    	lp.highlight_h1_title();
    	
        // Pause to visually observe the demo
        pauseForDemo();     

        // Assertion: Verify that the heading element is displayed
        Assert.assertTrue(lp.is_h1_title_Displayed(), "Heading with class 'title' is not displayed");

        // Assertion: Verify that the heading text matches the expected value
        Assert.assertEquals(lp.get_h1_title_Text(), "Automation Testing Practice", "Heading text mismatch");
    }

    // -----------------------
    // Locate element by Name
    // -----------------------
    @Story("Locate element by Name")
    @Test(description = "Locate button using 'name', verify visibility and text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a button using its name attribute, verifies it is displayed, and checks the button text")
    public void locateByName() throws InterruptedException {
    	
    	//Initialize the LocatorsPage object with driver and JavascriptExecutor
    	lp = new LocatorsPage(driver, js);
    	
        // Highlight the element for demo
    	lp.highlight_button_start();
    	
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify that the button is displayed
        Assert.assertTrue(lp.is_button_start_Displayed(), "Button with name 'start' is not displayed");

        // Assertion: Verify that the button text matches the expected value
        Assert.assertEquals(lp.get_button_start_Text(), "START", "Button text mismatch for 'start'");
    }

    // -----------------------
    // Locate element by Link Text
    // -----------------------
    @Story("Locate element by Link Text")
    @Test(description = "Locate link using 'linkText', verify visibility and text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a link using linkText, verifies it is displayed, and checks the link text")
    public void locateByLinkText() throws InterruptedException {
    	
    	//Initialize the LocatorsPage object with driver and JavascriptExecutor
    	lp = new LocatorsPage(driver, js);
    	
        // Highlight the element for demo
    	lp.highlight_a_UdemyCourses();
    	
        // Pause to visually observe the demo
        pauseForDemo();

        // Assertion: Verify that the link is displayed
        Assert.assertTrue(lp.is_a_UdemyCourses_Displayed(), "Link with text 'Udemy Courses' is not displayed");

        // Assertion: Verify that the link text matches the expected value
        Assert.assertEquals(lp.get_a_UdemyCourses_Text(), "Udemy Courses", "Link text mismatch for 'Udemy Courses'");
    }

    // -----------------------
    // Locate element by Partial Link Text
    // -----------------------
    @Story("Locate element by Partial Link Text")
    @Test(description = "Locate link using 'partialLinkText', verify visibility and text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a link using partialLinkText, verifies it is displayed, and checks the link text contains expected substring")
    public void locateByPartialLinkText() throws InterruptedException {
    	
    	//Initialize the LocatorsPage object with driver and JavascriptExecutor
    	lp = new LocatorsPage(driver, js);
    	
        // Highlight the element for demo
    	lp.highlight_a_PlayWrightPractice();
    	
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify that the link with partial text is displayed
        Assert.assertTrue(lp.is_a_PlayWrightPractice_Displayed(), "Link containing text 'Playwright' is not displayed");

        // Assertion: Verify that the full link text matches the expected value
        Assert.assertEquals(lp.get_a_PlayWrightPractice_Text(), "PlaywrightPractice", "Link text does not contain 'PlaywrightPractice'");
    }

    // -----------------------
    // Locate element by XPath
    // -----------------------
    @Story("Locate element by XPath")
    @Test(description = "Locate element using relative XPath, verify visibility and src attribute")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates an image using relative XPath, verifies it is displayed, and checks its src attribute")
    public void locateByXPath() throws InterruptedException {
    	
    	//Initialize the LocatorsPage object with driver and JavascriptExecutor
    	lp = new LocatorsPage(driver, js);
    	
        // Highlight the element for demo
    	lp.highlight_img_Wiki_icon();
    	
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify that the image is displayed
        Assert.assertTrue(lp.is_img_Wiki_icon_Displayed(), "Wikipedia icon is not displayed");

        // Assertion: Verify that the image's src attribute contains the expected file name
        Assert.assertTrue(lp.get_img_Wiki_icon_Attribute().contains("icon_wikipedia_w.png"), "Image src attribute mismatch");
    }

    // -----------------------
    // Locate element by CSS Selector
    // -----------------------
    @Story("Locate element by CSS Selector")
    @Test(description = "Locate input using CSS selector, verify visibility and type attribute")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a search input using CSS selector, verifies it is displayed, and checks its type attribute")
    public void locateByCssSelector() throws InterruptedException {
    	
    	//Initialize the LocatorsPage object with driver and JavascriptExecutor
    	lp = new LocatorsPage(driver, js);
    	
        // Highlight the element for demo
    	lp.highlight_input_search();
    	
        // Pause to visually observe the demo
        pauseForDemo();
        
        // Assertion: Verify that the input field is displayed
        Assert.assertTrue(lp.is_input_search_Displayed(), "Search input is not displayed");

        // Assertion: Verify that the type attribute of the input field is 'text'
        Assert.assertEquals(lp.get_input_search_Attribute(), "text", "Search input type attribute mismatch");
    }
}
