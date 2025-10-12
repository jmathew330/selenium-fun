package core;

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

    // -----------------------
    // Locate element by ID
    // -----------------------
    @Story("Locate element by ID")
    @Test(description = "Locate input field using 'id', verify visibility and placeholder text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates an input field using its ID, verifies it is displayed, and checks its placeholder text")
    public void locateById() throws InterruptedException {
        WebElement input_name = driver.findElement(By.id("name"));
        // Highlight the element for demo
        highlightElement(js, input_name);
        // Pause to visually observe the demo
        pauseForDemo();
        Assert.assertTrue(input_name.isDisplayed(), "Input field with ID 'name' is not displayed");
        Assert.assertEquals(input_name.getAttribute("placeholder"), "Enter Name", "Placeholder text mismatch for input 'name'");
    }

    // -----------------------
    // Locate element by Class Name
    // -----------------------
    @Story("Locate element by Class Name")
    @Test(description = "Locate heading using 'className', verify visibility and text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a heading using className, verifies it is displayed, and checks the text content")
    public void locateByClassName() throws InterruptedException {
        WebElement h1_title = driver.findElement(By.className("title"));
        // Highlight the element for demo
        highlightElement(js, h1_title);
        // Pause to visually observe the demo
        pauseForDemo();
        Assert.assertTrue(h1_title.isDisplayed(), "Heading with class 'title' is not displayed");
        Assert.assertEquals(h1_title.getText(), "Automation Testing Practice", "Heading text mismatch");
    }

    // -----------------------
    // Locate element by Name
    // -----------------------
    @Story("Locate element by Name")
    @Test(description = "Locate button using 'name', verify visibility and text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a button using its name attribute, verifies it is displayed, and checks the button text")
    public void locateByName() throws InterruptedException {
        WebElement button_start = driver.findElement(By.name("start"));
        // Highlight the element for demo
        highlightElement(js, button_start);
        // Pause to visually observe the demo
        pauseForDemo();
        Assert.assertTrue(button_start.isDisplayed(), "Button with name 'start' is not displayed");
        Assert.assertEquals(button_start.getText(), "START", "Button text mismatch for 'start'");
    }

    // -----------------------
    // Locate element by Link Text
    // -----------------------
    @Story("Locate element by Link Text")
    @Test(description = "Locate link using 'linkText', verify visibility and text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a link using linkText, verifies it is displayed, and checks the link text")
    public void locateByLinkText() throws InterruptedException {
        WebElement a_UdemyCourses = driver.findElement(By.linkText("Udemy Courses"));
        // Highlight the element for demo
        highlightElement(js, a_UdemyCourses);
        // Pause to visually observe the demo
        pauseForDemo();
        Assert.assertTrue(a_UdemyCourses.isDisplayed(), "Link with text 'Udemy Courses' is not displayed");
        Assert.assertEquals(a_UdemyCourses.getText(), "Udemy Courses", "Link text mismatch for 'Udemy Courses'");
    }

    // -----------------------
    // Locate element by Partial Link Text
    // -----------------------
    @Story("Locate element by Partial Link Text")
    @Test(description = "Locate link using 'partialLinkText', verify visibility and text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a link using partialLinkText, verifies it is displayed, and checks the link text contains expected substring")
    public void locateByPartialLinkText() throws InterruptedException {
        WebElement a_PlayWrightPractice = driver.findElement(By.partialLinkText("Playwright"));
        // Highlight the element for demo
        highlightElement(js, a_PlayWrightPractice);
        // Pause to visually observe the demo
        pauseForDemo();
        Assert.assertTrue(a_PlayWrightPractice.isDisplayed(), "Link containing text 'Playwright' is not displayed");
        Assert.assertTrue(a_PlayWrightPractice.getText().contains("Playwright"), "Link text does not contain 'Playwright'");
    }

    // -----------------------
    // Locate element by XPath
    // -----------------------
    @Story("Locate element by XPath")
    @Test(description = "Locate element using relative XPath, verify visibility and src attribute")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates an image using relative XPath, verifies it is displayed, and checks its src attribute")
    public void locateByXPath() throws InterruptedException {
        WebElement img_Wiki_icon = driver.findElement(By.xpath("//img[contains(@class,'wikipedia-icon')]"));
        // Highlight the element for demo
        highlightElement(js, img_Wiki_icon);
        // Pause to visually observe the demo
        pauseForDemo();
        Assert.assertTrue(img_Wiki_icon.isDisplayed(), "Wikipedia icon is not displayed");
        Assert.assertTrue(img_Wiki_icon.getAttribute("src").contains("icon_wikipedia_w.png"), "Image src attribute mismatch");
    }

    // -----------------------
    // Locate element by CSS Selector
    // -----------------------
    @Story("Locate element by CSS Selector")
    @Test(description = "Locate input using CSS selector, verify visibility and type attribute")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates a search input using CSS selector, verifies it is displayed, and checks its type attribute")
    public void locateByCssSelector() throws InterruptedException {
        WebElement input_search = driver.findElement(By.cssSelector("input.wikipedia-search-input"));
        // Highlight the element for demo
        highlightElement(js, input_search);
        // Pause to visually observe the demo
        pauseForDemo();
        Assert.assertTrue(input_search.isDisplayed(), "Search input is not displayed");
        Assert.assertEquals(input_search.getAttribute("type"), "text", "Search input type attribute mismatch");
    }
}
