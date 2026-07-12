// Package where utility classes are stored
package utils;

// Import TestNG Retry interface
import org.testng.IRetryAnalyzer;

// Import Test Result
import org.testng.ITestResult;

// RetryAnalyzer class
public class RetryAnalyzer implements IRetryAnalyzer {

    // Keeps track of how many times the test has retried
    private int retryCount = 0;

    // Maximum number of retries
    private static final int maxRetryCount = 2;

    // Method called automatically by TestNG when a test fails
    @Override
    public boolean retry(ITestResult result) {

        // Check whether retry limit has been reached
        if (retryCount < maxRetryCount) {

            // Increase retry count
            retryCount++;

            // Tell TestNG to execute the test again
            return true;
        }

        // Retry limit reached
        // TestNG will mark the test as failed
        return false;
    }
}
