// Package where all test classes are stored
package tests;

// Import TestNG assertion class
import org.testng.Assert;

// Import TestNG @Test annotation
import org.testng.annotations.Test;

// Import BaseTest to reuse browser setup and teardown
import fixtures.BaseTest;

// Import HomePage Page Object
import pages.HomePage;

// Import SearchPage Page Object
import pages.SearchPage;

// Import TestNG @Listeners annotation
import org.testng.annotations.Listeners;

// Import custom Test Listener (used for screenshot on failure)
import listeners.TestListener;

// Register the TestListener for this test class
@Listeners(TestListener.class)

// Test class extends BaseTest so it inherits browser setup and cleanup
public class AmazonSearchTest extends BaseTest {

    // Test method
    // retryAnalyzer retries the test automatically if it fails
    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void searchProduct() {

        // Create HomePage object
        HomePage home = new HomePage(driver);

        // Search for Laptop
        home.searchProduct("Laptop");

        // Create SearchPage object
        SearchPage search = new SearchPage(driver);

        // Click the first product from search results
        search.clickFirstProduct();

        // Switch to the new browser tab
        search.switchToNewTab();

        // Click "Add to Cart"
        search.addToCart();

        // Click "Proceed to Checkout"
        search.proceedToCheckout();

        // Verify that the Sign In page is displayed
        Assert.assertTrue(search.isSignInPageDisplayed(),
                "Sign In page is not displayed.");

    }
}
