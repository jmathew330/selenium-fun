package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonsPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	// -------------------------
	// Constructor & Initialization
	// -------------------------
	public RadioButtonsPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
		PageFactory.initElements(driver, this);
	}
	
	// -------------------------
	// Web Elements
	// -------------------------
	@FindBy(xpath = "//input[@id='yesRadio']") WebElement input_radio_Yes;
	@FindBy(xpath = "//input[@id='impressiveRadio']") WebElement input_radio_Impressive;
	@FindBy(xpath = "//input[@id='noRadio']") WebElement input_radio_No;
	@FindBy(xpath = "//p[@class='mt-3']") WebElement p_confirmSelect;
	
	// -------------------------
	// Radio Button Click Actions
	// -------------------------
	public void clickinput_radio_Yes() {
        js.executeScript("arguments[0].click();", input_radio_Yes);
	}
	
	public void click_input_radio_Impressive() {
        js.executeScript("arguments[0].click();", input_radio_Impressive);
	}
	
	public void click_input_radio_No() {
        js.executeScript("arguments[0].click();", input_radio_No);
	}
	
	// -------------------------
	// Utility Methods
	// -------------------------
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	// -------------------------
	// Radio Button Selection Checks
	// -------------------------
	public boolean is_input_radio_Yes_Selected() {
		return isElementSelected(input_radio_Yes);
	}
	
	public boolean is_input_radio_Impressive_Selected() {
		return isElementSelected(input_radio_Impressive);
	}
	
	public boolean is_input_radio_No_Selected() {
		return isElementSelected(input_radio_No);
	}
	
	// -------------------------
	// Radio Button Enabled Checks
	// -------------------------
	public boolean is_input_radio_No_Enabled() {
		return isElementEnabled(input_radio_No);
	}
	
	// -------------------------
	// Confirmation Message Getter
	// -------------------------
	public String get_p_confirmSelect_Text() {
		return getElementText(p_confirmSelect);
	}
}
