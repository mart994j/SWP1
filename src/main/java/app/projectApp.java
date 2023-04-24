package app;

import domain.Employee;
import domain.Project;

import java.util.*;

public class projectApp extends Observable {

    ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
    public int projectCount;
    private List<Project> projects = new ArrayList<>();

    private GregorianCalendar startDate = new GregorianCalendar(1000, 0, 1);
    private GregorianCalendar endDate = new GregorianCalendar(1000, 0, 1);


    public boolean checkAge(Employee employee) {
            if (employee.getAge() >= 70) {
                return false;
            }
        return true;
    }
    //Tjekker om om initals opfylder max 4 initialer
    public boolean checkInitials(Employee employee) {
            if (employee.getInitials().length() > 5) {
                return false;
                //Throw expection, find ud af hvordan man gør det****
            }
            return true;
        }


    public boolean addEmployee(Employee employee) {

            int sizeOfEmpList = employeeArrayList.size();
            if (checkInitials(employee) && checkAge(employee)) {
                employeeArrayList.add(employee);

            }
            if (sizeOfEmpList < employeeArrayList.size()) {
                return true;
            }
            return false;
        }
    public Project createProject (String projectName, int id){
        Project newProject = new Project(projectName,id);
        projects.add(newProject);
        projectCount++;
        return newProject;
    }

    public void setStartDate(GregorianCalendar newStartDate) throws ArithmeticException{
        if (newStartDate.after(endDate)) {
            throw new ArithmeticException("The start date must be before the end date");
        }

        startDate = newStartDate;

    }
    public void setEndDate(GregorianCalendar newEndDate){
        if (newEndDate.before(startDate)){
            throw new ArithmeticException("The end date must be after the start date");

        }
        endDate = newEndDate;

    }

    public GregorianCalendar getStartDate(){
        return startDate;
    }
    public GregorianCalendar getEndDate() {
        return endDate;
    }

    private int generateProjectID(int projectCount){

        return projectCount;
    }

    public String getStartDateString(){
        int date = startDate.get(Calendar.DATE);
        int month = startDate.get(Calendar.MONTH);
        int year = startDate.get(Calendar.YEAR);
        return date + "/" + month + "/" + year;
    }
    public String getEndDateString(){
        int date = endDate.get(Calendar.DATE);
        int month = endDate.get(Calendar.MONTH);
        int year = endDate.get(Calendar.YEAR);
        return date + "/" + month + "/" + year;
    }



}
