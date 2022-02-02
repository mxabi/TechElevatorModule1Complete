package com.techelevator.shapes;

public class Rectangle extends Shape{

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int length;
    private int width;

    public Rectangle(String color, boolean filled, int numLines) {
        super(color, filled, 4);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return (length + width)*2;
    }

    @Override
    public double getArea() {
        return (length*width);
    }
}
