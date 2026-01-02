@ui
Feature: Logout feature

  Scenario: Logout validation (FAIL)
    Given user opens login page
    When user logs in with valid credentials
    Then logout button should be visible
