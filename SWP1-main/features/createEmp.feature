Feature: Employee Creation
  Description: This feature allows the company to create employees with unique initials.

  Actors: The company

  Scenario: Create employee successfully
    Given employee with initials "MJ" exists
    And the employee has the name "Martin Jespersen"
    When I check for the employee is created
    Then I get the name "Martin Jespersen" and the initials "MJ"
    And the initials "MJ" is in the initials list
    And the employeelist conatins the employee


  Scenario: Fail creating an employee with the same initials
    Given an employee with the initials "MJ" exists
    When the actor tries to add a new employee with the initials "MJ"
    Then the error message "There is already an employee with the same initials"


  Scenario: Checking for initials
    Given that the admin is logged in
    When the admin adds a new user with the initials "martin" to the system
    Then the error message "4 or fewer please" appears.
