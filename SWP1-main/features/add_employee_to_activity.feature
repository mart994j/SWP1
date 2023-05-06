Feature: add employee to activity
  Description:Adding an employee to an activity.

  Actor: Project leader


  Scenario: Adding an employee to activity
    Given that a project exist and has an activity
    And that the project leader is logged in.
    Then add employee with the name "Christian Edler", inital "CHED" to the exisiting activity.

  Scenario: Trying to add an employee to activity when employee already has 20 activities
    Given that a project exist and has an activity
    And that the project leader is logged in.
    Then try to add employee with the name "Miriam Gartner", initial "MiGa" to the exisiting activity.
    Then employee has more than max activities
    Then the error message "Employee has the max limit activites" appears.

   Scenario: getting the assigned employees for an activity
   	Given that a project with name "Proj" exists and has an activity "Activity"
   	When The user tries to check the assigned employees
   	Then the user gets the list of assigned employees

