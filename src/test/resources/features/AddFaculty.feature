Feature: Add Faculty

  Scenario: Admin adds a faculty member
    Given the user is logged in as admin id
    When the user goes to the faculty page
    And enters faculty details and clicks on the "Add" button
    Then the faculty member is added successfully
