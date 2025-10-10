package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public Actions act;
	public WebDriverWait wait;
	
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
