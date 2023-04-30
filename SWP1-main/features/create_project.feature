Feature: create project
  Description: a project is created and gets a project number.
  when a project is created it has to have a name. It can be created with/without a start/end date.

  Actor: Employee

  Scenario: A project is created with the name "Test project" successfully
    Given that the company get a project with the name "Test project".
    When an employee creates the project.
    Then a project with the name "Test project" is created successfully.
    And the project gets given a project id.


    Scenario: A project is created with a name "Project1" succesfully with a start and end date
      Given that the company get a project with the name "Project1".
      And the project gets given a project startdate and enddate
      And the project gets given a project id.
      Then the project "Project1" is created successfully.
      
      
  Scenario: the end date of a project is changed to be sooner than the start date
	Given the project with id 1 exists
	When an employee edits the end date of the project to a date before the start date
	Then I get the error message "The end date must be after the start date"




