package com.techelevator;

public class RectangleWall extends Wall {
    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    @Override
    public int getArea() {
        return (length*height);
    }

    public int getHeight() {
        return height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int height) {
        this.height = height;
    }

    private int length;
    private int height;

    @Override
    public String toString() {
        return "TEST " + "(" + getLength() + "x" + getHeight() +")" + " rectangle"
               ;
    }
}
