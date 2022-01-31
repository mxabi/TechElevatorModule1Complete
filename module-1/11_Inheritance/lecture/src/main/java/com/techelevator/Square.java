package com.techelevator;

public class Square extends Shape {
    public Square() {
    }
    // Want sqaure to be child of Shape
    //Constructors: Teh subclass will get a default constructor if we don't specifically define one.
    //The subclass constructor must always call a constructor in the parent
    //Subclasses are also derived classes and are specializations
    //Is-A relationship, Square is-A Shape
    //Overriding method - the method has the same name and parameters defined
    //in the parent

    private double sideLength;

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public Square (String color, boolean filled) {
        //know that there are 4 lines

        // to specifically call a constructor in the parents, use the super ()
        super(color,filled, 4);
    }

    public Square (double sideLength) {
        setNumLines(4);
        this.sideLength = sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength*4;
    }
}

