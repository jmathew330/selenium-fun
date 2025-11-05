package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavascriptExecutorPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	public JavascriptExecutorPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		this.driver = driver;
		this.js = js;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[normalize-space()='Click Me']") WebElement button_ClickMe;
	
	@FindBy(id="dynamicClickMessage") WebElement p_message;
	
	@FindBy(id="firstName") WebElement input_firstName;
	
	@FindBy(id="lastName") WebElement input_lastName;
	
	@FindBy(id="userEmail") WebElement input_email;
	
	@FindBy(xpath="//input[@value='Male']") WebElement input_gender;
	
	@FindBy(id="userNumber") WebElement input_phone;
	
	@FindBy(id="dateOfBirthInput") WebElement input_dob;
	
	@FindBy(id="currentAddress") WebElement input_address;
	
	public void scrollPageBy200Px() {
        js.executeScript("window.scrollBy(0, 200);");
	}
	
	public void scrollPageToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void scrollPageToTop() {
        js.executeScript("window.scrollTo(0,0);");
	}

	public void openButtonsPage() {
		
		driver.get("https://demoqa.com/buttons");
		
		js.executeScript("document.body.style.zoom='65%';");
		
		WebElement div_Buttons_body = driver.findElement(By.xpath("//div[@id='app']//div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", div_Buttons_body);
	}
	
	public void click_button_ClickMe() {
        js.executeScript("arguments[0].click();", button_ClickMe);
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	public String get_p_message_Text() {
		return getElementText(p_message);
	}
	
	public void openFormPage() {
		driver.get("https://demoqa.com/automation-practice-form");
		
		// Zoom out the page for better layout visibility
		js.executeScript("document.body.style.zoom='65%';");
		
		// Scroll to the form section to ensure it’s visible
		WebElement div_Buttons_body = driver.findElement(By.xpath("//div[@id='app']//div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", div_Buttons_body);
	}
	
	public void fillOutForm() {
        js.executeScript("arguments[0].value = 'FNTest';", input_firstName);
        js.executeScript("arguments[0].value = 'LNTest';", input_lastName);
        js.executeScript("arguments[0].value = 'testemail123@email.com';", input_email);
        js.executeScript("arguments[0].click();", input_gender);
        js.executeScript("arguments[0].value = '1234567890';", input_phone);
        js.executeScript("arguments[0].value = '11 Jan 2005';", input_dob);
        js.executeScript("arguments[0].value = '123 QA Lane';", input_address);
	}
	
	public void clickSubmit() {
        WebElement button_submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")));
        js.executeScript("arguments[0].click();", button_submit);
	}
	
	public String retrieveFormValue(WebElement element) {
		return (String) js.executeScript("return arguments[0].value;", element);
	}
	
	public String get_input_firstName_value() {
		return retrieveFormValue(input_firstName);
	}
	
	public String get_input_lastName_value() {
		return retrieveFormValue(input_lastName);
	}
	
	public String get_input_email_value() {
		return retrieveFormValue(input_email);
	}
	
	public String get_input_gender_value() {
		return retrieveFormValue(input_gender);
	}
	
	public String get_input_phone_value() {
		return retrieveFormValue(input_phone);
	}
	
	public String get_input_dob_value() {
		return retrieveFormValue(input_dob);
	}
	
	public String get_input_address_value() {
		return retrieveFormValue(input_address);
	}
	
	public List<String> retrieveValuesFromTable(WebDriver driver, String xpath){
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
	
	public void assertInputOutputDates(List<String> list, int index, String inputDateFormat, String outputDateFormat, String inputDateValue) {
		
		// Retrieve the corresponding output date from the list
		String outputDateValue = list.get(index);
		
	    // Format patterns for parsing input and output date strings
	    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern(inputDateFormat); // e.g., "dd MMM yyyy"
	    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern(outputDateFormat); // e.g., "dd MMMM,yyyy"

	    // Parse both input and output dates using their respective formats
	    LocalDate inputDate = LocalDate.parse(inputDateValue, inputFormat);
	    LocalDate outputDate = LocalDate.parse(outputDateValue, outputFormat);
	    
	    // Assertion: verify that the parsed dates match exactly
	    Assert.assertEquals(inputDate, outputDate, "Input and output date mismatch!");
	}
	
}
