package com.techelevator;

public class Employee {

    //Instance Variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    //Setters and Getters

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        this.fullName = lastName+ ","+ " " + firstName;
        return fullName;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //Create constructor that accepts:

    public Employee(int employeeId, String firstName, String lastName, double annualSalary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    public void raiseSalary(double percent){
        double raisedSalary = (percent * annualSalary/100) + annualSalary;
        this.annualSalary =raisedSalary;
    }
}
