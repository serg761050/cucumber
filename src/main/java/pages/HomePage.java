package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

public class HomePage extends BasePage {


    @FindBy(xpath = "//a[@class='mobile-autorize mobile-item']")
    private WebElement logInButton;

    @FindBy(xpath = "//a[@class='or-color'][1]")
    private WebElement iphone13Link;

    @FindBy(xpath = "//a[contains(@data-ecomm-cart, '248798')]")
    private WebElement buyButton;

    @FindBy(xpath = "//a[contains(@class, 'main-btn main-btn--orange')]")
    private WebElement continuePurchasesButton;

    @FindBy(xpath = "//a[contains(@class, 'mobile-cart ')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@class='header-top-mobile flex-wrap']")
    private WebElement header;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isHeaderVisible() { return header.isDisplayed();}

    public boolean isIphone13LinkVisible() {return iphone13Link.isDisplayed();}

    public void clickIphone13Link() {iphone13Link.click();}

    public boolean isBuyButtonVisible() {return buyButton.isDisplayed();}

    public boolean isCartIconVisible() {return cartIcon.isDisplayed();
    }

    public boolean isContinuePurchasesButtonVisible() {
        return continuePurchasesButton.isDisplayed();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isLogInButtonVisible() {return logInButton.isDisplayed();
    }

    public void clickLoInButton() {logInButton.click();}

    public void clickBuyButton() {
        buyButton.click();
    }

    public void clickContinuePurchasesButton() {
        try {
           continuePurchasesButton.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            continuePurchasesButton.click();
        }
    }


    public int getQuantityInCart() {
        return Integer.parseInt(cartIcon.getAccessibleName().substring(0, 1));
    }



    public void close() {
        driver.close();
    }
}
