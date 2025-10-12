package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * DropdownsTestsUtils provides helper methods to handle dropdown test setup actions,
 * such as scrolling into view.
 */
public class DropdownsTestsUtils {

    /**
     * Scrolls to the dropdown section on the page using JavaScript.
     *
     * @param driver WebDriver instance
     * @param js     JavascriptExecutor for scrolling
     */
    public static void scrollToDropdowns(WebDriver driver, JavascriptExecutor js) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement div_form_group = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='form-group'])[5]"))
        );
        js.executeScript("arguments[0].scrollIntoView(true);", div_form_group);
    }
}