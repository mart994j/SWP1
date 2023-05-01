package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import app.ProjectApp;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class projectSteps {
	private ProjectHolder projectHolder;
	private ErrorMessageHolder errorMessageHolder;
	private ProjectAppHolder projectAppHolder;

	public projectSteps(ProjectAppHolder projectAppHolder, ErrorMessageHolder errorMessageHolder,
							  ProjectHolder projectHolder) {
		this.errorMessageHolder = errorMessageHolder;
		this.projectHolder = projectHolder;
		this.projectAppHolder = projectAppHolder;
	}

	@Given("that the company get a project with the name {string}.")
	public void thatTheCompanyGetAProjectWithTheName(String name) throws Exception {
		ProjectApp projectApp = projectAppHolder.getProjectsApp();
		Project project = new Project(name, projectApp.projectCount);
		projectHolder.setProject(project);

	}

	@When("an employee creates the project.")
	public void anEmployeeCreatesTheProject() {
		ProjectApp projectApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		projectApp.createProject(project.getProjectName());
	}

	@Then("a project with the name {string} is created successfully.")
	public void aProjectWithTheNameIsCreatedSuccessfully(String name) {
		ProjectApp projectApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		assertEquals(name, project.getProjectName());
		assertTrue(projectApp.getProjects().contains(project));
	}

	@Then("the project gets given a project id.")
	public void theProjectGetsGivenAProjectId() {
		Project project = projectHolder.getProject();
		assertNotNull(project.getProjectId());
	}
}
