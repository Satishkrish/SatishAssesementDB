package com.assesement.runner;

import com.assesement.factory.DriverFactory;
import com.assesement.utils.Utility;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

@CucumberOptions(features = "src/test/resources/com/assesement/features", glue = {
        "com/assesement/stepDefinitions"}, tags="@RegressionTest")

public class TestRunnerRegression extends AbstractTestNGCucumberTests {
    WebDriver driver;
    Properties properties;

    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        properties = Utility.getProperties();
        DriverFactory.initializeBrowser(properties.getProperty("browser"));
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(properties.getProperty("url"));
        acceptCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void acceptCookies() throws InterruptedException {
        WebElement shadowHost = driver.findElement(By.id("usercentrics-root"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) javascriptExecutor.executeScript("return arguments[0].shadowRoot", shadowHost);
        shadowRoot.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3)")).click();
    }
}
