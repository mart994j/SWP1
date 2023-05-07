package domain;


import java.util.ArrayList;
import java.util.Optional;
import app.ActivityNotFound;
import app.NotProjectLeaderException;
import java.util.Calendar;
import java.util.List;


public class Project {
	private String projectName;
	private Employee projectLeader;
	public static ArrayList<Activity> activities = new ArrayList<>();
	public ArrayList<Employee> employees = new ArrayList<>();
	private int projectNumber;
	private Calendar dueDate;
	private Calendar startDate;
	private int id;

	public boolean isProjectLeader;
	

	
	public Project (String projectName, int id) {
		this.projectName = projectName;
		this.id = id;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public void setProjectLeader(Employee employee) {
		isProjectLeader = true;
		this.projectLeader = employee;
	}
	public Employee getProjectLeader() {
		return projectLeader;
	}
	
/*	public int getProjectNum() {
		return projectNumber;
	}*/
	
	public int getProjectId() {
		return id;
	}
	public void setProjectId(int id) {
		this.id = id;
	}
	

	
	/*public Activity getActivityByName(String activityName) throws ActivityNotFound {
		Optional<Activity> r = activities.stream().filter(b -> b.getActivName().equals(activityName)).findFirst();
        if (!r.isPresent()) {
            throw new ActivityNotFound("The activity does not exist");
        }
        return (Activity) r.get();
	}*/
	
	
	/*public Calendar getStartDate() {
		return startDate;
		
	}
	
	public Calendar getDueDate() {
		return dueDate;
		
	}*/

	public List<Employee> getAssignedEmployees(Project project) {
		return employees;
	}
	
	public boolean checkActivityList(String name) {
		for(int i = 0; i < activities.size(); i++) {
			if(name.equals(activities.get(i).getActivName())) {
				return true;
			}
		}
		return false;
	}
	
	 public boolean checkEmployeeList(Employee employee) {
	        return employees.contains(employee);
	    }
	

}
