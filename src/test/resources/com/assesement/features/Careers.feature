Feature: Test all the important Scenarios of Careers Page


  @SmokeTest
  Scenario: Check the Language Switch Button

    Given User is on careers HomePage
    Then user Verifies the Navigation Contains "Inside Deutsche Bank,Our Business,Our people,Professionals,Students and Graduates,School leavers Germany,School leavers UK"

  @SmokeTest
  Scenario: Check the Language Switch Button

    Given User is on careers HomePage
    When user Clicks on Switch Language Button
    And user Verify the Page is in German Language
    And user Clicks on Switch Language Button Again
    Then User is back on English language


  @SmokeTest
  Scenario: Verify the Contact Page from Careers

    Given User is on careers HomePage
    When user Clicks on Contact Button
    And User Verifies the phone number is "+49 30 6676 - 9010"
    Then User goes back to career page

  @SmokeTest
  Scenario: Verify more button is working Inside Deutsche Bank Section

    Given User is on careers HomePage
    When user Clicks on More Button under Inside Deutsche Bank Section
    And User Verifies Title of the page is "Welcome - Inside Deutsche Bank – Deutsche Bank Careers"
    Then User goes back to career page


  @SmokeTest
  Scenario: Verify Search is working under Life at DB

    Given User is on careers HomePage
    When user Searches for "Lakshmi" Under Life at DB
    And Verify the search Shows the  article contains "Lakshmi"
    And user is able to navigate to the article and verifies the title "Lakshmi – Deutsche Bank Careers"
    Then User goes back to career page

  @SmokeTest
  Scenario: Verify Next and Previous Button is working in carousel

    Given User is on careers HomePage
    When user Click on Next under Carousel
    And Verify the Second Carousel Shows the  article contains "Discover how we"
    When user Click on previous under Carousel
    And Verify the First Carousel Shows the  article contains "Explore how we"


  @SmokeTest
  Scenario: Verify Load More is Working

    Given User is on careers HomePage
    When user Click on Load More
    Then Verify the Article Containing "Nikolaus" is displayed

  @SmokeTest
  Scenario: Verify what you are looking for is working

    Given User is on careers HomePage
    When user Clicks Search from ToolBox
    And Enter Search Input and clicks on Search
    Then New tab with search result is opened ,Verify the Title and switch to parent

  @SmokeTest
  Scenario: Verify the Copyright Footer of the page

    Given User is on careers HomePage
    Then Verify if footer is equal to "Copyright © 2023 Deutsche Bank AG, Frankfurt am Main"
