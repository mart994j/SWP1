package example.cucumber;

import domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class projectSteps {

private String projectName;
private Project project;


@Given("that the company get a project with the name {string}.")
public void thatTheCompanyGetAProjectWithTheName(String projectName) {
	this.projectName = projectName;

}

@When("an employee creates the project.")
public void anEmployeeCreatesTheProject() {
	int id = generateID();
	project = new Project(projectName,id);

}



@Then("a project with the name {string} is created successfully.")
public void aProjectWithTheNameIsCreatedSuccessfully(String projectName) {
	assert projectName.equals(project.getProjectName());
}

@Then("the project gets given a project id.")
public void theProjectGetsGivenAProjectId() {
	assert project.getId() > 0;
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
