package app;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Activity {
	private String activName;
    private ArrayList<Employee> employees;
    private int startWeek;
    private int endWeek;
    private int timeBudget;

    
    public Activity(String activName) {
    	this.activName = activName;

    }
    
    public String getActivName() {
    	return activName;
    }
    public List<Employee> getAssignedEmployees() {
		return employees;

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
    public void setActivName(String activName) {
    	this.activName = activName;
    }
    
    public void assignEmp(Employee employee) {
    	employees.add(employee);
    }
    public int getStartWeek(){return startWeek;}
    public int getEndWeek(){return endWeek;}
    public int getTimeBudget(){return timeBudget;}
    public int getTimePeriod(){return endWeek - startWeek;}
    
    
    
    
	

}
