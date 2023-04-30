package example.cucumber;

import app.projectApp;
import domain.Activity;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ActivitySteps {
    private app.projectApp projectApp;
    private Employee employee;
    private Project project;
    public ActivitySteps(projectApp projectApp) {
        this.projectApp = projectApp;
    }


    @Given("that a project exist and has an activity")
    public void thatAProjectExistAndHasAnActivity() {
        projectApp.createProject("Project1");
        projectApp.getProjectWithName("Project1").addActivityToProject(new Activity("Activity1",15,14,20));
//project.setProjectLeader(projectApp.getEmployeeWithInitials("EMJ"));
        if(projectApp.projects.size()>0 && projectApp.getProjectWithName("Project1").getActivities().size()>0){
            assertTrue(true);
        } else{
            assertFalse(false);
        }
    }
    @Given("that the project leader is logged in.")
    public void that_the_project_leader_is_logged_in () {
        projectApp.addEmployee(new Employee("Emil Jøj",45,"EMJ"));
        //assertTrue(true);
        // assertTrue( projectApp.checkLogin(project.getProjectLeader()));
    }

    @Then("add employee with the name {string}, inital {string} and age {string} to the exisiting activity.")
    public void addEmployeeWithTheNameInitalAndAgeToTheExisitingActivity(String string, String string2, String string3) {
        employee = new Employee(string,Integer.parseInt(string3),string2);
        projectApp.getActivityWithName("Activity1","Project1").addEmployeeToActivity(employee);
    }
}
