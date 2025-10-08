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
public class FramesTests extends BaseTest {

    @Feature("Frames Module")
    @Story("Switch to frame 1 and enter text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Switches to frame 1, enters text, and verifies it was entered correctly")
    @Test
    public void frame1Test() {
        enterTextInFrame("frame_1", "mytext1", "I am on frame 1");
    }

    @Feature("Frames Module")
    @Story("Switch to frame 2 and enter text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Switches to frame 2, enters text, and verifies it was entered correctly")
    @Test
    public void frame2Test() {
        enterTextInFrame("frame_2", "mytext2", "I am on frame 2");
    }

    @Feature("Frames Module")
    @Story("Switch to frame 3 and enter text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Switches to frame 3, enters text, and verifies it was entered correctly")
    @Test
    public void frame3Test() {
        enterTextInFrame("frame_3", "mytext3", "I am on frame 3");
    }

    @Feature("Frames Module")
    @Story("Switch to frame 4 and enter text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Switches to frame 4, enters text, and verifies it was entered correctly")
    @Test
    public void frame4Test() {
        enterTextInFrame("frame_4", "mytext4", "I am on frame 4");
    }

    @Feature("Frames Module")
    @Story("Switch to frame 5 and enter text")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Switches to frame 5, enters text, and verifies it was entered correctly")
    @Test
    public void frame5Test() {
        enterTextInFrame("frame_5", "mytext5", "I am on frame 5");
    }

    /**
     * Helper method to switch to a frame, enter text, and verify the input value
     *
     * @param frameSrc  src attribute of the frame (without .html)
     * @param inputName name attribute of the input inside the frame
     * @param text      text to enter into the input
     */
    private void enterTextInFrame(String frameSrc, String inputName, String text) {
        // Retrieve the frame element
        WebElement frame = driver.findElement(By.xpath("//frame[@src='" + frameSrc + ".html']"));
        // Switch to the frame
        driver.switchTo().frame(frame);

        // Retrieve the input element inside the frame
        WebElement input_frame = driver.findElement(By.name(inputName));
        // Enter the text into the input
        input_frame.sendKeys(text);

        // Assertion: Verify that the text was entered correctly
        Assert.assertEquals(input_frame.getAttribute("value"), text, "Text in frame input mismatch!");

        // Switch back to the main content
        driver.switchTo().defaultContent();
    }
}
