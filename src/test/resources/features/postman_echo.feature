Feature: Basic Authentication API

  Scenario: Access API using Basic Authentication
    Given I have valid basic authentication credentials
    When I send a GET request to "/basic-auth"
    Then the response status code should be 200
    And the response should contain "authenticated" as true
