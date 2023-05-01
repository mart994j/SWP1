package app;

public class Employee {
	private String name;
	private String initials;
	
	
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
	
}
