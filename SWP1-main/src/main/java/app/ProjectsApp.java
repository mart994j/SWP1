package app;

import java.util.ArrayList;
import java.util.List;

import domain.Activity;
import domain.Employee;
import domain.Project;

public class ProjectsApp {
	DateServer dateServer = new DateServer();
	public ArrayList<Project> projects = new ArrayList<>();

	private ArrayList<Employee> employees = new ArrayList<>();

	public int projectCount = 0;

	public Project createProject(String name) {
		Project newProject = new Project(name, projectCount);
		projects.add(newProject);
		projectCount++;
		return newProject;

	}

	public List<Project> getProjects() {
		return projects;
	}

	public boolean addEmployee(Employee employee) throws OperationNotAllowedException {
		for (Employee e : employees) {
			if (e.getInitials().equals(employee.getInitials())) {
				throw new OperationNotAllowedException("An employee with the same initials is already in the system");
			}
			

		}
		employees.add(employee);
		return true;
	}

	public List<String> getInitialsList() {
		List<String> employeeInit = new ArrayList<>();
		for (Employee e : employees) {
			employeeInit.add(e.getInitials());
		}
		return employeeInit;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

//Tjekker om om initals opfylder max 4 initialer
	public boolean checkInitials(Employee employee) {
		if (employee.getInitials().length() > 5) {
			return false;

		}
		return true;
	}

	private boolean userloggedin = false;

	public boolean isUserLoggedIn() {
		return userloggedin;
	}

	public boolean userLogin(Employee employee, String initials) {
		// TODO Auto-generated method stub
		userloggedin = initials.equals(employee.getInitials());
		return userloggedin;
	}

	public void userLogout() {
		// TODO Auto-generated method stub
		userloggedin = false;
	}
	public Project getProjectWithName(String projectName) {
		for (Project e: projects) {
			if(e.getProjectName().equals(projectName));
			
			return e;
		}
		return null;
	}

	public void setDateServer(DateServer dateServer) {
		this.dateServer = dateServer;
		
	}

	public Activity getActivityWithName(String activityName, String projectName) {
		for (Activity a: getProjectWithName(projectName).activities) {
			if(a.getActivName().equals(activityName));
			
			return a;
		}
		return null;
	}
	
}
