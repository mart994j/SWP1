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

import java.util.List;

public class ActivitySteps {
	private ProjectAppHolder projectAppHolder;
	private ErrorMessageHolder errorMessageHolder;
	private EmpHolder employeeHolder;
	private ProjectHolder projectHolder;
	private ActivityHolder activityHolder;

	public ActivitySteps(ActivityHolder activityHolder, ProjectAppHolder projectAppHolder,
			ErrorMessageHolder errorMessageHolder, EmpHolder employeeHolder, ProjectHolder projectHolder) {
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
		Activity activity = new Activity("name", null, null, 0);
		projectsApp.addActivity(activity,projectsApp.getProjectWithName("Project1"));
		if (projectsApp.projects.size() > 0 && projectsApp.getProjectWithName("Project1").activities.size() > 0) {
			assertTrue(true);
		} else {
			assertFalse(false);
		}
	}

	@Given("that the project leader is logged in.")
	public void that_the_project_leader_is_logged_in() throws OperationNotAllowedException {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		projectsApp.addEmployee(new Employee("Martin", "MJ"));
		projectsApp.adminLogin("adminadmin");
		assertTrue(projectsApp.adminLoggedIn());
	}

	@Then("add employee with the name {string}, inital {string} to the exisiting activity.")
	public void addEmployeeWithTheNameInitalAndAgeToTheExisitingActivity(String string, String string2)
			throws OperationNotAllowedException {
		Employee employee = new Employee(string, string2);
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		projectsApp.getActivityWithName("Activity1", "Project1").assignEmp(employee);
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
		projectApp.addActivity(activity, project);
	}

	@When("the projectleader edits the time budget to {int}")
	public void theProjectleaderEditsTheTimeBudgetTo(Integer int1) {
		Project project = projectHolder.getProject();
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		Employee projectLeader = employeeHolder.getEmployee();
		Activity activity = activityHolder.getActivity();
		project = new Project("name", int1);
		activity = new Activity(null, null, null, int1);
		projectApp.addActivity(activity, project);
		project.setProjectLeader(projectLeader);
		activity.setExpectedAmountOfHours(int1);
	}

	@Then("the expected time budget changes	to {int}")
	public void theExpectedTimeBudgetChangesTo(Integer int1) {
		Activity activity = activityHolder.getActivity();
		activity = new Activity(null, null, null, int1);
		double expectedBudget = activity.getExpectedAmountOfHours();
		assertEquals(activity.getExpectedAmountOfHours(), expectedBudget,0.5);
	}

	@Then("I get the error message {string}")
	public void iGetTheErrorMessage(String errorMessage) {
		ErrorMessageHolder errorMessageHolder = new ErrorMessageHolder();
		errorMessageHolder.setErrorMessage(errorMessage);

		assertEquals("Error message is incorrect", errorMessage, errorMessageHolder.getErrorMessage());
	}

	@Then("try to add employee with the name {string}, initial {string} to the exisiting activity.")
	public void tryToAddEmployeeWithTheNameInitialToTheExisitingActivity(String string, String string2)
			throws OperationNotAllowedException {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Employee emp = new Employee(string, string2);
		projectsApp.addEmployee(emp);
		Project pr = new Project("testProject", 12345);
		for (int i = 0; i < 21; i++) {
			String name = "" + i;
			projectsApp.addActivity(new Activity(name,null,null,0), pr);
		}
		for (int i = 0; i < pr.activities.size(); i++) {
			pr.activities.get(i).assignEmp(emp);
			emp.empActvities.add(pr.activities.get(i));
		}
		System.out.println(emp.empActvities.size());

	}

	@Then("employee has more than max activities")
	public void employeeHasMoreThanActivities() {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		System.out.println(projectsApp.getEmployeeWithName("Miriam Gartner").empActvities.size());
		assertFalse(projectsApp.checkMaxActivites(projectsApp.getEmployeeWithName("Miriam Gartner")));

	}

	@Then("the error message {string} appears.")
	public void theErrorMessageAppears(String errorMessage) {
		ErrorMessageHolder errorMessageHolder = new ErrorMessageHolder();
		errorMessageHolder.setErrorMessage(errorMessage);

		assertEquals("Employee has the max limit activites", errorMessage, errorMessageHolder.getErrorMessage());
	}

	@Given("that a project with name {string} exists and has an activity {string}")
	public void thatAProjectWithNameExistsAndHasAnActivity(String projName, String activName) {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Activity activity = activityHolder.getActivity();
		Project project = projectHolder.getProject();
		project = new Project(projName, 0);
		activity = new Activity(activName, null, null, 0);
		projectsApp.addActivity(activity, project);
	}

	@When("The user tries to check the assigned employees")
	public void theUserTriesToCheckTheAssignedEmployees() {
		Project project = projectHolder.getProject();
		Activity activity = activityHolder.getActivity();
		activity = new Activity("activName", null, null, 0);

		List<Employee> assignedEmployees = activity.getAssignedEmployees();

	}

	@Then("the user gets the list of assigned employees")
	public void theUserGetsTheListOfAssignedEmployees() {
		Project project = projectHolder.getProject();
		project = new Project("projName", 0);

		List<Employee> expectedAssignedEmployees = project.getAssignedEmployees(project);
		List<Employee> actualAssignedEmployees = project.getAssignedEmployees(project);
		assertEquals(expectedAssignedEmployees, actualAssignedEmployees);
	}

	@When("a user tries to create an activity with the same name {string}")
	public void aUserTriesToCreateAnActivityWithTheSameName(String name) {
		Activity activity = activityHolder.getActivity();
		activity = new Activity(name, null, null, 0);
	}
}
