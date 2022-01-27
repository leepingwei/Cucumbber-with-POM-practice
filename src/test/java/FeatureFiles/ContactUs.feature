Feature: Contact us function

  Scenario Outline: Contact us function test
    Given Navigate to shopdemo website
    When User click on contact us link
    Then User fill up the form and submit with "<Name>" "<Email>" "<Subject>" "<Message>"
    Then User quit the browser

    Examples:
      | Name   | Email           | Subject         | Message                               |
      | Kevin  | kevin@test.com  | Banana          | Let's go get banana                   |
      | Stuart | stuart@test.com | Unicorn         | Making an unicorn for Agnes           |
      | Bob    | bob@test.com    | Ice cream Truck | Buying ice cream from ice cream truck |
