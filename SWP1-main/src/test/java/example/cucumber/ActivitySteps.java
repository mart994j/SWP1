package example.cucumber;

import app.OperationNotAllowedException;
import app.ProjectsApp;
import domain.Activity;
import domain.Employee;
import domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;

import static org.junit.Assert.*;

public class ActivitySteps {
    private ProjectAppHolder projectAppHolder;
    private ErrorMessageHolder errorMessageHolder;
    private EmpHolder employeeHolder;
    private ProjectHolder projectHolder;
    private ActivityHolder activityHolder;






    public ActivitySteps(ActivityHolder activityHolder,ProjectAppHolder projectAppHolder,ErrorMessageHolder errorMessageHolder,EmpHolder employeeHolder,ProjectHolder projectHolder) {
      this.activityHolder = activityHolder;
      this.projectAppHolder = projectAppHolder;
      this.employeeHolder = employeeHolder;
      this.projectHolder = projectHolder;
      this.errorMessageHolder = errorMessageHolder;
    }


    @Given("that a project exist and has an activity")
    public void thatAProjectExistAndHasAnActivity() {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        Activity activity = activityHolder.getActivity();




        projectHolder.setProject(projectsApp.createProject("Project1"));
        activityHolder.setActivity(new Activity("Activity1",null,null,0));
        projectsApp.getProjectWithName("Project1").addActivity(new Activity("Activity1",null,null,0));
        assertTrue(projectsApp.projects.size()>0 && projectsApp.getProjectWithName("Project1").activities.size()>0);
        assertEquals(projectsApp.getActivityWithName("Activity1","Project1").getActivName(),"Activity1");
    }
    @Given("that the project leader is logged in.")
    public void that_the_project_leader_is_logged_in () throws OperationNotAllowedException {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        Employee employee = employeeHolder.getEmployee();



        employeeHolder.setEmployee(new Employee("Martin","MJ"));
        projectsApp.addEmployee(employee);
        projectsApp.adminLogin("adminadmin");
        assertTrue(projectsApp.adminLoggedIn());
    }

    @Then("add employee with the name {string}, initial {string} to the exisiting activity.")
    public void addEmployeeWithTheNameInitalAndExisitingActivity(String string, String string2) {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        Project project = projectHolder.getProject();
        Employee employee = employeeHolder.getEmployee();
        employeeHolder.setEmployee(new Employee(string,string2));
        Activity activity = activityHolder.getActivity();
        project.setProjectName("Project1");
        activity.setActivName("Activity1");
        projectsApp.getActivityWithName("Activity1","Project1").assignEmp(employee);
    }




    @Then("try to add employee with the name {string}, initial {string} to the exisiting activity.")
    public void tryToAddEmployeeWithTheNameInitialToTheExisitingActivity(String string, String string2) {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        Project project = projectHolder.getProject();
        Employee employee = employeeHolder.getEmployee();
        employeeHolder.setEmployee(new Employee(string,string2));
        for (int i = 0; i<20; i++) {
            String name = ""+i;
           project.addActivity(new Activity(name,null,null,0));
        }
        for (int i = 0; i < 20; i++) {
            projectsApp.getProjectWithName(project.getProjectName()).activities.get(i).assignEmp(employee);
        }

    }

    @Then("employee has more than max activities")
    public void employeeHasMoreThanActivities() {
        ProjectsApp projectsApp = projectAppHolder.getProjectsApp();
        Project project = projectHolder.getProject();
        Activity activity = activityHolder.getActivity();
        Employee employee = employeeHolder.getEmployee();
        assertFalse(projectsApp.checkMaxActivites(employee));

    }

    @Then("the error message {string} appears.")
    public void theErrorMessageAppears(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
