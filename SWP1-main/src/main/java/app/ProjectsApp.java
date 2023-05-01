package app;

import java.util.ArrayList;
import java.util.List;

import domain.Activity;
import domain.Employee;
import domain.Project;
import java.util.Observable;


public class ProjectsApp extends Observable {
	Project project;
	DateServer dateServer = new DateServer();
	private boolean adminLoggedIn = false;
	public ArrayList<Project> projects = new ArrayList<>();

	private ArrayList<Employee> employees = new ArrayList<>();

	public int projectCount = 0;

	////// Project things //////
	public Project createProject(String name) {
		Project project = new Project(name, projectCount);
		projects.add(project);
		projectCount++;
		return project;

	}

	public List<Project> getProjects() {
		return projects;
	}


	public Project getProjectWithName(String projectName) {
		for (Project e: projects) {
			if(e.getProjectName().equals(projectName));

			return e;
		}
		return null;
	}
	////// Employee things //////
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
	////// User things //////
	private boolean userloggedin = false;
	public boolean isUserLoggedIn() {
		return userloggedin;
	}
	public boolean userLogin(String initials) {
		// TODO Auto-generated method stub
		for (Employee employee:employees) {
			userloggedin = initials.equals(employee.getInitials());
		}
		return userloggedin;
	}

	public void setDateServer(DateServer dateServer) {
		this.dateServer = dateServer;
		
	}
	////// Activity things //////
	public Activity getActivityWithName(String activityName, String projectName) {
		for (Activity a: getProjectWithName(projectName).activities) {
			if(a.getActivName().equals(activityName));
			
			return a;
		}
		return null;
	}

	////// Admin things //////
	public boolean adminLoggedIn() {
		// returns true if admin is logged in, false if admin isn't logged in
		return adminLoggedIn;
	}

	public boolean adminLogin(String password) {
		adminLoggedIn = password.equals("adminadmin");
		setChanged();
		notifyObservers();
		return adminLoggedIn;
	}

	public void adminLogout() {
		adminLoggedIn = false;
		setChanged();
		notifyObservers();
	}

	private void checkAdminLoggedIn() throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Admin login required");
		}
	}

}
