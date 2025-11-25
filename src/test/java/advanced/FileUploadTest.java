package advanced;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.FileUploadPage;

/**
 * FileUploadTest contains Selenium-based automated tests for verifying
 * file upload functionality in a web application.
 * 
 * <p>This class validates that:
 * <ul>
 *   <li>A file can be successfully uploaded via the upload form.</li>
 *   <li>The success message appears after upload.</li>
 *   <li>The uploaded file name displayed matches the selected file name.</li>
 * </ul>
 * 
 * <p>Implements Allure annotations for structured and detailed reporting.
 */

@Epic("Advanced Selenium Tests")               // Group tests under an Epic for Allure reporting
@Feature("File Upload Module")                 // Identify the specific feature being tested
public class FileUploadTest extends BaseTest {
	
	FileUploadPage fp; // Page object for file upload actions

	// ----------------------
	// Test: File Upload Verification
	// ----------------------
	@Story("Upload a file successfully")        // User story for context in Allure reports
	@Test(description = "Upload a file and validate the success message and uploaded file name.")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Uploads a file using the file upload form, verifies the success message, and ensures the displayed filename matches the uploaded file.")
	public void fileUploadTest() throws InterruptedException {
		
		// Initialize the FileUploadPage object
		fp = new FileUploadPage(driver);
		
		// Define the path of the file to upload
		String filePath = "/Users/JeffinMathew/Desktop/TestFile";
		
		// Upload the specified file
		fp.uploadFile(filePath);
		
		// Optional pause to visually observe file selection
		pauseForDemo();
		
		// Click the submit button to confirm upload
		fp.clickSubmit();
		
		// Optional pause to visually observe upload completion
		pauseForDemo();
		
		// Verify that the success message is displayed after upload
		Assert.assertTrue(
			fp.isFileUploadSucessMessageDisplayed(),
			"File upload success message should be displayed."
		);
		
		// Verify that the uploaded file name matches the selected file
		Assert.assertEquals(
			fp.getUploadedFileName(),
			fp.getFileName(filePath),
			"Uploaded file name should match the selected file name."
		);
	}
}
