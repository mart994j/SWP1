Feature: Userloggedin
  Description:

  Actor: Employee

  Scenario: A user is logged in
    Given that a user exists
    And initials is "SWA"
    Then the user login succeds
    And the user is logged in

  Scenario: A user logs in with wrong initials
    Given that a user exists
    And initials is "wrong"
    Then the user login fails
    And the user is not logged in

  Scenario: A user tries to create an activity but is not logged in
    Given that the admin is not logged in
    When the user tries to add an employee to the system 
    Then the error message "You cant add employees when your not logged in" appears.

  Scenario: User logs out
    Given that the user is logged in with the initials "SWA"
    When the user logs out
    Then the user is not logged in