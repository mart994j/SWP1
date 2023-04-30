package domain;

import javax.naming.Name;
import java.util.ArrayList;

public class Employee {
    private String name;
    private int age;
    private String initials;

    private ArrayList<Activity> employeeActivityList = new ArrayList<Activity>();
    public Employee(String name,int age, String initials){
            this.name = name;
            this.age = age;
            this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getInitials(){
     return initials;
    }


    public boolean checkAge(){
        if (age >=70){
            return false;
            //Throw expection, find ud af hvordan man gør det****
        }
        return true;
    }
    //Tjekker om om initals opfylder max 4 initialer
    public boolean checkInitials(){
            if (initials.length() > 5){
                return false;
            //Throw expection, find ud af hvordan man gør det****
            }
            return true;
    }





}

