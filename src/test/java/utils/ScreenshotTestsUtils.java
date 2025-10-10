package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotTestsUtils {

	
	//Capture full page
	public static void captureFullPage(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/" + fileName);
		FileUtils.copyFile(src, dest);
		
	}
	
	//Capture specific element
	public static void captureElement(WebDriver driver, WebElement element, String fileName) throws IOException {
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/" + fileName);
		FileUtils.copyFile(src, dest);
	}

}
