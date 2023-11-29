package com.assesement.stepDefinitions;


import com.assesement.pages.CareersPage;
import com.assesement.pages.SearchPage;
import com.assesement.utils.WebpageUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static com.assesement.factory.DriverFactory.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Search{
    WebDriver driver=getDriver();
    CareersPage cp=new CareersPage(driver);
    SearchPage sp=new SearchPage(driver);

    @Given("User is on careers HomePage")
    public void user_is_on_careers_home_page_page() {
        WebpageUtility.waitForPageToLoad(driver);
        assertThat("Home – Deutsche Bank Careers").isEqualTo(driver.getTitle());

    }
    @When("user Clicks on professional")
    public void user_clicks_on_professional() throws InterruptedException {
      cp.clickOnProfessionButton();

    }
    @When("user Enters Keyword {string}")
    public void user_enters_keyword(String string) {
        sp.searchValue(string);

    }
    @When("user clicks on search")
    public void user_clicks_on_search() {
        sp.clickSearch();
    }


    @Then("user gets searched Keyword {string} in search result")
    public void user_gets_searched_keyword_in_search_result(String string) {
            assertThat(sp.verifyResult(string)).isTrue();

        }
}
