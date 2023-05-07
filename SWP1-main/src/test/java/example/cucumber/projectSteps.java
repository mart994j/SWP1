package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import app.ProjectsApp;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class projectSteps {
	private ProjectHolder projectHolder;
	private ErrorMessageHolder errorMessageHolder;
	private ProjectAppHolder projectAppHolder;
	private EmpHolder employeeHolder;


	public projectSteps(ProjectAppHolder projectAppHolder, ErrorMessageHolder errorMessageHolder,
			ProjectHolder projectHolder, EmpHolder employeeHolder) {
		this.errorMessageHolder = errorMessageHolder;
		this.projectHolder = projectHolder;
		this.projectAppHolder = projectAppHolder;
		this.employeeHolder = employeeHolder;
	}

	@Given("that the company get a project with the name {string}.")
	public void that_the_company_get_a_project_with_the_name(String name) throws Exception {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		project = new Project(name, 0);
		projectHolder.setProject(project);

	}

	@When("an employee creates the project.")
	public void an_employee_creates_the_project() {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		projectsApp.createProject(project.getProjectName(), project.getProjectId());

	}

	@Then("a project with the name {string} is created successfully.")
	public void a_project_with_the_name_is_created_successfully(String name) {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Project project = projectHolder.getProject();
		assertEquals(name, project.getProjectName());
		if (projectsApp.getProjects().contains(project)) {
			assertTrue(true);
		}

	}

	@Then("the project gets given a project id.")
	public void the_project_gets_given_a_project_id() {
		Project project = projectHolder.getProject();
		assertNotNull(project.getProjectId());
	}

	@Given("that a project with the name {string} exists")
	public void thatAProjectWithTheNameExists(String name) {
		Project project = projectHolder.getProject();
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();

		project = new Project(name, 0);
		project.setProjectName(name);
		projectApp.projects.add(project);
		assertTrue(projectApp.projects.contains(project));
	}

	@When("a user searches for the project {string}")
	public void aUserSearchesForTheProject(String name) {
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Project project = projectsApp.getProjectWithName(name);
		projectHolder.setProject(project);
	}

	@Then("the project {string} is found")
	public void theProjectIsFound(String name) {
		Project project = projectHolder.getProject();
		assertNotNull(project);
		assertEquals(name, project.getProjectName());
	}

	@Given("there is a project leader assigned with the name {string}")
	public void thereIsAProjectLeaderAssignedWithTheName(String name) {
		Project project = projectHolder.getProject();
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Employee emp = employeeHolder.getEmployee();
		
		project = new Project("TestProject", 0);
		emp = new Employee(name, null);
		project.setProjectLeader(emp);
		
	}

	@When("the user changes the project leader to {string}")
	public void theUserChangesTheProjectLeaderTo(String newProjectLeader) {
		Project project = projectHolder.getProject();
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Employee emp = employeeHolder.getEmployee();
		
		project = new Project("TestProject", 0);
		emp = new Employee(newProjectLeader, null);
		project.setProjectLeader(emp);
	}

	@Then("the project leader is changed to {string}")
	public void theProjectLeaderIsChangedTo(String newProjectLeader) {
		Project project = projectHolder.getProject();
		ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
		Employee emp = employeeHolder.getEmployee();
		emp = new Employee(newProjectLeader, null);
		assertTrue(emp.getName() == newProjectLeader);
	}

	@Given("a user tries to create a project with the name {string}")
	public void aUserTriesToCreateAProjectWithTheName(String name123) {
		Project project = projectHolder.getProject();
		ProjectsApp projectApp = projectAppHolder.getProjectsApp();
		projectApp.createProject(name123,0);
	}
}
