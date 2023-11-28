package com.assesement.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CareersPage
{
    WebDriver driver;

    public CareersPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBy (xpath="//li[@id='professionals_top']/a")
    private WebElement professionButton;

    public void clickOnProfessionButton()
    {
        acceptCookies();
        professionButton.click();
    }
    public void acceptCookies()
    {
        WebElement root=driver.findElement(By.id("usercentrics-root"));
        SearchContext shadowDom=root.getShadowRoot();
        shadowDom.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3)")).click();
    }



}
