package example.cucumber;

import domain.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import app.OperationNotAllowedException;
import app.ProjectsApp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmployeeSteps {
	private ProjectAppHolder projectAppHolder;
	private ErrorMessageHolder errorMessageHolder;
	private EmpHolder employeeHolder;
	private ProjectHolder projectHolder;
	private ActivityHolder activityHolder;
	
    public EmployeeSteps(ActivityHolder activityHolder,ProjectHolder projectHolder,EmpHolder employeeHolder,ProjectAppHolder projectAppHolder,ErrorMessageHolder errorMessageHolder) {
    	this.activityHolder = activityHolder;
    	this.employeeHolder = employeeHolder;
    	this.errorMessageHolder = errorMessageHolder;
    	this.projectAppHolder = projectAppHolder;
    	this.projectHolder = projectHolder;
    }

    @Given("that the employees initials are 4 or less")
    public void that_the_employees_initials_are_or_less() {
		Employee employee = employeeHolder.getEmployee();
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
        employee = new Employee("Chris Grant", "CHGR");
       assertTrue(projectApp.checkInitials(employee));
       
    }

    @Then("the employee has been added")
    public void add_the_employee_has_been_added() throws OperationNotAllowedException {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		Employee employee = employeeHolder.getEmployee();
        assertTrue(projectApp.addEmployee(employee));
      
    }

    @Given("that employee has more than {string} initials")
    public void that_employee_has_more_than_initials(String string) {
		Employee employee = employeeHolder.getEmployee();
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
        employee = new Employee("Karen Finnerman", "KAFI");
        assertFalse(projectApp.checkInitials(employee ));
       
    }
    @Then("the error message {string} is given")
    public void the_error_message_is_given(String string1) {
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		Employee employee = employeeHolder.getEmployee();

        assertFalse(projectApp.checkInitials(employee));
 
    }
    @Given("that employee is older than {int} years old")
    public void that_employee_is_older_than_ears_old(Integer int1) {
		Employee employee = employeeHolder.getEmployee();

        employee = new Employee("Peter Henrikson Dalton", "PEHEDA");
      
    }
    @Then("the error message {string} is shown")
    public void the_error_message_is_shown(String string1) {
        // Write code here that turns the phrase above into concrete actions
        
    }
}
