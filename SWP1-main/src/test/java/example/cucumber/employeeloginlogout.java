package example.cucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.ProjectApp;
import domain.Employee;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class employeeloginlogout {

	private ProjectAppHolder projectAppHolder;
	private ErrorMessageHolder errorMessageHolder;
	private EmpHolder employeeHolder;
	private ProjectHolder projectHolder;
	private ActivityHolder activityHolder;
	
	private String initials;

	public employeeloginlogout(ActivityHolder activityHolder,ProjectHolder projectHolder,EmpHolder employeeHolder,ProjectAppHolder projectAppHolder,ErrorMessageHolder errorMessageHolder) throws Exception {
		this.activityHolder = activityHolder;
		this.employeeHolder = employeeHolder;
		this.errorMessageHolder = errorMessageHolder;
		this.projectAppHolder = projectAppHolder;
		this.projectHolder = projectHolder;
	}

//user login correct initials
	@Given("that a user exists")
	public void thatAUserExists() throws Exception {
		ProjectApp projectApp = projectAppHolder.getProjectsApp();
		assertFalse(projectApp.isUserLoggedIn());
	}

	@Given("initials are {string}")
	public void initialsIs(String initials) throws Exception {
		Employee employees = employeeHolder.getEmployee();
		employees = new Employee("Wulf", initials);

	}

	@Then("the user login succeeds")
	public void theUserIsLoggedIn() throws Exception {
		ProjectApp projectApp = projectAppHolder.getProjectsApp();
		Employee employees = employeeHolder.getEmployee();
		assertTrue(projectApp.userLogin(employees, initials));

	}

	@And("the user is logged in")
	public void userloggedin() throws Exception {
		ProjectApp projectApp = projectAppHolder.getProjectsApp();
		assertTrue(projectApp.isUserLoggedIn());
	}

	@Then("the user login fails")
	public void theUserLoginFails() throws Exception {
		ProjectApp projectApp = projectAppHolder.getProjectsApp();
		Employee employees = employeeHolder.getEmployee();

		assertFalse(projectApp.userLogin(employees, initials));
	}

	@Then("the user is not logged in")
	public void theUserIsNotLoggedIn() throws Exception {
		ProjectApp projectApp = projectAppHolder.getProjectsApp();
		assertFalse(projectApp.isUserLoggedIn());
	}

}

