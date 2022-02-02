package com.techelevator.shapes;

public abstract class Shape {

    //Does it make sense to getPerimeter and getArea

    private String color;
    private boolean filled;
    private int numLines;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public int getNumLines() {
        return numLines;
    }

    public void setNumLines(int numLines) {
        this.numLines = numLines;
    }

    protected Shape(String color, boolean filled, int numLines) {
        this.color = color;
        this.filled = filled;
        this.numLines = numLines;
    }

    public abstract double getPerimeter();
    public abstract double getArea();


}
