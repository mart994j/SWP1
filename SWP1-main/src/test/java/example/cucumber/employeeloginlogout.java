package example.cucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.OperationNotAllowedException;
import app.ProjectsApp;
import domain.Employee;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class employeeloginlogout {

	private ProjectAppHolder projectAppHolder;
	private ErrorMessageHolder errorMessageHolder;
	private EmpHolder employeeHolder;
	private ProjectHolder projectHolder;
	private ActivityHolder activityHolder;
	private ProjectsApp projectApp;
	

	private String initials;

	public employeeloginlogout(ProjectsApp projectApp, ActivityHolder activityHolder, ProjectHolder projectHolder,
			EmpHolder employeeHolder, ProjectAppHolder projectAppHolder, ErrorMessageHolder errorMessageHolder)
			throws Exception {
		this.activityHolder = activityHolder;
		this.employeeHolder = employeeHolder;
		this.errorMessageHolder = errorMessageHolder;
		this.projectAppHolder = projectAppHolder;
		this.projectHolder = projectHolder;
		this.projectApp = projectApp;
	}

//userloggin korrekt initialer
	@Given("that a user exists")
	public void thatAUserExists() throws Exception {
		projectApp.addEmployee(new Employee("Wulf", "SWA"));
		assertFalse(projectApp.isUserLoggedIn());
	}

	@Given("initials is {string}")
	public void initialsIs(String initials) throws Exception {
		this.initials = initials;
	}

	@Then("the user login succeds")
	public void theUserIsLoggedIn() throws Exception {
		assertTrue(projectApp.userLogin(initials));

	}

	@And("the user is logged in")
	public void userloggedin() throws Exception {
		assertTrue(projectApp.isUserLoggedIn());
	}

	@Then("the user login fails")
	public void theUserLoginFails() throws Exception {
		assertFalse(projectApp.userLogin(initials));
	}

	@Then("the user is not logged in")
	public void theUserIsNotLoggedIn() throws Exception {
		assertFalse(projectApp.isUserLoggedIn());
	}


	@Given("that the user is logged in with the initials {string}")
	public void thatTheUserIsLoggedInWithTheInitials(String initials) throws Exception {
		this.initials=initials;
		projectApp.addEmployee(new Employee("Wulf", "SWA"));
		projectApp.userLogin(initials);
		assertTrue(projectApp.isUserLoggedIn());
	}

	@When("the user logs out")
	public void theUserLogsOut() throws Exception {
		assertFalse(projectApp.userLogout());
	}

	@When("the admin adds a new user with the initials {string} to the system")
	public void theAdminAddsANewUserWithTheInitialsToTheSystem(String initials) throws OperationNotAllowedException {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Employee emp = new Employee(null, initials);
		emp.setInitials(initials);
		try {
			projectsApp.addEmployee(emp);
		} catch (OperationNotAllowedException e) {
			throw new RuntimeException(e);
		}
		assertFalse(projectsApp.checkInitials(emp));
	}
}