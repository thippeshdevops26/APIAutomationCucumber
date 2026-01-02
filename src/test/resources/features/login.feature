@ui
Feature: Login feature

  Scenario: Valid login (PASS)
    Given user opens login page
    When user logs in with valid credentials
    Then user should see success message

  Scenario: Invalid login (FAIL)
    Given user opens login page
    When user logs in with invalid credentials
    Then error message should be shown
