Feature: Add Student

  Scenario: Admin adds a student
    Given the user is admin
    When the user goes to the student page
    And enters student details and clicks on the "Add" button
    Then the student is added successfully
