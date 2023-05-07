Feature: Calculate time per week

  Scenario: Calculate time per week for a given date range
   Given a project with the id 1 exists.
    And a activity with the name "Lærke" exists.
    And the expectedAmountOfHours is 20
    And the startWeek is 20
    And the endWeek is 29
    Then the time per week is 2.0