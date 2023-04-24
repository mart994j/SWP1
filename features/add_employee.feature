Feature: Add Employee
  Description: Make an employee
  Actors: Administrator

  Scenario: Add an employee successfully
    Given that the employees initials are 4 or less
    And they are under the age of 70
    Then the employee has been added

  #Scenario: Add an employee that has more than 4 initials
  #  Given that employee has more than "4" initials
  #  Then the error message "employee cannot be added with 5 or more initials" is given

 # Scenario: Add an employee is older than 69 years old
  #  Given that employee is older than 69 years old
 #   Then the error message "employee cannot be added if over 69 years old" is shown