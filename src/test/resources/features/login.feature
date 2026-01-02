Feature: Login functionality

  Scenario: Login with valid credentials
    Given user is on login page
    When user logs in with username "tomsmith" and password "SuperSecretPassword!"
    Then login should be successful

  Scenario: Login with invalid credentials
    Given user is on login page
    When user logs in with username "wronguser" and password "wrongpass"
    Then error message should be displayed
