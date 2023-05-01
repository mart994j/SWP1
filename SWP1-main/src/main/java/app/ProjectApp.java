package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import domain.Activity;
import domain.Employee;
import domain.Project;

public class ProjectApp extends Observable {
	DateServer dateServer = new DateServer();
	public ArrayList<Project> projects = new ArrayList<>();
	private ArrayList<Employee> employees = new ArrayList<>();

	private boolean adminLoggedIn = false;
	public int projectCount = 0;
	private boolean userloggedin = false;


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

	////// User things /////
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


	////// Project things /////
	public Project createProject(String name) {
		Project newProject = new Project(name, projectCount);
		projects.add(newProject);
		projectCount++;
		return newProject;
	}

	public List<Project> getProjects() {
		return projects;
	}

	// Checks if the initials contain max 4 initials
	public boolean checkInitials(Employee employee) {
		if (employee.getInitials().length() > 5) {
			return false;

		}
		return true;
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

	////// Activity things /////
	public Activity getActivityWithName(String activityName, String projectName) {
		for (Activity a: getProjectWithName(projectName).activities) {
			if(a.getActivityName().equals(activityName));
			
			return a;
		}
		return null;
	}
	
}
