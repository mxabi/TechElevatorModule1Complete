package com.techelevator.studentexample;

public class ExampleNoConstructor {
    private int someData;

    //java magically gives me a default no-arg constructor if i don't have any constructors defined
    //public ExampleNoConstructor(){}

    /* when you have a constructor defined, you don't get teh default no-arg magically anymore
    public ExampleNoConstructor (int someData){
        this.someData = someData;
    }
    */

}
