package com.techelevator.studentexample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {
    //static variables are SHARED between the class and all objects
    public static final String bootcamp = "Tech Elevator";
    //final means you can't change it
    //static methods are SHARED between the class and all objects and therefore don't have access
    // to any instance variables, only static variables
    public static void printTheBootcamp(){
        System.out.println(bootcamp );
    }

    //all instance variables should be private
    private int studentNumber; //you can only set this when you create a Student
    //public getter/setter
    public int getStudentNumber() {
        return this.studentNumber;
    }

    private LocalDate birthday;
    //setter for the birthday
    public void setBirthday(LocalDate birthday){ //parameter of method is named same as instance variable
        //birthday will refer to the local parameter that got passed in
        //we'll use this.birthday to refer to the instance variable
        this.birthday = birthday;
    }

    //DONT DO THIS JUST FOR DEMO
    public int publicInstanceVariable;

    private String firstName;
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String first){
        firstName = first;//set the instance variable = the parameter
    }

    private String lastName;
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String last){
        lastName = last;
    }

    /* DERIVED properties / getters don't have their own instance variable named the same thing
        but are based on oher instance variables
     */
    //the students full name
    public String getFullName(){
        return firstName+" "+lastName;
    }

    //keep track of the all the quiz scores
    private List<Integer> quizScores = new ArrayList<>();
    //add the score for todays quiz
    public void addQuizScore(int quizScore){
        quizScores.add(quizScore);
    }
    //derived property/getter
    public double getQuizAverage(){
        //prevent divide by zero
        if (quizScores.size()==0){
            return 0;
        }
        //the sum of all the quiz scores divided by the total count
        int sum = 0;
        for(int score : quizScores){
            sum += score;
        }
        return (double)sum / quizScores.size();
    }

    //set the instance variables based on the initialization data
    // constructor - special method that runs ONLY and every time an object is created
    //  must be public and NO RETURN VALUE and MUST BE NAMED WITH THE NAME OF THE CLASS
    public Student(int stud_num){
        studentNumber = stud_num;
    }
    //i want to initilize all of the student number, the last name
    // and the first name when i create a student object
    //OVERLOADING - same method name, different parameter type or count
    public Student(int studentNum, String first, String last){
        studentNumber = studentNum;
        firstName = first;
        lastName = last;
    }
    //default no-arg constructor if you don't have any constructor written
    public Student(){}

    //another overloaded example
    //when object.example is called, the compiler will look at the params being
    //passed in to decide which method to call
    public void example(int a){
        System.out.println("example with param int a was called");
    }
    public void example(int a, int b){
        System.out.println("example with params int a int b was called");
    }

    /* The type of the parameters matters, not the name
    public void example(int b, int a){
        System.out.println("example with params int a int b was called");
    }
     */
    public void example(String s){
        System.out.println("example with param string s was called");
        someHelperMethod();
    }

    //i can have private helper methods that involve implementation details
    private void someHelperMethod(){
        System.out.println("in the helper method");
    }

}
