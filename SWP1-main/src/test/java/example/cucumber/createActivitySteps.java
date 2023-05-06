package example.cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import domain.Activity;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class createActivitySteps {

	private ProjectAppHolder projectAppHolder;
	private ErrorMessageHolder errorMessageHolder;
	private EmpHolder employeeHolder;
	private ProjectHolder projectHolder;
	private ActivityHolder activityHolder;

	public createActivitySteps(ProjectAppHolder projectAppHolder,ErrorMessageHolder errorMessageHolder,EmpHolder
			employeeHolder,ProjectHolder projectHolder,ActivityHolder activityHolder) {
		this.activityHolder = activityHolder;
		this.employeeHolder = employeeHolder;
		this.errorMessageHolder = errorMessageHolder;
		this.projectAppHolder = projectAppHolder;
		this.projectHolder = projectHolder;
	}



	@Given("a project with id {int} exists")
	public void aProjectWithIdExists(int id) {
		Project project = projectHolder.getProject();
		project = new Project(null, id);
		projectHolder.setProject(project);
		project.setProjectId(id);
		assertTrue(id == project.getProjectId());

	}


	@Given("the project leader has initials {string}")
	public void theProjectLeaderHasInitials(String initials) {
		Employee employee = new Employee("Martin Jespersen",initials);
		employeeHolder.setEmployee(employee);
		projectHolder.getProject().setProjectLeader(employee);
	}

	@When("the project leader {string} creates the activity {string}")
	public void theProjectLeaderCreatesTheActivity(String initials, String name) {
		assertTrue(projectHolder.getProject().getProjectLeader().getInitials().equals(initials));
		Activity activity = new Activity(name,null, null, 0);
		projectHolder.getProject().addActivity(activity);
	}

	@Then("the activity {string} is created for the project")
	public void theActivityIsCreatedForTheProject(String name) {
		Activity activity = new Activity(name,null, null, 0);
		activity.setActivName(name);
		assertTrue(activity.getActivName() == name);

	}
}