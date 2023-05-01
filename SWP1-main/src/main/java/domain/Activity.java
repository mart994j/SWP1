package domain;
import domain.Employee;

import java.util.ArrayList;

public class Activity {
    private String name;
    private Employee projectLeader;
    private ArrayList<Employee> employees;
    private int startWeek;
    private int endWeek;
    private int timeBudget;

    // You initialize an activity only by its name. Everything else will be set or added afterwards.
    public Activity(String name){
        this.name = name;
    }

    public void setProjectLeader(Employee projectLeader){
        this.projectLeader = projectLeader;
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public void setStartWeek(int sw){
        startWeek = sw;
    }
    public void setEndWeek(int ew){
        endWeek = ew;
    }
    public void setTimeBudget(int tb){
        timeBudget = tb;
    }
    public void setActivityName(String activityName) { name = activityName; }

    public String getActivityName(){return name;}
    public Employee getProjectLeader(){return projectLeader;}
    public ArrayList<Employee> getEmployees(){return employees;}
    public int getStartWeek(){return startWeek;}
    public int getEndWeek(){return endWeek;}
    public int getTimeBudget(){return timeBudget;}
    public int getTimePeriod(){return endWeek - startWeek;}
    public void assignEmp(Employee employee) { employees.add(employee); }
}