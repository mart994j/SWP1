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

    public Activity(String name, Employee projectLeader, ArrayList<Employee> employees, int startWeek, int endWeek, int timeBudget){
        this.name = name;
        this.projectLeader = projectLeader;
        this.employees = employees;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.timeBudget = timeBudget;
    }

    public String getName(){return name;}
    public Employee getProjectLeader(){return projectLeader;}
    public ArrayList<Employee> getEmployees(){return employees;}
    public int getStartWeek(){return startWeek;}
    public int getEndWeek(){return endWeek;}
    public int getTimeBudget(){return timeBudget;}
    public int getTimePeriod(){return endWeek - startWeek;}
}