Feature: create project
  Description: a project is created and gets a project number.
  when a project is created it has to have a name. It can be created with/without a start/end date.

  Actor: Employee

  Scenario: A project is created with the name "Test project" successfully
    Given that the company get a project with the name "Test project".
    When an employee creates the project.
    Then a project with the name "Test project" is created successfully.
    And the project gets given a project id.
    
   Scenario: Find a project with the name  "UI til DTU"
   	Given that a project with the name "UI til DTU" exists
   	When a user searches for the project "UI til DTU"
   	Then the project "UI til DTU" is found

	Scenario: Changeing a project leader
		Given that a project with the name "MCS" exists
		And there is a project leader assigned with the name "OOP"
		When the user changes the project leader to "MSJ"
		Then the project leader is changed to "MSJ"



