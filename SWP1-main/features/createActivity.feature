Feature: Create activity
	Description: creating activities for a project.
	Actor: Project Leader.
	
	Scenario: Create an activity successfully
		Given a project with id 1 exists
		And the project leader has initials "MJ" 
		When the project leader "MJ" creates the activity "Bag en kage"
		Then the activity "Bag en kage" is created for the project

