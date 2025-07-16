package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Before
    public void setUp() {
        extent = ExtentReportManager.getReportInstance();
        ConfigReader.loadProperties();
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("baseUrl");
        System.out.println("Running tests on browser: " + browser);
        System.out.println("Opening URL: " + baseUrl);
        driver = DriverFactory.getDriver(browser, baseUrl);
    }

    @After
    public void tearDown() {
        extent.flush(); // writes everything to the report
        DriverFactory.quitDriver();
    }    
}
