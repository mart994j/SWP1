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