package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import app.ProjectsApp;
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
	public void that_the_company_get_a_project_with_the_name(String name) throws Exception {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		project = new Project(name, projectsApp.projectCount);
        projectHolder.setProject(project);

	}
	@When("an employee creates the project.")
	public void an_employee_creates_the_project() {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		projectsApp.createProject(project.getProjectName());


	}
	@Then("a project with the name {string} is created successfully.")
	public void a_project_with_the_name_is_created_successfully(String name) {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		assertEquals(name, project.getProjectName());
		if(projectsApp.getProjects().contains(project)){
			assertTrue(true);
		}

	}
	@Then("the project gets given a project id.")
	public void the_project_gets_given_a_project_id() {
		Project project = projectHolder.getProject();
		assertNotNull(project.getProjectId());
	}
}
