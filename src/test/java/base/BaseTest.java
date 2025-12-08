package base;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

public class BaseTest {

    // -------------------------------------------------------
    // WebDriver & Utilities
    // -------------------------------------------------------
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static TakesScreenshot ts;
    public Actions act;
    public WebDriverWait wait;

    // -------------------------------------------------------
    // Setup (Runs Before Each Test Method)
    // -------------------------------------------------------
    @Parameters({"url"})
    @BeforeMethod
    public void setup(String url) {

        // Load configuration values
        String browser = ConfigReader.get("browser");
        int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));
        int explicitWait  = Integer.parseInt(ConfigReader.get("explicitWait"));
        String windowMaximized = ConfigReader.get("windowMaximize");
        int zoom = Integer.parseInt(ConfigReader.get("zoomLevel"));

        // Initialize browser
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }
        
        
     // Maximize window if enabled in config
        if (windowMaximized != null && windowMaximized.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
        }

        // Browser settings
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.get(url);

        // Core utilities
        js = (JavascriptExecutor) driver;
        ts = (TakesScreenshot) driver;
        act = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));

        // Apply zoom level from config
        js.executeScript("document.body.style.zoom='" + zoom + "%';");
    }

    // -------------------------------------------------------
    // Utility Methods
    // -------------------------------------------------------
    public static void pauseForDemo() throws InterruptedException {
        Thread.sleep(3000);
    }

    public static void highlightElement(JavascriptExecutor js, WebElement element) {
        js.executeScript(
                "arguments[0].setAttribute('style', arguments[1]);",
                element,
                "border: 2px solid red; background: yellow;"
        );
    }

    // -------------------------------------------------------
    // Tear Down (Runs After Each Test Method)
    // -------------------------------------------------------
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
