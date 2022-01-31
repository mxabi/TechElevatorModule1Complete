package com.techelevator.shapes;

public class Circle extends Shape{
    //since Circle extends Shape, it inherits: color, filled, numLines, and all the methods

    private double radius;
    public double getRadius(){return radius;}
    public void setRadius(double radius){this.radius = radius;}

    //constrctor - set the radius, set the color, set filled, set num lines
    public Circle(String color, boolean filled, double radius){
        //call the Shape constructor
        super(color,filled,1);
        //as an alternative, i could've let it call the no-arg constructor
        //behind the scenes and called setColor, setFilled, setNumLines
        this.radius = radius;
        //this.filled = filled;//I don't have access to private stuff on the parent
    }

    //get perimeter - calculate and return the perimeter
    @Override //annotation - checks to make sure i'm actually overriding
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }
}
