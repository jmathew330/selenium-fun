package framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

/**
 * AssertionsTest demonstrates the use of TestNG hard and soft assertions.
 *
 * This class contains two tests:
 *  - Hard assertions: Stop execution immediately when an assertion fails.
 *  - Soft assertions: Collect all assertion results and report them at the end.
 *
 * The purpose of this class is to show how different TestNG assertion types behave
 * during test execution.
 */

@Epic("TestNG Framework Demonstrations")
@Feature("Assertion Handling in TestNG")
public class AssertionsTest {

    /**
     * Demonstrates TestNG hard assertions.
     * Hard assertions stop the test immediately on failure.
     */
    @Story("Validate TestNG Hard Assertions")
    @Test(description = "Executes hard assertion validations.")
    @Description("Demonstrates various hard assertion scenarios such as equality, Boolean checks, and null handling.")
    public void hardAssertionsTest() {

        Assert.assertEquals("Hello", "Hello", "Strings should be equal.");
        Assert.assertNotEquals(10, 50, "Values should not match.");
        Assert.assertTrue(10 > 5, "Condition should be true.");
        Assert.assertFalse(5 > 10, "Condition should be false.");

        String phrase = "Selenium is fun";
        Assert.assertNotNull(phrase, "Value should not be null.");

        String nullPhrase = null;
        Assert.assertNull(nullPhrase, "Value should be null.");
    }

    /**
     * Demonstrates TestNG soft assertions.
     * Soft assertions allow a test to continue even when an assertion fails.
     */
    @Story("Validate TestNG Soft Assertions")
    @Test(description = "Executes soft assertion validations.")
    @Description("Shows how TestNG soft assertions collect failures and evaluate them together using assertAll().")
    public void softAssertionsTest() {

        SoftAssert sa = new SoftAssert();

        sa.assertEquals("QA", "QA", "Strings should match.");
        sa.assertTrue(5 > 1, "Condition should be true.");
        sa.assertNotNull("not-null", "Value should not be null.");

        sa.assertAll();
    }
}
