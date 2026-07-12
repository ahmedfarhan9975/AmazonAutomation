// Package where the BaseTest class is stored
package fixtures;

// Import Duration class to set wait time
import java.time.Duration;

// Selenium WebDriver interface
import org.openqa.selenium.WebDriver;

// Chrome browser driver
import org.openqa.selenium.chrome.ChromeDriver;

// TestNG annotations
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// Automatically manages ChromeDriver version
import io.github.bonigarcia.wdm.WebDriverManager;

// Reads values from config.properties
import utils.ConfigReader;

// Base class for all test classes
public class BaseTest {

    // Static WebDriver object shared across the framework
    protected static WebDriver driver;

    // Returns the current driver instance
    // Other classes can call BaseTest.getDriver()
    public static WebDriver getDriver() {
        return driver;
    }

    // Runs BEFORE every TestNG test method
    @BeforeMethod
    public void setup() {

        // Automatically downloads and configures ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch a new Chrome browser
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Wait up to 10 seconds when searching for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create ConfigReader object
        ConfigReader config = new ConfigReader();

        // Open the application URL from config.properties
        driver.get(config.getProperty("baseUrl"));
    }

    // Runs AFTER every TestNG test method
    @AfterMethod
    public void tearDown() {

        // Check if browser is open
        if (driver != null) {

            // Close all browser windows and end the WebDriver session
            driver.quit();
        }
    }
}
