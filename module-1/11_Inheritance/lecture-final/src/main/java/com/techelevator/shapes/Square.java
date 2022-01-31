package com.techelevator.shapes;

import com.techelevator.shapes.Shape;

//extends Shape => Square is a child of shape
public class Square extends Shape {

    /*
       Inheritance - enables a child/sub class to take on the properties
          and methods defined in the parent/super class
       Subclass is the derived class/child that does the inheriting. The subclass can have additional instance variables
       Superclass is the base class/parent whose data/behavior is being passed down/inherited

       Subclasses are also called derived classes and are specializations of the super class

       is-a relationship Square is-a Shape

       Constructors:
        The subclass will also get a default constructor if we don't specifically define one. This default
        constructor will magically call the no-arg constructor in the parent. The subclass
        constructor must always call a constructor in the parent
        It will either automatically call the no-arg constructor OR we can specifically call a different one

        Override a method - the method has the same name and parameters as a method defined
          in the parent. but changes the behavior/implementation for the child object

        You can only inherit from ONE parent; single inheritance ONLY

        Transitive

        All classes actually extend Object behind the scenes

     */

    private double sideLength;
    public double getSideLength(){return sideLength;}
    public void setSideLength(double sideLength){this.sideLength = sideLength;}

    //constructor in Square
    public Square(String color, boolean filled){
        //know that there are 4 lines

        //to specifically call a constructor in the parent, use the super()
        super(color,filled,4);
    }

    public Square(){
        //this will automatically call the shape no arg constructor
        setNumLines(4);

    }

    public Square(double sideLength){
        //this will automatically call the shape no arg constructor
        setNumLines(4);
        this.sideLength = sideLength;

    }

    @Override //have an error if I"m not actually overriding anything, ie typo
    public double getPerimeter(){
        return sideLength*4;
    }

}
