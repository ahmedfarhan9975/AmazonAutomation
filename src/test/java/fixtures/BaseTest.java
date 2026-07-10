package fixtures;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {

    protected static WebDriver driver;

    public static WebDriver getDriver() {

        return driver;

    }

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ConfigReader config = new ConfigReader();

        driver.get(config.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();

        }
    }
}