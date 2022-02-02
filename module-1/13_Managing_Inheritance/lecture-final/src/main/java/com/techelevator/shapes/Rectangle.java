package com.techelevator.shapes;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, boolean filled, double length, double width) {
        super(color, filled, 4);
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString(){
        String retVal = "Length: "+length+" Width: "+width+" ";
        //also include in retVal the color and filled
        //i don't want to duplicate code becuase it violates DRY
        //call the toString method in my parent
        retVal += super.toString();

        //if i just wanted getColor()
        String color = getColor();

        return retVal;
    }


    public double getLength(){return length;}
    public double getWidth() {return width;}

    @Override
    public double getPerimter() {
        return (length + width) * 2;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}
