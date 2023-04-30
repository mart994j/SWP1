package example.cucumber;

import domain.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import app.projectApp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmployeeSteps {
    private projectApp projectApp;
    private Employee employee;
    public EmployeeSteps(projectApp projectApp) {
		this.projectApp = projectApp;
	}

    @Given("that the employees initials are 4 or less")
    public void that_the_employees_initials_are_or_less() {
        employee = new Employee("Chris Grant", 24,"CHGR");
       assertTrue(projectApp.checkInitials(employee));
       
    }
    @Given("they are under the age of {int}")
    public void they_are_under_the_age_of(Integer int1) {
        assertTrue(projectApp.checkAge(employee));
      
    }
    @Then("the employee has been added")
    public void add_the_employee_has_been_added() {

        assertTrue(projectApp.addEmployee(employee));
      
    }

    @Given("that employee has more than {string} initials")
    public void that_employee_has_more_than_initials(String string) {
        employee = new Employee("Karen Finnerman", 59,"KAFI");
        assertFalse(projectApp.checkInitials(employee ));
       
    }
    @Then("the error message {string} is given")
    public void the_error_message_is_given(String string1) {

        assertFalse(projectApp.checkInitials(employee));
 
    }
    @Given("that employee is older than {int} years old")
    public void that_employee_is_older_than_ears_old(Integer int1) {
        employee = new Employee("Peter Henrikson Dalton", 35,"PEHEDA");
      
    }
    @Then("the error message {string} is shown")
    public void the_error_message_is_shown(String string1) {
        // Write code here that turns the phrase above into concrete actions
        
    }
}
