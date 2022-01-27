package com.techelevator;

import com.techelevator.cards.*;
import com.techelevator.studentexample.*;

import java.util.Scanner;

class MainProgram {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {
        demoStudent();
        //Classes  - Deck of Cards, Card (suit would be an attribute)
        demoCards();

    }

    private static void demoCards(){
      DeckOfCards deck = new DeckOfCards();
      System.out.println(deck.dealOne());
      System.out.println(deck.dealOne());
      System.out.println(deck.dealOne());
      System.out.println("print the deck");
      System.out.println(deck);
    }

    //static means that you don't need an object.method() in order to call the method
    private static void demoStudent() {
        //create a student object
        Student lily = new Student(11);
        lily.setFirstName("Lily");
        //can't call private things in Student from anywhere outside of Student
        //lily.firstName = "lily";
        //lily.someHelperMethod();
        //i can set public instance variables
        lily.publicInstanceVariable = 100;//this is bad practice
        lily.setLastName("LaFleur");
        System.out.println("Lily's quiz average: "+lily.getQuizAverage());

        Student evan = new Student(222,"Evan","Hacker");

        evan.example(1);
        evan.example(2,2);
        evan.addQuizScore(90);
        evan.addQuizScore(65);
        System.out.println("Evan's quiz average: "+evan.getQuizAverage());

        Student jim  = new Student();
        ExampleNoConstructor enc = new ExampleNoConstructor();

        //objects can access static variables but it's weird to do it this way
        System.out.println(lily.bootcamp);

        //access static variables by the class name as a convention/best practice
        System.out.println(Student.bootcamp);

        evan.setLastName("Presley");
        Math.round(4.4);
        Student.printTheBootcamp();

    }

}
