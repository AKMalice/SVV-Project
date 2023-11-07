Feature: Make an Announcement

  Scenario: Admin makes an announcement on the dashboard
    Given the user is logged in as admin
    When the user goes to the dashboard
    And types an announcement text and sends it
    Then the user checks if the announcement is successful
