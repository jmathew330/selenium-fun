package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * FileUploadPage contains methods to interact with a file upload form
 * on a web page using Selenium WebDriver.
 * 
 * <p>This class follows the Page Object Model (POM) pattern and provides
 * reusable methods for:
 * <ul>
 *   <li>Uploading a file by sending a file path to the upload input</li>
 *   <li>Clicking the submit button</li>
 *   <li>Retrieving the uploaded file name</li>
 *   <li>Verifying successful file upload messages</li>
 * </ul>
 * 
 * Example usage:
 * <pre>
 * FileUploadPage uploadPage = new FileUploadPage(driver);
 * uploadPage.uploadFile("C:/path/to/file.txt");
 * uploadPage.clickSubmit();
 * Assert.assertTrue(uploadPage.isFileUploadSuccessMessageDisplayed());
 * </pre>
 */
public class FileUploadPage {
	
	WebDriver driver;
	
	// ------------------------------------------
	// Constructor & PageFactory Initialization
	// ------------------------------------------
	/**
	 * Initializes WebElements using Selenium PageFactory.
	 * 
	 * @param driver WebDriver instance controlling the browser
	 */
	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// ------------------------------------------
	// WebElement Locators
	// ------------------------------------------
	/** Input element for uploading a file */
	@FindBy(xpath="//input[@id='file-upload']") 
	WebElement input_file_upload;
	
	/** Submit button to complete the upload */
	@FindBy(xpath="//input[@id='file-submit']") 
	WebElement input_file_submit;
	
	/** Success message displayed after successful upload */
	@FindBy(xpath="//h3[normalize-space()='File Uploaded!']") 
	WebElement h3_file_upload_success_msg;
	
	/** Element that displays the name of the uploaded file */
	@FindBy(xpath="//div[@id='uploaded-files']") 
	WebElement div_uploaded_files;
	
	
	// ------------------------------------------
	// File Upload Actions
	// ------------------------------------------
	/**
	 * Uploads a file by sending the file path to the upload input field.
	 * 
	 * @param filePath The full path of the file to be uploaded
	 */
	public void uploadFile(String filePath) {
		input_file_upload.sendKeys(filePath);
	}
	
	/**
	 * Clicks the submit button to confirm and complete the upload process.
	 */
	public void clickSubmit() {
		input_file_submit.click();
	}
	
	
	// ------------------------------------------
	// Utility Methods
	// ------------------------------------------
	/**
	 * Extracts and returns the file name from a given file path.
	 * 
	 * @param filePath The full file path (e.g., "C:/Users/Admin/Desktop/test.txt")
	 * @return The file name (e.g., "test.txt")
	 */
	public String getFileName(String filePath) {
		String[] filePathParts = filePath.split("/");
		return filePathParts[filePathParts.length - 1];
	}
	
	/**
	 * Checks whether the "File Uploaded!" success message is displayed.
	 * 
	 * @return true if the success message is visible, false otherwise
	 */
	public boolean isFileUploadSucessMessageDisplayed() {
		return h3_file_upload_success_msg.isDisplayed();
	}
	
	/**
	 * Retrieves the text of the uploaded file name displayed on the page.
	 * 
	 * @return The uploaded file name as shown in the UI
	 */
	public String getUploadedFileName() {
		return div_uploaded_files.getText();
	}

}
