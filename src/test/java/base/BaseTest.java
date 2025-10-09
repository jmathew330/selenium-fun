package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	public Actions act;
	
	@Parameters({"url"})
	@BeforeMethod
	public void setup(String url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='65%';");
		act = new Actions(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
