Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario: Check home page functionality
    When User opens "https://avic.ua" page
    Then User checks header visibility
    And User checks loginButton visibility
    And User checks cartIcon visible


  Scenario Outline: Check displaying the number of product in the cart
    Given User opens '<homePage>' page
    When User clicks iPhone13Link
    And User clicks buyButton
    And User clicks continuePurchasesButton
    Then User checks that amount of products in wish list are <amountOfProducts>

    Examples:
    | homePage        | amountOfProducts |
    |https://avic.ua  | 1                |


