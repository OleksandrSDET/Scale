@scale
Feature: Fake Gold Bar Test

  Background:
    Given I open the website

  Scenario: Find the fake gold bar
    When I find the fake gold bar
    Then I should see the alert message
    And I should see the  list of Weighings