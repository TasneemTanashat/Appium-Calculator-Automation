# Appium Android Calculator Automation Testing

## Overview

This project is an automated mobile testing project developed using **Appium, Java, Selenium WebDriver, and TestNG**.  
It automates functional test scenarios for the Android Calculator application, including arithmetic operations, button interactions, and validation of calculation results.

The project uses **Appium with UiAutomator2** to interact with Android UI elements and execute automated test cases on an Android device.

## Technologies Used

- Java
- Appium
- Selenium WebDriver
- TestNG
- Maven
- UiAutomator2
- Android Device / Emulator
- Eclipse IDE

## Test Scenarios

The automated tests cover the following scenarios:

- Multiplication calculation (9 × 5)
- Addition calculation
- Subtraction calculation
- Multiplication calculation
- Division calculation
- Decimal calculations
- Clear button functionality
- Delete button functionality
- Division by zero validation
- Clicking all calculator digit buttons
- Clicking odd number buttons

## Automation Features

- Configured Android capabilities using `DesiredCapabilities`
- Automated Android application launch using APK file
- Used `AndroidDriver` to interact with mobile elements
- Located elements using resource IDs and class names
- Implemented TestNG annotations:
  - `@BeforeTest`
  - `@BeforeMethod`
  - `@Test`
  - `@AfterMethod`
- Added assertions to validate expected calculation results
- Captured screenshots automatically after each test execution

## Project Structure

└── myPackage/
└── CalculatorAppClass.java

MyApp/
└── calculator18.apk

screenshots/
└── Test execution screenshots

## Prerequisites

Before running the project, make sure you have:

- Java JDK 21+
- Eclipse IDE
- Maven
- Appium Server
- Android Emulator or Physical Android Device
- Appium UiAutomator2 Driver installed

## How to Run

1. Start Appium Server:

2. Connect an Android device or start an emulator.

3. Open the Maven project in Eclipse.

4. Run `CalculatorAppClass.java` as a TestNG Test.

5. Test results and screenshots will be generated after execution.

## Dependencies

The project uses Maven dependencies including:

- Appium Java Client
- Selenium WebDriver
- TestNG
- Apache Commons IO

## Test Execution

Each test creates a new Android driver session before execution and closes the session after completion.

Screenshots are automatically saved after every test execution for reporting and debugging purposes.

## Author

Eng. Tasneem Tanashat
ُىل
