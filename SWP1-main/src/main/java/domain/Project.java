package domain;

import java.util.ArrayList;
import java.util.Optional;
import app.ActivityNotFound;
import app.NotProjectLeaderException;
import java.util.Calendar;


public class Project {
	private String projectName;
	private Employee projectLeader;
	public ArrayList<Activity> activities = new ArrayList<>();
	private int projectNumber;
	private Calendar dueDate;
	private Calendar startDate;

	
	public Project (String projectName, int projectCount) {
		this.projectName = projectName;
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
		return 123;
	}
	public void addActivity(Activity activity)  {
		activities.add(activity);
		
	}
	
	
	private void projectLeaderCheck(String projectLeaderInit) throws NotProjectLeaderException {
		if (this.projectLeader == null || projectLeaderInit == null
                || !this.projectLeader.getInitials().equals(projectLeaderInit)){
			throw new NotProjectLeaderException("Du er ikke project leader!");
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
}
