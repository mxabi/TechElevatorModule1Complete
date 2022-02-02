package com.techelevator.shapes;

public class Circle extends Shape {

    public Circle(String color, boolean filled, int numLines, double radius) {
        super(color, filled, 1);
        this.radius =radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private double radius;

    @Override
    public double getPerimeter() {
        return 2*radius*Math.PI;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}
