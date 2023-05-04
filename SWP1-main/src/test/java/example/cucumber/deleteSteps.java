package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import app.ActivityNotFound;
import app.OperationNotAllowedException;
import app.ProjectsApp;
import domain.Activity;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class deleteSteps {

	private ProjectsApp projectApp;
	private int id;
	private String initials;
	private String name;

	private ProjectAppHolder projectAppHolder;
	private ErrorMessageHolder errorMessageHolder;
	private EmpHolder employeeHolder;
	private ProjectHolder projectHolder;
	private ActivityHolder activityHolder;

	public deleteSteps(ActivityHolder activityHolder, ProjectAppHolder projectAppHolder,
			ErrorMessageHolder errorMessageHolder, EmpHolder employeeHolder, ProjectHolder projectHolder) {
		this.activityHolder = activityHolder;
		this.projectAppHolder = projectAppHolder;
		this.employeeHolder = employeeHolder;
		this.projectHolder = projectHolder;
		this.errorMessageHolder = errorMessageHolder;
	}

	@Given("a project with the id {int} exists.")
	public void aProjectWithTheIdExists(int id) throws Exception {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		projectApp.createProject(null, id);
		assertTrue(projectApp.projectExists(id));
		this.id = id;
	}

	@Given("the admin deletes the project")
	public void theAdminDeletesTheProject() throws Exception {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		assertFalse(projectApp.deleteProject(id));
	}

	@Then("the project has been deleted")
	public void theProjectHasBeenDeleted() throws Exception {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		assertFalse(projectApp.projectExists(id));
	}

	@Given("an employee with the initials {string} exists.")
	public void anEmployeeWithTheInitialsExists(String initials) throws Exception {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		projectApp.addEmployee(new Employee(null, initials));

		assertTrue(projectApp.empExists(initials));
		this.initials = initials;
	}

	@Given("the admin deletes the employee")
	public void theAdminDeletesTheEmployee() throws Exception {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		assertFalse(projectApp.deleteEmp(initials));
	}

	@Then("the employee has been deleted")
	public void theEmployeeHasBeenDeleted() throws Exception {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		assertFalse(projectApp.empExists(initials));
	}

	@Given("a activity with the name {string} exists.")
	public void aActivityWithTheNameExists(String name) throws ActivityNotFound {
		Project project = projectHolder.getProject();
		Activity activity = activityHolder.getActivity();

		project = new Project("Test", 123);
		project.addActivity(activity = new Activity(name, null, null, id));

		project.activities.add(activity);
		assertTrue(name, project.activities.contains(activity));

	}

	@Given("the admin deletes the activity")
	public void theAdminDeletesTheActivity() {
		Project project = projectHolder.getProject();
		Activity activity = activityHolder.getActivity();

		project = new Project("Test", 123);
		assertFalse(project.activities.contains(activity));
	}

	@Then("the activity has been delete")
	public void theActivityHasBeenDelete() {
		Project project = projectHolder.getProject();
		Activity activity = activityHolder.getActivity();
		project = new Project("Test", 123);

		assertFalse(project.activities.contains(activity));
	}

}