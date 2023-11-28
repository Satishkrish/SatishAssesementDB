package com.assesement.runner;

import com.assesement.factory.DriverFactory;
import com.assesement.utils.Utility;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

@CucumberOptions(features = "src/test/resources/com/assesement/features", glue = {
        "com/assesement/stepDefinitions"}, tags="@SmokeTest")

public class TestRunner extends AbstractTestNGCucumberTests {
    WebDriver driver;
    Properties properties;

    @BeforeMethod
    public void setup() throws IOException {
        properties = Utility.getProperties();
        DriverFactory.initializeBrowser(properties.getProperty("browser"));
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(properties.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
