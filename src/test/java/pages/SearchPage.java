package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;

    // Constructor
    public SearchPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Locators

    private By firstProduct = By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]");

    private By addToCartButton = By.id("add-to-cart-button");
    
    private By proceedToCheckoutButton = By.name("proceedToRetailCheckout");

    // Click on the first product
    public void clickFirstProduct() {

        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstProduct));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", product);

    }

    // Switch to newly opened tab
    public void switchToNewTab() {

        String parentWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                break;
            }
        }
    }

    // Click Add to Cart
    public void addToCart() {

        List<WebElement> buttons = driver.findElements(By.id("add-to-cart-button"));

        for (WebElement button : buttons) {

            if (button.isDisplayed() && button.isEnabled()) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

                break;
            }
        
        }
    
   }

    public void proceedToCheckout() {

        WebElement checkoutButton = wait.until(
                ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkoutButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
    }
    public boolean isSignInPageDisplayed() {

        return driver.getTitle().contains("Amazon Sign-In");

    }

    }

