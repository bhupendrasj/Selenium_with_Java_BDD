@smoke
Feature: Login Functionality

  Scenario: Login with valid credentials
    Given user is on the LambdaPlayground login page
    When user enters valid username and password
    And clicks on the login button
    Then user should be redirected to the dashboard
