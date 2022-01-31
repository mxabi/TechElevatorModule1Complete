package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MainProgram {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        //class called RubberDuck - color, birthday, derived age, size, autoResponse
        //  method to make the duck talk

        //RubberDuck is a data type just like String
        RubberDuck jim = new RubberDuck();
        //jim.demoPrivate(); can't access private things
        LocalDate jimBirthday = LocalDate.of(1961, 5, 17);
        jim.setColor("purple");

        RubberDuck lily = new RubberDuck("blue",LocalDate.now());

        List<String> demo = new ArrayList<>();
        RubberDuck sam = new RubberDuck();
        RubberDuck kevin = new RubberDuck();

        //generally, when we access static stuff, we do it by the class name
        //for clarity/readability
        System.out.println("There were "+RubberDuck.getDuckCount()+" ducks created.");


    }

}
