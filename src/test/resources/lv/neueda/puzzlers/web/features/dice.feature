@all @dice
Feature: Dice

  Background:
    Given a user is on dice page

  Scenario: Three "+" dice should appear at least once in 20 seconds
    When a user toggles the switch "on"
    Then dice start to shuffle
    And a user sees three "+" dice in a row within 60 seconds