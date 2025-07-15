package pages;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public abstract class loginPage extends BasePage {
    public loginPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    // Locators for the login page elements
    static By myAccountDrp = By.xpath("(//*[contains(text(),'My account')])[2]");
    static By registerBtn = By.xpath("//*[contains(@id,'column-right')]//*[contains(text(),'Register')]");
    static By usernameField = By.id("username");
    static By passwordField = By.id("password");
    static By loginButton = By.id("login");

    public static void RegisterUser() {
        waitForElementToBeVisible(myAccountDrp, 10);
        clickElement(myAccountDrp);
        waitForElementToBeVisible(registerBtn, 10);
        clickElement(registerBtn);

    }

    public static void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public static void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public static void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    
}
