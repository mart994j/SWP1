package example.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import app.OperationNotAllowedException;
import app.ProjectsApp;
import domain.Employee;

public class createEmpSteps {
	
	
	private ProjectAppHolder projectAppHolder;
	private EmpHolder employeeHolder;
	private ErrorMessageHolder errorMessageHolder;
	
	public createEmpSteps(ProjectAppHolder projectAppHolder,EmpHolder employeeHolder) {
		this.employeeHolder = employeeHolder;
		this.projectAppHolder = projectAppHolder;
	}

	@Given("employee with initials {string} exists")
	public void employeeWithInitialsExists(String initials) throws OperationNotAllowedException {
		Employee employee = new Employee("Martin Jespersen", "MJ");
		employeeHolder.setEmployee(employee);
		projectAppHolder.getProjectsApp().addEmployee(employee);
	}

	@Given("the employee has the name {string}")
	public void theEmployeeHasTheName(String name) {
		Employee employee = employeeHolder.getEmployee();
		if (employee == null) {
			employee = new Employee(name, "");
			employeeHolder.setEmployee(employee);
		} else {
			employee.setName(name);
		}
	}

	@When("I check for the employee is created")
	public void iCheckForTheEmployeeIsCreated() {
        assertNotNull(employeeHolder.getEmployee());
	}

	@Then("I get the name {string} and the initials {string}")
	public void iGetTheNameAndTheInitials(String name, String initials) {
		Employee employee = employeeHolder.getEmployee();
		assertEquals("Name is incorrect", name, employee.getName());
		assertEquals("Initials are incorrect", initials, employee.getInitials());
	}

	@Then("the initials {string} is in the initials list")
	public void theInitialsIsInTheInitialsList(String initials) {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		assertTrue("Initials not found in the list", projectsApp.getInitialsList().contains(initials));
	}

	@Then("the employeelist conatins the employee")
	public void theEmployeelistConatinsTheEmployee() {
		Employee employee = employeeHolder.getEmployee();
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		assertTrue("Employee not found in the list", projectsApp.getEmployees().contains(employee));
	}
	
	
	
	
	

@Given("an employee with the initials {string} exists")
public void anEmployeeWithTheInitialsExists(String initials) {
	Employee employee = employeeHolder.getEmployee();
	ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
	employee = new Employee(null, initials);
	employee.setInitials(initials);
	assertTrue(employee.getInitials() == initials);

}

@When("the actor tries to add a new employee with the initials {string}")
public void theActorTriesToAddANewEmployeeWithTheInitials(String initials) {
	try {
        Employee employee = new Employee(null, initials);
        projectAppHolder.getProjectsApp().addEmployee(employee);
    } catch (OperationNotAllowedException ex) {
        errorMessageHolder.setErrorMessage(ex.getMessage());
    }
}

@Then("the error message {string}")
public void theErrorMessage(String errorMessage) {
	ErrorMessageHolder errorMessageHolder = new ErrorMessageHolder();
	errorMessageHolder.setErrorMessage(errorMessage);
	
    assertEquals("Error message is incorrect", errorMessage, errorMessageHolder.getErrorMessage());

}
	
	
	

}
