package com.assesement.pages;

import com.assesement.utils.WebpageUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;


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

    @FindBy (xpath="//li[@class='itm-toolbox']//a[contains(@href,'language')]")
    private WebElement languageButton;

    @FindBy (xpath="//nav[@class='navigation-customer']//a[contains(@href,'career')]")
    private WebElement career;



    @FindBy (xpath="//li[@class='itm-toolbox']//a[@title='contact']")
    private WebElement contactButton;

    @FindBy (xpath="//div[@class='content']//p[contains(text(),'Phone')]")
    private WebElement phoneNumber;

    @FindBy (xpath="//a[@class='button type-icon icon--bg wt-enabled']")
    private WebElement moreButtonIDB;

    @FindBy (xpath="//input[@placeholder='Search']")
    private WebElement searchLDB;

    @FindBy (xpath="//div[@class='news-stream-entry-description']//span")
    private WebElement articleTextClick;

    private WebElement articleText(String in)
    {
        return driver.findElement(By.xpath("//div[@class='news-stream-entry-description']//span[contains(@title,'"+in+"')]"));
    }

    @FindBy (xpath="//a[@class='level-1-link wt-enabled']")
    private List<WebElement> headers;

    @FindBy (xpath="//button[@name='Slide next1']")
    private WebElement nextButton;

    @FindBy (xpath="//button[@name='Slide prev1']")
    private WebElement previousButton;

    @FindBy (xpath="//a[contains(@title,'Explore') and @class='wt-enabled']")
    private WebElement page1Content;

    @FindBy (xpath="//a[@title='to inclusive culture' and @class='wt-enabled']")
    private WebElement page2Content;


    @FindBy (xpath="//button[text()='Load More']")
    private WebElement loadMoreButton;

    @FindBy (xpath="//span[contains(@Title,'Nikolaus learns how')]//h4")
    private WebElement loadMoreContent;

    @FindBy (xpath="//a[@title='Search']")
    private WebElement searchFromToolBox;
    @FindBy (xpath="//input[@name='searchtext']")
    private WebElement sendInputSearch;

    @FindBy (xpath="//div[@class='footer-information']/p")
    private WebElement footerText;

    public void clickOnProfessionButton() throws InterruptedException {
        professionButton.click();
    }
    public void clickOnlanguage()
    {
        languageButton.click();
    }
    public String getcareerText()
    {
        return career.getText();
    }

    public void  goToCareerPage()
    {
    career.click();
    }
    public void clickSupport()
    {
        contactButton.click();
    }
    public String getPhoneNumber()
    {
        return phoneNumber.getText();
    }

    public void clickMoreIDB()
    {
        moreButtonIDB.click();
    }
    public void searchLDB(String input)
    {
        searchLDB.sendKeys(input);

    }
    public String returnLDBTitle(String search) throws InterruptedException {
            //Did not intend use this but explicit wait is not working for some reason, due to lack of time adding sleep

            Thread.sleep(3000);
            return articleText(search).getAttribute("title");

    }
    public void clickOnArticle()
    {
        articleTextClick.click();
    }

    public Boolean verifyHeaders(String expected)
    {
        Boolean found=false;
        for(WebElement e:headers)
        {
            if(expected.contains(e.getText()))
            {
                found=true;
            }
            else found=false; break;
        }
        return found;
    }

    public void clickNextButton()
    {
        nextButton.click();
    }
    public void clickprevButton()
    {
        WebpageUtility.explicitWait(driver,previousButton,"ElementClickable");
        previousButton.click();
    }

    public String getFirstContent() throws InterruptedException {
        Thread.sleep(2000);
        return page1Content.getText();
    }
    public String getSecondContent() throws InterruptedException {
        Thread.sleep(2000);
        return page2Content.getText();
    }

    public void clickLoadMore()  {
        WebpageUtility.explicitWait(driver,loadMoreButton,"ElementClickable");
        loadMoreButton.click();
    }

    public String getloadMoreContent() {
        return loadMoreContent.getText();
    }

    public void clickOnSearchFromToolbox()
    {
        searchFromToolBox.click();
    }
    public String getFooterText()
    {
       return footerText.getText();
    }
    public void search()
    {
        String os=System.getProperty("os.name").toLowerCase();
        sendInputSearch.sendKeys("QA");
        if(os.contains("mac")) {
            sendInputSearch.sendKeys(Keys.RETURN);
        }
        else {
            sendInputSearch.sendKeys(Keys.ENTER);
        }
    }
}

