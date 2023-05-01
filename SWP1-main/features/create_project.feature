Feature: create project
  Description: a project is created and gets a project number.
  when a project is created it has to have a name. It can be created with/without a start/end date.

  Actor: Employee

  Scenario: A project is created with the name "Test project" successfully
    Given that the company get a project with the name "Test project".
    When an employee creates the project.
    Then a project with the name "Test project" is created successfully.
    And the project gets given a project id.




