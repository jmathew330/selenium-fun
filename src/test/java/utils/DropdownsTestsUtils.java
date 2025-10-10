package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownsTestsUtils {
	
	public static void scrollToDropdowns(WebDriver driver, JavascriptExecutor js) {
		
		WebElement div_form_group = driver.findElement(By.xpath("(//div[@class='form-group'])[5]"));
		
		js.executeScript("arguments[0].scrollIntoView(true)", div_form_group);
	}
	
	
	public static void pauseForDemo() throws InterruptedException {
		
		Thread.sleep(3000);
	}

}
