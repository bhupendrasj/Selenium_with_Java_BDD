package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class loginPage extends BasePage {
    public loginPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    // Locators for the login page elements
    static By myAccountDrp = By.xpath("(//*[contains(text(),'My account')])[2]");
    static By registerBtn = By.xpath("//*[contains(@id,'column-right')]//*[contains(text(),'Register')]");
    static By firstNameFld = By.xpath("//input[contains(@id,'input-firstname')]");
    static By lastNameFld = By.xpath("//input[contains(@id,'input-lastname')]");
    static By emailFld = By.xpath("//input[contains(@id,'input-email')]");
    static By telephoneFld = By.xpath("//input[contains(@id,'input-telephone')]");
    static By passwordFld = By.xpath("//input[contains(@id,'input-password')]");
    static By confirmPasswordFld = By.xpath("//input[contains(@id,'input-confirm')]");
    static By subscribeRadio = By.xpath("//input[@type='radio' and @name='newsletter' and @value='1']");
    static By agreeCheckbox = By.xpath("//input[@type='checkbox' and @name='agree']");
    static By continueBtn = By.xpath("//input[@type='submit' and @value='Continue']");
    static By usernameField = By.id("username");
    static By passwordField = By.id("password");
    static By loginButton = By.id("login");


    public void RegisterUser() throws InterruptedException {
        try{
            test = extent.createTest("Register User Test");
            waitForElementToBeVisible(myAccountDrp, 10);
            clickElement(myAccountDrp, "My Account Dropdown");
            waitForElementToBeVisible(registerBtn, 10);
            clickElement(registerBtn, "Register Button");
            waitForElementToBeVisible(firstNameFld, 10);
            enterText(firstNameFld, "John");
            enterText(lastNameFld, "Doe");
            String randomText = RandomStringUtils.randomAlphanumeric(19);
            enterText(emailFld, randomText+"@gmail.com");
            enterText(telephoneFld, "1234567890");
            enterText(passwordFld, "password123");
            enterText(confirmPasswordFld, "password123");
            jsclickElement(subscribeRadio);
            jsclickElement(agreeCheckbox);
            clickElement(continueBtn, "Continue Button");
            test.pass("User registered successfully");
        
        } catch (Exception e) {
            methodFail("registering user", e);
        }
    }

    // @dataProvider(name="loginDataProvider")
    // public Object[][] loginUser() {
    //     return new Object[][] {
    //         {"username1", "testpass1"},
    //         {"username2", "testpass2"},
    //         {"username3", "testpass3"}
    //     };
    // }       

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
