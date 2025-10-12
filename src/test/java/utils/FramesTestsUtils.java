package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FramesTestsUtils {
	
    /**
     * Helper method to switch to a frame, enter text, and verify the input value
     *
     * @param frameSrc  src attribute of the frame (without .html)
     * @param inputName name attribute of the input inside the frame
     * @param text      text to enter into the input
     */
    public static void enterTextInFrame(WebDriver driver, String frameSrc, String inputName, String text) {
    	
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
