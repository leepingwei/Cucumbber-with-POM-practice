Feature: Share To Facebook

  Scenario: Click on Share button to share to Facebook
    Given Navigate to shopdemo website
    When User click on Share button
    Then Verify Login message on the pop up window
    Then User quit the browser