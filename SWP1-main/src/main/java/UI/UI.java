package UI;

import app.OperationNotAllowedException;
import domain.*;
import app.ProjectsApp;
import java.util.GregorianCalendar;
import java.util.Scanner;

// Two dummy employees are created, Jane Doe and John doe, with initials "jado" and "jodo", respectively
// admin password is adminadmin
public class UI {
    public void pause() {
        try {
            // Wait 2 seconds
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }
    public GregorianCalendar dateConverter(int year, int weekNumber) {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setWeekDate(year, weekNumber, 1);
            return calendar;
    }
    
    
    
    
    public void printMainOptions() {
        System.out.println("");
        System.out.println("Please select an option");
        System.out.println("Enter a number:");
        System.out.println("00. Exit program");
        System.out.println("0. Log out");
        System.out.println("1. Create a new Project");
        System.out.println("2. List all Projects");
        System.out.println("3. List all Employees");
        System.out.println("4. View or edit Project");
        System.out.println("5. Add a new Employee to system");
        System.out.println("6. Delete an Employee");
        System.out.println("7. Delete a Project");
    }
    public void printProjects(ProjectsApp app) {
        System.out.println("");
        System.out.println("Listing all Projects");
        for (int i = 0; i < app.projects.size(); i++) {
            System.out.println((i + 1) + ": " + app.projects.get(i).getProjectName() + " - ID: " + app.projects.get(i).getProjectId());
        }
    }
    public void printAppEmployees(ProjectsApp app) {
        System.out.println("");
        System.out.println("Listing all Employees in system");
        for (int i = 0; i < app.getEmployees().size(); i++) {
            System.out.println(i+1 + ". " + "Name: " + app.getEmployees().get(i).getName());
        }
    }
    public void printProjectOptions(ProjectsApp app, int projectSelection) {
        System.out.println("");
        System.out.println("Viewing Project: " + app.projects.get(projectSelection-1).getProjectName());
        System.out.println("Please select a option");
        System.out.println("0. Back");
        System.out.println("1. Add Activity");
        System.out.println("2. View Activities");
        System.out.println("3. View Employees");
        System.out.println("4. Add Employee");
        System.out.println("5. View Time Data");
        System.out.println("6. Set Project Leader");
        System.out.println("7. Delete activity");
    }
    public void printActivityOptions(ProjectsApp app, int projectSelection, int activitySelection) {
        System.out.println("");
        System.out.println("Viewing Project: " + app.projects.get(projectSelection-1).getProjectName());
        System.out.println("Viewing Activity: " + app.projects.get(projectSelection-1).activities.get(activitySelection-1).getActivName());
        System.out.println("Please select an option");
        System.out.println("0. Back");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Add hours to activity");
        System.out.println("4. View Time data");

    }


    //Project.java needs a way to return employees.
    public void printProjectEmployees(ProjectsApp app, int selection) {
        System.out.println("");
        System.out.println("Listing all Employees in project: " + app.projects.get(selection-1).getProjectName());
        if(app.projects.get(selection-1).getProjectLeader()!=null) {
            System.out.println("Project Leader is: " + app.projects.get(selection-1).getProjectLeader().getName());
        } else {
            System.out.println("Project does not have a Project Leader");
        }
        for (int i = 0; i < app.projects.get(selection-1).employees.size(); i++) {
            System.out.println(i+1 + ". " + app.projects.get(selection-1).employees.get(i).getName());
        }
    }
    public void printActivityEmployees(ProjectsApp app, int selectionProject, int selectionActivity) {
        System.out.println("Listing all Employees in Activity: " + app.projects.get(selectionProject-1).activities.get(selectionActivity-1).getActivName());
        for (int i = 0; i < app.projects.get(selectionProject-1).activities.get(selectionActivity-1).employees.size(); i++) {
            System.out.println(i+1 + ". " + app.projects.get(selectionProject-1).activities.get(selectionActivity-1).employees.get(i).getName());
        }
    }
    public void printActivities(ProjectsApp app, int selection) {
       // int selection = Integer.parseInt(input);
            System.out.println("Listing all Activities in Project: " + app.projects.get(selection-1).getProjectName());
            System.out.println("0. Back");
            for (int i = 0; i < app.projects.get(selection - 1).activities.size(); i++) {
                System.out.println((i + 1) + ": " + app.projects.get(selection-1).activities.get(i).getActivName());
            }
    }
    public int printTimeSpentActivity(ProjectsApp app, int selectionProject, int selectionActivity) {
       return app.projects.get(selectionProject-1).activities.get(selectionActivity-1).getHoursSpent();
    }
    // Obsolete, the logic is in the main function already
    //Flg. funktion/metode er ikke funktionel pt.
    public void printProjectInfo(ProjectsApp app) {
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        int selection = Integer.parseInt(input);
        if (selection > 0 && selection <= app.projects.size()) {
            System.out.println("0. Back");
            //   printProjectOptions(app);
            input = scanner.nextLine();
        } else {
            System.out.println("Invalid input, please enter a valid project number");
            printProjectInfo(app);
        }
    }
    public int printTimeSpentProject(ProjectsApp app, int selectionProject, int selectionActivity) {
        int sum = 0;
        for(int i = 0; i < app.projects.get(selectionProject-1).activities.size(); i++) {
            sum += app.projects.get(selectionProject-1).activities.get(selectionActivity-1).getHoursSpent();
        }
        return sum;
    }
    public void viewProjects(ProjectsApp app) {
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which project would you like to view?");
        printProjects(app);
        input = scanner.nextLine();
        int selection = Integer.parseInt(input);
        if (selection > 0 && selection <= app.projects.size()) {
            System.out.println("0. Back");
            printProjectInfo(app);
            app.projects.get(selection - 1);
        } else {
            System.out.println("Invalid input, please enter a valid project number");
        }
    }

    public static void main(String[] args) {
        // Instantiate UI
        UI ui = new UI();
        // Instantiate projectsAPP
        ProjectsApp app = new ProjectsApp();
        // Instantiate Employees "John doe" and "Jane doe" with credentials
        try {
            app.addEmployee(new Employee("John Doe", "jodo"));
        }
        catch (OperationNotAllowedException e){ }
        try {
            app.addEmployee(new Employee("Jane Doe", "jado"));
        }
        catch (OperationNotAllowedException e){ }

        // Instantiate projects for testing
        app.createProject("Project 1",23001);
        app.createProject("Project 2",23002);
        // Instantiate activities
        int startW1 = 2;
        int dueW1 = 5;
        GregorianCalendar startWeek1 = ui.dateConverter(2023,startW1);
        GregorianCalendar endWeek1 = ui.dateConverter(2023,dueW1);

        app.addActivity(new Activity("Activity 1.1",startWeek1,endWeek1,5), app.projects.get(0));
        app.addActivity(new Activity("Activity 2.1",startWeek1,endWeek1,5), app.projects.get(1));


        ////////////////////////////////////////////////////////////
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        // Prompt the user for their initials
        System.out.println("Welcome to Softwarefirmaet A/S!");
        System.out.println("Enter your initials: ");
        // Read the user's input from the command line
        String input = scanner.nextLine();
        // Write the user's input to the console

        // login with credentials
        // userlogin
        if(app.userLogin(input)) {
            System.out.println("Hello, " + input + "!");
            ui.pause();
            // Main menu
            while (true) {
                if (!app.isUserLoggedIn()) {
                    System.out.println("Welcome to Softwarefirmaet A/S!");
                    System.out.println("Enter your initials: ");
                    input = scanner.nextLine();
                    if (app.userLogin(input)) {
                        System.out.println("Hello, " + input + "!");
                        ui.pause();
                    } else {
                        System.out.println("Invalid credentials, terminating.");
                        break;
                    }
                }
                ui.printMainOptions();
                input = scanner.nextLine();
                switch (input) {
                    case "00":
                        break;
                    case "0":
                        app.userLogout();
                        input = "";
                        break;
                    case "1":
                        System.out.println("Please provide admin password");
                        input = scanner.nextLine();
                        String password1 = input;
                        if (app.adminLogin(password1)==true) {
                        	  System.out.println("Admin login successfully");
                        	  ui.pause();
                        } else {
                        	 System.out.println("Wrong password");
                       	  ui.pause();
                       	  break;
                        }
                        
                        System.out.println("Enter a project name");
                        input = scanner.nextLine();
                        String projectName = input;
                        System.out.println("Enter a project ID");
                        input = scanner.nextLine();
                        if (!input.matches("\\d+")) {
                            System.out.println("Input is not an integer, please try again");
                            ui.pause();
                            break;
                        }
                        int projectID = Integer.parseInt(input);
                        app.createProject(projectName, projectID);
                        ui.printProjects(app);
                        ui.pause();
                        break;
                    case "2":
                        ui.printProjects(app);
                        ui.pause();
                        break;
                    case "3":
                        ui.printAppEmployees(app);
                        ui.pause();
                        break;
                    case "4":
                        ui.printProjects(app);
                        System.out.println("Choose a project to View or edit");
                        input = scanner.nextLine();
                        if (!input.matches("\\d+")) {
                            System.out.println("Input is not an integer, please try again");
                            ui.pause();
                            break;
                        }
                        // it is necessary to parse to int in order to control that the user input is not out of bounds with the projects list
                        int selection = Integer.parseInt(input);
                        if (selection > 0 && selection <= app.projects.size()) {
                            // Project menu
                            while (true) {
                                if (input.equals("0")) {
                                    input = "";
                                    break;
                                }
                                ui.printProjectOptions(app, selection);
                                input = scanner.nextLine();
                                switch (input) {
                                    case "0":
                                        break;
                                    case "1":
                                        System.out.println("Please name the activity");
                                        input = scanner.nextLine();
                                        String name = input;
                                        if (app.projects.get(selection - 1).checkActivityList(name)) {
                                            System.out.println("An activity with this name already exists, please try again");
                                            input = "";
                                            ui.pause();
                                            break;
                                        }
                                        int startW;
                                        int dueW;
                                        int hourBudget;
                                        int year;
                                        System.out.println("Please enter the year of the activity");
                                        input = scanner.nextLine();
                                        if (input.matches("\\d+")) {
                                            String yearcheck = input;
                                            year = Integer.parseInt(yearcheck);
                                        } else {
                                            System.out.println("Input is not an integer, please restart");
                                            ui.pause();
                                            break;
                                        }
                                        System.out.println("Please enter the starting week of the activity");
                                        input = scanner.nextLine();
                                        if (input.matches("\\d+")) {
                                            String startWeek = input;
                                            startW = Integer.parseInt(startWeek);
                                        } else {
                                            System.out.println("Input is not an integer, please restart");
                                            ui.pause();
                                            break;
                                        }
                                        System.out.println("Please enter the week the activity is due");
                                        input = scanner.nextLine();
                                        if (input.matches("\\d+")) {
                                            String dueWeek = input;
                                            dueW = Integer.parseInt(dueWeek);
                                        } else {
                                            System.out.println("Input is not an integer, please restart");
                                            ui.pause();
                                            break;
                                        }
                                        System.out.println("Please enter the hour budget of the activity");
                                        input = scanner.nextLine();
                                        if (input.matches("\\d+")) {
                                            String dueWeek = input;
                                            hourBudget = Integer.parseInt(dueWeek);
                                        } else {
                                            System.out.println("Input is not an integer, please restart");
                                            ui.pause();
                                            break;
                                        }
                                        GregorianCalendar startWeek = ui.dateConverter(year, startW);
                                        GregorianCalendar endWeek = ui.dateConverter(year, dueW);
                                        app.addActivity(new Activity(name, startWeek, endWeek, hourBudget), app.projects.get(selection-1));
                                        break;
                                    case "2":
                                        ui.printActivities(app, selection);
                                        System.out.println("Select an activity");
                                        input = scanner.nextLine();
                                        if (input.equals("0")) {
                                            input = "";
                                            break;
                                        }
                                        int selectActivity = Integer.parseInt(input);
                                        if (selectActivity > 0 && selectActivity <= app.projects.get(selection - 1).activities.size()) {
                                            // Activity menu
                                            while (true) {
                                                ui.printActivityOptions(app, selection, selectActivity);
                                                input = scanner.nextLine();
                                                if (input.equals("0")) {
                                                    input = "";
                                                    break;
                                                }
                                                switch (input) {
                                                    case "0":
                                                        break;
                                                    case "1":
                                                        ui.printAppEmployees(app);
                                                        System.out.println("Please select an Employee");
                                                        input = scanner.nextLine();
                                                        if (!input.matches("\\d+")) {
                                                            System.out.println("Input is not an integer, please try again");
                                                            ui.pause();
                                                            break;
                                                        }
                                                        int selectedEmployee = Integer.parseInt(input);
                                                        if (app.projects.get(selection - 1).activities.get(selectActivity - 1).checkEmployeeList(app.getEmployees().get(selectedEmployee - 1))) {
                                                            System.out.println("This Employee is already added to this activity. Returning");
                                                            ui.pause();
                                                            break;
                                                        }
                                                        app.projects.get(selection - 1).activities.get(selectActivity - 1).employees.add(app.getEmployees().get(selectedEmployee - 1));
                                                        System.out.println("Employee added!");
                                                        ui.pause();
                                                        break;
                                                    case "2":
                                                        ui.printActivityEmployees(app, selection, selectActivity);
                                                        break;
                                                    case "3":
                                                        System.out.println("Please enter hours spent");
                                                        input = scanner.nextLine();
                                                        if (!input.matches("\\d+")) {
                                                            System.out.println("Input is not an integer, please try again");
                                                            ui.pause();
                                                            break;
                                                        }
                                                        int hours = Integer.parseInt(input);
                                                        app.projects.get(selection - 1).activities.get(selectActivity - 1).addHoursSpent(hours);
                                                        System.out.println(hours + " Hours added,");
                                                        ui.pause();
                                                        break;
                                                    case "4":
                                                        System.out.println("Time data for activity: "
                                                                + app.projects.get(selection - 1).activities.get(selectActivity - 1)
                                                                .getActivName());
                                                        System.out.println("Budget hours on activity: "
                                                                + app.projects.get(selection - 1).activities.get(selectActivity - 1)
                                                                .getExpectedAmountOfHours());
                                                        System.out.println("Hours Spent on activity: "
                                                                + ui.printTimeSpentActivity(app, selection, selectActivity));
                                                        System.out
                                                                .println("StartWeek: " + app.projects.get(selection - 1).activities
                                                                        .get(selectActivity - 1).getStartWeekString());
                                                        System.out.println("Endweek: " + app.projects.get(selection - 1).activities
                                                                .get(selectActivity - 1).getEndWeekString());
                                                        System.out.println("Budget time per week: "
                                                                + app.projects.get(selection - 1).activities.get(selectActivity - 1)
                                                                .getTimePerWeek());
                                                        ui.pause();
                                                        break;
                                                    default:
                                                        System.out.println("Unexpected input: " + input + ", try again.");
                                                        break;
                                                }
                                            }
                                        } else {
                                            System.out.println("Unexpected input: " + input + ", try again.");
                                            ui.pause();
                                        }
                                        break;

                                    case "3":
                                        ui.printProjectEmployees(app, selection);
                                        ui.pause();
                                        break;
                                    case "4":
                                        ui.printAppEmployees(app);
                                        System.out.println("Please select the number of the employee you wish to add");
                                        input = scanner.nextLine();
                                        if (!input.matches("\\d+")) {
                                            System.out.println("Input is not an integer, please try again");
                                            ui.pause();
                                            break;
                                        }
                                        int selectEmployee = Integer.parseInt(input);
                                        if (selectEmployee > 0 && selectEmployee <= app.getEmployees().size()) {
                                            if (app.projects.get(selection - 1).checkEmployeeList(app.getEmployees().get(selectEmployee - 1))) {
                                                System.out.println("This Employee is already added to this Project. Returning");
                                                ui.pause();
                                                break;
                                            } else {
                                                app.projects.get(selection - 1).employees.add(app.getEmployees().get(selectEmployee - 1));
                                                System.out.println("Employee added to Project");
                                                ui.pause();
                                            }
                                        } else {
                                            System.out.println("Invalid employee number, please try again");
                                            ui.pause();
                                            break;
                                        }
                                        break;
                                    case "5":
                                        //Code should probably be put in a method of its own
                                        int hoursSpent = 0;
                                        int hoursBudget = 0;
                                        for (int i = 0; i < app.projects.get(selection - 1).activities.size(); i++) {
                                            hoursSpent += app.projects.get(selection - 1).activities.get(i).getHoursSpent();
                                            hoursBudget += app.projects.get(selection - 1).activities.get(i).getExpectedAmountOfHours();
                                        }
                                        System.out.println("");
                                        System.out.println("Time data for Project: " + app.projects.get(selection - 1).getProjectName());
                                        System.out.println("Budgeted Hours: " + hoursBudget);
                                        System.out.println("Hours Spent: " + hoursSpent);
                                        ui.pause();
                                        ui.pause();
                                        break;
                                    case "6":
                                    	 System.out.println("Please provide admin password");
                                         input = scanner.nextLine();
                                         String password = input;
                                         if (app.adminLogin(password)==true) {
                                         	  System.out.println("Admin login successfully");
                                         	  ui.pause();
                                         } else {
                                         	 System.out.println("Wrong password");
                                        	  ui.pause();
                                        	  break;
                                         }
                                        System.out.println("Admin login successful!");
                                        ui.pause();
                                        System.out.println("Please select a Project Leader from the List");
                                        ui.printAppEmployees(app);
                                        input = scanner.nextLine();
                                        int selectProjectLeader = Integer.parseInt(input);
                                        if (selectProjectLeader > 0 && selectProjectLeader <= app.getEmployees().size()) {
                                            if (!app.projects.get(selection - 1).checkEmployeeList(app.getEmployees().get(selectProjectLeader - 1))) {
                                                app.projects.get(selection - 1).employees.add(app.getEmployees().get(selectProjectLeader - 1));
                                            }
                                            app.projects.get(selection - 1).setProjectLeader(app.getEmployees().get(selectProjectLeader - 1));
                                        } else {
                                            System.out.println("Invalid employee number, " + input + ", please try again");
                                            ui.pause();
                                            break;
                                        }
                                        break;
                                    case "7":
                                    	 System.out.println("Please provide admin password");
                                         input = scanner.nextLine();
                                         String password4 = input;
                                         if (app.adminLogin(password4)==true) {
                                         	  System.out.println("Admin login successfully");
                                         	  ui.pause();
                                         } else {
                                         	 System.out.println("Wrong password");
                                        	  ui.pause();
                                        	  break;
                                         }
                                        System.out.println("Please enter activity name:");
                                        input=scanner.nextLine();
                                        if (app.activExists(input)!=true){
                                            System.out.println("Activity doesn't exist");
                                    } else {
                                            app.deleteAct(input,app.projects.get(selection-1));
                                            System.out.println("The Activity has been deleted");
                                        }
                                        ui.pause();
                                        break;

                                    default:
                                        System.out.println("Invalid input");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Invalid selection");
                            break;
                        }
                        break;
                    case "5":
                    	 System.out.println("Please provide admin password");
                         input = scanner.nextLine();
                         String password = input;
                         if (app.adminLogin(password)==true) {
                         	  System.out.println("Admin login successfully");
                         	  ui.pause();
                         } else {
                         	 System.out.println("Wrong password");
                        	  ui.pause();
                        	  break;
                         }
                    
                        System.out.println("Please enter name of the new Employee");
                        input = scanner.nextLine();
                        String newEmployeeName = input;
                        System.out.println("Please enter initials of new Employee (4 characters)");
                        input = scanner.nextLine();
                        String newEmployeeInitials = input;
                        if (newEmployeeInitials.length() == 5) {
                            System.out.println("initials must be 4 characters or less, please try again");
                            ui.pause();
                            break;
                        }
                        try {
                            app.addEmployee(new Employee(newEmployeeName, newEmployeeInitials));
                            System.out.println("Employee added to system");
                            ui.pause();
                        } catch (OperationNotAllowedException e) {
                            System.out.println("An employee with the same initials already exists, please try again");
                            ui.pause();
                            break;
                        }
                        break;
                    case "6":
                    	 System.out.println("Please provide admin password");
                         input = scanner.nextLine();
                         String password3 = input;
                         if (app.adminLogin(password3)==true) {
                         	  System.out.println("Admin login successfully");
                         	  ui.pause();
                         } else {
                         	 System.out.println("Wrong password");
                        	  ui.pause();
                        	  break;
                         }
                        System.out.println("Please enter Employee initials:");
                        input = scanner.nextLine();
                        if (app.empExists(input) != true) {
                            System.out.println("Employee doesn't exist");
                        } else {
                            app.deleteEmp(input);
                            System.out.println("The Employee has been deleted.");
                        }
                        ui.pause();
                        break;
                    case "7":
                    	 System.out.println("Please provide admin password");
                         input = scanner.nextLine();
                         String password2 = input;
                         if (app.adminLogin(password2)==true) {
                         	  System.out.println("Admin login successfully");
                         	  ui.pause();
                         } else {
                         	 System.out.println("Wrong password");
                        	  ui.pause();
                        	  break;
                         }
                        System.out.println("Please enter project ID:");
                        int inputInt;
                        inputInt = scanner.nextInt();

                        if (app.projectExists(inputInt) != true) {
                            System.out.println("Project doesn't exist");
                        } else {
                            app.deleteProject(inputInt);
                            System.out.println("The project has been deleted.");
                        }
                        ui.pause();
                        break;

                    default:
                        System.out.println("Unexpected value: " + input);
                        ui.pause();
                        break;
                }
                        if (input.equals("00")) {
                        break;

                    } 
                } 
            }else {
                System.out.println("Invalid credentials, terminating.");
            }}}