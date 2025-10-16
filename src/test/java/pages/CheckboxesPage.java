package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {
	
	WebDriver driver;
	
	// -------------------------
	// Constructor & Initialization
	// -------------------------
	public CheckboxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// -------------------------
	// Web Elements
	// -------------------------
	@FindBy(xpath="//input[1]") WebElement input_checkbox1;
	@FindBy(xpath="//input[2]") WebElement input_checkbox2;
	
	// -------------------------
	// Utility Methods
	// -------------------------
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	// -------------------------
	// Checkbox Click Actions
	// -------------------------
	public void clickCheckbox1() {
		input_checkbox1.click();
	}
	
	public void clickCheckbox2() {
		input_checkbox2.click();
	}
	
	// -------------------------
	// Checkbox Selection Checks
	// -------------------------
	public boolean is_input_checkbox1_Selected() {
		return isElementSelected(input_checkbox1);
	}
	
	public boolean is_input_checkbox2_Selected() {
		return isElementSelected(input_checkbox2);
	}
	
	// -------------------------
	// Verification Methods
	// -------------------------
	public void verifyCheckboxesAreSelected() {
		if(is_input_checkbox1_Selected() == false) {
			clickCheckbox1();
		}
		if(is_input_checkbox2_Selected() == false) {
			clickCheckbox2();
		}
	}
}
