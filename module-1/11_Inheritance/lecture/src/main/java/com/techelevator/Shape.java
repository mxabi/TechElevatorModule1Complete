package com.techelevator;

public class Shape {
    //every shape will have a color and boolean if its filled in or not

    private String color;

    public void setColor(String color) {
        this.color = color; //set instance variable to parameter that was passed in
    }

    public String getColor() {
        return color;
    }

    private boolean filled;

    public boolean isFilled() { //getters for boolean are ia instead of get in the method name
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled; // must use this because instance variable and parameter are same name
    }

    private int numLines;

    public int getNumLines() {
        return numLines;
    }

    protected void setNumLines(int numLines) {
        this.numLines = numLines;
    }

    public Shape (String color, boolean filled, int numLines){
        this.color = color;
        this.filled = filled;
        this.numLines = numLines;
        System.out.println("Here in the shapre 3 arg constructor");
    }

    public Shape(){
        //public no arg constructor
        System.out.println("No arg constructor");
    }

    //define a method to get the perimeter
    public double getPerimeter(){
        return 0;
    }


}
