package domain;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Project {
    private String projectName;
    private Employee projectLeader;
    private int id;
    private ArrayList<Activity> activities = new ArrayList<>();



    public Project(String projectName, int id){
        this.projectName = projectName;
        

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProjectLeader(Employee employee) {
        this.projectLeader = employee;
    }
    public Employee getProjectLeader(){
        return projectLeader;
    }

  
    public void addActivityToProject(Activity activity){
       activities.add(activity);
    }
    public List<Activity> getActivities() {
        return activities;
    }

}
