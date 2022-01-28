package com.techelevator;

import java.time.LocalDate;
import java.time.Period;

public class RubberDuck {
    /*
       class - defining data and behavior (variables and methods) to be a blueprint for creating objects
       objects - live in the heap; instances of a class; intantiate a class to create an object; every object/instance
                 has it's own copy of all instance variables and methods
       instance variable - defined on the class level/in scope for whole class; should 99.9% of the time be private;
                           every object has its own (all class level variables are intance unless they have static)
       static variable - shared by the class and all objects. used VERY INFREQUENTLY. The opposite of static is instance
                         if the static keyword is not there, then it's instance
       static method  -  shared by the class and all objects. can only access static variables, not instance variables
       getters/setters - specific methods named with getInstanceVariableName to provide access to the private instance variables
                         get - public 'same data type as instance variable' getInstanceVarName() { return the instance variable;}

                         get derived - instead of a returning an instance variable, we figure something out based on a different one

                         set - used to set an instance variable
                               public void setInstanceVariableName(datatypeofinstanceVar paramName) { set the instance var to the param}
       this - always refers to the object on which the method was called so if i have abeda.method() this refers to the abeda object
              we can use this.whatever anytime we want to, but we MUST do it if a parameter name conflicts with an instance variable name we want to access
       constructors - are special methods that are called when an object is created; they can do some intialization;
                      if you don't have any constructors, java automatically gives you the default no-arg constructor behind the scenes
                      public no return named the same a the class
       default values can be set either when you declare the instance variable or in the constructor
       encapsulation - the class combines the data and the behavior
                       abstraction - hiding implementation details using access modifiers (public/private)
       private - only accessbile in the class
       public - accessible anywhere
     */

    private static int duckCount=0; //SHARED between all ducks; keep track of the number of ducks created
    public static int getDuckCount() {return duckCount;}

    private String color = "yellow"; //instance variable
    public String getColor(){
        return color;
    } //getter
    public void setColor(String color){ //setter
        //the instance variable is named color and the paramter is named color
        //this always refers to instance variables/methods;
        this.color =  color;
        //setting instance variable color = parameter color
    }

    private LocalDate birthday; //instance variable
    public int getAge(){ //age is a derived property
        demoPrivate();//i can access private stuff

        LocalDate currentDate = LocalDate.now(); //this is a LOCAL variable because the scope is just to this method
        if ((birthday != null) && (currentDate != null)) {
            return Period.between(birthday, currentDate).getYears();
        } else {
            return 0;
        }

    }

    private String unitializedInstanceVariable;
    private final int NUMBER_OF_WINGS = 2; //final means that once you set it, it can never be changed
    //naming convention for final is all caps

    //no-arg constructor; default initializations
    public RubberDuck() {
        //ducks are yellow default - that's set on teh instance variable declaration but i could put it here if i wanted to
        //color = "yellow";
        //default birthday to today
        birthday = LocalDate.now();
        //NUMBER_OF_WINGS = 1; you can't change a final
        duckCount++; //you can access static variables from non-static methods
    }
    //overload the constructor to let whoeever is creating the object set the init values
    public RubberDuck(String color, LocalDate birthday){
        //setting the instance variables to the parameters that the user passed in when creating the object
        this.color = color;
        this.birthday = birthday;
        duckCount++; //you can access static variables from non-static methods
    }
    //i just know the color
    public RubberDuck(String color){
        this.color = color;
        duckCount++;
    }

    private void demoPrivate(){}


}
