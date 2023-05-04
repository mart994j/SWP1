package example.cucumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import app.OperationNotAllowedException;
import app.ProjectsApp;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class deleteSteps {

    private ProjectsApp projectApp;
    private int id;
	private String initials;

    public deleteSteps(ProjectsApp projectApp) {
        this.projectApp=projectApp;

    }

    @Given("a project with the id {int} exists.")
    public void aProjectWithTheIdExists(int id) throws Exception{
        projectApp.createProject("KBH", 1);
        assertTrue(projectApp.projectExists(id));
        this.id = id;
    }


    @Given("the admin deletes the project")
    public void theAdminDeletesTheProject() throws Exception {
        assertFalse(projectApp.deleteProject(id));
    }

    @Then("the project has been deleted")
    public void theProjectHasBeenDeleted()throws Exception {
        assertFalse(projectApp.projectExists(id));
    }
    
    
    @Given("an employee with the initials {string} exists.")
    public void anEmployeeWithTheInitialsExists(String initials) throws Exception {
        projectApp.addEmployee(new Employee("Wulf", "SWA"));
       assertTrue(projectApp.empExists(initials));
       this.initials=initials;
    }

    @Given("the admin deletes the employee")
    public void theAdminDeletesTheEmployee() throws Exception {
    assertFalse(projectApp.deleteEmp(initials));
    }

    @Then("the employee has been deleted")
    public void theEmployeeHasBeenDeleted() throws Exception {
        assertFalse(projectApp.empExists(initials));
    }

}