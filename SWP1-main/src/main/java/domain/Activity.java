package domain;
import domain.Employee;

import java.util.ArrayList;

public class Activity {
    private String name;

    private ArrayList<Employee> employeesOnActivity = new ArrayList<Employee>();
    private int startWeek;
    private int endWeek;
    private int timeBudget;

    public Activity(String name, int startWeek, int endWeek, int timeBudget){
        this.name = name;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.timeBudget = timeBudget;
    }

    public String getName(){return name;}
    public ArrayList<Employee> getEmployeesOnActivity(){return employeesOnActivity;}

    public void addEmployeeToActivity(Employee employee){
        employeesOnActivity.add(employee);
    }
    public int getStartWeek(){return startWeek;}
    public int getEndWeek(){return endWeek;}
    public int getTimeBudget(){return timeBudget;}
    public int getTimePeriod(){return endWeek - startWeek;}
}