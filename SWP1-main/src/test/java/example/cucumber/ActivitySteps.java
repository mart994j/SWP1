package example.cucumber;

import app.OperationNotAllowedException;
import app.ProjectsApp;
import domain.Activity;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
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
		
        projectsApp.createProject("Project1", 0);    
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
    
    
    
    
    
    @Given("the project with an id {int} exists")
    public void theProjectWithAnIdExists(Integer id) {
        ProjectsApp projectApp = projectAppHolder.getProjectsApp();
        Project project = projectHolder.getProject();
        project = new Project(null, id);
        project.setProjectId(id);
        
    }

    @Given("the activity with {string} exists for a project")
    public void theActivityWithExistsForAProject(String name) {
    	ProjectsApp projectApp = projectAppHolder.getProjectsApp();
        Project project = projectHolder.getProject();
        project = new Project("TestProject", 0);
        project.setProjectName("TestProject");
        Activity activity = new Activity(name, null, null, 0);
        project.addActivityToProject(activity);
    }

    @When("the projectleader edits the time budget to {int}")
    public void theProjectleaderEditsTheTimeBudgetTo(Integer int1) {
        Project project = projectHolder.getProject();
        Employee projectLeader = employeeHolder.getEmployee();
        Activity activity = activityHolder.getActivity();
        project = new Project("name", int1);
        activity = new Activity(null, null, null, int1);
        project.addActivity(activity);
        project.setProjectLeader(projectLeader);
        activity.setExpectedAmountOfHours(int1);
    }
    
    @Then("the expected time budget changes	to {int}")
    public void theExpectedTimeBudgetChangesTo(Integer int1) {
        Activity activity = activityHolder.getActivity();
        activity = new Activity(null, null, null, int1);
        int expectedBudget = activity.getExpectedAmountOfHours();
        assertEquals(expectedBudget, activity.getExpectedAmountOfHours());
    }
    
    @Then("I get the error message {string}")
    public void iGetTheErrorMessage(String errorMessage) {
    	ErrorMessageHolder errorMessageHolder = new ErrorMessageHolder();
    	errorMessageHolder.setErrorMessage(errorMessage);
    	
        assertEquals("Error message is incorrect", errorMessage, errorMessageHolder.getErrorMessage());
    }
    
   
    
    
    
    
}
