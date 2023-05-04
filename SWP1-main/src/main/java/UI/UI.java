package UI;

import app.OperationNotAllowedException;
import domain.*;
import app.ProjectsApp;
import java.util.GregorianCalendar;
import java.util.Scanner;
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
        System.out.println("Please select an option");
        System.out.println("Enter a number:");
        System.out.println("00. Exit program");
        System.out.println("1. Create a new Project");
        System.out.println("2. List all Projects");
        System.out.println("3. List all Employees");
        System.out.println("4. View or edit Project");
        System.out.println("5. Add a new Employee to system");
    }
    public void printProjects(ProjectsApp app) {
        System.out.println("Listing all Projects");
        for (int i = 0; i < app.projects.size(); i++) {
            System.out.println((i + 1) + ": " + app.projects.get(i).getProjectName());
        }
    }
    public void printAppEmployees(ProjectsApp app) {
        System.out.println("Listing all Employees in system");
        for (int i = 0; i < app.getEmployees().size(); i++) {
            System.out.println(i+1 + ". " + "Name: " + app.getEmployees().get(i).getName());
        }
    }
    public void printProjectOptions() {
        System.out.println("Please select a option");
        System.out.println("0. Back");
        System.out.println("1. Add Activity");
        System.out.println("2. View Activities");
        System.out.println("3. View Employees");
        System.out.println("4. Add Employee");
        System.out.println("5. View time Spent");
        System.out.println("6. Set Project Leader");
    }
    public void printActivityOptions() {
        System.out.println("Please select an option");
        System.out.println("0. Back");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Add hours to activity");
        System.out.println("4. View Time data");
    }

    //Flg. funktion/metode er ikke funktionel pt.
    public void printProjectInfo(ProjectsApp app) {
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        int selection = Integer.parseInt(input);
        if (selection > 0 && selection <= app.projects.size()) {
            System.out.println("0. Back");
            printProjectOptions();
            input = scanner.nextLine();
        } else {
            System.out.println("Invalid input, please enter a valid project number");
            printProjectInfo(app);
        }
    }
    //Project.java needs a way to return employees.
    public void printProjectEmployees(ProjectsApp app, int selection) {
        System.out.println("Listing all Employees in project: " + app.projects.get(selection-1).getProjectName());
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
    public void printActivities(ProjectsApp app, String input) {
        int selection = Integer.parseInt(input);
            System.out.println("Listing all Activities in Project: " + app.projects.get(selection-1).getProjectName());
            System.out.println("0. Back");
            for (int i = 0; i < app.projects.get(selection - 1).activities.size(); i++) {
                System.out.println((i + 1) + ": " + app.projects.get(selection-1).activities.get(i).getActivName());
            }
    }
    public int printTimeSpentActivity(ProjectsApp app, int selectionProject, int selectionActivity) {
       return app.projects.get(selectionProject-1).activities.get(selectionActivity-1).getHoursSpent();
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
        catch (OperationNotAllowedException e){

        }
        try {
            app.addEmployee(new Employee("Jane Doe", "jado"));
        }
        catch (OperationNotAllowedException e){

        }

        // Instantiate projects for testing
        app.createProject("Project 1",23001);
        app.createProject("Project 2",23002);
        // Instantiate activities
        int startW1 = 2;
        int dueW1 = 5;
        GregorianCalendar startWeek1 = ui.dateConverter(2023,startW1);
        GregorianCalendar endWeek1 = ui.dateConverter(2023,dueW1);
        app.projects.get(0).addActivity(new Activity("Activity 1.1",startWeek1,endWeek1,5));
        app.projects.get(1).addActivity(new Activity("Activity 2.1",startWeek1,endWeek1,5));

        ////////////////////////////////////////////////////////////
        // Create a Scanner object to read input from the command line
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
                ui.printMainOptions();
                input = scanner.nextLine();
                switch (input) {
                    case "00":
                        break;
                    case "1":
                        System.out.println("Enter a project name");
                        input = scanner.nextLine();
                        String projectName = input;
                        System.out.println("Enter a project ID");
                        input = scanner.nextLine();
                        int projectID = Integer.parseInt(input);
                        app.createProject(projectName,projectID);
                        ui.printProjects(app);
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
                        // it is necessary to parse to int in order to control that the user input is not out of bounds with the projects list
                        int selection = Integer.parseInt(input);
                        if (selection > 0 && selection <= app.projects.size()) {
                            // Project menu
                            while(true) {
                                if(input.equals("0")) {
                                    break;
                                }
                                ui.printProjectOptions();
                                input = scanner.nextLine();
                                switch (input) {
                                    case "0":
                                        break;
                                    case "1":
                                        System.out.println("Please name the activity");
                                        input = scanner.nextLine();
                                        String name = input;

                                        System.out.println("Please enter the starting week of the activity");
                                        input = scanner.nextLine();
                                        String startW = input;

                                        System.out.println("Please enter the week the activity is due");
                                        input = scanner.nextLine();
                                        String dueW = input;


                                        System.out.println("Please enter the hour budget of the activity");
                                        input = scanner.nextLine();
                                        int hourBudget = Integer.parseInt(input);

                                        GregorianCalendar startWeek = ui.dateConverter(2023, Integer.parseInt(startW));
                                        GregorianCalendar endWeek = ui.dateConverter(2023, Integer.parseInt(dueW));
                                        app.projects.get(selection - 1).addActivity(new Activity(name, startWeek, endWeek, hourBudget));
                                        break;
                                    case "2":
                                        ui.printActivities(app, input);
                                        System.out.println("Select an activity");
                                        input = scanner.nextLine();
                                        if(input.equals("0")) {
                                            input="99999";
                                            break;
                                        }
                                        int selectActivity = Integer.parseInt(input);
                                        if(selectActivity > 0 && selectActivity <= app.projects.get(selection-1).activities.size()) {
                                            System.out.println("Viewing activity: " + app.projects.get(selection-1).activities.get(selectActivity-1).getActivName());

                                            // Activity menu
                                            while(true) {
                                                ui.printActivityOptions();
                                                input = scanner.nextLine();
                                                if(input.equals("0")) {
                                                    input="999999";
                                                    break;
                                                }
                                                switch (input) {
                                                    case "0":
                                                        break;
                                                    case "1":
                                                        ui.printAppEmployees(app);
                                                        System.out.println("Please select an Employee");
                                                        input = scanner.nextLine();
                                                        int selectedEmployee = Integer.parseInt(input);
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
                                                        int hours = Integer.parseInt(input);
                                                        app.projects.get(selection-1).activities.get(selectActivity-1).addHoursSpent(hours);
                                                        System.out.println(hours + " Hours added,");
                                                        break;
                                                    case "4":
                                                        System.out.println("Time data for activity: " + app.projects.get(selection-1).activities.get(selectActivity-1).getActivName());
                                                        System.out.println("Budget hours on activity: " + app.projects.get(selection-1).activities.get(selectActivity-1).getExpectedAmountOfHours());
                                                        System.out.println("Hours Spent on activity: " + ui.printTimeSpentActivity(app,selection,selectActivity));
                                                        ui.pause();
                                                        break;
                                                    default:
                                                        System.out.println("Unexpected input: " + input + ", try again.");
                                                        break;
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("Unexpected input: " + input +", try again.");
                                            ui.pause();
                                        }
                                        break;

                                    case "3":
                                        ui.printProjectEmployees(app,selection);
                                        ui.pause();
                                        break;
                                    case "4":
                                        ui.printAppEmployees(app);
                                        System.out.println("Please select the number of the employee you wish to add");
                                        input = scanner.nextLine();
                                        int selectEmployee = Integer.parseInt(input);
                                        if (selectEmployee > 0 && selectEmployee <= app.getEmployees().size()) {
                                            app.projects.get(selection-1).employees.add(app.getEmployees().get(selectEmployee-1));
                                        } else {
                                            System.out.println("Invalid employee number, please try again");
                                            ui.pause();
                                            break;
                                        }
                                        break;
                                    case "5":
                                        int hoursSpent = 0;
                                        int hoursBudget = 0;
                                        for (int i = 0; i < app.projects.get(selection-1).activities.size();i++) {
                                            hoursSpent += app.projects.get(selection-1).activities.get(i).getHoursSpent();
                                            hoursBudget += app.projects.get(selection-1).activities.get(i).getExpectedAmountOfHours();
                                        }
                                        System.out.println("Time data for Project: " + app.projects.get(selection-1).getProjectName());
                                        System.out.println("Budgeted Hours: " + hoursBudget);
                                        System.out.println("Hours Spent: " + hoursSpent);
                                        ui.pause();
                                        ui.pause();
                                        break;
                                    case "6":
                                        System.out.println("Please provide admin password");
                                        input = scanner.nextLine();
                                        String password = input;
                                        app.adminLogin(password);
                                        try {
                                            app.checkAdminLoggedIn();
                                        } catch (OperationNotAllowedException e) {
                                            System.out.println("User is not admin");
                                            break;
                                        }
                                        System.out.println("Admin login successful!");
                                        ui.pause();
                                        System.out.println("Please select a Project Leader from the List");
                                        ui.printAppEmployees(app);
                                        input = scanner.nextLine();
                                        int selectProjectLeader = Integer.parseInt(input);
                                        if (selectProjectLeader > 0 && selectProjectLeader <= app.getEmployees().size()) {
                                            app.projects.get(selectProjectLeader-1).employees.add(app.getEmployees().get(selectProjectLeader-1));
                                            app.projects.get(selectProjectLeader-1).setProjectLeader(app.getEmployees().get(selectProjectLeader-1));
                                        } else {
                                            System.out.println("Invalid employee number, " + input + ", please try again");
                                            ui.pause();
                                            break;
                                        }
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
                        app.adminLogin(password);
                        try {
                            app.checkAdminLoggedIn();
                        } catch (OperationNotAllowedException e) {
                            System.out.println("User is not admin");
                            break;
                        }
                        System.out.println("Admin login successful!");
                        ui.pause();
                        System.out.println("Please enter name of the new Employee");
                        input = scanner.nextLine();
                        String newEmployeeName = input;
                        System.out.println("Please enter initials of new Employee");
                        input = scanner.nextLine();
                        String newEmployeeInitials = input;
                        try {
                            app.addEmployee(new Employee(newEmployeeName, newEmployeeInitials));
                        }
                        catch (OperationNotAllowedException e) {
                            System.out.println("An employee with the same initials already exists, returning");
                            ui.pause();
                            break;
                        }
                        break;
                    default:
                        System.out.println("Unexpected value: " + input);
                        break;
                }
                if(input.equals("00")) {
                    break;
                }
            }
        } else {
            System.out.println("Invalid credentials, terminating.");
        }
    }
}