package com.assesement.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WebpageUtility {
    public static void waitForPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60L));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }

    public static void explicitWait(WebDriver driver, WebElement element, String type) {

        switch (type) {
            case "ElementClickable":
                new WebDriverWait(driver, Duration.ofSeconds(60L))
                        .until(ExpectedConditions.elementToBeClickable(element));
                break;
            case "ElementToBeDisplayed":
                new WebDriverWait(driver, Duration.ofSeconds(60L))
                        .until(ExpectedConditions.visibilityOf(element));
                break;
            case "ElementToBeSelected":
                new WebDriverWait(driver, Duration.ofSeconds(60L))
                        .until(ExpectedConditions.elementToBeSelected(element));
                break;
            default:
                System.out.println("Specify type");
        }
    }

    public static String switchToNewWindowAndPrintTitle(WebDriver driver)  {
        // It will return the parent window name as a String
        String title = null;
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        // Now iterate using Iterator
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                title = driver.switchTo().window(child_window).getTitle();
                driver.close();
            }
        }
        //switch to the parent window
        driver.switchTo().window(parent);
        return title;
    }
}
