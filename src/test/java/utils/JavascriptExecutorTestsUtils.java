package utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class JavascriptExecutorTestsUtils {
	
	
	public static void openDemoQASite(WebDriver driver, JavascriptExecutor js) {
		driver.get("https://demoqa.com/buttons");
		js.executeScript("document.body.style.zoom='65%';");
		WebElement div_Buttons_body = driver.findElement(By.xpath("//div[@id='app']//div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", div_Buttons_body);
	}
	
	public static void openDemoQASite_Form(WebDriver driver, JavascriptExecutor js) {
		driver.get("https://demoqa.com/automation-practice-form");
		js.executeScript("document.body.style.zoom='65%';");
		WebElement div_Buttons_body = driver.findElement(By.xpath("//div[@id='app']//div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", div_Buttons_body);
	}
	
	public static void pauseForDemo() throws InterruptedException {
		
		Thread.sleep(3000);
	}
	
	
	public static List<String> retrieveValuesFromTableColumn(WebDriver driver, String xpath) {
		
		List<WebElement> tableValues = driver.findElements(By.xpath(xpath));
		
		List<String> nonEmptyTableValues = new ArrayList<String>();
		
		for(WebElement value : tableValues) {
			String valueText = value.getText().trim();
			if(!valueText.isEmpty()) {
				nonEmptyTableValues.add(valueText);
			}
		}
		return nonEmptyTableValues;
	}
	
	
	public static void assertInputOutputDates(List<String> list, int index, String inputDateFormat, String outputDateFormat, String inputDateValue) {
		
		String outputDateValue = list.get(index);
		
	    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern(inputDateFormat); // dd MMM yyyy
	    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern(outputDateFormat); // dd MMMM,yyyy

	    LocalDate inputDate = LocalDate.parse(inputDateValue, inputFormat);
	    LocalDate outputDate = LocalDate.parse(outputDateValue, outputFormat);
	    
	    Assert.assertEquals(inputDate, outputDate);
	}

}
