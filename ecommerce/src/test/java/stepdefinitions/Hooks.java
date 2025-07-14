package stepdefinitions;

import org.openqa.selenium.WebDriver;

import utils.ConfigReader;
import utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        ConfigReader.loadProperties();
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("baseUrl");
        System.out.println("Running tests on browser: " + browser);
        System.out.println("Opening URL: " + baseUrl);
        driver = DriverFactory.getDriver(browser, baseUrl);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }    
}
