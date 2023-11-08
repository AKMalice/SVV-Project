Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be logged in successfully

  Scenario: User logs in with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username and password
    And clicks the login button
    Then the user should see an error message