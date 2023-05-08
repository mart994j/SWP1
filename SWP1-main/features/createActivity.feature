Feature: Create activity
	Description: creating activities for a project.
	Actor: Project Leader.

	Scenario: Create an activity successfully
		Given a project with id 23001 exists
		And the project leader has initials "MJ"
		When the project leader "MJ" creates the activity "Bag en kage"
		Then the activity "Bag en kage" is created for the project

	Scenario: The time budget of an activity is changed
		Given the project with an id 1 exists
		And the activity with "Byg en racerbane" exists for a project
		When the projectleader edits the time budget to 50
		Then the expected time budget changes	to 50

	Scenario: the time budget is set to less than 0
		Given the project with an id 1 exists
		And the activity with "Lej en kæb" exists for a project
		When the projectleader edits the time budget to -100
		Then I get the error message "The expected amount of hours must be at least 0 hours"

	Scenario: create activity with the same names
		Given that a project with the name "Hej" exists
		And the activity with "Bag en kage" exists for a project
		When a user tries to create an activity with the same name "Bag en kage"
		Then I get the error message "You cant add an activity with the same name"

		
	
		

