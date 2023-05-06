package domain;

import java.util.ArrayList;

public class Employee {
	private String name;
	private String initials;
	public ArrayList<Activity> empActvities = new ArrayList<Activity>();


	public Employee(String name, String initials) {
		this.name = name;
		this.initials = initials;
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
		this.initials = initials;
	}
	
}
