# myDemoApp Android App QA Tests
This repository contains the source code for Android application [myDemoAp](https://drive.google.com/file/d/1FADmP5gZrYs07_x689XjS2htxnH78r80/view?usp=sharing) QA tests.
The README provides information on how to run automated QA tests for this application using Appium, Selenium, Cucumber, TestNG, and JUnit.

## Overview
These automated tests validate various functionalities of the [myDemoApp](https://drive.google.com/file/d/1FADmP5gZrYs07_x689XjS2htxnH78r80/view?usp=sharing), covering aspects such as login, logout, product sorting, product details page and products page.

## Prerequisites
* Java Development Kit (JDK) installed
* IntelliJ IDEA installed
* Android Studio installed
* Appium installed
* Android SDK installed
* Emulator or physical Android device for testing with myDemoApp installed

## Project Setup

1. Clone this repository to your local machine.

    *git clone https://github.com/ZavoronokJ/myDemoApp-tests.git*

2. Open the project in IntelliJ IDEA. 
3. Install required dependencies by either using Maven:

    *mvn clean install*

## Running Automated Tests

### Configuration
1. Adjust Appium server options inside **src/test/java/steps/DriverFactory** file.
2. When setting up the Appium options for the test execution, make sure to include the following details:
* **Emulator ID:** emulator-5554
* **Platform version:** 12.0
* **APK source path:** C:/path/to/file.apk

## Test Execution
1. Run the tests using command line with Maven:

   *mvn test*

## Test Aspects Covered

### Login
* Testing scenarios with diverse valid/invalid login credentials.
* Verification of successful login and error handling for failed login attempts.
### Logout
* Test scenarios verifying the logout functionality.
### Product Sorting
* Tests for sorting products by various criteria.
* Verification of the sorting functionality's accuracy.
### Product Details Page
* Test cases to validate the correctness of product details displayed.
### Products Page
* Verification of product information exploration functionalities.
