package com.techelevator;

import com.techelevator.cardgame.Card;
import com.techelevator.cardgame.DeckOfCards;
import com.techelevator.studentExample.Student;

import java.util.Scanner;

class MainProgram {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

    demoStudent();
    demoCards();


    }
    //static means your dont need an object.method to call the method
    private static void demoStudent() {
        //Create a student object
        Student abeda = new Student(456789456); // create object
        abeda.setFirstName("Abeda");
        abeda.setLastName("Alam");

        Student evan = new Student(222, "Evan","Hacker");
        evan.example(2);
        evan.addQuizScores(90);
        evan.addQuizScores(65);
        System.out.println("Evans quiz average" + evan.getAverageQuizScore());

        System.out.println(abeda.bootcamp);
    }

    private static void demoCards(){
        Card aceOfHearts = new Card ("Hearts", 1);
        System.out.println(aceOfHearts);
        DeckOfCards deck = new DeckOfCards();
        System.out.println(deck);

    }

}


