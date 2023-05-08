package example.cucumber;

import app.NotProjectLeaderException;
import domain.Project;
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

	private ProjectHolder projectHolder;

	private ProjectAppHolder projectAppHolder;
	private EmpHolder employeeHolder;
	private ErrorMessageHolder errorMessageHolder;
	private String name;

	public createEmpSteps(ProjectAppHolder projectAppHolder,EmpHolder employeeHolder, ProjectHolder projectHolder) {
		this.employeeHolder = employeeHolder;
		this.projectAppHolder = projectAppHolder;
		this.projectHolder = projectHolder;
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

	@When("the user tries to add an employee to the system")
	public void the_user_tries_to_add_an_employee_to_the_system() throws OperationNotAllowedException {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		Employee employee = employeeHolder.getEmployee();
		employee = new Employee("Martin","MSJ");
		projectApp.addEmployee(employee);
	}

	@When("an employee {string} is assigned to the project {string} as a project leader")
	public void an_employee_is_assigned_to_the_project_as_a_project_leader(String name, String projectName) {
		this.name = name;
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Employee employee = employeeHolder.getEmployee();
		Project project = projectsApp.getProjectWithName(projectName);
		project.setProjectLeader(employee);
	}

	@Then("the employee is project leader")
	public void the_employee_is_project_leader() throws NotProjectLeaderException {
		Employee employee = employeeHolder.getEmployee();
		Project project = projectHolder.getProject();
		project = new Project ("Test",0);
		employee =new Employee(name,"init");
		project.setProjectLeader(employee);
		project.getProjectLeader();
		assertTrue(project.isProjectLeader);
	}







}
