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
