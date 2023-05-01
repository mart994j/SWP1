package example.cucumber;

import app.OperationNotAllowedException;
import app.ProjectsApp;
import domain.Activity;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ActivitySteps {
	private ProjectAppHolder projectAppHolder;
	private ErrorMessageHolder errorMessageHolder;
	private EmpHolder employeeHolder;
	private ProjectHolder projectHolder;
	private ActivityHolder activityHolder;
	
	
    public ActivitySteps(ActivityHolder activityHolder,ProjectAppHolder projectAppHolder,ErrorMessageHolder errorMessageHolder,EmpHolder employeeHolder,ProjectHolder projectHolder) {
      this.activityHolder = activityHolder;
      this.projectAppHolder = projectAppHolder;
      this.employeeHolder = employeeHolder;
      this.projectHolder = projectHolder;
      this.errorMessageHolder = errorMessageHolder;
    }


    @Given("that a project exist and has an activity")
    public void thatAProjectExistAndHasAnActivity() {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		
        projectsApp.createProject("Project1");    
        Activity activity = new Activity("name",null,null,0);
        projectsApp.getProjectWithName("Project1").addActivity(activity);
        if(projectsApp.projects.size()>0 && projectsApp.getProjectWithName("Project1").activities.size()>0){
            assertTrue(true);
        } else{
            assertFalse(false);
        }
    }
    @Given("that the project leader is logged in.")
    public void that_the_project_leader_is_logged_in () throws OperationNotAllowedException {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
    	projectsApp.addEmployee(new Employee("Martin","MJ"));
        //assertTrue(true);
        // assertTrue( projectApp.checkLogin(project.getProjectLeader()));
    }

    @Then("add employee with the name {string}, inital {string} to the exisiting activity.")
    public void addEmployeeWithTheNameInitalAndAgeToTheExisitingActivity(String string, String string2) {
        Employee employee = new Employee(string,string2);
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        projectsApp.getActivityWithName("Activity1","Project1").assignEmp(employee);
    }
}
