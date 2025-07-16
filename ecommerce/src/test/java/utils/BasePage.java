package utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public abstract class BasePage {

    protected static WebDriver driver;
    protected static JavascriptExecutor jsExecutor;
    protected ExtentReports extent;
    protected ExtentTest test;

    
    // Constructor to initialize the WebDriver
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        jsExecutor = (JavascriptExecutor) driver;
        extent = ExtentReportManager.getReportInstance();
        test = extent.createTest(this.getClass().getSimpleName());
    }

    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    
    public static void clickElement(By locator) {
        WebElement element = findElement(locator);
        if (element != null) {
            scrollToElement(locator);
            highlightElement(locator);
            element.click();
            unhighlightElement(locator);
        } else {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }

    public static void jsclickElement(By locator) {
        WebElement element = findElement(locator);
        if (element != null) {
            highlightElement(locator);
            scrollToElement(locator);
            jsExecutor.executeScript("arguments[0].click();", element);
            unhighlightElement(locator);
        } else {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }

    public static void clearElement(By locator) {
        WebElement element = findElement(locator);
        if (element != null) {
            scrollToElement(locator);
            highlightElement(locator);
            element.clear();
            unhighlightElement(locator);
        } else {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }

    public static void enterText(By locator, String text) {
        WebElement element = findElement(locator);
        if (element != null) {
            scrollToElement(locator);
            highlightElement(locator);
            element.clear();
            element.sendKeys(text);
            unhighlightElement(locator);
        } else {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }

    public static void jsenterText(By locator, String text) {
        WebElement element = findElement(locator);
        if (element != null) {
            scrollToElement(locator);
            highlightElement(locator);
            element.clear();
            jsExecutor.executeScript("arguments[0].value='" + text + "';", element);
            unhighlightElement(locator);
        } else {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }

    public static String getElementText(By locator) {
        WebElement element = findElement(locator);
        if (element != null) {
            scrollToElement(locator);
            highlightElement(locator);
            unhighlightElement(locator);
            return element.getText();
        }   else {
            throw new NoSuchElementException("Element not found: " + locator);  
        }
    }
    public static boolean isElementDisplayed(By locator) {
        try {
            WebElement element = findElement(locator);
            scrollToElement(locator);
            highlightElement(locator);
            unhighlightElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        System.out.println("Waiting for element to be visible");
        scrollToElement(locator);
        highlightElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        unhighlightElement(locator);
    }

    public static void waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        System.out.println("Waiting for element to be clickable");
        scrollToElement(locator);
        highlightElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
            unhighlightElement(locator);
    }

    public static void waitForElementToDisappear(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForPageToLoad(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver -> ((String) ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")).equals("complete"));
    }

    public static void navigateTo(String url) {
        driver.get(url);
        waitForPageToLoad(10); // Wait for the page to load completely
    }

    public static void refreshPage() {
        driver.navigate().refresh();
        waitForPageToLoad(10); // Wait for the page to load completely
    }
    public static void scrollToElement(By locator) {
        WebElement element = findElement(locator);
        if (element != null) {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        } else {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }

    public static void scrollToTop() {
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }
    
    public static void scrollToBottom() {
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public static void highlightElement(By locator) {
        WebElement element = findElement(locator);
        if (element != null) {
            jsExecutor.executeScript("arguments[0].style.border='3px solid red';", element);
        } else {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }

    public static void unhighlightElement(By locator) {
        WebElement element = findElement(locator);
        if (element != null) {
            jsExecutor.executeScript("arguments[0].style.border='';", element);
        } else {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }
    
}
