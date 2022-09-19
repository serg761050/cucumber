package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ResultPage;
import org.junit.Assert;
import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class DefinitionsSteps {

    private static final long DEFAULT_TIMEOUT = 10;

    WebDriver driver;
    HomePage homePage;

    PageFactoryManager pageFactoryManager;

    ResultPage resultPage = new ResultPage();

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.isHeaderVisible();
    }




    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks iPhone13Link visibility")
    public void userCheckIPhone13LinkVisibility() {
        homePage.isIphone13LinkVisible();
    }

    @And("User clicks iPhone13Link")
    public void userClicksIPhone13Link() {
        homePage.clickIphone13Link();
    }

    @And("User checks buyButton visibility")
    public void userCheckBuyButtonVisibility() {
        homePage.isBuyButtonVisible();
    }

    @And("User clicks buyButton")
    public void userClickBuyButton() {
        homePage.clickBuyButton();
    }

    @And("User clicks continuePurchasesButton")
    public void userClickContinuePurchasesButton() {
        homePage.clickContinuePurchasesButton();
    }

    @And("User checks cartIcon visible")
    public void userCheckCartIconVisible() {
        homePage.isCartIconVisible();
    }

    @Then("User checks that amount of products in wish list are {int}")
    public void userChecksThatAmountOfProductsInWishListAreAmountOfProducts(int amountOfProducts) {
        int actualResult = homePage.getQuantityInCart();
        Assert.assertEquals(actualResult, amountOfProducts);
    }


    @And("User checks loginButton visibility")
    public void userChecksLoginButtonVisibility() {
        homePage.isLogInButtonVisible();
    }

    @Then("User checks home page title")
    public void userChecksHomePageTitle() {
        String actualResult = homePage.getTitle();
        String expectedResult = resultPage.homePageTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }



}
