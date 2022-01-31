package com.techelevator.shapes;

//base class/super class
public class Shape {
    /*every shape will have a color and a boolean if its filled in or not and how many lines it has */
    private String color; //instance variable
    public String getColor(){return color;}
    public void setColor(String color){this.color = color;} //set the instance variable = the parameter that was passed in

    private boolean filled;
    public boolean isFilled(){return filled;}//getters for booleans are is instead of get in the method name
    public void setFilled(boolean filled){this.filled = filled;} //must use this because instance variable and parameter are same name

    private int numLines;
    public int getNumLines(){return numLines;}

    //protected is an access modifier like private or public
    //it means it's accessible in this class & child classes & package

    protected void setNumLines(int numLines){this.numLines = numLines;}

    //constructor that initializes all of the instance variables
    public Shape(String color, boolean filled, int numLines){
        this.color = color;
        this.filled = filled;
        this.numLines = numLines;
        System.out.println("Here in the Shape 3 arg constructor");
    }

    public Shape(){//default no-arg constructor
        System.out.println("Here in the Shape no-arg constructor");
    }

    //define a method to get the perimeter
    public double getPerimeter(){return 0;}
}
