Feature: Search for Professional Roles and Verify Search Result Matches the Entered Keyword

  @SmokeTest @SanityTest @RegressionTest
Scenario: Search with English Keyword
Given User is on careers HomePage
When user Clicks on professional
And user Enters Keyword "QA"
And user clicks on search
Then user gets searched Keyword "QA" in search result






