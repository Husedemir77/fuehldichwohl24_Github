Feature: US-1 User should be able to use fühldichgesund Page functionality.


  Scenario: US01_TC01 The unter menus in the page should be visible.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then  Hover on fühldichgesund menu
    And   check the menu link
    And Driver close


  Scenario: US01_TC03 All links should have destination and work properly.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fühldichgesund menu
    And Hover fühldichgesundMenus und check
    And Driver close


  Scenario: US01_TC04 Every product should have image, name and price.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fühldichgesund menu
    And go to subMenus und Product check
    And Driver close


  Scenario: US02_TC01 User should be able to add the product to Cart.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fühldichgesund menu
    And Random go to submenus und random add a Product in den Warenkorb
    Then check in den Warenkorb a product
    And Driver close

  Scenario: US02_TC02 If the product is In Stock user should be able to change the quantity
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fühldichgesund menu
    And Random go to submenus und random add a Product in den Warenkorb
    Then change the quantity in der Warenkorb
    And check pries and zwischensumme
    And Driver close

  Scenario: US03_TC02 Selected product should be able to deleted.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fühldichgesund menu
    And Random go to submenus und random add a Product in den Warenkorb
    And go to Warenkorb
    Then remove the product
    And check the not
    And Driver close




















