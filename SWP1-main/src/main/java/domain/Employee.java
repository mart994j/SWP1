package domain;

import app.ProjectsApp;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private String initials;
ProjectsApp projectsApp;
	public List<Activity> empActvities = new ArrayList<Activity>();


	public Employee(String name, String initials) {
		this.name = name;
		this.initials = initials;
	}

	public void employeeActivies(){
		for (Activity a: projectsApp.activity
			 ) {
			if(initials.equals(a.employee.initials)){
				empActvities.add(a);
			}
		}


	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials=initials;
	}
}
