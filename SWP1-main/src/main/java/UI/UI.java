package UI;

import app.OperationNotAllowedException;
import domain.*;
import app.ProjectsApp;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.List;
public class UI {


    public void pause() {
        try {
            // Wait 2 seconds
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Handle the exception
        }
    }
    public GregorianCalendar dateConverter(int year, int weekNumber) {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setWeekDate(year, weekNumber, 1);
            return calendar;
    }
    public void printMainOptions() {
        System.out.println("What would you like to do?");
        System.out.println("Enter a number:");
        System.out.println("00. Exit program");
        System.out.println("1. Create a new project");
        System.out.println("2. List all projects");
        System.out.println("3. View or edit project");
        System.out.println("4. Add a new employee to system");
    }
    public void printProjects(ProjectsApp app) {
        System.out.println("Listing all Projects");
        for (int i = 0; i < app.projects.size(); i++) {
            System.out.println((i + 1) + ": " + app.projects.get(i).getProjectName());
        }
    }
    public void printProjectOptions() {
        System.out.println("What would you like to do?");
        System.out.println("0. Back");
        System.out.println("1. Add Activity");
        System.out.println("2. View activities");
        System.out.println("3. View employees");
        System.out.println("4. Add employee");
        System.out.println("5. Set Project Leader");
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
/*    public void printProjectEmployees(ProjectsApp app, int selection) {
        for (int i = 0; app.projects.get(selection-1));

    }*/
    public void printActivities(ProjectsApp app, String input) {
        int selection = Integer.parseInt(input);
            System.out.println("Listing all Activities in Project: " + app.projects.get(selection-1).getProjectName());
            for (int i = 0; i < app.projects.get(selection - 1).activities.size(); i++) {
                System.out.println((i + 1) + ": " + app.projects.get(i).activities.get(i).getActivName());
            }
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
        // Instantiate an employee "user" with credentials
        Employee user = new Employee("John Doe", "jodo");
        // Instantiate projects for testing
        app.createProject("Project 1",23001);
        app.createProject("Project 2",23002);

        int startW1 = 2;
        int dueW1 = 5;

        GregorianCalendar startWeek1 = ui.dateConverter(2023,startW1);
        GregorianCalendar endWeek1 = ui.dateConverter(2023,dueW1);

        app.projects.get(0).addActivity(new Activity("fisk",startWeek1,endWeek1,5));
        app.projects.get(1).addActivity(new Activity("hest",startWeek1,endWeek1,5));






        ////////////////////////////////////////////////////////////
        // Create a Scanner object to read input from the command line
        Scanner scanner = new Scanner(System.in);
        // Prompt the user for their initials
        System.out.println("Welcome to Softwarefirmaet A/S!");
        System.out.println("Enter your initials: ");
        // Read the user's input from the command line
        String input = scanner.nextLine();
        // Write the user's input to the console
        System.out.println("Hello, " + input + "!");
        //login with credentials
        app.userLogin(input);

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
                    ui.printProjects(app);
                    System.out.println("Choose a project to View or edit");
                    input = scanner.nextLine();
                    // it is necessary to parse to int in order to control that the user input is not out of bounds with the projects list
                    int selection = Integer.parseInt(input);
                    if (selection > 0 && selection <= app.projects.size()) {
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
                                    ui.pause();
                                    break;
                                case "3":

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
                case "4":
                    try {
                        app.checkAdminLoggedIn();
                    } catch (OperationNotAllowedException e) {
                        System.out.println("User is not admin");
                        break;
                    }
                default:
                    System.out.println("Unexpected value: " + input);
                    break;
            }
            if(input.equals("00")) {
                break;
            }
        }
    }
}