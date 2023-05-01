Feature: add employee to activity
  Description:Adding an employee to an activity.

  Actor: Project leader


  Scenario: Adding an employee to activity
    Given that a project exist and has an activity
    And that the project leader is logged in.
    Then add employee with the name "Christian Edler", inital "CHED" to the exisiting activity.


 # Scenario: trying to add an employee to activity when there is no activity
  #  Given that a project exist.
   # And that the project leader is logged in.
    #Then add employee with the name "Christian Edler", inital "CHED" and age "23" to an activity.

  #Scenario: Trying to add an employee to activity when employee already has 20 activities
   # Given that a project exist and has an activity
    #And that the project leader is logged in.
    #Then add employee with the name "Christian Edler", inital "CHED" and age "23" to the exisiting activity.


