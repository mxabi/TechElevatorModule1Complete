package com.techelevator;

import java.time.LocalDate;
import java.time.Period;

public class RubberDuck {
    /*
    Class - Defining data and behavior or variables and methods to be a blueprint
    for creating objects
    Objects - Live in the heap, instances of a class
    Can Instantiate a class to create an object
    Every object for instance has it's own copy of instance variables and methods
     An instance variable - defined on the class, should 99.9% of the time be private
        Every object should have its own
        (all class level variables are isntance unless they have static)
    getters/setters - specific methods named with getInstanceVariable name to provide
    objects access to the private instance variables
                get = public 'some data type as instance variable'
                get dericed - instead

     this alwys refers to object on which method was called so if i have abeda.method()
     this refers to the abeda object
        we can use this.whatever anytime we want to but we MUST do it if

     */


    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color; //refers to instance variable
        //saying instance variable color  = parameter color
    }

    private LocalDate birthday;// instance variable

    public int getAge(){
        LocalDate currentDate =LocalDate.now();
        if((birthday != null ) && (currentDate != null)){
            return Period.between(birthday, currentDate).getYears();
        } else{
            return 0;
        }
    }
}
