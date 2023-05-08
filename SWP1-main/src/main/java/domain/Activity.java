package domain;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import app.OperationNotAllowedException;
import app.ProjectsApp;

public class Activity {
    private String activName;
    private GregorianCalendar startW;
    private GregorianCalendar endW;
    private double expectedAmountOfHours;
    private int hoursSpent;
    public List<Employee> employees = new ArrayList<>();

    public Activity(String activName, GregorianCalendar startW, GregorianCalendar endW, double expectedAmountOfHours) {
        this.activName = activName;
        this.startW = startW;
        this.endW = endW;
        this.expectedAmountOfHours = expectedAmountOfHours;
    }

    public String getActivName() {
        return activName;
    }

   public int getHoursSpent() {
        return this.hoursSpent;
    }

    public double getExpectedAmountOfHours() {
        return expectedAmountOfHours;
    }

    public double getTimePerWeek() {
        if (endW.get(GregorianCalendar.WEEK_OF_YEAR) < startW.get(GregorianCalendar.WEEK_OF_YEAR)) {
            return expectedAmountOfHours
                    / (endW.get(GregorianCalendar.WEEK_OF_YEAR) + 52 - startW.get(GregorianCalendar.WEEK_OF_YEAR) + 1);
        } else {
            return expectedAmountOfHours
                    / (endW.get(GregorianCalendar.WEEK_OF_YEAR) - startW.get(GregorianCalendar.WEEK_OF_YEAR) + 1);
        }
    }

    public void setExpectedAmountOfHours(int expectedAmountOfHours) {
        this.expectedAmountOfHours = expectedAmountOfHours;
    }

    public void addHoursSpent(int hours) {
        this.hoursSpent += hours;
    }

    public List<Employee> getAssignedEmployees() {
        return employees;

    }

    public String getStartWeekString() {
        return "Week " + startW.get(GregorianCalendar.WEEK_OF_YEAR) + " of " + startW.get(GregorianCalendar.YEAR);
    }

    public String getEndWeekString() {
        if (endW.get(GregorianCalendar.WEEK_OF_YEAR) < startW.get(GregorianCalendar.WEEK_OF_YEAR)) {
            return "Week " + endW.get(GregorianCalendar.WEEK_OF_YEAR) + " of " + (endW.get(GregorianCalendar.YEAR)+1);
        } else {
            return "Week " + endW.get(GregorianCalendar.WEEK_OF_YEAR) + " of " + endW.get(GregorianCalendar.YEAR);
        }
    }

  /*  public void setStartWeek(GregorianCalendar newStartWeek) throws OperationNotAllowedException {
        if (newStartWeek.after(endW)) {
            throw new OperationNotAllowedException("The start week must be before the end week");
        }
        this.startW = newStartWeek;
    }

    public void setEndWeek(GregorianCalendar newEndWeek) throws OperationNotAllowedException {
        if (newEndWeek.before(startW)) {
            throw new OperationNotAllowedException("The end week must be after the start week");
        }
        this.endW = newEndWeek;
    }*/

    public void setActivName(String activName) {
        this.activName = activName;
    }

    public void assignEmp(Employee employee) {
        employees.add(employee);
    }

    public boolean checkEmployeeList(Employee employee) {
        return employees.contains(employee);
    }
}
