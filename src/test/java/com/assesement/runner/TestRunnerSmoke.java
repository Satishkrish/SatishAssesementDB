package com.assesement.runner;

import com.assesement.factory.DriverFactory;
import com.assesement.utils.Utility;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

@CucumberOptions(features = "src/test/resources/com/assesement/features", glue = {
        "com/assesement/stepDefinitions"}, tags="@SmokeTest")

public class TestRunnerSmoke extends AbstractTestNGCucumberTests {
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
        WebElement root = driver.findElement(By.id("usercentrics-root"));
        SearchContext shadowDom = root.getShadowRoot();
        try {
            shadowDom.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3)")).click();
        }
        catch (Exception e)
        {
            System.out.println("cookie has been accepted");
        }
    }
}
