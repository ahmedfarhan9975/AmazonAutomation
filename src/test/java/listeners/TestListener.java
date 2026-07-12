// Package where listener classes are stored
package listeners;

// Java imports for file handling
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

// Java imports for timestamp
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Selenium imports
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

// TestNG Listener imports
import org.testng.ITestListener;
import org.testng.ITestResult;

// Import BaseTest to access WebDriver
import fixtures.BaseTest;

// Custom Listener class
public class TestListener implements ITestListener {

    // This method automatically runs whenever a test fails
    @Override
    public void onTestFailure(ITestResult result) {

        // Get the current WebDriver instance
        WebDriver driver = BaseTest.getDriver();

        // If driver is null, do nothing
        if (driver == null) {
            return;
        }

        // Capture screenshot
        File source =
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Generate timestamp
        String timeStamp =
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Create screenshot file name
        File destination =
                new File("screenshots/"
                        + result.getName()
                        + "_"
                        + timeStamp
                        + ".png");

        // Create screenshots folder if it doesn't exist
        destination.getParentFile().mkdirs();

        try {

            // Copy screenshot to destination folder
            Files.copy(source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            // Print screenshot location
            System.out.println(
                    "Screenshot saved: "
                            + destination.getAbsolutePath());

        }

        catch (IOException e) {

            // Print error if copying fails
            e.printStackTrace();

        }

    }

}
