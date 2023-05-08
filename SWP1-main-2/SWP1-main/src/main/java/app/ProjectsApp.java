package app;

import java.util.ArrayList;
import java.util.List;

import domain.Activity;
import domain.Employee;
import domain.Project;
import java.util.Observable;


public class ProjectsApp extends Observable {
	Project project;
	int id;
    private boolean empexist;
    private boolean activexist;
	public ArrayList<Activity> activities = new ArrayList<>();
	private boolean adminLoggedIn = false;
	public ArrayList<Project> projects = new ArrayList<>();
	public ArrayList<Employee> employees = new ArrayList<>();
	public ArrayList<Activity> aktiviteter = new ArrayList<>();




	////// Project things //////

	public void addActivity(Activity activity,Project project)  {
		project.activities.add(activity);
		aktiviteter.add(activity);
	}


	public List<Integer> getProjectList() {
        List<Integer> projectInit = new ArrayList<>();
        for (Project p : projects) {
            projectInit.add(p.getProjectId());
        }
        return projectInit;
    }

    private boolean projectexist;

    public boolean projectExists (int id) {
        if (getProjectList().contains(id)) {
            projectexist=true;
        } else {
            projectexist=false;
        }
        return projectexist;
    }

    public boolean deleteProject (int id) {
        int pemp=getProjectList().indexOf(id);
        projects.remove(pemp);
        projectExists(id);
        return projectexist;
    }
	
	
	
	
	
	public void createProject(String name,int id) {
		projects.add(new Project(name,id));


	}

	public List<Project> getProjects() {
		return projects;
	}


	public Project getProjectWithName(String projectName) {
		for (Project e: projects) {
			if(projectName.equals(e.getProjectName())){
				return e;
			}
		}
		return null;
	}
	////// Employee things //////
	public boolean addEmployee(Employee employee) throws OperationNotAllowedException {
		for (Employee e : employees) {
			if (e.getInitials().equals(employee.getInitials())) {
				throw new OperationNotAllowedException("An employee with the same initials is already in the system");
			}
		}
		employees.add(employee);
		return true;
	}

	public Employee getEmployeeWithName(String name){
		for (Employee e : employees) {
			if(name.equals(e.getName())){
				return e;
			}
		}
		return null;
	}

	public List<String> getInitialsList() {
		List<String> employeeInit = new ArrayList<>();
		for (Employee e : employees) {
			employeeInit.add(e.getInitials());
		}
		return employeeInit;
	}

	public List<Employee> getEmployees() {
		return employees;
	}


	public boolean empExists (String initials) {
		if (getInitialsList().contains(initials)) {
			empexist=true;
		} else {
			empexist=false;
		}
		return empexist;
	}

	public boolean deleteEmp (String initials)  {
		int remp=getInitialsList().indexOf(initials);
		employees.remove(remp);
		empExists(initials);
		return empexist;
	}


	public boolean checkMaxActivites(Employee employee){
		if(employee.empActvities.size() < 20){
			return true;
		}
		return false;
	}



	//Tjekker om om initals opfylder max 4 initialer
	public boolean checkInitials(Employee employee) {
		if (employee.getInitials().length() > 5) {
			return false;

		}
		return true;
	}
	////// User things //////
	private boolean userloggedin = false;
	public boolean isUserLoggedIn() {
		return userloggedin;
	}
	public boolean userLogin(String initials) {
		for (Employee employee:employees) {
			userloggedin = initials.equals(employee.getInitials());
			if(userloggedin != false) {
				return userloggedin;
			}
		}
		return userloggedin;
	}



	
	public boolean userLogout() {
		userloggedin=false;
		return userloggedin;
	}
	
	////// Activity things //////
	public List<String> getActivList() {
        List<String> activInit = new ArrayList<>();
        for (Activity a : aktiviteter) {
            activInit.add(a.getActivName());
        }
        return activInit;
    }

    public boolean activExists (String name) {
		if (getActivList().contains(name)) {
            activexist=true;
        } else {
            activexist=false;
        }
        return activexist;
    }

    public boolean deleteAct (String name,Project project) {
		for (int i =0; i<project.activities.size();i++){
			if(name.equals(project.activities.get(i).getActivName())){
				project.activities.remove(i);
				break;
			}
		}
        int remp=getActivList().indexOf(name);
        aktiviteter.remove(remp);
        activExists(name);
        return activexist;
    }
	
	
	
	
	public Activity getActivityWithName(String activityName, String projectName) {
		for (Activity a: getProjectWithName(projectName).activities) {
			if(a.getActivName().equals(activityName));
			
			return a;
		}
		return null;
	}

	////// Admin things //////
	public boolean adminLoggedIn() {
		// returns true if admin is logged in, false if admin isn't logged in
		return adminLoggedIn;
	}

	public boolean adminLogin(String password) {
		adminLoggedIn = password.equals("adminadmin");
		setChanged();
		notifyObservers();
		return adminLoggedIn;
	}

	public void adminLogout() {
		adminLoggedIn = false;
		setChanged();
		notifyObservers();
	}

	public boolean checkAdminLoggedIn() throws OperationNotAllowedException {
		return adminLoggedIn;
	}



	//checkInitials, CheckMaxActivities,
	//GetHoursSpent, GetTimePerWeek, AddHoursSpent, getStartWeekString, getEndWeekString, setEndWeek
	//CheckEmployeeList, getActivityByName,getStartDate, getDueDate, CheckActivityList


}
