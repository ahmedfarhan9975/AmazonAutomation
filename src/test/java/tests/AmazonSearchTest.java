package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import fixtures.BaseTest;
import pages.HomePage;
import pages.SearchPage;
import org.testng.annotations.Listeners;
import listeners.TestListener;

@Listeners(TestListener.class)
public class AmazonSearchTest extends BaseTest {


	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void searchProduct() {

	    HomePage home = new HomePage(driver);

	    home.searchProduct("Laptop");

	    SearchPage search = new SearchPage(driver);

	    search.clickFirstProduct();

	    search.switchToNewTab();

	    search.addToCart();

	    search.proceedToCheckout();

	    Assert.assertTrue(search.isSignInPageDisplayed(),
	            "Sign In page is not displayed.");

	}
}