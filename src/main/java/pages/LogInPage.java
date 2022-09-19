package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{
    @FindBy(xpath = "//a[@class='mobile-autorize mobile-item']")
    private WebElement logInButton;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void openLogInPage() {
        logInButton.click();
    }




}
