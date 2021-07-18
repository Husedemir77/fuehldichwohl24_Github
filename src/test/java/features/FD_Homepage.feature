Feature: Homepage Functionality

  Background:

    Given navigate to FDW page

  @SmokeTest
  Scenario:Check the homepage titel
    Then user check the mainpage titel

  @RegressionTest
    Scenario:Check the functionality of the homepage
    Then user check the search function
    Then  check the main tab buttons
    When user scrolls down the Page it should load correctly.

  @RegressionTest
    Scenario: Checking the titels
      When user click on the main menu buttons
      Then header texts should match

  @RegressionTest
    Scenario: Checking product text and  price
      When user click on a product text and price should match




