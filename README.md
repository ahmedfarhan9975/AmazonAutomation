# Amazon Automation Framework

## Overview

This project is a Selenium WebDriver automation framework developed using Java, Maven, and TestNG. It automates a basic end-to-end user journey on Amazon India by searching for a product, opening the first search result, adding it to the cart, proceeding to checkout, and verifying that the Amazon Sign-In page is displayed.

---

## Tools & Technologies

* Java 21
* Selenium WebDriver 4
* Maven
* TestNG
* Eclipse IDE
* WebDriverManager

---

## Framework Design

The framework follows the **Page Object Model (POM)** design pattern.

### Project Structure

```
src/test/java
│
├── fixtures
│   └── BaseTest.java
│
├── listeners
│   └── TestListener.java
│
├── pages
│   ├── HomePage.java
│   └── SearchPage.java
│
├── tests
│   └── AmazonSearchTest.java
│
└── utils
    ├── ConfigReader.java
    └── RetryAnalyzer.java

src/test/resources
└── config.properties
```

---

## Features Implemented

* Page Object Model (POM)
* Environment configuration using `config.properties`
* Explicit waits using WebDriverWait
* Retry mechanism using TestNG Retry Analyzer
* Screenshot capture on test failure
* Parallel execution support using `testng.xml`
* TestNG HTML reports

---

## Test Scenario

1. Open Amazon India.
2. Search for "Laptop".
3. Open the first product from the search results.
4. Add the product to the cart.
5. Click **Proceed to Checkout**.
6. Verify that the Amazon Sign-In page is displayed.

---

## Setup Instructions

1. Install Java 21.
2. Install Eclipse IDE.
3. Import the project as a Maven Project.
4. Update Maven Dependencies.
5. Ensure Google Chrome is installed.
6. WebDriverManager automatically downloads the required ChromeDriver.

---

## How to Run the Tests

### Using Eclipse

* Right-click `testng.xml`
* Select **Run As → TestNG Suite**

or

* Right-click `AmazonSearchTest.java`
* Select **Run As → TestNG Test**

---

## Reporting

After execution, TestNG automatically generates an HTML report in:

```
test-output/index.html
```

---

## Additional Framework Enhancements

* Automatic screenshot capture on test failure.
* Automatic retry of failed tests.
* Parallel execution support using TestNG.

---

## Tested By

Farhan Sayed
