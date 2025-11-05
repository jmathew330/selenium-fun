# SeleniumFun Project

![Java](https://img.shields.io/badge/Java-17-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.29.0-green) ![TestNG](https://img.shields.io/badge/TestNG-7.11-blue) ![Maven](https://img.shields.io/badge/Maven-3.x-red)

**Automated UI Test Suite for Core Selenium Concepts**  

This project demonstrates a variety of **Selenium WebDriver automation techniques** in Java using **TestNG** and **Allure Reports**. It is designed as a showcase of core Selenium concepts for QA portfolios and recruiter visibility.

---

## Table of Contents

- [Technologies Used](#technologies-used)  
- [Project Structure](#project-structure)  
- [Test Modules](#test-modules)  
- [Prerequisites](#prerequisites)  
- [Setup & Run](#setup--run)  
- [Reporting](#reporting)  
- [Notes](#notes)  

---

## Technologies Used

- Java 17  
- Selenium WebDriver 4.29.0  
- TestNG 7.11  
- Allure TestNG 2.30  
- Maven 3.x  
- ChromeDriver / WebDriverManager  

---

## Project Structure

```plaintext
src/
└── test/
    ├── java/
    │   ├── base/
    │   │   └── BaseTest.java
    │   └── core/
    │       ├── LocatorsTest.java
    │       ├── WaitsTests.java
    │       ├── FramesTests.java
    │       ├── WindowsTest.java
    │       └── AlertsTests.java
    │       └── MouseActions.java
    │       ├── KeyboardActionsTests.java
    │       ├── JavascriptExecutorTests.java
    │       ├── ScreenshotsTests.java
    │       ├── DropdownsTests.java    
    │       ├── CheckboxesTests.java
    │       └── RadioButtonsTests.java
    │   │
    │   └── advanced/
    │       ├── StaticTableTest.java
    │       └── DatePickerTests.java
```
- **base/BaseTest.java** → WebDriver setup, teardown, and shared methods  
- **core/** → Modular tests demonstrating different Selenium concepts  

---

## Test Modules

### 1. LocatorsTest
- Verifies elements using: `id`, `className`, `name`, `linkText`, `XPath`, `CSS Selector`  
- Assertions include text validation and element visibility  

### 2. WaitsTests
- **Implicit Wait:** For elements already present in the DOM  
- **Explicit Wait:** Waits for dynamically loaded elements  
- **Fluent Wait:** Polls for element visibility with timeout and ignore conditions

### 3. AlertsTests
- **Simple Alert:** Verifies alert text and page result after accepting  
- **Confirmation Alert:** Verifies alert text and page result after dismissing  
- **Prompt Alert:** Enters text, verifies alert, and validates result    

### 4. FramesTests
- Switches to frames (`frame_1` to `frame_5`)  
- Enters text inside frame elements and switches back to default content  

### 5. WindowsTest
- Opens a new browser window  
- Switches to the new window  
- Validates the page title and closes the new window  

### 6. MouseActionsTests
- Mouse hover and click.
- Double-click with assertion of result text.
- Right-click and verify context menu links.
- Drag-and-drop elements.

### 7. KeyboardActionsTests
- **Type Keys Test:** Types text into input fields and verifies each key press  
- **Special Keys Test:** Tests Escape, Backspace, Tab, and Shift key detection  

### 8. JavascriptExecutorTests
- **Scroll Test:** Scrolls page down, to bottom, and back to top  
- **Click Test:** Clicks elements via JS and validates dynamic messages  
- **Set Values Test:** Populates form fields using JS, submits, and verifies table output  

### 9. ScreenshotsTests
- **Full Page Screenshot:** Captures the entire webpage  
- **Element Screenshot:** Captures a specific element (e.g., logo)

### 10. DropdownsTests
- **Select by Visible Text:** Selects 'Brazil' from a single-selection dropdown and verifies selection  
- **Select by Value:** Selects 'France' from a single-selection dropdown by value and validates it  
- **Select by Index:** Selects 'India' from a single-selection dropdown by index and verifies selection  
- **Select Multiple Options:** Selects multiple options ('Blue', 'White', 'Yellow') from a multi-select dropdown and validates all selections  

### 11. CheckboxesTests
- **Single Checkbox Test:** Selects and validates one checkbox  
- **Multiple Checkboxes Test:** Selects multiple checkboxes, validates, and deselects one  

### 12. RadioButtonsTests
- **Select 'Yes' Radio Button:** Verifies selection and confirmation message  
- **Select 'Impressive' Radio Button:** Verifies selection and confirmation message  
- **Verify Disabled 'No' Radio Button:** Confirms it is not clickable

  ### 13. StaticTableTest
- **Purpose:** Validates reading and verifying all data from a **static HTML table**.  
- **Approach:** Uses Page Object Model (POM) to read all rows and columns and compares them with a predefined dataset.  
- **Key Validations:** Confirms that all table data matches the expected values and maintains data integrity.

### 14. DatePickerTests
- **Purpose:** Tests interactions with a **jQuery UI DatePicker** widget.  
- **Approach:** Selects both future and past dates using a POM class and validates that the input field reflects the selected date.  
- **Key Validations:** Ensures correct date selection, navigation between months/years, and proper date formatting (`MM/dd/yyyy`).  

  
---

## Prerequisites

- Java 17+ installed  
- Maven installed  
- Chrome / ChromeDriver installed (or WebDriverManager configured)  
- Allure installed (for generating reports)
  
---

## Setup & Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/SeleniumFun.git

