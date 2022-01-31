package com.techelevator.shapes;

public class Circle extends Shape{
    //since Circle extends shape, it inherits: color, shape, numLines
    //and all

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //constructor - set radius, set the color, set filled, set num lines
    //get perimeter

    public Circle (double radius, String color, boolean filled){
        //call the Shape constructor
        // could also do super(color,filled,1)
        this.radius = radius;
        setColor(color);
        setFilled(filled);
        setNumLines(1);
    }
    @Override
    public double getPerimeter(){
       return 2*Math.PI*radius;
    }


}
