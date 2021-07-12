Feature: Blog Page Functionality

  Background: Navigate to Blog page
    Given User navigates to "https://fuehldichwohl24.de/"
    And Click on the Blog link
  @SmokeTest
  Scenario: US_01 TC_01 User should be able to go to Blog page by clicking link
    Then Blog page title should be "Blog"

  @RegressionTest
  Scenario: US_01 TC_02 Each article on Blog page should have an image
    Then User should see an image for an article

  Scenario: US_01 TC_03 User should be able to go to article by clicking image
    When User clicks image of any article randomly
    Then User should be able to navigate to related page

  Scenario: US_01 TC_04 User should be able to go to article by clicking title
    When User clicks the title of any article randomly
    Then User should be able to navigate to related page

  Scenario: US_01 TC_05 User should be able to go to article by clicking wieterlesen
    When User clicks any wieterlesen randomly
    Then User should be able to navigate to related page