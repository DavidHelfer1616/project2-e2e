Feature: Login Page
  Background:
    Given A user is on the register page
    When The user enters valid user information
    Then The user will be redirected to the login page
    Given A user is on the login page
  Scenario: Logging in with valid credentials will redirect to users main feed
    When A user enters correct login credentials
    Then The user is redirected to their main feed
  Scenario: Logging in with invalid credentials will show error message
    When A user enters incorrect login credentials
    Then An invalid credentials message shows on login form
  Scenario: Clicking on the "Create Account" button will redirect user to the register page
    When A user clicks on the create account button
    Then The user is redirected to the register page
  Scenario:  Clicking on the "Forgot Password" button will redirect user to the reset password page
    When A user clicks on the forgot password button
    Then The user is redirected to the reset password page