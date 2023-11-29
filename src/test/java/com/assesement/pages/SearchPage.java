package com.assesement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.assesement.factory.DriverFactory.getDriver;

public class SearchPage
{
    WebDriver driver;

    public SearchPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBy(id="jobIdSearch")
    private WebElement searchInput;

    @FindBy(xpath ="//button[normalize-space()='Search']")
    private WebElement searchButton;


    @FindBy(xpath="//div[@class='yello-search-result']//h2")
    private List<WebElement> searchResult;
    public void searchValue(String search)
    {
        searchInput.sendKeys(search);
    }
    public void clickSearch()
    {
        searchButton.click();
    }

    public Boolean verifyResult(String res)
    {
        Boolean found=false;
        for(WebElement e:searchResult)
        {
            if(e.getText().contains(res))
                found= true;
            else
                found= false; break;
        }
        return found;
    }
}
