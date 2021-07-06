Feature: Blog Page Functionality

  Background: Navigate to Blog page
    Given User navigates to "https://fuehldichwohl24.de/"
    And Click on the Blog link

  Scenario: US_01 TC_01 User should be able to go to Blog page by clicking link
    Then Blog page title should be "Blog - fuehldichwohl24.de"

  Scenario: US_01 TC_02 Each article on Blog page should have an image
    Then User should see an image for an article

  Scenario: US_01 TC_03 User should be able to go to article by clicking image
    Given User clicks image of any article randomly
    Then User should be able to navigate to related page

  Scenario: US_01 TC_04 User should be able to go to article by clicking title
    Given User clicks the title of any article randomly
    Then User should be able to navigate to related page

  Scenario: US_01 TC_05 User should be able to go to article by clicking wieterlesen
    Given User clicks any wieterlesen randomly
    Then User should be able to navigate to related page