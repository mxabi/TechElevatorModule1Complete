package com.techelevator.shapes;

/*
Let's revisit shapes

All of my shapes should have a color that's a string and a boolean for if it's filled and number of lines.
I can change the color and if it's filled after it's created but I can only set the number of lines when I create it.
Anyone can get the info.

//Does it make sense to have a generic shape? no, so make it abstract so you can't instantiate

I should be able to getPerimeter and getArea for every shape

I need to have Shapes of Rectangles and Circles
 */
public abstract class Shape { //i can't instantiate so  = new Shape()  is not allowed
    private String color;
    private boolean filled;
    private int numLines;

    public Shape(String color, boolean filled, int numLines) {
        this.color = color;
        this.filled = filled;
        this.numLines = numLines;
    }

    @Override
    public String toString(){
        return "Color: "+color+" Filled: "+filled;
    }

    public abstract double getPerimter();//every subclass of Shape MUST have a getPerimeter method
    public abstract double getArea(); //every subclass of Shape MUST have a getArea method

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
}
