Feature: Testing Change Password Functionality

  Scenario: Changing password functionality
    Given the user is on the login-page
    When the user clicks the forgot password link
    And the user types the username
    And the user clicks the reset password button
    And the user enters the reset link
    And the user enters the new password
    And the user clicks the return to login page
    Then the user should be redirected to the login page
