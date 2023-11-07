Feature: Add Exams

  Scenario: Admin adds an exam
    Given the user is an admin
    When the user goes to the exams page
    And enters exam details and clicks on the Add button
    Then the exam is added successfully
