package app;

import java.util.ArrayList;
import java.util.List;


public class ProjectsApp {
	private ArrayList<Project> projects = new ArrayList<>();

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

	public void addEmployee(Employee employee)throws OperationNotAllowedException {
		for (Employee e : employees) {
			if(e.getInitials().equals(employee.getInitials())) {
				throw new OperationNotAllowedException("An employee with the same initials is already in the system");
			}
			
		}
		employees.add(employee);
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

}
