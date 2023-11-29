package com.assesement.stepDefinitions;

import com.assesement.pages.CareersPage;
import com.assesement.pages.SearchPage;
import com.assesement.utils.WebpageUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assert;
import org.openqa.selenium.WebDriver;

import static com.assesement.factory.DriverFactory.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Careers {
    WebDriver driver=getDriver();
    CareersPage cp=new CareersPage(driver);
    SearchPage sp=new SearchPage(driver);


    @When("user Clicks on Switch Language Button")
    public void user_clicks_on_switch_language_button() {
        cp.clickOnlanguage();
    }
    @When("user Verify the Page is in German Language")
    public void user_verify_the_page_is_in_german_language() {
        assertThat("Karriere").isEqualTo(cp.getcareerText());
    }
    @When("user Clicks on Switch Language Button Again")
    public void user_clicks_on_switch_language_button_again() {
        cp.clickOnlanguage();
    }
    @Then("User is back on English language")
    public void user_is_back_on_english_language() {
        assertThat("Careers").isEqualTo(cp.getcareerText());
    }
    @When("user Clicks on Contact Button")
    public void user_clicks_on_contact_button() {
    cp.clickSupport();
    }

    @And("User Verifies the phone number is {string}")
    public void user_verifies_the_phone_number_is(String string) {
    assertThat(cp.getPhoneNumber()).contains(string);
    }

    @Then("User goes back to career page")
    public void user_goes_back_to_career_page() {
        cp.goToCareerPage();
    }

    @When("user Clicks on More Button under Inside Deutsche Bank Section")
    public void user_clicks_on_more_button_under_inside_deutsche_bank_section() {
        cp.clickMoreIDB();
    }

    @And("User Verifies Title of the page is {string}")
    public void user_verifies_title_of_the_page_is(String string) {
        assertThat(string).isEqualTo(driver.getTitle());
    }

    @When("user Searches for {string} Under Life at DB")
    public void user_searches_for_under_life_at_db(String string) {
        cp.searchLDB(string);
    }

    @And("Verify the search Shows the  article contains {string}")
    public void verify_the_search_shows_the_article_contains(String string) throws InterruptedException {
        assertThat(cp.returnLDBTitle(string)).contains(string);
    }

    @And("user is able to navigate to the article and verifies the title {string}")
    public void user_is_able_to_navigate_to_the_article_and_verifies_the_title(String string) {
        cp.clickOnArticle();
        assertThat(string).isEqualTo(driver.getTitle());
    }



    @Then("user Verifies the Navigation Contains {string}")
    public void user_verifies_the_navigation_contains(String string) {
        assertThat(cp.verifyHeaders(string)).isTrue();
    }

    @When("user Click on Next under Carousel")
    public void user_click_on_next_under_carousel() {
        cp.clickNextButton();
    }

    @And("Verify the Second Carousel Shows the  article contains {string}")
    public void verify_the_second_carousel_shows_the_article_contains(String string) throws InterruptedException {
        assertThat(cp.getSecondContent()).contains(string);
    }

    @And("user Click on previous under Carousel")
    public void user_click_on_previous_under_carousel() {

        cp.clickprevButton();
    }

    @And("Verify the First Carousel Shows the  article contains {string}")
    public void verify_the_first_carousel_shows_the_article_contains(String string) throws InterruptedException {
      assertThat(cp.getFirstContent()).contains(string);
    }

    @When("user Click on Load More")
    public void user_click_on_load_more(){
    cp.clickLoadMore();
    }

    @Then("Verify the Article Containing {string} is displayed")
    public void verify_the_article_containing_is_displayed(String string) {
        assertThat(cp.getloadMoreContent()).contains(string);
    }

    @When("user Clicks Search from ToolBox")
    public void user_clicks_search_from_tool_box() {
       cp.clickOnSearchFromToolbox();
    }

    @And("Enter Search Input and clicks on Search")
    public void enter_search_input_and_clicks_on_search() {
        cp.search();
    }

    @Then("New tab with search result is opened ,Verify the Title and switch to parent")
    public void new_tab_with_search_result_is_opened_verify_the_title_and_switch_to_parent() throws InterruptedException {
        assertThat(WebpageUtility.switchToNewWindowAndPrintTitle(driver)).isEqualTo("search – Deutsche Bank Careers");
        cp.goToCareerPage();
    }

    @Then("Verify if footer is equal to {string}")
    public void verify_if_footer_is_equal_to(String string) {
    assertThat(cp.getFooterText()).isEqualTo(string);
    }

}
