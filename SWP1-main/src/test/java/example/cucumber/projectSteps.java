package example.cucumber;

import app.ProjectsApp;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class projectSteps {

private String nameOfProject;
private ProjectAppHolder projectAppHolder;
private ErrorMessageHolder errorMessageHolder;
private EmpHolder employeeHolder;
private ProjectHolder projectHolder;
private ActivityHolder activityHolder;
	public projectSteps(ActivityHolder activityHolder,ProjectHolder projectHolder,EmpHolder employeeHolder,ProjectAppHolder projectAppHolder,ErrorMessageHolder errorMessageHolder) {
		this.activityHolder = activityHolder;
		this.employeeHolder = employeeHolder;
		this.errorMessageHolder = errorMessageHolder;
		this.projectAppHolder = projectAppHolder;
		this.projectHolder = projectHolder;
	}

@Given("that the company get a project with the name {string}.")
public void thatTheCompanyGetAProjectWithTheName(String projectName) {
	nameOfProject = projectName;
}

@When("an employee creates the project.")
public void anEmployeeCreatesTheProject() {
	ProjectsApp projectApp = projectAppHolder.getProjectsApp();
	Employee employee = employeeHolder.getEmployee();
	Project project = projectHolder.getProject();
	project = new Project(nameOfProject,projectApp.projectCount );

}



@Then("a project with the name {string} is created successfully.")
public void aProjectWithTheNameIsCreatedSuccessfully(String projectName) {
	ProjectsApp projectApp = projectAppHolder.getProjectsApp();

	assert nameOfProject.equals(projectApp.getProjectWithName(projectName));
}

@Then("the project gets given a project id.")
public void theProjectGetsGivenAProjectId() {
	Project project = projectHolder.getProject();
	assert project.getProjectId() > 0;
}
public int generateID() {
	return 110232;
}

@And("the project gets given a project startdate and enddate")
	public void theProjectGetsGivenAProjectStartdateAndEnddate() {

	}

@Then("the project {string} is created successfully.")
	public void theProjectIsCreatedSuccessfully(String arg0) {
	}
}
