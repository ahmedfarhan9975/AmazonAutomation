// Package where all Page Object classes are stored
package pages;

// Import Selenium locator class
import org.openqa.selenium.By;

// Import Selenium WebDriver
import org.openqa.selenium.WebDriver;

// Page Object Class for Amazon Home Page
public class HomePage {

    // WebDriver object used to interact with browser
    private WebDriver driver;

    // Locator for Amazon search textbox
    private By searchBox = By.id("twotabsearchtextbox");

    // Locator for Search button
    private By searchButton = By.id("nav-search-submit-button");

    // Constructor
    // Receives the WebDriver object from the test class
    public HomePage(WebDriver driver) {

        // Store driver in local variable
        this.driver = driver;

    }

    // Method to search any product
    public void searchProduct(String product) {

        // Clear existing text from search box
        driver.findElement(searchBox).clear();

        // Type the product name
        driver.findElement(searchBox).sendKeys(product);

        // Click Search button
        driver.findElement(searchButton).click();

    }

}
