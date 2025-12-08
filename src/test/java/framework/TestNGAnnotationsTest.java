package framework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

/**
 * TestNGAnnotationsTest demonstrates the full TestNG annotation lifecycle.
 * 
 * The purpose of this class is to show the execution order of:
 *  - Suite-level hooks
 *  - Test-level hooks
 *  - Class-level hooks
 *  - Method-level hooks
 * 
 * Each annotation prints a message to the console, making it easy to observe
 * the execution flow when running TestNG.
 */

@Epic("TestNG Framework Demonstrations")
@Feature("TestNG Lifecycle Execution Order")
public class TestNGAnnotationsTest {

    // ------------------------------------------
    // Suite-Level Annotations
    // ------------------------------------------

    /**
     * Executes once before the entire TestNG suite begins.
     */
    @BeforeSuite
    @Description("Executes before the entire TestNG suite starts.")
    public void beforeSuite() {
        System.out.println("BeforeSuite: Runs once before the entire test suite.");
    }

    /**
     * Executes once after the entire TestNG suite completes.
     */
    @AfterSuite
    @Description("Executes after the entire TestNG suite completes.")
    public void afterSuite() {
        System.out.println("AfterSuite: Runs once after the entire test suite.");
    }

    // ------------------------------------------
    // Test-Level Annotations (linked to <test> tag in testng.xml)
    // ------------------------------------------

    /**
     * Executes before any test defined under a <test> tag in testng.xml.
     */
    @BeforeTest
    @Description("Runs before any tests defined under the <test> tag in testng.xml.")
    public void beforeTest() {
        System.out.println("BeforeTest: Runs before <test> tag in testng.xml.");
    }

    /**
     * Executes after all tests under a <test> tag are completed.
     */
    @AfterTest
    @Description("Runs after all tests under the <test> tag in testng.xml.")
    public void afterTest() {
        System.out.println("AfterTest: Runs after <test> tag in testng.xml.");
    }

    // ------------------------------------------
    // Class-Level Annotations
    // ------------------------------------------

    /**
     * Executes once before any @Test method in this class.
     */
    @BeforeClass
    @Description("Runs once before any @Test method in the class.")
    public void beforeClass() {
        System.out.println("BeforeClass: Runs once before any test method in this class.");
    }

    /**
     * Executes once after all @Test methods in this class.
     */
    @AfterClass
    @Description("Runs once after all @Test methods in the class.")
    public void afterClass() {
        System.out.println("AfterClass: Runs once after all test methods in this class.");
    }

    // ------------------------------------------
    // Method-Level Annotations
    // ------------------------------------------

    /**
     * Executes before each @Test method in this class.
     */
    @BeforeMethod
    @Description("Runs before each individual @Test method.")
    public void beforeMethod() {
        System.out.println("BeforeMethod: Runs before each @Test method.");
    }

    /**
     * Executes after each @Test method in this class.
     */
    @AfterMethod
    @Description("Runs after each individual @Test method.")
    public void afterMethod() {
        System.out.println("AfterMethod: Runs after each @Test method.");
    }

    // ------------------------------------------
    // Test Methods
    // ------------------------------------------

    /**
     * Sample Test 1
     */
    @Story("Execute TestNG test method 1")
    @Test(description = "Executes Test One")
    @Description("Demonstrates execution of a sample test method in TestNG.")
    public void testOne() {
        System.out.println("Test one is running...");
    }

    /**
     * Sample Test 2
     */
    @Story("Execute TestNG test method 2")
    @Test(description = "Executes Test Two")
    @Description("Demonstrates execution of another sample test method in TestNG.")
    public void testTwo() {
        System.out.println("Test two is running...");
    }
}
