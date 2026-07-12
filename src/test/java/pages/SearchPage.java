package pages;

// Import Duration class for waits
import java.time.Duration;

// Import List and Set collections
import java.util.List;
import java.util.Set;

// Selenium imports
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Selenium Explicit Wait classes
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Page Object for Amazon Search Results & Product Page
public class SearchPage {

    // WebDriver object
    private WebDriver driver;

    // Explicit Wait object
    private WebDriverWait wait;

    // Constructor
    public SearchPage(WebDriver driver) {

        // Store driver reference
        this.driver = driver;

        // Create Explicit Wait of 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===========================
    // Locators
    // ===========================

    // Locator for first product
    private By firstProduct =
            By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]");

    // Locator for Add to Cart button
    private By addToCartButton =
            By.id("add-to-cart-button");

    // Locator for Proceed to Checkout button
    private By proceedToCheckoutButton =
            By.name("proceedToRetailCheckout");

    // Click first product
    public void clickFirstProduct() {

        // Wait until product is visible
        WebElement product =
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));

        // Create JavaScript Executor
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        // Click using JavaScript
        js.executeScript("arguments[0].click();", product);

    }

    // Switch to newly opened browser tab
    public void switchToNewTab() {

        // Current tab
        String parentWindow =
                driver.getWindowHandle();

        // All opened tabs
        Set<String> allWindows =
                driver.getWindowHandles();

        // Find child tab
        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {

                // Switch to child tab
                driver.switchTo().window(window);

                break;
            }
        }
    }

    // Click Add to Cart
    public void addToCart() {

        // Find all Add to Cart buttons
        List<WebElement> buttons =
                driver.findElements(By.id("add-to-cart-button"));

        // Loop through buttons
        for (WebElement button : buttons) {

            // Click first visible button
            if (button.isDisplayed() && button.isEnabled()) {

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", button);

                break;
            }
        }
    }

    // Click Proceed to Checkout
    public void proceedToCheckout() {

        // Wait until button becomes clickable
        WebElement checkoutButton =
                wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));

        // Click using JavaScript
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkoutButton);

        // Temporary pause
        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        // Print URL and Title
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }

    // Verify Sign In page
    public boolean isSignInPageDisplayed() {

        return driver.getTitle().contains("Amazon Sign-In");

    }

}
