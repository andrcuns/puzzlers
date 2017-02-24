@mapMarker
Feature: Map markers

  Background:
    Given a user is on map marker page

  Scenario: Map marker with address should be placed on map
    When a user enters "56.9086" in field "latitude"
    And a user enters "24.0832" in field "longitude"
    And clicks the "Add marker" button
    Then a map marker should appear

    When a user clicks on a map marker
    Then a popup should appear
    And a popup should contain text "Vienības gatve 109"