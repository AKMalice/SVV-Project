Feature: Generate Analytics

  Scenario: Admin Generates Analytics
    Given the user is logged in as an admin
    When the user goes to the analytics page
    And selects report to generate
    Then analytics data is generated