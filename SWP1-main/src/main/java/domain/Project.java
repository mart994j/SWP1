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
	public ArrayList<Activity> activities = new ArrayList<>();
	public ArrayList<Employee> employees = new ArrayList<>();
	private int projectNumber;
	private Calendar dueDate;
	private Calendar startDate;
	private int id; 
	

	
	public Project (String projectName, int id) {
		this.projectName = projectName;
		this.id = id;
	}
	
	public void addActivityToProject(Activity activity) {
		activities.add(activity);
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public void setProjectLeader(Employee employee) {
		this.projectLeader = employee;
	}
	public Employee getProjectLeader() {
		return projectLeader;
	}
	
	public int getProjectNum() {
		return projectNumber;
	}
	public int getProjectId() {
		return id;
	}
	public void setProjectId(int id) {
		this.id = id;
	}
	
	public void addActivity(Activity activity)  {
		activities.add(activity);
		
	}
	
	
	public void projectLeaderCheck(String projectLeaderInit) throws NotProjectLeaderException {
		if (this.projectLeader == null || projectLeaderInit == null
                || !this.projectLeader.getInitials().equals(projectLeaderInit)){
			throw new NotProjectLeaderException("You are not the Project Leader");
		}
	}
	
	public Activity getActivityByName(String activityName) throws ActivityNotFound {
		Optional<Activity> r = activities.stream().filter(b -> b.getActivName().equals(activityName)).findFirst();
        if (!r.isPresent()) {
            throw new ActivityNotFound("The activity does not exist");
        }
        return (Activity) r.get();
	}
	
	
	public Calendar getStartDate() {
		return startDate;
		
	}
	
	public Calendar getDueDate() {
		return dueDate;
		
	}

	public List<Employee> getAssignedEmployees(Project project) {
		return employees;
	}
}
