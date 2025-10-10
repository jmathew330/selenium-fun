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

@Epic("Core Selenium Tests")
@Feature("Locators Module")
public class LocatorsTest extends BaseTest {

    // -----------------------
    // Locate element by ID
    // -----------------------
    @Story("Locate element by ID")
    @Test(description = "Locate input field using 'id', verify visibility and placeholder text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locates an input field using its ID, verifies it is displayed, and checks its placeholder text")
    public void locateById() {
        WebElement input_name = driver.findElement(By.id("name"));
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
    public void locateByClassName() {
        WebElement h1_title = driver.findElement(By.className("title"));
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
    public void locateByName() {
        WebElement button_start = driver.findElement(By.name("start"));
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
    public void locateByLinkText() {
        WebElement a_UdemyCourses = driver.findElement(By.linkText("Udemy Courses"));
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
    public void locateByPartialLinkText() {
        WebElement a_PlayWrightPractice = driver.findElement(By.partialLinkText("Playwright"));
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
    public void locateByXPath() {
        WebElement img_Wiki_icon = driver.findElement(By.xpath("//img[contains(@class,'wikipedia-icon')]"));
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
    public void locateByCssSelector() {
        WebElement input_search = driver.findElement(By.cssSelector("input.wikipedia-search-input"));
        Assert.assertTrue(input_search.isDisplayed(), "Search input is not displayed");
        Assert.assertEquals(input_search.getAttribute("type"), "text", "Search input type attribute mismatch");
    }
}
