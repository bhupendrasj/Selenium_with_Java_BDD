package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Login extends loginPage {
    // WebDriver driver = Hooks.driver;  // ✅ Getting driver from Hooks

   public Login(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

@Given("user is on the LambdaPlayground login page")
public void userIsOnLoginPage() {
    System.out.println("Hello");
    RegisterUser();
    // Hooks.driver.get("https://www.lambdatest.com/playground");
    // loginPage = new loginPage(); // ✅ initialize here after driver is ready
}

@When("user enters valid username and password")
public void enterCredentials() {
    System.out.println("Entering credentials");
    // pages.loginPage.enterUsername("testuser");
    // pages.loginPage.enterPassword("password123");
}

@When("clicks on the login button")
public void clickLogin() {
    System.out.println("Clicking login button");
    // pages.loginPage.clickLoginButton();
}

@Then("user should be redirected to the dashboard")
public void verifyDashboard() {
    System.out.println("Verifying dashboard");
    // Assert.assertTrue(true);
}
}