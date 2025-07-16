package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

public class Login {
    // WebDriver driver = Hooks.driver;  // ✅ Getting driver from Hooks
    private pages.loginPage loginPage;

    public Login() {
        this.loginPage = new loginPage(Hooks.driver); // ✅ Initialize loginPage with the driver
    }

@Given("user is on the LambdaPlayground login page")
public void userIsOnLoginPage() throws InterruptedException {
    loginPage.RegisterUser();
    
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