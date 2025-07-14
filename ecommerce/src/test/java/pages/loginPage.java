package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class loginPage extends BasePage {
    public loginPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    // Locators for the login page elements
    static By usernameField = By.id("username");
    static By passwordField = By.id("password");
    static By loginButton = By.id("login");

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
