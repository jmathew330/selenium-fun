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
 * RadioButtonsTests contains Selenium tests to validate single radio button selection
 * and confirmation message functionality.
 */
@Epic("Core Selenium Tests")
@Feature("Radio Button Handling Module")
public class RadioButtonsTests extends BaseTest {

    // ----------------------------
    // Select 'Yes' radio button
    // ----------------------------
    @Story("Select the 'Yes' radio button")
    @Test(description = "Click the 'Yes' radio button and verify that it is selected")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks the 'Yes' radio button and verifies that it is selected and the confirmation message displays 'You have selected Yes'.")
    public void selectRadioButtonTest() throws InterruptedException {

        WebElement input_radio1 = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        js.executeScript("arguments[0].click();", input_radio1);
        
        // Pause to visually observe the demo
        pauseForDemo();
        
        Assert.assertTrue(input_radio1.isSelected(), "'Yes' radio button should be selected.");

        WebElement p_confirmSelect = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String p_confirmSelectMessage = p_confirmSelect.getText();

        Assert.assertTrue(p_confirmSelectMessage.contains("You have selected Yes"),
                "Confirmation message should contain 'You have selected Yes'.");
    }

    // ----------------------------
    // Select 'Impressive' radio button
    // ----------------------------
    @Story("Select the 'Impressive' radio button")
    @Test(description = "Click the 'Impressive' radio button and verify that it is selected")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks the 'Impressive' radio button and verifies that it is selected and the confirmation message displays 'You have selected Impressive'.")
    public void selectOtherRadioButtonTest() throws InterruptedException {

        WebElement input_radio2 = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        js.executeScript("arguments[0].click();", input_radio2);
        
        // Pause to visually observe the demo
        pauseForDemo();

        Assert.assertTrue(input_radio2.isSelected(), "'Impressive' radio button should be selected.");

        WebElement p_confirmSelect = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String p_confirmSelectMessage = p_confirmSelect.getText();

        Assert.assertTrue(p_confirmSelectMessage.contains("You have selected Impressive"),
                "Confirmation message should contain 'You have selected Impressive'.");
    }
    
    
    // ----------------------------
    // Verify 'No' radio button is disabled
    // ----------------------------
    @Story("Verify that the 'No' radio button is disabled")
    @Test(description = "Verify that the 'No' radio button is not clickable or selectable")
    @Severity(SeverityLevel.MINOR)
    @Description("Checks that the 'No' radio button is disabled and cannot be interacted with or selected by the user.")
    public void verifyDisabledRadioButtonTest() throws InterruptedException {

        WebElement input_radio3 = driver.findElement(By.xpath("//input[@id='noRadio']"));
        
        // Pause to visually observe the demo
        pauseForDemo();

        // Verify that the radio button is disabled
        Assert.assertFalse(input_radio3.isEnabled(), "'No' radio button should be disabled.");

        // Try clicking it via JS (should have no effect)
        js.executeScript("arguments[0].click();", input_radio3);

        // Confirm it’s still not selected
        Assert.assertFalse(input_radio3.isSelected(), "'No' radio button should remain unselected.");
    }
}
