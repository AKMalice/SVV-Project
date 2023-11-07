# Author: Abdul
Feature: Check if the website is accessible

  Scenario: Verify the NOVA website is accessible
    Given the browser is open
    When the user navigates to the NOVA website
    Then the user should be on the NOVA website
