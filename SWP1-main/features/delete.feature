Feature: Delete
  Description: Delete a activity
  Actors: Administrator

  Scenario: Delete an activity successfully

    Given a activity with the name "Lærke" exists.
    And the admin deletes the activity
    Then the activity has been delete

  Scenario: Delete an employee successfully

    Given an employee with the initials "SWA" exists.
    And the admin deletes the employee
    Then the employee has been deleted

  Scenario: Delete a project successfully

    Given a project with the id 1 exists.
    And the admin deletes the project
    Then the project has been deleted