package com.assesement.stepDefinitions;


import com.assesement.pages.CareersPage;
import com.assesement.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.assesement.factory.DriverFactory.getDriver;

public class Search{
    WebDriver driver=getDriver();
    CareersPage cp=new CareersPage(driver);
    SearchPage sp=new SearchPage(driver);
    @Given("User is on careers DB page")
    public void user_is_on_careers_db_page() {
        cp.clickOnProfessionButton();
        sp.searchValue("QA");
    }
    @When("user Clicks on professional")
    public void user_clicks_on_professional() {
        driver.findElement(By.xpath("//li[@id='professionals_top']/a")).click();
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user Enters Keyword {string}")
    public void user_enters_keyword(String string) {
        driver.findElement(By.xpath("//li[@id='professionals_top']/a")).click();
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user clicks on search")
    public void user_clicks_on_search() {
        driver.findElement(By.xpath("//li[@id='professionals_top']/a")).click();
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user gets searched Keyword in search result")
    public void user_gets_searched_keyword_in_search_result() {
        driver.findElement(By.xpath("//li[@id='professionals_top']/a")).click();
        // Write code here that turns the phrase above into concrete actions

    }
}
