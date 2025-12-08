package framework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DataProviderPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * DataProviderTest performs data-driven testing for login functionality.
 * 
 * Each test uses TestNG's @DataProvider to supply username/password combinations
 * and validates both successful login message visibility and message content.
 */

@Epic("Framework Module")
@Feature("Data-Driven Login Testing")
public class DataProviderTest extends BaseTest {

    // Page object reference
    DataProviderPage dp;

    // ------------------------------------------
    // Test Method (Data-driven)
    // ------------------------------------------

    /**
     * Test: Login using DataProvider credentials
     * 
     * Objective:
     *  - Enter username & password from data provider
     *  - Validate login success message visibility
     *  - Validate message text contains expected success string
     */
    @Story("Login validation using DataProvider")
    @Test(dataProvider = "loginData", description = "Perform login test using data-driven inputs")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validates successful login using credentials supplied by a TestNG DataProvider.")
    public void loginUsingDataProviderTest(String username, String password) {

        // Initialize page object
        dp = new DataProviderPage(driver);

        // Perform login
        dp.login(username, password);

        // Validate success message appears
        Assert.assertTrue(dp.isLoginSuccessMessageDisplayed(),
                "Success message should be displayed after login.");

        // Validate message contains correct text
        Assert.assertTrue(dp.getLoginSuccessMessageText().contains("You logged into a secure area!"),
                "Success message text should confirm login.");
    }

    // ------------------------------------------
    // TestNG Data Provider
    // ------------------------------------------

    /**
     * DataProvider that supplies login credentials for testing.
     * 
     * @return Object[][] containing username/password sets
     */
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"tomsmith", "SuperSecretPassword!"}
        };
    }
}
