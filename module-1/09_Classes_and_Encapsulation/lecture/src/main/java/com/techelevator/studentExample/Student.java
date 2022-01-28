package com.techelevator.studentExample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {
    //all instance variables are private
    private int studentNumber;
    private String firstName;
    private String lastName;

    //Static variables are shared
    public static String bootcamp = "Tech Elevator";

    //To access private instance variables, create public/setter method : access modifiers

    public int getStudentNumber() {
        return studentNumber;
    }

    private LocalDate birthday;

    public void setBirthday(LocalDate birthday){
        //birthday will refer to local parameter
        //this.birthday will refer to instance variable
        birthday =this.birthday;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName (String first){
        firstName = first;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last){
        lastName = last;
    }

    //The students full name is a derived property

    public String getFullName() {
        return firstName + "" + lastName;
    }

    //Keep track of all the quiz scores
    List<Integer> quizScores = new ArrayList<>();

    //add the score for todays quiz
    public void addQuizScores ( int quizScore){
        quizScores.add(quizScore);
    }

    //derived property/getter
    public double getAverageQuizScore(){
        //prevent divide by 0
        if (quizScores.size() ==0){
            return 0;
        }
        //sum of all quiz scores / total count of quiz scores
        int sum = 0;
        for ( int score: quizScores) {
            sum+=score;
        }
        return (double)sum/quizScores.size();
    }

    // set the instance variables based on initialization data
    //constructor - special method thaat runs ONLY and every time an object is created
    //must be public, no return value & must be named with the name of the class
    public Student(int sn) {
        studentNumber =sn;
    }

    // OVERLOADING - same method name, different paramater type or count
    // i want to initialize the student number, last name, and first name

    public Student (int sn, String first,String last){
        studentNumber = sn;
        firstName = first;
        lastName = last;
    }
    public void example (int a){
        System.out.println("example with param int a was called");
    }

    public void example (int a,int b){
        System.out.println("example with params  int a and int b was called");
    }

    public void example (String s){
        System.out.println(" Example with param str");
    }

    //Classes - Deck of cards, Card, (suit would be attribute of card)
    //
}

