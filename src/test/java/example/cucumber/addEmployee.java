package example.cucumber;

import domain.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.ArrayList;

import app.OperationNotAllowedException;
import app.projectApp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class addEmployee {
    private projectApp projectApp;
    private Employee employee;
    private ErrorMessageHolder errorMessage;
    public addEmployee(projectApp projectApp, ErrorMessageHolder errorMessage) {
        this.projectApp = projectApp;
        this.errorMessage = errorMessage;
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
        try {
            assertTrue(projectApp.addEmployee(employee));
        } catch (OperationNotAllowedException e) {
            e.printStackTrace();
        }

    }

    @Given("that employee has more than 4 initials")
    public void that_employee_has_more_than_initials() throws Exception {
        employee = new Employee("Peter Henrikson Dalton", 35,"PEHEDA");
        try {
            projectApp.addEmployee(employee);
        } catch (OperationNotAllowedException e ) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }
    @Then("the error message {string} is given")
    public void the_error_message_is_given(String errorMessage) {
        assertEquals(errorMessage, this.errorMessage.getErrorMessage());

    }
    @Given("that employee is older than {int} years old")
    public void that_employee_is_older_than_ears_old(Integer int1) {
        employee = new Employee("Karen Finnerman", 72,"KAFI");
        try {
            projectApp.addEmployee(employee);
        } catch (OperationNotAllowedException e ) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }
    @Then("the error message {string} is shown")
    public void the_error_message_is_shown(String errorMessage) {

        assertEquals(errorMessage, this.errorMessage.getErrorMessage());
    }
}