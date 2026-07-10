package listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import fixtures.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = BaseTest.getDriver();

        if (driver == null) {
            return;
        }

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        File destination = new File(
                "screenshots/" + result.getName() + "_" + timeStamp + ".png");

        destination.getParentFile().mkdirs();

        try {

            Files.copy(source.toPath(), destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved: "
                    + destination.getAbsolutePath());

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}