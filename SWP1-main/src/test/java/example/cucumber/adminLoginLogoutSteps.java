package example.cucumber;

import app.ProjectsApp;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class adminLoginLogoutSteps {
    private ProjectHolder projectHolder;
    private EmpHolder employeeHolder;
    private ErrorMessageHolder errorMessageHolder;
    private ProjectAppHolder projectAppHolder;
    private String password;

    public adminLoginLogoutSteps(ProjectAppHolder projectAppHolder,EmpHolder employeeHolder) {
        this.employeeHolder = employeeHolder;
        this.projectAppHolder = projectAppHolder;
    }

    @Given("that the admin is logged in")
    public void thatTheAdminIsLoggedIn() throws Exception {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        assertTrue(projectsApp.adminLogin("adminadmin"));
    }

    @Given("that the admin is not logged in")
    public void thatTheAdminIsNotLoggedIn() throws Exception {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        assertFalse(projectsApp.adminLoggedIn());
    }

    @Given("the password is {string}")
    public void thePasswordIs(String password) throws Exception {
        this.password = password;
    }

    @When("the admin logs out")
    public void theAdminLogsOut() throws Exception {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        projectsApp.adminLogout();
    }

    @Then("the admin login succeeds")
    public void theAdminLoginSucceeds() throws Exception {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        assertTrue(projectsApp.adminLogin(password));
    }

    @Then("the admin login fails")
    public void theAdminLoginFails() throws Exception {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        assertFalse(projectsApp.adminLogin(password));
    }

    @Then("the admin is logged in")
    public void theAdminIsLoggedIn() {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        assertTrue(projectsApp.adminLoggedIn());
    }

    @Then("the admin is not logged in")
    public void theAdminIsNotLoggedIn() throws Exception {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        assertFalse(projectsApp.adminLoggedIn());
    }


}