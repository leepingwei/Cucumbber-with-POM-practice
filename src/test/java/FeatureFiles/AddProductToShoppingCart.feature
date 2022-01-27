Feature: Add product to shopping cart

  Scenario: Choose an product and add to shopping cart
    Given Navigate to shopdemo website
    When User add one product to shopping cart
    Then User click on continue shopping button
    Then User click on shopping cart link
    Then Verify if the item been displayed
    Then User quit the browser